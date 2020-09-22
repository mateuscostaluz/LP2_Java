package br.gov.sp.fatec.exercicio2;

import org.junit.Test;

import junit.framework.Assert;

public class InvoiceTest {

  Invoice invoice1 = new Invoice(1, "Carro", 100, 200.0);
  Invoice invoice2 = new Invoice(1, "Carro", -1, 200.0);
  Invoice invoice3 = new Invoice(1, "Carro", 100, -1.0);

  @Test
  public void testGetInvoiceAmount() {
    Assert.assertEquals(20000.0, invoice1.getInvoiceAmount());
    Assert.assertEquals(0.0, invoice2.getInvoiceAmount());
    Assert.assertEquals(0.0, invoice3.getInvoiceAmount());
  }

}
