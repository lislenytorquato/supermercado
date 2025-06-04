package questao20.supermercado.model;

import java.util.List;

public class Pedido {
    private List<Item> listaDeItens;
    private Double valorTotalDoPedido;

    public void calculaValorTotal(){

    }
    public Boolean adicionaItemNaLista(Produto produto, Integer quantidade){

    }
    public void imprimePedido(){

    }
    public void imprimeValorTotal(){

    }
    public void adicionaItem(){

    }
    public String recebeNomeDoTeclado(){

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
}
