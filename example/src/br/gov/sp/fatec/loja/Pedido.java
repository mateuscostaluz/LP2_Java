package br.gov.sp.fatec.loja;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pedido {
  private Integer codigo;
  private Date dataRecebido;
  private Double total;
  private ItemPedido item;
  private boolean isConfirmed;
  
  public Pedido() {
    codigo = 1;
    total = 0.0;
  }
  
  public void confirmar() {
    isConfirmed = true;
  }
  
  public void cancelar() {
    isConfirmed = true;
  }
  
  public Integer gerarNovoCodigo() {
    codigo += 1;
    return codigo;
  }
  
  public Double calcularTotal() {
    total = item.calculaValorItem();
    return total;
  }
}
