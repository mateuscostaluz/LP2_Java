package br.gov.sp.fatec.baralho;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BaralhoTest {
  private Carta cartaTest;
  private Baralho baralhoTest;
  
  @Before
  public void init() {
    baralhoTest = new Baralho();
  }
  
  @Test
  public void testConstrutor() {
    cartaTest = new Carta(Nome.AS, Naipe.OUROS);
    Assert.assertEquals(cartaTest.getNome() + cartaTest.getNaipe(), baralhoTest.getCartas()[0].getNome() + baralhoTest.getCartas()[0].getNaipe());
    
    cartaTest = new Carta(Nome.CORINGA, Naipe.CORINGA);
    Assert.assertEquals(cartaTest.getNome() + cartaTest.getNaipe(), baralhoTest.getCartas()[55].getNome() + baralhoTest.getCartas()[55].getNaipe());
    
    cartaTest = new Carta(Nome.AS, Naipe.PAUS);
    Assert.assertEquals(cartaTest.getNome() + cartaTest.getNaipe(), baralhoTest.getCartas()[0].getNome() + baralhoTest.getCartas()[51].getNaipe());
  }
}
