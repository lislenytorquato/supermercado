package questao20.supermercado.component;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import questao20.supermercado.implement.EntradaImplement;
import questao20.supermercado.implement.SaidaImplement;
import questao20.supermercado.model.Menu;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MenuTest {

    @InjectMocks
    private Menu menu;

    @Mock
    EntradaImplement entradaImplement;

    @Mock
    SaidaImplement saidaImplement;

    @Test
    @DisplayName("1- deve controlar menu")
    void deveControlarMenu(){
        String primeiraLinha = "Escolha as opções do menu";
        String segundaLinha = "1- Controlar Menu";
        String terceiraLinha = "2- Mostrar Estoque";
        doNothing().when(saidaImplement).imprimir(primeiraLinha);
        doNothing().when(saidaImplement).imprimir(segundaLinha);
        doNothing().when(saidaImplement).imprimir(terceiraLinha);
        when(entradaImplement.lerInt()).thenReturn(1);
        menu.controlaMenu();
        verify(saidaImplement,times(1)).imprimir(primeiraLinha);
        verify(saidaImplement,times(1)).imprimir(segundaLinha);
        verify(saidaImplement,times(1)).imprimir(terceiraLinha);
        verify(entradaImplement,times(1)).lerInt();
    }
}
