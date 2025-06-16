package questao20.supermercado.model;

import org.springframework.stereotype.Component;
import questao20.supermercado.implement.SaidaImplement;

import java.util.List;
import java.util.Scanner;

@Component
public class Pedido {
    private List<Item> listaDeItens;
    private Double valorTotalDoPedido = 0.0;
    private SaidaImplement saidaImplement;

    public Pedido(List<Item> listaDeItens, Double valorTotalDoPedido, SaidaImplement saidaImplement) {
        this.listaDeItens = listaDeItens;
        this.valorTotalDoPedido = valorTotalDoPedido;
        this.saidaImplement = saidaImplement;
    }

    public Pedido(){

   }
    public Double retornarTroco(Double valorRecebido){
        Double troco = 0.0;
        if (valorRecebido>this.getValorTotalDoPedido()){
            troco = valorRecebido - this.getValorTotalDoPedido();
        }
        if (troco.equals(0.0)){
           saidaImplement.imprimir("Sem troco");
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
        System.out.println(this.getValorTotalDoPedido());
    }
    public void adicionaItem(Item item){
        listaDeItens.add(item);
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
