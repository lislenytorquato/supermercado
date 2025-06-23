package questao20.supermercado.helper;

import questao20.supermercado.implement.EntradaImplement;
import questao20.supermercado.implement.SaidaImplement;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doNothing;

public class MenuTestHelper {
    private static final String PRIMEIRA_LINHA = "Escolha as opções do menu";
    private static final String SEGUNDA_LINHA = "1- Controlar Menu";
    private static final String TERCEIRA_LINHA = "2- Mostrar Estoque";
    private static final String QUARTA_LINHA = "3- Sair";
    public static final String CASE_3_RESPOSTA = "Saindo...";
    public static final String DEFAULT_RESPOSTA ="opção inválida";


    public static void menuDoNothingWhen(SaidaImplement saidaImplement){
        doNothing().when(saidaImplement).imprimir(PRIMEIRA_LINHA);
        doNothing().when(saidaImplement).imprimir(SEGUNDA_LINHA);
        doNothing().when(saidaImplement).imprimir(TERCEIRA_LINHA);
        doNothing().when(saidaImplement).imprimir(QUARTA_LINHA);
    }
    public static void verificarMenu(SaidaImplement saidaImplement, EntradaImplement entradaImplement){
        verify(saidaImplement,times(1)).imprimir(PRIMEIRA_LINHA);
        verify(saidaImplement,times(1)).imprimir(SEGUNDA_LINHA);
        verify(saidaImplement,times(1)).imprimir(TERCEIRA_LINHA);
        verify(saidaImplement, times(1)).imprimir(QUARTA_LINHA);
        verify(entradaImplement,times(1)).lerInt();
        verify(saidaImplement,times(1)).imprimir(PRIMEIRA_LINHA);
        verify(saidaImplement,times(1)).imprimir(SEGUNDA_LINHA);
        verify(saidaImplement,times(1)).imprimir(TERCEIRA_LINHA);
        verify(saidaImplement, times(1)).imprimir(QUARTA_LINHA);
        verify(entradaImplement,times(1)).lerInt();
    }

}
