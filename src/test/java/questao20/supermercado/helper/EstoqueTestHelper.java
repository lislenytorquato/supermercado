package questao20.supermercado.helper;

import questao20.supermercado.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class EstoqueTestHelper {
    public static final Integer ID_ESTOQUE = 1;
    public static final Integer ID_PRODUTO_1 = 1;
    public static final String NOME_PRODUTO_1 = "MACARRÃO" ;
    public static final Integer QTD_ESTOQUE_PRODUTO_1 = 10;
    public static final Double PRECO_PRODUTO_1 = 10.28 ;
    public static final Integer ID_PRODUTO_2 = 2;
    public static final String NOME_PRODUTO_2 = "SABÃO EM PÓ" ;
    public static final Integer QTD_ESTOQUE_PRODUTO_2 = 16;
    public static final Double PRECO_PRODUTO_2 = 13.65 ;
    public static final Integer ID_PRODUTO_3 = 3;
    public static final String NOME_PRODUTO_3 = "FRANGO" ;
    public static final Integer QTD_ESTOQUE_PRODUTO_3 = 30;
    public static final Double PRECO_PRODUTO_3 = 31.74 ;
    public static final String NOME_PRODUTO_INEXISTENTE = "CAFÉ";
    public static final Integer ID_PRODUTO_INEXISTENTE = 4;
    public static final Integer QTD_PARA_DAR_BAIXA_IGUAL_A_QTD_ESTOQUE_PRODUTO_1 = 10;
    public static final Integer QTD_PARA_DAR_BAIXA_DIFERENTE_A_QTD_ESTOQUE_PRODUTO_1 = 7;

    public static List<Produto> criarListaDeProdutos(){
        Produto produto1 =  new Produto(ID_PRODUTO_1,NOME_PRODUTO_1,PRECO_PRODUTO_1,QTD_ESTOQUE_PRODUTO_1);
        Produto produto2 =  new Produto(ID_PRODUTO_2,NOME_PRODUTO_2,PRECO_PRODUTO_2,QTD_ESTOQUE_PRODUTO_2);
        Produto produto3 = new Produto(ID_PRODUTO_3,NOME_PRODUTO_3,PRECO_PRODUTO_3,QTD_ESTOQUE_PRODUTO_3);

        List<Produto> listaDeProdutos = new ArrayList<>();
        listaDeProdutos.add(produto1);
        listaDeProdutos.add(produto2);
        listaDeProdutos.add(produto3);

        return listaDeProdutos;
    }
}
