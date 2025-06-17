package questao20.supermercado.model;

import org.springframework.stereotype.Component;

@Component
public class                                                                                                    Item {

    private Produto produto;
    private Integer quantidade;
    private Double valorDoItem;

    public Item(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public void defineValorTotal(){
           this.valorDoItem = this.produto.getPreco()* this.quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorDoItem() {
        return valorDoItem;
    }

    public void setValorDoItem(Double valorDoItem) {
        this.valorDoItem = valorDoItem;
    }
}
