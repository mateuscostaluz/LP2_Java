package collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.Cliente;
import entities.Lance;
import entities.Produto;

public class LancesTest {
	
	private Lances cut;
		
	@Before
	public void init() {
		cut = new Lances();
	}
	
	@Test
	public void validarHistoricoLances() {
		cut = new Lances();
		Cliente cliente1 = new Cliente("1231", "4353245", "ameno", "jardim souto", "email@email");
		Cliente cliente2 = new Cliente("4567", "75467", "gil", "jardim souto", "email1@email");
		Cliente cliente3 = new Cliente("8979", "3487523", "ronald", "jardim souto", "email11@email");
		Produto produto1 = new Produto("123", "arroz", 1000.0);
		Produto produto2 = new Produto("542423", "feijao", 354.0);						
		Lance lance1 = new Lance(cliente1, produto1, 1050.0);
		Lance lance2 = new Lance(cliente2, produto1, 1250.0);
		Lance lance3 = new Lance(cliente3, produto1, 1550.0);
		Lance lance4 = new Lance(cliente1, produto2, 750.0);
		cut.adicionar(lance1);
		cut.adicionar(lance2);
		cut.adicionar(lance3);
		cut.adicionar(lance4);
		cut.historicoLances(produto1);
		Assert.assertEquals(4, cut.getLances().size());
	}

}
