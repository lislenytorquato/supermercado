package questao20.supermercado.implement;

import questao20.supermercado.interfaces.IEntrada;

import java.util.Scanner;

public class EntradaImplement implements IEntrada {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String lerString() {
        return scanner.nextLine();
    }

    @Override
    public Integer lerInt() {
        return scanner.nextInt();
    }


}
