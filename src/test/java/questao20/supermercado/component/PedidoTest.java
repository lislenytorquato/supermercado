package questao20.supermercado.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import questao20.supermercado.implement.SaidaImplement;
import questao20.supermercado.model.Pedido;

import static questao20.supermercado.helper.PedidoTestHelper.*;

@ExtendWith(MockitoExtension.class)
public class PedidoTest {

    @InjectMocks
    Pedido pedido;

    @Mock
    SaidaImplement saidaImplement;

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


}
