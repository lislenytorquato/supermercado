package questao20.supermercado.implement;

import questao20.supermercado.interfaces.ISaida;

public class SaidaImplement implements ISaida {

    @Override
    public void imprimir(Double texto){
        System.out.println(texto);
    }

    @Override
    public void imprimir(Integer texto){
        System.out.println(texto);
    }

    @Override
    public void imprimir(String texto) {
        System.out.println(texto);
    }
}
