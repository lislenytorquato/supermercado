package questao20.supermercado.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import questao20.supermercado.exception.ProdutoException;
import questao20.supermercado.implement.SaidaImplement;
import questao20.supermercado.model.Estoque;
import questao20.supermercado.model.Menu;
import questao20.supermercado.model.Produto;

import static org.mockito.Mockito.*;
import static questao20.supermercado.helper.EstoqueTestHelper.*;

@ExtendWith(MockitoExtension.class)
public class EstoqueServiceTest {

    @InjectMocks
    private EstoqueService estoqueService;

    @Mock
    private Menu menu;

    @Mock
    private Estoque estoque;

    @Mock
    private SaidaImplement saidaImplement;

    @Test
    @DisplayName("1- deve exibir menu quando entrada eh um")
    void deveExibirMenuQuandoEntradaEhUm(){

        doNothing().when(menu).controlaMenu();
         estoqueService.exibirMenu();
        verify(menu, times(1)).controlaMenu();
    }

    @Test
    @DisplayName("2- deve criar estoque")
    void deveCriarEstoque(){
        Produto produto = new Produto(ID_PRODUTO_1,NOME_PRODUTO_1,PRECO_PRODUTO_1,QTD_ESTOQUE_PRODUTO_1);
        when(estoque.cadastrarProduto(produto)).thenReturn(Boolean.TRUE);
        doNothing().when(estoque).inicializarEstoque();
        estoqueService.criarEstoque(produto);

        verify(estoque, atMost(1)).inicializarEstoque();

    }

    @Test
    @DisplayName("3- deve encontrar produto por nome no estoque")
    void deveEncontrarProdutoPorNomeNoEstoque() throws ProdutoException {
        Produto produto = new Produto(ID_PRODUTO_1,NOME_PRODUTO_1,PRECO_PRODUTO_1,QTD_ESTOQUE_PRODUTO_1);
        when(estoque.encontrarProdutoPorNome(NOME_PRODUTO_1)).thenReturn(produto);
        Produto produtoEncontrado = estoqueService.encontraProdutoPorNomeNoEstoque(NOME_PRODUTO_1);

        Assertions.assertEquals(produto,produtoEncontrado);
    }

    @Test
    @DisplayName("4- deve encontrar produto por id no estoque")
    void deveEncontrarProdutoPorIdNoEstoque() throws ProdutoException {
        Produto produto = new Produto(ID_PRODUTO_1,NOME_PRODUTO_1,PRECO_PRODUTO_1,QTD_ESTOQUE_PRODUTO_1);
        when(estoque.encontrarProdutoPorId(ID_PRODUTO_1)).thenReturn(produto);
        Produto produtoEncontrado = estoqueService.encontraProdutoPorIdNoEstoque(ID_PRODUTO_1);

        Assertions.assertEquals(produto,produtoEncontrado);
    }

    @Test
    @DisplayName("5- deve dar baixa em estoque por nome do produto ")
    void deveDarBaixarEstoquePorNomeDoProduto() throws ProdutoException {
        Produto produto = new Produto(ID_PRODUTO_1,NOME_PRODUTO_1,PRECO_PRODUTO_1,QTD_ESTOQUE_PRODUTO_1);
        when(estoque.darBaixaEmEstoquePorNome(NOME_PRODUTO_1, QTD_PARA_DAR_BAIXA_MAIOR_QUE_A_QTD_ESTOQUE_PRODUTO_1)).thenReturn(Boolean.TRUE);
        estoqueService.darBaixaEmEstoquePorNomeDoProduto(NOME_PRODUTO_1, QTD_PARA_DAR_BAIXA_MAIOR_QUE_A_QTD_ESTOQUE_PRODUTO_1);

        verify(estoque,times(1)).darBaixaEmEstoquePorNome(NOME_PRODUTO_1, QTD_PARA_DAR_BAIXA_MAIOR_QUE_A_QTD_ESTOQUE_PRODUTO_1);

    }

    @Test
    @DisplayName("5- deve dar baixa em estoque por id do produto ")
    void deveDarBaixarEstoquePorIdDoProduto() throws ProdutoException {
        Produto produto = new Produto(ID_PRODUTO_1,NOME_PRODUTO_1,PRECO_PRODUTO_1,QTD_ESTOQUE_PRODUTO_1);
        when(estoque.darBaixaEmEstoquePorId(ID_PRODUTO_1,QTD_PARA_DAR_BAIXA_IGUAL_A_QTD_ESTOQUE_PRODUTO_1)).thenReturn(Boolean.TRUE);
        estoqueService.darBaixaEmEstoquePorIdDoProduto(ID_PRODUTO_1, QTD_PARA_DAR_BAIXA_IGUAL_A_QTD_ESTOQUE_PRODUTO_1);

        verify(estoque,times(1)).darBaixaEmEstoquePorId(ID_PRODUTO_1,QTD_PARA_DAR_BAIXA_IGUAL_A_QTD_ESTOQUE_PRODUTO_1);

    }

    @Test
    @DisplayName("5- deve retornar previsao do produto na lista ")
    void deveRetornarPrevisaoDoProdutoNaLista() throws ProdutoException {

        Produto produto = new Produto(ID_PRODUTO_1,NOME_PRODUTO_1,PRECO_PRODUTO_1,QTD_ESTOQUE_PRODUTO_1);
        when(estoque.getPosicaoDoProdutoNaLista(produto)).thenReturn(ID_ESTOQUE-1);
        Integer posicaoDoProdutoNaLista = estoqueService.retornarPosicaoDoProdutoNaLista(produto);

        Assertions.assertEquals(0,posicaoDoProdutoNaLista);

    }



}
