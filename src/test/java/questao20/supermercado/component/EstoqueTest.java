package questao20.supermercado.component;

import org.junit.jupiter.api.Assertions;
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

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;
import static questao20.supermercado.helper.EstoqueTestHelper.*;

@ExtendWith(MockitoExtension.class)
public class EstoqueTest {

    @InjectMocks
    Estoque estoque;

    @Mock
    SaidaImplement saidaImplement;


    @Test
    @DisplayName("1-deve incializar estoque imprimindo catalogo")
    void deveInicializarEstoqueImprimindoOCatalogo() {
        Boolean cadastraProduto1 = estoque.cadastraProduto(criarListaDeProdutos().getFirst());
        Boolean cadastraProduto2 = estoque.cadastraProduto(criarListaDeProdutos().get(1));
        Boolean cadastraProduto3 = estoque.cadastraProduto(criarListaDeProdutos().getLast());
        String imprimirListaDeProdutos = criarListaDeProdutos().stream().toString();

        verify(saidaImplement, atMost(1)).imprimir(imprimirListaDeProdutos);

    }

    @Test
    @DisplayName("2- deve encontrar produto por nome")
    void deveEncontrarProdutoPorNome() throws ProdutoException {
        Boolean cadastraProduto1 = estoque.cadastraProduto(criarListaDeProdutos().getFirst());
        Boolean cadastraProduto2 = estoque.cadastraProduto(criarListaDeProdutos().get(1));
        Boolean cadastraProduto3 = estoque.cadastraProduto(criarListaDeProdutos().getLast());

        Produto produto1Encontrado = estoque.encontraProduto(NOME_PRODUTO_1);

        Assertions.assertEquals(criarListaDeProdutos().getFirst().getNome(), produto1Encontrado.getNome());
        Assertions.assertEquals(criarListaDeProdutos().getFirst().getPreco(), produto1Encontrado.getPreco());
        Assertions.assertEquals(criarListaDeProdutos().getFirst().getQuantidadeEmEstoque(), produto1Encontrado.getQuantidadeEmEstoque());

    }

    @Test
    @DisplayName("3- deve lancar excecao quando nao encontrar produto por nome")
    void deveLancarExcecaoQuandoNaoEncontrarProdutoPorNome() throws ProdutoException {
        Boolean cadastraProduto1 = estoque.cadastraProduto(criarListaDeProdutos().getFirst());
        Boolean cadastraProduto2 = estoque.cadastraProduto(criarListaDeProdutos().get(1));
        Boolean cadastraProduto3 = estoque.cadastraProduto(criarListaDeProdutos().getLast());
        Assertions.assertThrows(ProdutoException.class, () -> estoque.encontraProduto(NOME_PRODUTO_INEXISTENTE));
    }

    @Test
    @DisplayName("4- deve encontrar produto por id")
    void deveEncontrarProdutoPorId() throws ProdutoException {
        Boolean cadastraProduto1 = estoque.cadastraProduto(criarListaDeProdutos().getFirst());
        Boolean cadastraProduto2 = estoque.cadastraProduto(criarListaDeProdutos().get(1));
        Boolean cadastraProduto3 = estoque.cadastraProduto(criarListaDeProdutos().getLast());

        Produto produto1Encontrado = estoque.encontraProduto(ID_PRODUTO_3);

        Assertions.assertEquals(criarListaDeProdutos().getLast().getNome(), produto1Encontrado.getNome());
        Assertions.assertEquals(criarListaDeProdutos().getLast().getPreco(), produto1Encontrado.getPreco());
        Assertions.assertEquals(criarListaDeProdutos().getLast().getQuantidadeEmEstoque(), produto1Encontrado.getQuantidadeEmEstoque());

    }

    @Test
    @DisplayName("5- deve lancar excecao quando nao encontrar produto por id")
    void deveLancarExcecaoQuandoNaoEncontrarProdutoPorId() throws ProdutoException {
        Boolean cadastraProduto1 = estoque.cadastraProduto(criarListaDeProdutos().getFirst());
        Boolean cadastraProduto2 = estoque.cadastraProduto(criarListaDeProdutos().get(1));
        Boolean cadastraProduto3 = estoque.cadastraProduto(criarListaDeProdutos().getLast());
        Assertions.assertThrows(ProdutoException.class, () -> estoque.encontraProduto(ID_PRODUTO_INEXISTENTE));
    }

    @Test
    @DisplayName("6-deve retornar true ao cadastrar produtos")
    void deveRetornarTrueAoCadastrarProdutos() {
        Boolean cadastraProduto1 = estoque.cadastraProduto(criarListaDeProdutos().getFirst());
        Boolean cadastraProduto2 = estoque.cadastraProduto(criarListaDeProdutos().get(1));
        Boolean cadastraProduto3 = estoque.cadastraProduto(criarListaDeProdutos().getLast());

        Assertions.assertEquals(Boolean.TRUE, cadastraProduto1);
        Assertions.assertEquals(Boolean.TRUE, cadastraProduto2);
        Assertions.assertEquals(Boolean.TRUE, cadastraProduto3);
    }

    @Test
    @DisplayName("7- deve retornar false ao dar baixa em estoque por nome")
    void deveRetornarFalseAoDarBaixaEmEstoquePorNome() throws ProdutoException {
        Boolean cadastraProduto1 = estoque.cadastraProduto(criarListaDeProdutos().getFirst());
        Boolean cadastraProduto2 = estoque.cadastraProduto(criarListaDeProdutos().get(1));
        Boolean cadastraProduto3 = estoque.cadastraProduto(criarListaDeProdutos().getLast());

        estoque.encontraProduto(NOME_PRODUTO_1);

        Boolean darBaixaEmEstoque = estoque.darBaixaEmEstoque(NOME_PRODUTO_1,QTD_PARA_DAR_BAIXA_IGUAL_A_QTD_ESTOQUE_PRODUTO_1);

        Assertions.assertEquals(Boolean.FALSE,darBaixaEmEstoque);

    }
    @Test
    @DisplayName("8- deve retornar true ao dar baixa em estoque por nome")
    void deveRetornarTrueAoDarBaixaEmEstoquePorNome() throws ProdutoException {
        Boolean cadastraProduto1 = estoque.cadastraProduto(criarListaDeProdutos().getFirst());
        Boolean cadastraProduto2 = estoque.cadastraProduto(criarListaDeProdutos().get(1));
        Boolean cadastraProduto3 = estoque.cadastraProduto(criarListaDeProdutos().getLast());

        estoque.encontraProduto(NOME_PRODUTO_1);

        Boolean darBaixaEmEstoque = estoque.darBaixaEmEstoque(NOME_PRODUTO_1,QTD_PARA_DAR_BAIXA_DIFERENTE_A_QTD_ESTOQUE_PRODUTO_1);

        Assertions.assertEquals(Boolean.TRUE,darBaixaEmEstoque);

    }
    @Test
    @DisplayName("7- deve retornar false ao dar baixa em estoque por id")
    void deveRetornarFalseAoDarBaixaEmEstoquePorId() throws ProdutoException {
        Boolean cadastraProduto1 = estoque.cadastraProduto(criarListaDeProdutos().getFirst());
        Boolean cadastraProduto2 = estoque.cadastraProduto(criarListaDeProdutos().get(1));
        Boolean cadastraProduto3 = estoque.cadastraProduto(criarListaDeProdutos().getLast());

        estoque.encontraProduto(NOME_PRODUTO_1);

        Boolean darBaixaEmEstoque = estoque.darBaixaEmEstoque(NOME_PRODUTO_1,QTD_PARA_DAR_BAIXA_IGUAL_A_QTD_ESTOQUE_PRODUTO_1);

        Assertions.assertEquals(Boolean.FALSE,darBaixaEmEstoque);

    }
    @Test
    @DisplayName("8- deve retornar true ao dar baixa em estoque por id")
    void deveRetornarTrueAoDarBaixaEmEstoquePorId() throws ProdutoException {
        Boolean cadastraProduto1 = estoque.cadastraProduto(criarListaDeProdutos().getFirst());
        Boolean cadastraProduto2 = estoque.cadastraProduto(criarListaDeProdutos().get(1));
        Boolean cadastraProduto3 = estoque.cadastraProduto(criarListaDeProdutos().getLast());

        estoque.encontraProduto(NOME_PRODUTO_1);

        Boolean darBaixaEmEstoque = estoque.darBaixaEmEstoque(ID_PRODUTO_1,QTD_PARA_DAR_BAIXA_DIFERENTE_A_QTD_ESTOQUE_PRODUTO_1);

        Assertions.assertEquals(Boolean.TRUE,darBaixaEmEstoque);

    }

    @Test
    @DisplayName("9- deve retornar posicao do produto")
    void deveRetornarPosicaoDoProduto() throws ProdutoException {
        Boolean cadastraProduto1 = estoque.cadastraProduto(criarListaDeProdutos().getFirst());
        Boolean cadastraProduto2 = estoque.cadastraProduto(criarListaDeProdutos().get(1));
        Boolean cadastraProduto3 = estoque.cadastraProduto(criarListaDeProdutos().getLast());

        Integer posicaoDoProdutoNaLista = estoque.getPosicaoDoProdutoNaLista(criarListaDeProdutos().getLast());

        Assertions.assertEquals(2,posicaoDoProdutoNaLista);

    }
}
