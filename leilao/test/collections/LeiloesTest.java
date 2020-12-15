package collections;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedList;

import javax.print.attribute.Size2DSyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import database.Database;
import entities.Cliente;
import entities.Imovel;
import entities.Instituicao;
import entities.Lance;
import entities.Leilao;
import entities.Veiculo;
import enums.StatusLeilao;
import enums.TipoImovel;
import enums.TipoVeiculo;

public class LeiloesTest {

	private Leiloes cut;
	
	private Imovel imovel1;
	private Imovel imovel2;
	private Imovel imovel3;
	private Imovel imovel4;
	
	private Veiculo veiculo1;
	private Veiculo veiculo2;
	
	private Produtos produtos;
	
	private Clientes clientes;
	
	private Cliente cliente1;
	private Cliente cliente2;
	
	private Instituicao instituicao;

	private Database database = new Database();
	
	@Before
	public void init() {
		cut = new Leiloes();
		
		imovel1 = new Imovel("ABC123", "Casa maneira", 100000.00, "Rua legal", TipoImovel.CASA);
		imovel2 = new Imovel("DEF456", "Apartamento maneiro", 80000.00, "Rua legal", TipoImovel.APARTAMENTO);
		imovel3 = new Imovel("GHI789", "Edifício maneiro", 50000.00, "Rua legal", TipoImovel.EDIFICIO);
		imovel4 = new Imovel("JKL100", "Terreno maneiro", 50000.00, "Rua legal", TipoImovel.TERRENO);
		
		veiculo1 = new Veiculo("XPTO1", "Carro gasto mas roda bem", 10000.00, "ABC-1234", 45000, "Amarelo", TipoVeiculo.CARRO);
		veiculo2 = new Veiculo("XPTO2", "Moto velha roubada", 6000.00, "DEF-5678", 25000, "Azul", TipoVeiculo.MOTOCICLETA);
		
		produtos = new Produtos();
		produtos.adicionar(imovel1);
		produtos.adicionar(imovel2);
		produtos.adicionar(imovel3);
		produtos.adicionar(imovel4);
		produtos.adicionar(veiculo1);
		produtos.adicionar(veiculo2);
		
		cliente1 = new Cliente("12345678910", "123456789", "Juarez Melez", "Rua da tristeza", "email@email.com");
		cliente2 = new Cliente("10987654321", "987654321", "Martinez Font", "Rua da agonia", "e@e.com");
		
		clientes = new Clientes();
		clientes.adicionar(cliente1);
		clientes.adicionar(cliente2);
		
		instituicao = new Instituicao("0001123456", "IBGEF", "Avenida nilda", "a@a.com");
	}
	
	@Test
	public void validarStatusLeilaoAberto() {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		
		Leilao leilao = new Leilao(now.plusMinutes(5), now.plusMinutes(10), produtos, clientes, instituicao);
		Assert.assertEquals(StatusLeilao.ABERTO, leilao.getStatusLeilao());
	}
	
	@Test
	public void validarStatusLeilaoAndamento() {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		
		Leilao leilao = new Leilao(now, now.plusMinutes(10), produtos, clientes, instituicao);
		Assert.assertEquals(StatusLeilao.ANDAMENTO, leilao.getStatusLeilao());
	}
	
	@Test
	public void validarStatusLeilaoFechado() {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		
		Leilao leilao = new Leilao(now.minusMinutes(10), now.minusMinutes(5), produtos, clientes, instituicao);
		Assert.assertEquals(StatusLeilao.FINALIZADO, leilao.getStatusLeilao());
	}
	
	@Test
	public void validarAdicionarLeilao() {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		
		Leilao leilao1 = new Leilao(now, now, produtos, clientes, instituicao);
		Leilao leilao2 = new Leilao(now, now, produtos, clientes, instituicao);
		
		Leiloes leiloes = new Leiloes();
		leiloes.adicionar(leilao1);
		leiloes.adicionar(leilao2);
		
		Assert.assertEquals(2, leiloes.getLeiloes().size());
	}
	
	@Test
	public void validarAdicionarRepetido() {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		
		Leilao leilao1 = new Leilao(now, now, produtos, clientes, instituicao);
		
		Leiloes leiloes = new Leiloes();

		leiloes.adicionar(leilao1);
		leiloes.adicionar(leilao1);
		
		Assert.assertEquals(1, leiloes.getLeiloes().size());
	}
	
	@Test
	public void validarAdicionarInvalido() {
		Leiloes leiloes = new Leiloes();
		
		try {
			leiloes.adicionar(instituicao);
		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("O item não é um leilão.", ex.getMessage());
		}
	}
	
	@Test
	public void validarAtualizarLeilao() {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		
		Instituicao instituicaoNova = new Instituicao("0001123456789", "Nova", "Rua do céu", "email@email.com");
		
		Leilao leilao1 = new Leilao(now, now, produtos, clientes, instituicao);
		Leilao leilao2 = new Leilao(now.plusMinutes(5), now.plusMinutes(10), produtos, clientes, instituicaoNova);
		
		Leiloes leiloes = new Leiloes();
		leiloes.adicionar(leilao1);
		
		leiloes.atualizar("1", leilao2);
		
		// leiloes.imprimir();
		
		Leilao leilao = (Leilao) leiloes.consultar("1");
		
		Assert.assertEquals(instituicaoNova.getCnpj(), leilao.getInstituicao().getCnpj());
	}
	
	@Test
	public void validarOrdernarLeilaoDataId() {
				
		LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		
		Leilao leilao1 = new Leilao(now.minusDays(10).minusHours(5), now.minusDays(10), produtos, clientes, instituicao);
		Leilao leilao2 = new Leilao(now.minusDays(10).minusHours(10), now.minusDays(10), produtos, clientes, instituicao);
		
		database.leiloes.adicionar(leilao1);
		database.leiloes.adicionar(leilao2);
		
		database.leiloes.toString();
		
		database.leiloes.ordenarLeiloesPorData();
		
		Assert.assertEquals("2", database.leiloes.getLeiloes().getFirst().getId());
		
		database.leiloes.ordenarLeiloesPeloId();
		
		Assert.assertEquals("1", database.leiloes.getLeiloes().getFirst().getId());
		
	}
	
}
