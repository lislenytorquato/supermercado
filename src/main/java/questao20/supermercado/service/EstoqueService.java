package questao20.supermercado.service;

import org.springframework.stereotype.Service;
import questao20.supermercado.exception.ProdutoException;
import questao20.supermercado.implement.SaidaImplement;
import questao20.supermercado.model.Estoque;
import questao20.supermercado.model.Menu;
import questao20.supermercado.model.Produto;

@Service
public class EstoqueService {

    private final Estoque estoque;
    private final Menu menu;
    private final SaidaImplement saidaImplement;

    public EstoqueService(Estoque estoque, Menu menu, SaidaImplement saidaImplement){
       this.estoque = estoque;
       this.menu = menu;
       this.saidaImplement = saidaImplement;
    }

    public void exibirMenu(){

        menu.controlaMenu();
    }
    public void criarEstoque(Produto produtoNovo){
        if (estoque.cadastrarProduto(produtoNovo)){
            estoque.inicializarEstoque();
        }
    }
    public Produto encontraProdutoPorNomeNoEstoque(String nome) throws ProdutoException {
        return estoque.encontrarProdutoPorNome(nome);
    }
    public Produto encontraProdutoPorIdNoEstoque(Integer id) throws ProdutoException {
        return estoque.encontrarProdutoPorId(id);
    }
    public void darBaixaEmEstoquePorNomeDoProduto(String nome, Integer quantidadePraDarBaixa) throws ProdutoException {
        if (estoque.darBaixaEmEstoquePorNome(nome,quantidadePraDarBaixa)){
            saidaImplement.imprimir(nome+ "saiu do estoque...");
        }
    }
    public void darBaixaEmEstoquePorIdDoProduto(Integer id, Integer quantidadePraDarBaixa) throws ProdutoException {
        if (estoque.darBaixaEmEstoquePorId(id,quantidadePraDarBaixa)){
            saidaImplement.imprimir(id+ "saiu do estoque...");
        }
    }

    public Integer retornarPosicaoDoProdutoNaLista(Produto produto) throws ProdutoException {
        return estoque.getPosicaoDoProdutoNaLista(produto);
    }






}
