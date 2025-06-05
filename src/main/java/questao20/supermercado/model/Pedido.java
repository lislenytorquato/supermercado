package questao20.supermercado.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Pedido {
    private List<Item> listaDeItens;
    private Double valorTotalDoPedido = 0.0;

    public Double retornarTroco(Double valorRecebido){
        Double troco = 0.0;
        if (valorRecebido>this.getValorTotalDoPedido()){
            troco = valorRecebido - this.getValorTotalDoPedido();
        }
        if (troco.equals(0.0)){
           System.out.println("Sem troco");
        }
        return troco;
    }





    public void calculaValorTotal(){
        listaDeItens.forEach(item -> {
            item.defineValorTotal();
            this.valorTotalDoPedido += item.getValorDoItem();
        });
    }
    public Boolean adicionaItemNaLista(Produto produto, Integer quantidade){
        listaDeItens.add(new Item(produto,quantidade));
        return Boolean.TRUE;
    }
    public void imprimePedido(){
    System.out.println(toString());
    }
    public void imprimeValorTotal(){
        log.info(this.getValorTotalDoPedido().toString());
    }
    public void adicionaItem(){
    }
    public String recebeNomeDoTeclado(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public Integer recebeQuantidadeDoTeclado(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public void limparCarrinho(){
        listaDeItens.clear();
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
