package questao20.supermercado.helper;

import org.springframework.beans.factory.annotation.Autowired;
import questao20.supermercado.service.PedidoService;

public class PedidoHelper {

    @Autowired
    PedidoService pedidoService;

    public Integer retonarQtdNotas200(Double troco, Double valorNota200){
        return pedidoService.calcularNotasETroco(troco,valorNota200).getFirst().intValue();
    }
    public Double retonartrocoDe200(Double troco, Double valorNota200){
        return pedidoService.calcularNotasETroco(troco,valorNota200).getLast();
    }

    public Integer retonarQtdNotas100(Double troco, Double valorNota100){
        return pedidoService.calcularNotasETroco(troco,valorNota100).getFirst().intValue();
    }
    public Double retonartrocoDe100(Double troco, Double valorNota100){
        return pedidoService.calcularNotasETroco(troco,valorNota100).getLast();
    }
    public Integer retonarQtdNotas50(Double troco, Double valorNota50){
        return pedidoService.calcularNotasETroco(troco,valorNota50).getFirst().intValue();
    }
    public Double retonartrocoDe50(Double troco, Double valorNota50){
        return pedidoService.calcularNotasETroco(troco,valorNota50).getLast().intValue();
    }
    public Integer retonarQtdNotas20(Double troco, Double valorNota20){
        return pedidoService.calcularNotasETroco(troco,valorNota20).getFirst().intValue();
    }
    public Integer retonartrocoDe20(Double troco, Double valorNota20){
        return pedidoService.calcularNotasETroco(troco,valorNota20).getLast().intValue();
    }
    public Integer retonarQtdNotas10(Double troco, Double valorNota10){
        return pedidoService.calcularNotasETroco(troco,valorNota10).getFirst().intValue();
    }
    public Integer retonartrocoDe10(Double troco, Double valorNota10){
        return pedidoService.calcularNotasETroco(troco,valorNota10).getLast().intValue();
    }
    public Integer retonarQtdNotas5(Double troco, Double valorNota5){
        return pedidoService.calcularNotasETroco(troco,valorNota5).getFirst().intValue();
    }
    public Integer retonartrocoDe5(Double troco, Double valorNota5){
        return pedidoService.calcularNotasETroco(troco,valorNota5).getLast().intValue();
    }
    public Integer retonarQtdNotas2(Double troco, Double valorNota2){
        return pedidoService.calcularNotasETroco(troco,valorNota2).getFirst().intValue();
    }
    public Integer retonartrocoDe2(Double troco, Double valorNota2){
        return pedidoService.calcularNotasETroco(troco,valorNota2).getLast().intValue();
    }
}
