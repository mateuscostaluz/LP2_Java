package br.gov.sp.fatec.baralho;

public enum Naipe {
  OUROS("ouros"), ESPADAS("espadas"), COPAS("copas"), PAUS("paus"), CORINGA("coringa");
  
  private String naipe;
  
  Naipe(String naipe) {
    this.naipe = naipe;
  }
  
  public String getNaipe() {
    return naipe;
  }
}
