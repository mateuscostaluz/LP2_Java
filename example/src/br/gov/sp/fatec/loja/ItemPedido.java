package br.gov.sp.fatec.loja;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedido {
  private Integer quantidade;
  private Produto produto;
  
  public Double calculaValorItem() {
    return quantidade * produto.getPreco();
  }
}
