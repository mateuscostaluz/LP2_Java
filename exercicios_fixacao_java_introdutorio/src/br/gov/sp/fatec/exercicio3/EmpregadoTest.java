package br.gov.sp.fatec.exercicio3;

import org.junit.Test;

import junit.framework.Assert;

public class EmpregadoTest {

  Empregado empregado1 = new Empregado("Mateus", "Luz", 0.0);
  Empregado empregado2 = new Empregado("Willian", "Dener", 1000.0);
  Empregado empregado3 = new Empregado("Leia", "Organa", -1000.0);

  @Test
  public void testGetSalarioAnual() {
    Assert.assertEquals(0.0, empregado1.getSalarioAnual(), 0);
    Assert.assertEquals(12000.0, empregado2.getSalarioAnual(), 0);
    Assert.assertEquals(0.0, empregado3.getSalarioAnual(), 0);
  }

  @Test
  public void testAumentoSalario() {
    empregado1.setSalarioMensal(empregado1.getSalarioMensal() * 1.1);
    empregado2.setSalarioMensal(empregado2.getSalarioMensal() * 1.1);
    empregado3.setSalarioMensal(empregado3.getSalarioMensal() * 1.1);
    
    Assert.assertEquals(0.0, empregado1.getSalarioMensal(), 0);
    Assert.assertEquals(1100.0, empregado2.getSalarioMensal(), 0);
    Assert.assertEquals(0.0, empregado3.getSalarioMensal(), 0);
  }

}
