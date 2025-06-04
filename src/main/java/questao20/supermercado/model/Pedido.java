package questao20.supermercado.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Pedido {
    private static final Logger log = LoggerFactory.getLogger(Pedido.class);
    private List<Item> listaDeItens;
    private Double valorTotalDoPedido = 0.0;

    public void calculaValorTotal(){

    }
    public Boolean adicionaItemNaLista(Produto produto, Integer quantidade){

    }
    public void imprimePedido(){
        log.info(this.toString());
    }
    public void imprimeValorTotal(){
        log.info(this.getValorTotalDoPedido().toString());
    }
    public void adicionaItem(){

    }
    public String recebeNomeDoTeclado(){
        return listaDeItens.stream().findAny().orElseThrow()
    }
    public Integer recebeQuantidadeDoTeclado(){

    }
    public void limparCarrinho(){

    }

    public List<Item> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(List<Item> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    public Double getValorTotalDoPedido() {
        return valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(Double valorTotalDoPedido) {
        this.valorTotalDoPedido = valorTotalDoPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "listaDeItens=" + listaDeItens +
                ", valorTotalDoPedido=" + valorTotalDoPedido +
                '}';
    }
}
