package br.gov.sp.fatec.biblioteca;

import java.util.Date;

public class Emprestimo {
  private Date dataEmprestimo;
  private Date dataDevolucao;
  
  public Date getDataEmprestimo() {
    return dataEmprestimo;
  }
  
  public void setDataEmprestimo(Date dataEmprestimo) {
    this.dataEmprestimo = dataEmprestimo;
  }
  
  public Date getDataDevolucao() {
    return dataDevolucao;
  }
  
  public void setDataDevolucao(Date dataDevolucao) {
    this.dataDevolucao = dataDevolucao;
  }
  
  public Emprestimo(Date dataEmprestimo, Date dataDevolucao) {
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucao = dataDevolucao;
  }
  
}
