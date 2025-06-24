package questao20.supermercado.helper;

import questao20.supermercado.model.Item;
import questao20.supermercado.model.Produto;

import java.util.List;

public class PedidoTestHelper {
    public static final Double TROCO_ZERO = 0.0;
    public static final Double VALOR_TOTAL_DO_PEDIDO_MAIOR_QUE_RECEBIDO = 100.0;
    public static final Double VALOR_RECEBIDO_MENOR_QUE_TOTAL = 70.0;
    public static final Double TROCO_TRINTA = 30.0;
    public static final Double VALOR_RECEBIDO_MAIOR_QUE_TOTAL = 110.0;
    public static final Double OUTRO_VALOR_RECEBIDO_MAIOR_QUE_TOTAL = 130.0;
    public static final Double VALOR_TOTAL_DO_PEDIDO_MENOR_QUE_RECEBIDO = 100.0;
    public static final Double TROCO_DEZ = 10.00;
    public static final Double TROCO_NOVE = 9.42;
    public static final String SEM_TROCO = "Sem troco";
    public static final String SALDO_INSUFICIENTE = "Saldo insuficiente";
    public static final String ITEM_1_NOME_PRODUTO = "MACARRÃO";
    public static final Double ITEM_1_PRECO_PRODUTO = 10.98;
    public static final Integer ITEM_1_QUANTIDADE_EM_ESTOQUE_PRODUTO = 10;
    public static final Integer ITEM_1_ID_PRODUTO = 1;
    public static final Integer ITEM_1_QUANTIDADE = 1;
    public static final String ITEM_2_NOME_PRODUTO = "ARROZ";
    public static final Double ITEM_2_PRECO_PRODUTO = 11.96;
    public static final Integer ITEM_2_QUANTIDADE_EM_ESTOQUE_PRODUTO = 13;
    public static final Integer ITEM_2_ID_PRODUTO = 2;
    public static final Integer ITEM_2_QUANTIDADE = 11;

    public static Produto criarProduto1(){
        Produto produto1 = new Produto(ITEM_1_ID_PRODUTO,
                ITEM_1_NOME_PRODUTO,
                ITEM_1_PRECO_PRODUTO,
                ITEM_1_QUANTIDADE_EM_ESTOQUE_PRODUTO);
        return produto1;
    }
    public static Produto criarProduto2(){
        Produto produto2 = new Produto(ITEM_2_ID_PRODUTO,
                ITEM_2_NOME_PRODUTO,
                ITEM_2_PRECO_PRODUTO,
                ITEM_2_QUANTIDADE_EM_ESTOQUE_PRODUTO);
         return produto2;
    }
    public static List<Item> criarListaDeitens(){

        Item item1 = new Item(criarProduto1(),ITEM_1_QUANTIDADE);
        item1.defineValorTotal();

        Item item2 = new Item(criarProduto2(),ITEM_2_QUANTIDADE);
        item2.defineValorTotal();

        return List.of(item1, item2);

    }
}
