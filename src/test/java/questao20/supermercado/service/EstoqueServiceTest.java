package questao20.supermercado.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import questao20.supermercado.implement.EntradaImplement;
import questao20.supermercado.implement.SaidaImplement;
import questao20.supermercado.model.Menu;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class EstoqueServiceTest {

    @InjectMocks
    EstoqueService estoqueService;

    @Mock
    EntradaImplement entradaImplement;

    @Mock
    SaidaImplement saidaImplement;

    @Test
    @DisplayName("1- deve exibir menu quando entrada eh um")
    void deveExibirMenuQuandoEntradaEhUm(){
        String primeiraLinha = "Escolha as opções do menu";
        String segundaLinha = "1- Controlar Menu";
        String terceiraLinha = "2- Mostrar Estoque";
        Mockito.when(saidaImplement.imprimir(primeiraLinha)).
        Mockito.when(entradaImplement.lerInt()).thenReturn(1);
        estoqueService.exibirMenu();

        Mockito.verify(entradaImplement,Mockito.times(1));



    }

}
