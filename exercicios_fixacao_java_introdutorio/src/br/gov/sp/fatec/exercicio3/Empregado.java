package br.gov.sp.fatec.exercicio3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empregado {
  private String nome;
  private String sobrenome;
  private Double salarioMensal;

  public Empregado(String nome, String sobrenome, Double salarioMensal) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.salarioMensal = (salarioMensal < 0) ? 0.0 : salarioMensal;
  }
  
  public Double getSalarioAnual() {
    return salarioMensal * 12;
  }

}
