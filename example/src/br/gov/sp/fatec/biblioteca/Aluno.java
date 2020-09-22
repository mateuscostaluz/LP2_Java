package br.gov.sp.fatec.biblioteca;

import java.util.Date;

public class Aluno extends Usuario {
	private int ra;
	private String curso;
	
  public int getRa() {
    return ra;
  }
  
  public void setRa(int ra) {
    this.ra = ra;
  }
  
  public String getCurso() {
    return curso;
  }
  
  public void setCurso(String curso) {
    this.curso = curso;
  }
  
  public Aluno(String nome, String endereco, String cpf, Date data, int ra, String curso) {
    super(nome, endereco, cpf, data);
    this.ra = ra;
    this.curso = curso;
  }
	
}
