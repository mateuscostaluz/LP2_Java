package br.gov.sp.fatec.exercicio2;

import lombok.Getter;
import lombok.Setter;

public class Invoice {
  @Setter
  private Long numeroItem;
  @Setter
  private String descricaoItem;
  @Setter
  @Getter
  private Long quantidadeItem;
  @Setter
  @Getter
  private Double precoUnitarioItem;
  
  public Invoice(Long numeroItem, String descricaoItem, Long quantidadeItem, Double precoUnitarioItem) {
    setNumeroItem(numeroItem);
    setDescricaoItem(descricaoItem);
    setQuantidadeItem(quantidadeItem);
    setPrecoUnitarioItem(precoUnitarioItem);
  }
  
  public void setQuantidade(Long quantidadeItem) {
    this.quantidadeItem = quantidadeItem < 0 ? 0 : quantidadeItem;
  }
  
  public void setPrecoUnitario(Double precoUnitarioItem) {
    this.precoUnitarioItem = precoUnitarioItem < 0 ? 0 : precoUnitarioItem;
  }
  
  public Double getInvoiceAmount() {
    return getQuantidadeItem() * getPrecoUnitarioItem();
  }
}
