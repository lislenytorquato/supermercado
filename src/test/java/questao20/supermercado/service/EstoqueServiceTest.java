package questao20.supermercado.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import questao20.supermercado.exception.ProdutoException;
import questao20.supermercado.helper.EstoqueTestHelper;
import questao20.supermercado.implement.EntradaImplement;
import questao20.supermercado.implement.SaidaImplement;
import questao20.supermercado.model.Estoque;
import questao20.supermercado.model.Menu;
import questao20.supermercado.model.Produto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

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
        when(estoque.cadastraProduto(produto)).thenReturn(Boolean.TRUE);
        doNothing().when(estoque).inicializaEstoque();
        estoqueService.criarEstoque(produto);

        verify(estoque, atMost(1)).inicializaEstoque();

    }

    @Test
    @DisplayName("3- deve encontrar produto por nome no estoque")
    void deveEncontrarProdutoPorNomeNoEstoque() throws ProdutoException {
        Produto produto = new Produto(ID_PRODUTO_1,NOME_PRODUTO_1,PRECO_PRODUTO_1,QTD_ESTOQUE_PRODUTO_1);
        when(estoque.encontraProduto(NOME_PRODUTO_1)).thenReturn(produto);
        Produto produtoEncontrado = estoqueService.encontraProdutoPorNomeNoEstoque(NOME_PRODUTO_1);

        Assertions.assertEquals(produto,produtoEncontrado);
    }

    @Test
    @DisplayName("3- deve encontrar produto por id no estoque")
    void deveEncontrarProdutoPorIdNoEstoque() throws ProdutoException {
        Produto produto = new Produto(ID_PRODUTO_1,NOME_PRODUTO_1,PRECO_PRODUTO_1,QTD_ESTOQUE_PRODUTO_1);
        when(estoque.encontraProduto(ID_PRODUTO_1)).thenReturn(produto);
        Produto produtoEncontrado = estoqueService.encontraProdutoPorIdNoEstoque(ID_PRODUTO_1);

        Assertions.assertEquals(produto,produtoEncontrado);
    }
}
