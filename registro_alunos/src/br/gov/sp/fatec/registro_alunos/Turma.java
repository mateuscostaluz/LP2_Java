package br.gov.sp.fatec.registro_alunos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Turma {
  private Aluno[] alunos;
  private Integer tamanhoAtual;
  
  public Turma(Integer tamanho) {
    setAlunos(new Aluno[tamanho]);
    setTamanhoAtual(0);
  }
  
  public Boolean incluirAluno(Aluno aluno) {
    if(getTamanhoAtual() < getAlunos().length) {
        setAlunos(alunos); this.alunos[getTamanhoAtual()] = aluno;
        setTamanhoAtual(getTamanhoAtual() + 1);
        return true;
      }
    return false;
  }
  
  public void alterarDadosAluno(String matricula, String nome, String curso) {
    for(Aluno aluno : alunos) {
      if(matricula.equals(aluno.getMatricula())) {
        aluno.setNome(nome);
        aluno.setCurso(curso);
      }
    }
  }
  
  public Aluno consultarPorNome(String nome) {
    for(Aluno aluno : alunos) {
      if(nome.equals(aluno.getNome()))
        return aluno;
    }
    return null;
  }
  
  public Aluno consultarPorMatricula(String matricula) {
    for(Aluno aluno : alunos) {
      if(matricula.equals(aluno.getMatricula()))
        return aluno;
    }
    return null;
  }
  
  public void excluirAlunoPorNome(String nome) {
    Turma auxiliar = new Turma(getAlunos().length);
    for(Aluno aluno : alunos) {
      if(aluno.getNome() != nome) {
        auxiliar.alunos[auxiliar.getTamanhoAtual()] = aluno;
      }
    }
    setAlunos(auxiliar.getAlunos());
    setTamanhoAtual(auxiliar.getTamanhoAtual());
  }
  
  public void listarAlunos() {
    for(Aluno aluno : alunos) {
      System.out.println("Matrícula: " + aluno.getMatricula() + "\n" + "Nome: " + aluno.getNome() + "\n" + "\n");
    }
  }
}
