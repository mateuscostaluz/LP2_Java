package br.gov.sp.fatec.baralho;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Carta {
  private String nome;
  private String naipe;

  public Carta(Nome nome, Naipe naipe) {
    setNaipe(naipe.getNaipe());
    setNome(nome.getNome());
  }
}
