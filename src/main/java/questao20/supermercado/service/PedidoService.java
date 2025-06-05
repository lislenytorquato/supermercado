package questao20.supermercado.service;

import org.springframework.stereotype.Service;
import questao20.supermercado.helper.PedidoHelper;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    public Integer calcularMenorQuantidadeDeNotas(Double troco){
        Integer qtdNotas = 0;
        PedidoHelper pedidoHelper = new PedidoHelper();
        if (troco>200.0){
          


    }


    public List<Double> calcularNotasETroco(Double troco, Double valorNota){
        Double resultado = 0.0;
        Integer qtdNotas = 0;
        List<Double> qtdNotasETroco = new ArrayList<>();

        if (troco > valorNota) {
            resultado = troco / valorNota;
            qtdNotas = (int) Math.floor(resultado);
            troco -= (valorNota * qtdNotas);
        }
        qtdNotasETroco.add(qtdNotas.doubleValue());
        qtdNotasETroco.add(troco);
        return qtdNotasETroco;
    }

}
