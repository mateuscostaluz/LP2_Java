package br.gov.sp.fatec.biblioteca;

import java.util.Date;

public class Funcionario extends Usuario {
	private Date dataAdmissao;
	private String departamento;
	
	public Date getDataAdmissao() {
    return dataAdmissao;
  }

  public void setDataAdmissao(Date dataAdmissao) {
    this.dataAdmissao = dataAdmissao;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public Funcionario(String nome, String endereco, String cpf, Date data, Date dataAdmissao, String departamento) {
    super(nome, endereco, cpf, data);
    this.dataAdmissao = dataAdmissao;
    this.departamento = departamento;
  }

  public void cadastrarObra() {
		//
	}
  
}
