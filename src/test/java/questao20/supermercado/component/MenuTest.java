package questao20.supermercado.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import questao20.supermercado.implement.EntradaImplement;
import questao20.supermercado.implement.SaidaImplement;
import questao20.supermercado.model.Estoque;
import questao20.supermercado.model.Menu;
import questao20.supermercado.model.Produto;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static questao20.supermercado.helper.MenuTestHelper.*;
import static questao20.supermercado.helper.MenuTestHelper.verificarMenu;

@ExtendWith(MockitoExtension.class)
public class MenuTest {

    @InjectMocks
    private Menu menu;

    @Mock
    EntradaImplement entradaImplement;

    @Mock
    SaidaImplement saidaImplement;

    @Mock
    Estoque estoque;


    @Test
    @DisplayName("1- deve escolher controlar menu e escolher sair")
    void deveControlarMenuEDepoisSair(){

        menuDoNothingWhen(saidaImplement);
        when(entradaImplement.lerInt()).thenReturn(1);
        doNothing().when(saidaImplement).imprimir(CASE_3_RESPOSTA);
        when(entradaImplement.lerInt()).thenReturn(3);
        menu.controlaMenu();
        verificarMenu(saidaImplement, entradaImplement);
        verify(saidaImplement, times(1)).imprimir(CASE_3_RESPOSTA);

    }

    @Test
    @DisplayName("2-deve escolher mostrar estoque")
    void deveMostrarEstoque(){

        menuDoNothingWhen(saidaImplement);
        when(entradaImplement.lerInt()).thenReturn(2);
      doNothing().when(estoque).inicializaEstoque();
        menu.controlaMenu();

      verificarMenu(saidaImplement,entradaImplement);
       verify(entradaImplement,times(1)).lerInt();
        verify(estoque,times(1)).inicializaEstoque();
    }

    @Test
    @DisplayName("3- deve mostrar mensagem default quando a opcao eh invalida")
    void deveMostrarOpcaoInvalida(){
        menuDoNothingWhen(saidaImplement);
        when(entradaImplement.lerInt()).thenReturn(4);
        doNothing().when(saidaImplement).imprimir(DEFAULT_RESPOSTA);
        menu.controlaMenu();

        verificarMenu(saidaImplement,entradaImplement);
        verify(saidaImplement,times(1)).imprimir(DEFAULT_RESPOSTA);

    }
}
