package br.gov.sp.fatec.exercicio3;

import lombok.Getter;
import lombok.Setter;

public class Empregado {
  @Getter
  @Setter
  private String nome;
  @Getter
  @Setter
  private String sobrenome;
  @Getter
  private Double salarioMensal;

  public Empregado(String nome, String sobrenome, Double salarioMensal) {
    setNome(nome);
    setSobrenome(sobrenome);
    setSalarioMensal(salarioMensal);
  }
  
  public void setSalarioMensal(Double salarioMensal) {
    this.salarioMensal = (salarioMensal < 0) ? 0.0 : salarioMensal;
  }
  
  public Double getSalarioAnual() {
    return salarioMensal * 12;
  }

}
