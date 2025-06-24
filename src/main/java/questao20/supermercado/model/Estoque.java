package questao20.supermercado.model;

import org.springframework.stereotype.Component;
import questao20.supermercado.exception.ProdutoException;
import questao20.supermercado.implement.SaidaImplement;

import java.util.ArrayList;
import java.util.List;

@Component
public class Estoque {

    private final Integer id = 1;
    private final List<Produto> listaDeProdutos = new ArrayList<>();
    private final SaidaImplement saidaImplement;

    public Estoque(SaidaImplement saidaImplement) {
        this.saidaImplement = saidaImplement;
    }

    public void inicializarEstoque(){
        this.imPrimirCatalogoDeEstoque();
    }
    public Produto encontrarProdutoPorNome(String nome) throws ProdutoException {
        return listaDeProdutos.stream()
                .filter(produto -> produto.getNome().equals(nome))
                .findFirst().orElseThrow(() -> new ProdutoException("Produto nao encontrado"));

    }
    public Produto encontrarProdutoPorId(Integer id) throws ProdutoException {
        return listaDeProdutos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst().orElseThrow(() -> new ProdutoException("Produto nao encontrado"));
    }
    public boolean cadastrarProduto(Produto produto){
         return listaDeProdutos.add(produto);
    }
    public void imPrimirCatalogoDeEstoque(){
        saidaImplement.imprimir(listaDeProdutos.toString());

    }
    public boolean darBaixaEmEstoquePorNome(String nome, Integer quantidadePraDarBaixa) throws ProdutoException {
        boolean darBaixaEmEstoque = false;
        Produto produtoParaDarBaixa = encontrarProdutoPorNome(nome);
        int quantidadeDeProdutos = produtoParaDarBaixa.getQuantidadeEmEstoque();

        if (temEstoque(produtoParaDarBaixa,quantidadePraDarBaixa)){
             quantidadeDeProdutos -= quantidadePraDarBaixa;
            darBaixaEmEstoque = true;
        }

        return darBaixaEmEstoque;
    }
    public Boolean darBaixaEmEstoquePorId(Integer id, Integer quantidadePraDarBaixa) throws ProdutoException {
        Boolean darBaixaEmEstoque = Boolean.FALSE;
        Produto produtoParaDarBaixa = encontrarProdutoPorId(id);
        int quantidadeDeProdutos = produtoParaDarBaixa.getQuantidadeEmEstoque();

        if (temEstoque(produtoParaDarBaixa,quantidadePraDarBaixa)){
            quantidadeDeProdutos -= quantidadePraDarBaixa;
            darBaixaEmEstoque=Boolean.TRUE;
        }

        return darBaixaEmEstoque;
    }
    public Integer getQuantidadeAtualEmEstoque(Produto produto){
        return produto.getQuantidadeEmEstoque();
    }
    public int getPosicaoDoProdutoNaLista(Produto produto) throws ProdutoException {

        for (int i=0;i<listaDeProdutos.size();i++){
            if (listaDeProdutos.get(i).getId().equals(produto.getId())){
                 return i;
            }
        }
            throw new ProdutoException("Produto nao encontrado");
    }
    public Boolean temEstoque(Produto produto, int quantidadeParaDarBaixa){
        return produto.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa;
    }
}
