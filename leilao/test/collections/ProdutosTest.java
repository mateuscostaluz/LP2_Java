package collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import database.Database;
import entities.Imovel;
import entities.Produto;
import entities.Veiculo;
import enums.TipoImovel;
import enums.TipoVeiculo;

public class ProdutosTest {

	private Produtos cut;
	
	private Database database = new Database();
	
	@Before
	public void init() {
		cut = new Produtos();
	}
	
	@Test
	public void validarAdicionarProduto() {
		Imovel imovel = new Imovel("123123", "bratec", 1.0 ,"av. sagitarius", TipoImovel.CASA);
		Imovel imovel2 = new Imovel("4312", "bratec", 1.0 ,"av. sagitarius", TipoImovel.APARTAMENTO);
		Imovel imovel3 = new Imovel("3242", "bratec", 1.0 ,"av. sagitarius", TipoImovel.EDIFICIO);
		Imovel imovel4 = new Imovel("564", "bratec", 1.0 ,"av. sagitarius", TipoImovel.TERRENO);
		Veiculo veiculo = new Veiculo("1", "teste", 1.0, "placa", 123, "azul", TipoVeiculo.CARRO);
		Veiculo veiculo2 = new Veiculo("1123", "teste", 1.0, "placa", 123, "azul", TipoVeiculo.MOTOCICLETA);		
		Produto produto = new Produto("1", "teste", 0.1);
		
		cut.adicionar(imovel);
		cut.adicionar(imovel2);
		cut.adicionar(imovel3);
		cut.adicionar(imovel4);
		cut.adicionar(veiculo);
		cut.adicionar(veiculo2);
		cut.adicionar(produto);
		
		cut.filtroFaixaValores(1.0, 10.0);
		cut.filtroPalavraChave("teste");
		cut.filtroTipoProduto(TipoImovel.CASA.toString());
		
		Assert.assertEquals(6, cut.getProdutos().size());
	}

}
