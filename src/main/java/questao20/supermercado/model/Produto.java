package questao20.supermercado.model;

public class Produto {
   private Integer id;
   private String nome;
   private Double preco;
   private Integer quantidadeEmEstoque;

   public Produto(Integer id, String nome, Double preco, Integer quantidadeEmEstoque) {
      this.id = id;
      this.nome = nome;
      this.preco = preco;
      this.quantidadeEmEstoque = quantidadeEmEstoque;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public Double getPreco() {
      return preco;
   }

   public void setPreco(Double preco) {
      this.preco = preco;
   }

   public Integer getQuantidadeEmEstoque() {
      return quantidadeEmEstoque;
   }

   public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
      this.quantidadeEmEstoque = quantidadeEmEstoque;
   }
}
