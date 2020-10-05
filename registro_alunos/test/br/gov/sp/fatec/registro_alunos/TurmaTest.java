package br.gov.sp.fatec.registro_alunos;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurmaTest {
  private Aluno aluno;
  
  private Prova prova;
  private Prova[] provas;
  
  private Turma turma;
  
  @Before
  public void init() {
    prova = new Prova(10.0, 2.5);
    
    provas = new Prova[4];
    provas[0] = prova;
    provas[1] = prova;
    provas[2] = prova;
    provas[3] = prova;
    
    turma = new Turma(3);
  }
  
  @Test
  public void validarIncluirAluno() {
    aluno = new Aluno("Matrícula1", "Aluno1", "Curso1", provas);
    assertEquals(true, turma.incluirAluno(aluno));
    
    aluno = new Aluno("Matrícula2", "Aluno2", "Curso2", provas);
    assertEquals(true, turma.incluirAluno(aluno));
    
    aluno = new Aluno("Matrícula3", "Aluno3", "Curso3", provas);
    assertEquals(true, turma.incluirAluno(aluno));
    
    aluno = new Aluno("Matrícula4", "Aluno4", "Curso4", provas);
    assertEquals(false, turma.incluirAluno(aluno));
  }
}
