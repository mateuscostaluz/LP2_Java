package collections;

import java.util.Collections;
import java.util.LinkedList;

import database.Database;
import entities.Leilao;
import interfaces.CreateReadUpdateDelete;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.LeilaoComparatorData;
import services.LeilaoComparatorId;

@NoArgsConstructor
@Getter
@Setter
public class Leiloes implements CreateReadUpdateDelete {
	
	private LinkedList<Leilao> leiloes = new LinkedList<Leilao>();
	private Integer idLeilao = 0;
	
	@Override
	public String toString() {
		String listaLeiloes = "";
		for (Leilao leilao : leiloes) {
			listaLeiloes += leilao.toString();
		};
		return listaLeiloes;
	}
	
	public void imprimir() {
		for (Leilao leilao : leiloes) {
			System.out.println(leilao.toString());
		}
	}
	
	@Override
	public void adicionar(Object leilao) {
		try {
			Leilao leilaoSave = (Leilao) leilao;
			Object leilaoSearch = consultar(leilaoSave.getId());
			
			if (leilaoSearch == null) {
				setIdLeilao(getIdLeilao() + 1);
				leilaoSave.setId(getIdLeilao().toString());
				getLeiloes().add(leilaoSave);
				System.out.println("Leilão cadastrado com sucesso.");
			} else {
				System.out.println("Leilão já cadastrado anteriormente.");
			}
		} catch (Exception e) {
			// e.printStackTrace();
			throw new IllegalArgumentException("O item não é um leilão.");
		}
	}

	@Override
	public Object consultar(String id) {
		for (Leilao leilao : leiloes) {
			if(leilao.getId().equals(id)) {
				return leilao;
			}
		}
		return null;
	}

	@Override
	public void atualizar(String id, Object leilaoNew) {
		Leilao leilaoNewCasted = (Leilao) leilaoNew;
			
		Object leilaoOld = consultar(id);
			
		if (leilaoOld instanceof Leilao) {
			Leilao leilaoOldCasted = (Leilao) leilaoOld;
			
			leilaoOldCasted.setProdutos(leilaoNewCasted.getProdutos());
			leilaoOldCasted.setClientes(leilaoNewCasted.getClientes());
			leilaoOldCasted.setInstituicao(leilaoNewCasted.getInstituicao());
			leilaoOldCasted.setStatusLeilao(leilaoNewCasted.getStatusLeilao());
		}
	}

	@Override
	public Boolean remover(String id) {
		Object leilao = consultar(id);
			
		if (leilao == null) {
			return leiloes.remove(leilao);
		}
		return false;
	}
	
	public void ordenarLeiloesPorData() {
		if (Database.leiloes.getLeiloes().size() > 0) {
			LeilaoComparatorData leilaoComparator = new LeilaoComparatorData();
			Collections.sort(Database.leiloes.getLeiloes(), leilaoComparator);
		}				
	}
	
	public void ordenarLeiloesPeloId() {
		if (Database.leiloes.getLeiloes().size() > 0) {
			LeilaoComparatorId leilaoComparator = new LeilaoComparatorId();
			Collections.sort(Database.leiloes.getLeiloes(), leilaoComparator);
		}		
	}

}
