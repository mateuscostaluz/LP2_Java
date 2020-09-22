package br.gov.sp.fatec.exercicio4;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ComplexTest {

  Complex complex1 = new Complex(2, 3);
  Complex complex2 = new Complex(5);
  Complex complex3 = new Complex();
  
  Complex complex4 = new Complex(4, 3);
  
  Complex complex5 = new Complex(1, 4);
  
  @Test
  public void testModulo() {
    Assert.assertEquals(complex1.getModulo(), Math.sqrt(13), 0);
    Assert.assertEquals(complex2.getModulo(), Math.sqrt(25), 0);
    Assert.assertEquals(complex3.getModulo(), Math.sqrt(0), 0);
  }


  @Test
  public void testAngulo() {
    Assert.assertEquals(complex4.getAngulo(), 1.3333333333298, 1);
  }

  @Test
  public void testInversoAditivo() {
    Assert.assertEquals(complex5.getInversoAditivo(), 1, 1);
  }

}
