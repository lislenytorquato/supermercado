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




}
