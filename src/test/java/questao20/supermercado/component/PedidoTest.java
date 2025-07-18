package questao20.supermercado.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
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
    List<Item> listaDeItens;


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
        Mockito.doNothing().when(saidaImplement).imprimir(SALDO_INSUFICIENTE);
        Mockito.doNothing().when(saidaImplement).imprimir(SEM_TROCO);
        Double troco = pedido.retornarTroco(VALOR_RECEBIDO_MENOR_QUE_TOTAL);

        Assertions.assertEquals(TROCO_ZERO, troco);
        Mockito.verify(saidaImplement,Mockito.times(1)).imprimir(SALDO_INSUFICIENTE);
        Mockito.verify(saidaImplement,Mockito.times(1)).imprimir(SEM_TROCO);
    }

    @Test
    @DisplayName("3- deve retornar troco se valor recebido for igual ao valor total do pedido")
    void deveRetornarTrocoSeValorRecebidoForIgualAoValorTotalDoPedido(){
        pedido.setValorTotalDoPedido(VALOR_TOTAL_DO_PEDIDO_IGUAL_AO_RECEBIDO);
        Mockito.doNothing().when(saidaImplement).imprimir(SEM_TROCO);
        Double troco = pedido.retornarTroco(VALOR_RECEBIDO_IGUAL_AO_TOTAL_DO_PEDIDO);

        Assertions.assertEquals(TROCO_ZERO, troco);
        Mockito.verify(saidaImplement,Mockito.times(1)).imprimir(SEM_TROCO);
    }

    @Test
    @DisplayName("4- deve calcular valor total do pedido")
    void deveCalcularValorTotalDoPedido(){

        pedido.calcularValorTotal();

        Mockito.verify(item,Mockito.atMost(1)).defineValorTotal();
    }

    @Test
    @DisplayName("5- deve adicionar item na lista")
    void deveAdicionarItemNaLista(){
        Produto produto1 = criarProduto1();

        Mockito.when(listaDeItens.add(Mockito.any(Item.class))).thenReturn(true);

        boolean pedidoAdicionado = pedido.adicionarItemNaLista(produto1, 3);


        Assertions.assertEquals(true,pedidoAdicionado);

    }

    @Test
    @DisplayName("6- deve imprimir pedido")
    void deveImprimirPedido(){
        pedido.imprimirPedido();

        Mockito.verify(saidaImplement,Mockito.atMost(1)).imprimir(pedido.getListaDeItens().stream().toString());
        Mockito.verify(saidaImplement,Mockito.atMost(1)).imprimir(pedido.getValorTotalDoPedido());
    }

    @Test
    @DisplayName("7- deve imprimir valor do pedido")
    void deveImprimirValorDoPedido(){

        pedido.imprimirValorTotal();

        Mockito.verify(saidaImplement,Mockito.atMost(1)).imprimir(pedido.getValorTotalDoPedido());
    }

    @Test
    @DisplayName("8- deve adicionar item")
    void deveAdicionarItem(){
        Produto produto = new Produto(ITEM_1_ID_PRODUTO,
                ITEM_1_NOME_PRODUTO,
                ITEM_1_PRECO_PRODUTO,
                ITEM_1_QUANTIDADE_EM_ESTOQUE_PRODUTO);
        Item item = new Item(produto,ITEM_1_QUANTIDADE);
        item.defineValorTotal();
        pedido.adicionarItem(item);

        Assertions.assertEquals(ITEM_1_NOME_PRODUTO, item.getProduto().getNome());
    }
    @Test
    @DisplayName("9- deve receber nome do teclado")
    void deveReceberNomeDoTeclado(){
        pedido.receberNomeDoTeclado();
        Mockito.verify(entradaImplement,Mockito.atMost(1)).lerString();
    }

    @Test
    @DisplayName("10- deve receber quantidade do teclado")
    void deveReceberQuantidadeDoTeclado(){
        pedido.receberQuantidadeDoTeclado();
        Mockito.verify(entradaImplement,Mockito.atMost(1)).lerString();
    }

    @Test
    @DisplayName("11- deve limpar carrinho")
    void deveLimparCarrinho(){

        pedido.limparCarrinho();

        Assertions.assertEquals(0, pedido.getListaDeItens().size());
    }


}
