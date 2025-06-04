package questao20.supermercado.model;

import questao20.supermercado.exception.ProdutoException;

import java.util.List;


public class Estoque {

    private Integer id;
    private List<Produto> listaDeProdutos;

    public void inicializaEstoque(){

    }
    public Produto encontraProduto(String nome){

    }
    public Produto encontraProduto(Integer id){

    }
    public Boolean cadastraProduto(Produto produto){

    }
    public void imPrimeCatalogoDeEstoque(){

    }
    public Boolean darBaixaEmEstoque(String nome, Integer quantidadePraDarBaixa){

    }
    public Boolean darBaixaEmEstoque(Integer id, Integer quantidadePraDarBaixa) throws ProdutoException {

        Produto produtoParaDarBaixa = listaDeProdutos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst().orElseThrow(() -> new ProdutoException("Produto nao encontrado"));

        produtoParaDarBaixa.setQuantidadeEmEstoque(quantidadePraDarBaixa);

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
