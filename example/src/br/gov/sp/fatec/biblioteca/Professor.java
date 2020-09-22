package br.gov.sp.fatec.biblioteca;

import java.math.BigInteger;
import java.util.Date;

public class Professor extends Usuario {
  private BigInteger registroProfessor;
  private String departamento;
  
  public BigInteger getRegistroProfessor() {
    return registroProfessor;
  }
  
  public void setRegistroProfessor(BigInteger registroProfessor) {
    this.registroProfessor = registroProfessor;
  }
  
  public String getDepartamento() {
    return departamento;
  }
  
  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }
  
  public Professor(String nome, String endereco, String cpf, Date data, BigInteger registroProfessor,
      String departamento) {
    super(nome, endereco, cpf, data);
    this.registroProfessor = registroProfessor;
    this.departamento = departamento;
  }
  
}
