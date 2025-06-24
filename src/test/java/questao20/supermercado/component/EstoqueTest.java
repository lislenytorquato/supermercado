package questao20.supermercado.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import questao20.supermercado.exception.ProdutoException;
import questao20.supermercado.implement.SaidaImplement;
import questao20.supermercado.model.Estoque;
import questao20.supermercado.model.Produto;

import java.util.List;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;
import static questao20.supermercado.helper.EstoqueTestHelper.*;

@ExtendWith(MockitoExtension.class)
public class EstoqueTest {

    @InjectMocks
    Estoque estoque;

    @Mock
    SaidaImplement saidaImplement;

    List<Produto> produtos = criarListaDeProdutos();

    @BeforeEach
        void setUp(){

            produtos.forEach(produto -> {
                estoque.cadastrarProduto(produto);
            });
        }



    @Test
    @DisplayName("1-deve incializar estoque imprimindo catalogo")
    void deveInicializarEstoqueImprimindoOCatalogo() {

        String imprimirListaDeProdutos = produtos.toString();

        estoque.inicializarEstoque();

        verify(saidaImplement, atMost(1)).imprimir(imprimirListaDeProdutos);

    }

    @Test
    @DisplayName("2- deve encontrar produto por nome")
    void deveEncontrarProdutoPorNome() throws ProdutoException {


        Produto produto1Encontrado = estoque.encontrarProdutoPorNome(NOME_PRODUTO_1);

        Assertions.assertEquals(produtos.get(0).getNome(), produto1Encontrado.getNome());
        Assertions.assertEquals(produtos.get(0).getPreco(), produto1Encontrado.getPreco());
        Assertions.assertEquals(produtos.get(0).getQuantidadeEmEstoque(), produto1Encontrado.getQuantidadeEmEstoque());

    }

    @Test
    @DisplayName("3- deve lancar excecao quando nao encontrar produto por nome")
    void deveLancarExcecaoQuandoNaoEncontrarProdutoPorNome() throws ProdutoException {

        Assertions.assertThrows(ProdutoException.class, () -> estoque.encontrarProdutoPorNome(NOME_PRODUTO_INEXISTENTE));
    }

    @Test
    @DisplayName("4- deve encontrar produto por id")
    void deveEncontrarProdutoPorId() throws ProdutoException {

        Produto produto1Encontrado = estoque.encontrarProdutoPorId(ID_PRODUTO_3);

        Assertions.assertEquals(produtos.get(2).getNome(), produto1Encontrado.getNome());
        Assertions.assertEquals(produtos.get(2).getPreco(), produto1Encontrado.getPreco());
        Assertions.assertEquals(produtos.get(2).getQuantidadeEmEstoque(), produto1Encontrado.getQuantidadeEmEstoque());

    }

    @Test
    @DisplayName("5- deve lancar excecao quando nao encontrar produto por id")
    void deveLancarExcecaoQuandoNaoEncontrarProdutoPorId() throws ProdutoException {

        Assertions.assertThrows(ProdutoException.class, () -> estoque.encontrarProdutoPorId(ID_PRODUTO_INEXISTENTE));
    }

    @Test
    @DisplayName("6-deve retornar true ao cadastrar produtos")
    void deveRetornarTrueAoCadastrarProdutos() {
        produtos.forEach(produto -> {
            boolean produtoCadastrado = estoque.cadastrarProduto(produto);
            Assertions.assertEquals(Boolean.TRUE, produtoCadastrado);
        });
    }

    @Test
    @DisplayName("7- deve retornar false ao dar baixa em estoque por nome")
    void deveRetornarFalseAoDarBaixaEmEstoquePorNome() throws ProdutoException {

        estoque.encontrarProdutoPorNome(NOME_PRODUTO_1);

        Boolean darBaixaEmEstoque = estoque.darBaixaEmEstoquePorNome(NOME_PRODUTO_1,QTD_PARA_DAR_BAIXA_MENOR_A_QTD_ESTOQUE_PRODUTO_1);

        Assertions.assertEquals(Boolean.FALSE,darBaixaEmEstoque);

    }
    @Test
    @DisplayName("8- deve retornar true ao dar baixa em estoque por nome")
    void deveRetornarTrueAoDarBaixaEmEstoquePorIdPorNome() throws ProdutoException {

        estoque.encontrarProdutoPorNome(NOME_PRODUTO_1);

        Boolean darBaixaEmEstoque = estoque.darBaixaEmEstoquePorNome(NOME_PRODUTO_1,QTD_PARA_DAR_BAIXA_IGUAL_A_QTD_ESTOQUE_PRODUTO_1);

        Assertions.assertEquals(Boolean.TRUE,darBaixaEmEstoque);

    }
    @Test
    @DisplayName("9- deve retornar false ao dar baixa em estoque por id")
    void deveRetornarFalseAoDarBaixaEmEstoquePorId() throws ProdutoException {

        estoque.encontrarProdutoPorId(ID_PRODUTO_1);

        Boolean darBaixaEmEstoque = estoque.darBaixaEmEstoquePorId(ID_PRODUTO_1,QTD_PARA_DAR_BAIXA_MENOR_A_QTD_ESTOQUE_PRODUTO_1);

        Assertions.assertEquals(Boolean.FALSE,darBaixaEmEstoque);

    }
    @Test
    @DisplayName("10- deve retornar true ao dar baixa em estoque por id")
    void deveRetornarTrueAoDarBaixaEmEstoquePorId() throws ProdutoException {

        estoque.encontrarProdutoPorId(ID_PRODUTO_1);

        Boolean darBaixaEmEstoque = estoque.darBaixaEmEstoquePorId(ID_PRODUTO_1,QTD_PARA_DAR_BAIXA_MENOR_A_QTD_ESTOQUE_PRODUTO_1);

        Assertions.assertEquals(Boolean.TRUE,darBaixaEmEstoque);

    }

    @Test
    @DisplayName("11- deve retornar posicao do produto")
    void deveRetornarPosicaoDoProduto() throws ProdutoException {

        Integer posicaoDoProdutoNaLista = estoque.getPosicaoDoProdutoNaLista(criarListaDeProdutos().getLast());

        Assertions.assertEquals(2,posicaoDoProdutoNaLista);

    }
}
