package br.gov.sp.fatec.exercicio3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmpregadoTest {
  private Empregado cut;
  
  @Before
  public void init() {
    cut = new Empregado("Mateus", "Luz", 0.0);
  }
  
  @Test
  public void testGetSalarioAnualValorPositivo() {
    cut.setSalarioMensal(2000.0);
    Assert.assertEquals(24000.0, cut.getSalarioAnual(), 0.01);
  }
  
  @Test
  public void testGetSalarioAnualValorNegativo() {
    cut.setSalarioMensal(-1.0);
    Assert.assertEquals(0.0, cut.getSalarioAnual(), 0.01);
  }

  @Test
  public void testAumentoSalario() {
    cut.setSalarioMensal(2000.00);
    Double aumento = cut.getSalarioMensal() * 1.1;
    cut.setSalarioMensal(aumento);
    Assert.assertEquals(2200.00, cut.getSalarioMensal(), 0);
  }
}
