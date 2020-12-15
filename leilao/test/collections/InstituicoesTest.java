package collections;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.Instituicao;

public class InstituicoesTest {

	private Instituicoes cut;
	
	@Before
	public void init() {
		cut = new Instituicoes();
	}
	
	@Test
	public void validarAdicionarInstituicao() {
		Instituicao instituicao1 = new Instituicao("123123", "bratec", "av. sagitarius", "bratec@email");
		Instituicao instituicao2 = new Instituicao("456", "receita federal", "av. paulista", "rcf@email");
		cut.adicionar(instituicao1);
		cut.adicionar(instituicao2);
		Assert.assertEquals(2, cut.getInstituicoes().size());
	}
	
	@Test
	public void validarAtualizacaoConsultaInstituicao() {
		Instituicao instituicao = new Instituicao("123123", "bratec", "av. sagitarius", "bratec@email");
		Instituicao nova = new Instituicao("1231234", "pichau", "bandeirantes", "pichau@email");
		cut.adicionar(instituicao);
		cut.atualizar(instituicao.getCnpj(), nova);
		Assert.assertEquals(cut.getInstituicoes().getFirst(), cut.consultar(nova.getCnpj()));
		
	}

}
