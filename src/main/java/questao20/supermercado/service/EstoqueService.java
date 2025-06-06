package questao20.supermercado.service;

import questao20.supermercado.exception.ProdutoException;
import questao20.supermercado.model.Estoque;
import questao20.supermercado.model.Menu;
import questao20.supermercado.model.Produto;

public class EstoqueService {

    Estoque estoque;

    public void exibirMenu(){
        Menu menu = new Menu();
        menu.controlaMenu();
    }
    public void criarEstoque(Produto produtoNovo){
        if (estoque.cadastraProduto(produtoNovo)){
            estoque.inicializaEstoque();
        }
    }
    public Produto encontraProdutoPorNomeNoEstoque(String nome) throws ProdutoException {
        return estoque.encontraProduto(nome);
    }
    public Produto encontraProdutoPorIdNoEstoque(Integer id) throws ProdutoException {
        return estoque.encontraProduto(id);
    }



}
