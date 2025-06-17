package questao20.supermercado.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import questao20.supermercado.implement.EntradaImplement;
import questao20.supermercado.implement.SaidaImplement;
import questao20.supermercado.model.Item;
import questao20.supermercado.model.Pedido;
import questao20.supermercado.model.Produto;

import java.util.List;

import static questao20.supermercado.helper.PedidoTestHelper.*;

@ExtendWith(MockitoExtension.class)
public class PedidoTest {

    @InjectMocks
    Pedido pedido;

    @Mock
    SaidaImplement saidaImplement;

    @Mock
    EntradaImplement entradaImplement;

    @Mock
    Item item;

    @Mock
    Produto produto;

    @Mock
    List<Item> listaDeItens;

    @BeforeEach
    void setUp(){
        Produto produto1 = new Produto(ITEM_1_ID_PRODUTO,
                ITEM_1_NOME_PRODUTO,
                ITEM_1_PRECO_PRODUTO,
                ITEM_1_QUANTIDADE_EM_ESTOQUE_PRODUTO);
        Item item1 = new Item(produto1,ITEM_1_QUANTIDADE);
        item1.defineValorTotal();

        Produto produto2 = new Produto(ITEM_1_ID_PRODUTO,
                ITEM_1_NOME_PRODUTO,
                ITEM_1_PRECO_PRODUTO,
                ITEM_1_QUANTIDADE_EM_ESTOQUE_PRODUTO);
        Item item2 = new Item(produto2,ITEM_1_QUANTIDADE);
        item2.defineValorTotal();

        pedido.adicionaItem(item1);
        pedido.adicionaItem(item2);
    }



    @Test
    @DisplayName("1- deve retornar troco se valor recebido for maior que valor total do pedido")
    void deveRetornarTrocoSeValorRecebidoForMaiorQueValorTotalDoPedido(){
        pedido.setValorTotalDoPedido(VALOR_TOTAL_DO_PEDIDO_MENOR_QUE_RECEBIDO);
        Double troco = pedido.retornarTroco(VALOR_RECEBIDO_MAIOR_QUE_TOTAL);

        Assertions.assertEquals(TROCO_DEZ, troco);

    }

    @Test
    @DisplayName("2- deve retornar troco se valor recebido for menor que valor total do pedido")
    void deveRetornarTrocoSeValorRecebidoForMenorQueValorTotalDoPedido(){
        pedido.setValorTotalDoPedido(VALOR_TOTAL_DO_PEDIDO_MAIOR_QUE_RECEBIDO);
        Mockito.doNothing().when(saidaImplement).imprimir(SEM_TROCO);
        Double troco = pedido.retornarTroco(VALOR_RECEBIDO_MENOR_QUE_TOTAL);

        Assertions.assertEquals(TROCO_ZERO, troco);
        Mockito.verify(saidaImplement,Mockito.times(1)).imprimir(SEM_TROCO);
    }

    @Test
    @DisplayName("3- deve calcular valor total do pedido")
    void deveCalcularValorTotalDoPedido(){

        pedido.calculaValorTotal();

        Mockito.verify(item,Mockito.atMost(1)).defineValorTotal();
    }

    @Test
    @DisplayName("4- deve adicionar item na lista")
    void deveAdicionarItemNaLista(){

        Boolean pedidoAdicionado = pedido.adicionaItemNaLista(produto, item.getQuantidade());

        Assertions.assertEquals(Boolean.TRUE,pedidoAdicionado);
    }

    @Test
    @DisplayName("5- deve imprimir pedido")
    void deveImprimirPedido(){

        Mockito.verify(saidaImplement,Mockito.atMost(1)).imprimir(pedido.getListaDeItens().stream().toString());
        Mockito.verify(saidaImplement,Mockito.atMost(1)).imprimir(pedido.getValorTotalDoPedido());
    }

    @Test
    @DisplayName("6- deve imprimir valor do pedido")
    void deveImprimirValorDoPedido(){

        pedido.imprimeValorTotal();

        Mockito.verify(saidaImplement,Mockito.atMost(1)).imprimir(pedido.getValorTotalDoPedido());
    }

    @Test
    @DisplayName("7- deve adicionar item")
    void deveAdicionarItem(){
        Produto produto = new Produto(ITEM_1_ID_PRODUTO,
                ITEM_1_NOME_PRODUTO,
                ITEM_1_PRECO_PRODUTO,
                ITEM_1_QUANTIDADE_EM_ESTOQUE_PRODUTO);
        Item item = new Item(produto,ITEM_1_QUANTIDADE);
        item.defineValorTotal();
        pedido.adicionaItem(item);

        Assertions.assertEquals(ITEM_1_NOME_PRODUTO, item.getProduto().getNome());
    }
    @Test
    @DisplayName("8- deve receber nome do teclado")
    void deveReceberNomeDoTeclado(){
        pedido.recebeNomeDoTeclado();
        Mockito.verify(entradaImplement,Mockito.atMost(1)).lerString();
    }

    @Test
    @DisplayName("9- deve receber nome do teclado")
    void deveReceberQuantidadeDoTeclado(){
        pedido.recebeQuantidadeDoTeclado();
        Mockito.verify(entradaImplement,Mockito.atMost(1)).lerString();
    }

    @Test
    @DisplayName("10- deve limpar carrinho")
    void deveLimparCarrinho(){

        pedido.limparCarrinho();

        Assertions.assertEquals(0, pedido.getListaDeItens().size());
    }


}
