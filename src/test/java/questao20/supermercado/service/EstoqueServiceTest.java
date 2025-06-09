package questao20.supermercado.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import questao20.supermercado.implement.EntradaImplement;
import questao20.supermercado.implement.SaidaImplement;
import questao20.supermercado.model.Estoque;
import questao20.supermercado.model.Menu;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

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

        Mockito.doNothing().when(menu).controlaMenu();
         estoqueService.exibirMenu();
        Mockito.verify(menu, Mockito.times(1)).controlaMenu();
    }

}
