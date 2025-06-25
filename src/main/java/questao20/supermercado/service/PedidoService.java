package questao20.supermercado.service;

import org.springframework.stereotype.Service;
import questao20.supermercado.model.Item;
import questao20.supermercado.model.Pedido;
import questao20.supermercado.model.Produto;

@Service
public class PedidoService {

    private final Pedido pedido;

    public PedidoService(Pedido pedido){
        this.pedido = pedido;
    }

    public Double retornarTroco(Double valorRecebido){
        return pedido.retornarTroco(valorRecebido);
    }
    public void calculaValorTotal(){
        pedido.calcularValorTotal();
    }
    public Boolean adicionaItemNaLista(Produto produto, Integer quantidade){
        return pedido.adicionarItemNaLista(produto,quantidade);
    }
    public void imprimePedido(){
        pedido.imprimirPedido();
    }
    public void imprimeValorTotal(){
        pedido.imprimirValorTotal();
    }
    public void adicionaItem(Item item){
        pedido.adicionarItem(item);
    }
    public String recebeNomeDoTeclado(){
       return pedido.receberNomeDoTeclado();
    }
    public Integer recebeQuantidadeDoTeclado(){
        return pedido.receberQuantidadeDoTeclado();
    }
    public void limparCarrinho(){
        pedido.limparCarrinho();
    }
    public Integer calculaNotasDoTroco(Double troco){
        Double[] valores={200.00,100.00,50.00,20.00,10.00,5.00,2.00};
        Integer[] quantidadeDeNotas = new Integer[7];
        Integer totalQuantidadeNotas = 0;
        for (int i = 0; i<7; i++){

            if (troco % valores[i] !=0.00){
                quantidadeDeNotas[i] = (int) Math.floor(troco / valores[i]);
                troco = troco % valores[i];
                totalQuantidadeNotas += quantidadeDeNotas[i];
            } else if (troco % valores[i] == 0.00){
                 quantidadeDeNotas[i] = (int) (troco / valores[i]);
                troco -= (valores[i]*quantidadeDeNotas[i]);
                totalQuantidadeNotas += quantidadeDeNotas[i];
            }

        }
        return totalQuantidadeNotas;
    }





}
