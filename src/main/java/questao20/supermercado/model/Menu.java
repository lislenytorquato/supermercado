package questao20.supermercado.model;

import java.util.Scanner;

public class Menu {

    public void controlaMenu(){
        System.out.println("Escolha as opções do menu");
        System.out.println("1- Controlar Menu");
        System.out.println("2- Mostrar Estoque");
        switchCase();
    }

    public void mostraEstoque(){
        Estoque.inicializaEstoque().imPrimeCatalogoDeEstoque();

    }
    public void switchCase (){
         Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()){
            case 1:
                controlaMenu();
            case 2:
                mostraEstoque();
            default:
                System.out.println("opção inválida");
        }
    }
}
