package questao20.supermercado.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import questao20.supermercado.exception.ProdutoException;

import java.util.List;


public class Estoque {

    private static final Logger log = LoggerFactory.getLogger(Estoque.class);
    private final Integer id = 1;
    private List<Produto> listaDeProdutos;

    public  static Estoque inicializaEstoque(){
        return new Estoque();
    }
    public Produto encontraProduto(String nome) throws ProdutoException {
        return listaDeProdutos.stream()
                .filter(produto -> produto.getNome().equals(nome))
                .findFirst().orElseThrow(() -> new ProdutoException("Produto nao encontrado"));

    }
    public Produto encontraProduto(Integer id) throws ProdutoException {
        return listaDeProdutos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst().orElseThrow(() -> new ProdutoException("Produto nao encontrado"));
    }
    public Boolean cadastraProduto(Produto produto){
         listaDeProdutos.add(produto);
         return Boolean.TRUE;
    }
    public void imPrimeCatalogoDeEstoque(){
        log.info(listaDeProdutos.stream().toString());
    }
    public Boolean darBaixaEmEstoque(String nome, Integer quantidadePraDarBaixa) throws ProdutoException {
        Boolean darBaixaEmEstoque = Boolean.FALSE;
        Produto produtoParaDarBaixa = encontraProduto(nome);
        if (temEstoqueOuNao(produtoParaDarBaixa,quantidadePraDarBaixa)){
            darBaixaEmEstoque=Boolean.TRUE;
        }
        return darBaixaEmEstoque;
    }
    public Boolean darBaixaEmEstoque(Integer id, Integer quantidadePraDarBaixa) throws ProdutoException {
        Boolean darBaixaEmEstoque = Boolean.FALSE;
        Produto produtoParaDarBaixa = encontraProduto(id);

        if (temEstoqueOuNao(produtoParaDarBaixa,quantidadePraDarBaixa)){
            darBaixaEmEstoque=Boolean.TRUE;
        }
        return darBaixaEmEstoque;
    }
    public Integer getQuantidadeAtualEmEstoque(Produto produto){
        return produto.getQuantidadeEmEstoque();

    }
    public Integer getPosicaoDoProdutoNaLista(Produto produto) throws ProdutoException {

        Integer posicao = null;

        for (int i=0;i<listaDeProdutos.size();i++){
            if (listaDeProdutos.get(i).getId().equals(produto.getId())){
                 posicao=i;
            }
        }
        if (posicao==null){
            throw new ProdutoException("Produto nao encontrado");
        }
        return posicao;
    }
    public Boolean temEstoqueOuNao(Produto produto, Integer quantidadeParaDarBaixa){
        Boolean temEstoque = Boolean.TRUE;
        if (produto.getQuantidadeEmEstoque().equals(quantidadeParaDarBaixa)){
            temEstoque = Boolean.FALSE;
        }
        return temEstoque;
    }
}
