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
        Double[] valores={200.00,100.00,50.00,20.00,10.00,5.00,2.00};
        Integer[] qtdNotas = new Integer[7];
        Integer totalQtdNotas = 0;
        for (int i = 0; i<7; i++){

            if (troco % valores[i] !=0.00){
                qtdNotas[i] = (int) Math.floor(troco / valores[i]);
                troco = troco % valores[i];
                totalQtdNotas += qtdNotas[i];
            } else if (troco % valores[i] == 0.00){
                 qtdNotas[i] = (int) (troco / valores[i]);
                troco -= (valores[i]*qtdNotas[i]);
                totalQtdNotas += qtdNotas[i];
            }

        }
        return totalQtdNotas;
    }





}
