package br.gov.sp.fatec.exercicio2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Invoice {
  private Integer numeroItem;
  private String descricaoItem;
  private Integer quantidadeItem;
  private Double precoUnitarioItem;
  
  public Invoice(Integer numeroItem, String descricaoItem, Integer quantidadeItem, Double precoUnitarioItem) {
    this.numeroItem = numeroItem;
    this.descricaoItem = descricaoItem;
    this.quantidadeItem = (quantidadeItem < 0) ? 0 : quantidadeItem;
    this.precoUnitarioItem = (precoUnitarioItem < 0) ? 0.0 : precoUnitarioItem;
  }
  
  public Double getInvoiceAmount() {
    return (quantidadeItem * precoUnitarioItem);
  }
  
}
