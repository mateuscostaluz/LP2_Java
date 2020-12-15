package collections;

import java.util.LinkedList;

import entities.Instituicao;
import interfaces.CreateReadUpdateDelete;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Instituicoes implements CreateReadUpdateDelete {
	
	private LinkedList<Instituicao> instituicoes = new LinkedList<Instituicao>();

	@Override
	public String toString() {
		String listaInstituicoes = "";
		for (Instituicao instituicao : instituicoes) {
			listaInstituicoes += instituicao.toString();
		};
		return listaInstituicoes;
	}
	
	@Override
	public void imprimir() {
		for (Instituicao instituicao : instituicoes) {
			System.out.println(instituicao.toString());
		}
	}
	
	@Override
	public void adicionar(Object instituicao) {
		try {
			Instituicao instituicaoSave = (Instituicao) instituicao;
			Object instituicaoSearch = consultar(instituicaoSave.getCnpj());
				
			if (instituicaoSearch == null) {
				getInstituicoes().add(instituicaoSave);
				System.out.println("Instituição cadastrada com sucesso.");
			} else {
				System.out.println("Instituição já cadastrada anteriormente.");
			}
		} catch (Exception e) {
			// e.printStackTrace();
			throw new IllegalArgumentException("O item não é uma instituição.");
		}
	}

	@Override
	public Object consultar(String cnpj) {
		for (Instituicao instituicao : instituicoes) {
			if(instituicao.getCnpj().equals(cnpj)) {
				return instituicao;
			}
		}
		return null;
	}

	@Override
	public void atualizar(String cpnj, Object instituicaoNew) {
		Instituicao instituicaoNewCasted = (Instituicao) instituicaoNew;
			
		Object instituicaoOld = consultar(cpnj);
			
		if (instituicaoOld != null) {
			Instituicao instituicaoOldCasted = (Instituicao) instituicaoOld;
			
			instituicaoOldCasted.setCnpj(instituicaoNewCasted.getCnpj());
			instituicaoOldCasted.setNome(instituicaoNewCasted.getNome());
			instituicaoOldCasted.setEndereco(instituicaoNewCasted.getEndereco());
			instituicaoOldCasted.setEmail(instituicaoNewCasted.getEmail());
		} 		
	}

	@Override
	public Boolean remover(String cpnj) {
		Object instituicao = consultar(cpnj);
			
		if (instituicao instanceof Instituicao) {
			return instituicoes.remove(instituicao);
		}
		return false;
	}
	
}
