package questao20.supermercado.model;

import org.springframework.beans.factory.annotation.Autowired;
import questao20.supermercado.implement.EntradaImplement;
import questao20.supermercado.implement.SaidaImplement;

public class Menu {

    @Autowired
    EntradaImplement entradaImplement;
    @Autowired
    SaidaImplement saidaImplement;

    public void controlaMenu(){
        saidaImplement.imprimir("Escolha as opções do menu");
        saidaImplement.imprimir("1- Controlar Menu");
        saidaImplement.imprimir("2- Mostrar Estoque");
        switchCase();
    }

    public void mostraEstoque(){
        Estoque estoque = new Estoque();
        estoque.inicializaEstoque();
    }
    public void switchCase (){
        int opcao = entradaImplement.lerInt();
        switch (opcao){
            case 1:
                controlaMenu();
            case 2:
                mostraEstoque();
            default:
                saidaImplement.imprimir("opção inválida");
        }
    }
}
