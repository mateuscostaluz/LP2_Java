package br.gov.sp.fatec.baralho;

public enum Nome {
  AS("A"), 
  DOIS("2"), 
  TRES("3"), 
  QUATRO("4"), 
  CINCO("5"), 
  SEIS("6"), 
  SETE("7"), 
  OITO("8"), 
  NOVE("9"), 
  DEZ("10"), 
  VALETE("J"), 
  DAMA("Q"), 
  REI("K"), 
  CORINGA("coringa");
  
  private String nome;
  
  Nome(String nome) {
    this.nome = nome;
  }
  
  public String getNome() {
    return nome;
  }
}
