package br.gov.sp.fatec.exercicio2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceTest {
  private Invoice cut;
  
  @Before
  public void init() {
    cut = new Invoice(1L, "Item 1",2L, 2.5);
  }
  
  @Test
  public void validarCalculoInvoiceAmountComPrecoNegativo() {
    cut.setPrecoUnitario(-1.0);
    Assert.assertEquals(0.0, cut.getInvoiceAmount(), 0.01);
  }
  
  @Test
  public void validarCalculoInvoiceAmountComQuantidadeNegativo() {
    cut.setQuantidade(-1L);
    Assert.assertEquals(0.0, cut.getInvoiceAmount(), 0.01);
  }
  
  @Test
  public void validarcalculoInvoiceAmountComQuantidadePrecoPositivo() {
    Assert.assertEquals(5.0, cut.getInvoiceAmount(), 0.01);
  }
}
