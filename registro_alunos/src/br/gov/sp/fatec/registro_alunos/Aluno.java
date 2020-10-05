package br.gov.sp.fatec.registro_alunos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Aluno {
  private String matricula;
  private String nome;
  private String curso;
  private Prova[] provas = new Prova[4];
}
