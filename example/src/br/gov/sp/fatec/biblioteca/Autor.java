package br.gov.sp.fatec.biblioteca;

public class Autor {
  private String nome;
  private String nacionalidade;
  
  public String getNome() {
    return nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public String getNacionalidade() {
    return nacionalidade;
  }
  
  public void setNacionalidade(String nacionalidade) {
    this.nacionalidade = nacionalidade;
  }
  
  public Autor(String nome, String nacionalidade) {
    this.nome = nome;
    this.nacionalidade = nacionalidade;
  }
  
}
