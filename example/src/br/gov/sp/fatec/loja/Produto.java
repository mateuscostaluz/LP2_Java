package br.gov.sp.fatec.loja;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
  private Double preco;

  public Double getPreco() {
    return preco;
  }
}
