package br.gov.sp.fatec.exercicio4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComplexTest {
  private Complex complex1;
  private Complex complex2;
  private Complex complex3;
  private Complex complex4;
  private Complex complex5;
  
  @Before
  public void init() {
    complex1 = new Complex(2, 3);
    complex2 = new Complex(5);
    complex3 = new Complex();
    complex4 = new Complex(4, 3);
    complex5 = new Complex(1, 4);
  }
  
  @Test
  public void testModulo() {
    Assert.assertEquals(complex1.getModulo(), Math.sqrt(13), 0.01);
    Assert.assertEquals(complex2.getModulo(), Math.sqrt(25), 0.01);
    Assert.assertEquals(complex3.getModulo(), Math.sqrt(0), 0.01);
  }


  @Test
  public void testAngulo() {
    Assert.assertEquals(complex4.getAngulo(), 1.3333333333298, 1);
  }

  @Test
  public void testInversoAditivo() {
    Assert.assertEquals(complex5.getInversoAditivo(), 4, 1);
  }
  
  @Test
  public void testSomarAditivo() {
    complex3 = complex3.somar(complex1, complex4);
    Assert.assertEquals(complex3.getReal(), 6.0, 0.01);
    Assert.assertEquals(complex3.getImaginaria(), 6.0, 0.01);
  }
  
  @Test
  public void testSubtrairAditivo() {
    complex3 = complex3.subtrair(complex1, complex4);
    Assert.assertEquals(complex3.getReal(), -2.0, 0.01);
    Assert.assertEquals(complex3.getImaginaria(), 0.0, 0.01);
  }
  
  @Test
  public void testMultiplicarAditivo() {
    complex3 = complex3.multiplicar(complex1, complex4);
    Assert.assertEquals(complex3.getReal(), 8.0, 0.01);
    Assert.assertEquals(complex3.getImaginaria(), 9.0, 0.01);
  }
  
  @Test
  public void testDividirAditivoDiferenteDeZero() {
    complex3 = complex3.dividir(complex1, complex4);
    Assert.assertEquals(complex3.getReal(), 0.5, 0.01);
    Assert.assertEquals(complex3.getImaginaria(), 1.0, 0.01);
  }
  
  @Test
  public void testDividirAditivoIgualAZero() {
    complex3.setReal(0.0);
    complex3.setImaginaria(0.0);
    complex3 = complex3.dividir(complex1, complex3);
    Assert.assertEquals(complex3.getReal(), 0.0, 0.01);
    Assert.assertEquals(complex3.getImaginaria(), 0.0, 0.01);
  }
  
  @Test
  public void testToString() {
    Assert.assertEquals("(2.0, 3.0)", complex1.toString());
  }
}
