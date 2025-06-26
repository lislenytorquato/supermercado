package questao20.supermercado.model;

import org.springframework.stereotype.Component;
import questao20.supermercado.implement.EntradaImplement;
import questao20.supermercado.implement.SaidaImplement;

import java.util.ArrayList;
import java.util.List;

@Component
public class Pedido {
    private List<Item> listaDeItens = new ArrayList<>();
    private Double valorTotalDoPedido = 0.0;
    private SaidaImplement saidaImplement;
    private EntradaImplement entradaImplement;

    public Pedido(List<Item> listaDeItens, Double valorTotalDoPedido,
                  SaidaImplement saidaImplement, EntradaImplement entradaImplement) {
        this.listaDeItens = listaDeItens;
        this.valorTotalDoPedido = valorTotalDoPedido;
        this.saidaImplement = saidaImplement;
        this.entradaImplement = entradaImplement;
    }

    public Pedido(){

   }
    public Double retornarTroco(Double valorRecebido){
        double troco = 0.0;
        Double valorTotalPedido = this.getValorTotalDoPedido();

        if (valorRecebido < valorTotalPedido){
            saidaImplement.imprimir("Saldo insuficiente");
            return 0.0;
        }
            troco = valorRecebido - valorTotalPedido;

        if (Double.compare(troco,0.0) == 0){
           saidaImplement.imprimir("Sem troco");
        }
        return troco;
    }
    public void calcularValorTotal(){
        this.valorTotalDoPedido = 0.0;
        listaDeItens.forEach(item -> {
            item.defineValorTotal();
            this.valorTotalDoPedido += item.getValorDoItem();
        });

    }
    public boolean adicionarItemNaLista(Produto produto, Integer quantidade){
        return listaDeItens.add(new Item(produto,quantidade));
    }
    public void imprimirPedido(){
    saidaImplement.imprimir(this.listaDeItens.toString());
    saidaImplement.imprimir(this.getValorTotalDoPedido());
    }
    public void imprimirValorTotal(){
        saidaImplement.imprimir(this.getValorTotalDoPedido());
    }
    public void adicionarItem(Item item){
        listaDeItens.add(item);
    }
    public String receberNomeDoTeclado(){
        return entradaImplement.lerString();
    }
    public Integer receberQuantidadeDoTeclado(){
        return entradaImplement.lerInt();
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


}
