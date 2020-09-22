package br.gov.sp.fatec.biblioteca;

public class Obra {
  private String genero;
  private String idioma;
  private String midia;
  private String nome;
  private int anoPublicacao;
  private Autor autor;
  private Editora editora;
  
  public String getGenero() {
    return genero;
  }
  
  public void setGenero(String genero) {
    this.genero = genero;
  }
  
  public String getIdioma() {
    return idioma;
  }
  
  public void setIdioma(String idioma) {
    this.idioma = idioma;
  }
  
  public String getMidia() {
    return midia;
  }
  
  public void setMidia(String midia) {
    this.midia = midia;
  }
  
  public String getNome() {
    return nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public int getAnoPublicacao() {
    return anoPublicacao;
  }
  
  public void setAnoPublicacao(int anoPublicacao) {
    this.anoPublicacao = anoPublicacao;
  }
  
  public Autor getAutor() {
    return autor;
  }
  
  public void setAutor(Autor autor) {
    this.autor = autor;
  }
  
  public Editora getEditora() {
    return editora;
  }
  
  public void setEditora(Editora editora) {
    this.editora = editora;
  }
  
  public Obra(String genero, String idioma, String midia, String nome, int anoPublicacao, Autor autor,
      Editora editora) {
    this.genero = genero;
    this.idioma = idioma;
    this.midia = midia;
    this.nome = nome;
    this.anoPublicacao = anoPublicacao;
    this.autor = autor;
    this.editora = editora;
  }
  
}
