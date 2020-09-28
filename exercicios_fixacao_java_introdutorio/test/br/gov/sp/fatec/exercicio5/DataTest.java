package br.gov.sp.fatec.exercicio5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataTest {
  private Data cut;
  
  @Before
  public void init() {
    cut = new Data(21, 3, 1997);
    cut = new Data();   
  }
  
  @Test
  public void validarString() {
    cut = new Data(21, 5, 2000);
    Assert.assertEquals("21/5/2000", cut.toString());
    cut = new Data();
    Assert.assertEquals("27/09/2020", cut.getDatavazia());
  }
  
  @Test
  public void validarData() {
    cut = new Data(32, 3, 2020);
    Assert.assertEquals("1/4/2020", cut.toString());
    cut = new Data(30, 14, 2020);
    Assert.assertEquals("30/1/2021", cut.toString());
    cut = new Data(32, 14, 2020);
    Assert.assertEquals("1/1/2021", cut.toString());
  }
  
  @Test
  public void validarAvancarData() {
    cut = new Data(10, 5, 2020);
    Assert.assertEquals("11/5/2020", cut.avancarData(cut).toString());
  }
}
