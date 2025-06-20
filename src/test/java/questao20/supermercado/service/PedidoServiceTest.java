package questao20.supermercado.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import questao20.supermercado.helper.PedidoTestHelper;
import questao20.supermercado.model.Item;
import questao20.supermercado.model.Pedido;
import questao20.supermercado.model.Produto;

import java.util.List;

import static questao20.supermercado.helper.PedidoTestHelper.*;
import static questao20.supermercado.helper.PedidoTestHelper.ITEM_1_ID_PRODUTO;
import static questao20.supermercado.helper.PedidoTestHelper.ITEM_1_NOME_PRODUTO;
import static questao20.supermercado.helper.PedidoTestHelper.ITEM_1_PRECO_PRODUTO;
import static questao20.supermercado.helper.PedidoTestHelper.ITEM_1_QUANTIDADE;
import static questao20.supermercado.helper.PedidoTestHelper.ITEM_1_QUANTIDADE_EM_ESTOQUE_PRODUTO;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {

    @InjectMocks
    PedidoService pedidoService;

    @Mock
    Pedido pedido;

    @Test
    @DisplayName("1- deve calcular notas do troco eh maior que 200")
    void deveCalcularNotasDoTrocoEhMaiorQue200(){
        Integer notasDoTroco = pedidoService.calculaNotasDoTroco(1000.0);
        Assertions.assertEquals(5, notasDoTroco);
    }

    @Test
    @DisplayName("2- deve calcular notas do troco nao eh multiplo de 200")
    void deveCalcularNotasDoTrocoNaoEhMultiploDe200(){
        Integer notasDoTroco = pedidoService.calculaNotasDoTroco(1002.0);
        Assertions.assertEquals(6, notasDoTroco);
    }

    @Test
    @DisplayName("3- deve calcular notas do troco eh maior que 100")
    void deveCalcularNotasDoTrocoEhMaiorQue100EMenorQue200(){
        Integer notasDoTroco = pedidoService.calculaNotasDoTroco(157.0);
        Assertions.assertEquals(4, notasDoTroco);
    }

    @Test
    @DisplayName("4- deve calcular notas quando troco eh menor que 100 ou maior que 200")
    void deveCalcularNotasQuandoTrocoEhMenorQue100OuMaiorQue200(){
        Integer notasDoTroco1 = pedidoService.calculaNotasDoTroco(98.0);
        Integer notasDoTroco2 = pedidoService.calculaNotasDoTroco(210.0);
        Assertions.assertEquals(5, notasDoTroco1);
        Assertions.assertEquals(2, notasDoTroco2);
    }

    @Test
    @DisplayName("5- deve calcular notas quando troco eh maior que 50 e menor que 100")
    void deveCalcularNotasQuandoTrocoEhMaiorQue50EMenorQue100(){
        Integer notasDoTroco = pedidoService.calculaNotasDoTroco(79.0);
        Assertions.assertEquals(5, notasDoTroco);
    }

    @Test
    @DisplayName("6- deve calcular notas quando troco eh menor que 50 ou maior que 100")
    void deveCalcularNotasDoTrocoEhMenorQue50OuMaiorQue100(){
        Integer notasDoTroco1 = pedidoService.calculaNotasDoTroco(37.0);
        Integer notasDoTroco2 = pedidoService.calculaNotasDoTroco(325.0);
        Assertions.assertEquals(4, notasDoTroco1);
        Assertions.assertEquals(4, notasDoTroco2);
    }

    @Test
    @DisplayName("7- deve calcular notas quando troco eh maior que 20 e menor que 50")
    void deveCalcularNotasQuandoTrocoEhMaiorQue20EMenorQue50(){
        Integer notasDoTroco = pedidoService.calculaNotasDoTroco(25.0);
        Assertions.assertEquals(2, notasDoTroco);
    }

    @Test
    @DisplayName("8- deve calcular notas quando troco eh menor que 20 ou maior que 50")
    void deveCalcularNotasDoTrocoEhMenorQue20OuMaiorQue50(){
        Integer notasDoTroco1 = pedidoService.calculaNotasDoTroco(17.0);
        Integer notasDoTroco2 = pedidoService.calculaNotasDoTroco(65.0);
        Assertions.assertEquals(3, notasDoTroco1);
        Assertions.assertEquals(3, notasDoTroco2);
    }

    @Test
    @DisplayName("9- deve calcular notas quando troco eh maior que 10 e menor que 20")
    void deveCalcularNotasQuandoTrocoEhMaiorQue10EMenorQue20(){
        Integer notasDoTroco = pedidoService.calculaNotasDoTroco(16.75);
        Assertions.assertEquals(2, notasDoTroco);
    }

    @Test
    @DisplayName("10- deve calcular notas quando troco eh menor que 10 ou maior que 20")
    void deveCalcularNotasDoTrocoEhMenorQue10OuMaiorQue20(){
        Integer notasDoTroco1 = pedidoService.calculaNotasDoTroco(6.0);
        Integer notasDoTroco2 = pedidoService.calculaNotasDoTroco(23.0);
        Assertions.assertEquals(1, notasDoTroco1);
        Assertions.assertEquals(2, notasDoTroco2);
    }

    @Test
    @DisplayName("11- deve calcular notas quando troco eh maior que 5 e menor que 10")
    void deveCalcularNotasQuandoTrocoEhMaiorQue5EMenorQue10(){
        Integer notasDoTroco = pedidoService.calculaNotasDoTroco(8.75);
        Assertions.assertEquals(2, notasDoTroco);
    }

    @Test
    @DisplayName("12- deve calcular notas quando troco eh menor que 5 ou maior que 10")
    void deveCalcularNotasDoTrocoEhMenorQue5OuMaiorQue10(){
        Integer notasDoTroco1 = pedidoService.calculaNotasDoTroco(3.0);
        Integer notasDoTroco2 = pedidoService.calculaNotasDoTroco(15.0);
        Assertions.assertEquals(1, notasDoTroco1);
        Assertions.assertEquals(2, notasDoTroco2);
    }

    @Test
    @DisplayName("13- deve criar pedido")
    void deveCriarPedido(){
     
        pedido.setListaDeItens(pedido.getListaDeItens());
        pedido.setValorTotalDoPedido(VALOR_TOTAL_DO_PEDIDO_MENOR_QUE_RECEBIDO);
    }

    @Test
    @DisplayName("14- deve calcular notas quando troco eh 3 ou menor que 2")
    void deveCalcularNotasQuandoTrocoEhMaiorQue3OuMenorQue2(){
        Integer notasDoTroco1 = pedidoService.calculaNotasDoTroco(3.75);
        Integer notasDoTroco2 = pedidoService.calculaNotasDoTroco(1.15);
        Assertions.assertEquals(1, notasDoTroco1);
        Assertions.assertEquals(0, notasDoTroco2);
    }

}
