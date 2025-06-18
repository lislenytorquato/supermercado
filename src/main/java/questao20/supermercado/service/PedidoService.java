package questao20.supermercado.service;

import org.springframework.stereotype.Service;
import questao20.supermercado.model.Item;
import questao20.supermercado.model.Pedido;
import questao20.supermercado.model.Produto;

import java.util.List;

@Service
public class PedidoService {

    private final Pedido pedido;

    public PedidoService(Pedido pedido){
        this.pedido = pedido;
    }

    public void criarPedido(List<Item> listaDeItens, Double valorTotalDoPedido){
        pedido.setListaDeItens(listaDeItens);
        pedido.setValorTotalDoPedido(valorTotalDoPedido);
    }

    public Double retornarTroco(Double valorRecebido){
        return pedido.retornarTroco(valorRecebido);
    }
    public void calculaValorTotal(){
        pedido.calculaValorTotal();
    }
    public Boolean adicionaItemNaLista(Produto produto, Integer quantidade){
        return pedido.adicionaItemNaLista(produto,quantidade);
    }
    public Integer calculaNotasDoTroco(Double troco){
        Integer notas200=0;
        Integer notas100=0;
        Integer notas50=0;
        Integer notas20=0;
        Integer notas10=0;
        Integer notas5=0;
        Integer notas2=0;
        Integer totalNotas=0;
        if (troco % 200.0 !=0.0){
            notas200 = (int) (troco / 200);
            troco = troco % 200.0;
            totalNotas += notas200;
        } else if (troco % 200.0 == 0.0){
            notas200 = (int) (troco / 200);
            troco -= (200*notas200);
            totalNotas += notas200;
        }
        if (troco % 100.0 !=0.0){
            notas100 = (int) (troco / 100);
            troco = troco % 100.0;
            totalNotas += notas100;
        } else if (troco % 100.0 == 0.0){
            notas100 = (int) (troco / 100);
            troco -= (100*notas100);
            totalNotas += notas100;
        }
        if (troco % 50.0 !=0.0){
            notas50 = (int) (troco / 50);
            troco = troco % 50.0;
            totalNotas += notas50;
        }
        else if (troco % 50.0 == 0.0){
            notas50 = (int) (troco / 50);
            troco -= (50*notas50);
            totalNotas += notas50;
        }
        if (troco % 20.0 !=0.0){
            notas20 = (int) (troco / 20);
            troco = troco % 20.0;
            totalNotas += notas20;
        }
        else if (troco % 20.0 == 0.0){
            notas20 = (int) (troco / 20);
            troco -= (20*notas20);
            totalNotas += notas20;
        }
        if (troco % 10.0 !=0.0){
            notas10 = (int) (troco / 10);
            troco = troco % 10.0;
            totalNotas += notas10;
        }
        else if (troco % 10.0 == 0.0){
            notas10 = (int) (troco / 10);
            troco -= (10*notas10);
            totalNotas += notas10;
        }
        if (troco % 5.0 !=0.0){
            notas5 = (int) (troco / 5);
            troco = troco % 5.0;
            totalNotas += notas5;
        }else if (troco % 5.0 == 0.0){
            notas5 = (int) (troco / 5);
            troco -= (5*notas5);
            totalNotas += notas5;
        }

        if (troco % 2.0 !=0.0){
            troco = troco % 2.0;
            if(troco==1.0){
                notas2 = troco.intValue();
                totalNotas += notas2;
            }

        }  else if (troco % 2.0 == 0.0){
            notas2 = (int) (troco / 2);
            troco -= (2*notas2);
            totalNotas += notas2;
        }
        if (troco>=3.0 && troco<4) {
            if (troco % 3.0 == 0.0 || troco % 3.0 != 0.0) {
                troco = troco % 2.0;
                notas2 = troco.intValue();
                totalNotas += notas2;
            }
        }
        return totalNotas;
    }





}
