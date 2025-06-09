package questao20.supermercado.model;

import org.springframework.stereotype.Component;
import questao20.supermercado.implement.EntradaImplement;
import questao20.supermercado.implement.SaidaImplement;

@Component
public class Menu {

   private final EntradaImplement entradaImplement;
    private final SaidaImplement saidaImplement;

    public Menu(EntradaImplement entradaImplement, SaidaImplement saidaImplement){
        this.entradaImplement = entradaImplement;
        this.saidaImplement = saidaImplement;
    }

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
                break;
            case 2:
                mostraEstoque();
                break;
            default:
                saidaImplement.imprimir("opção inválida");
                break;
        }
    }
}
