package collections;

import java.util.Collections;
import java.util.LinkedList;

import database.Database;
import entities.Lance;
import entities.Leilao;
import entities.Produto;
import interfaces.CreateReadUpdateDelete;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.LeilaoComparatorId;

@NoArgsConstructor
@Getter
@Setter
public class Lances implements CreateReadUpdateDelete {
	
	private LinkedList<Lance> lances = new LinkedList<Lance>();
	
	public Lances historicoLances (Produto produto) {
		Lances encontrados = new Lances();
		Integer contador = 0;
		for (Lance lance : lances) {
			if (lance.getProduto().equals(produto)) {
				encontrados.adicionar(lance);
				contador ++;
			}
		}
		return (contador>0) ? encontrados : null;
	}
	
	@Override
	public String toString() {
		String listaLances = "";
		for (Lance lance : lances) {
			listaLances += lance.toString();
		};
		return listaLances;
	}
	
	@Override
	public void imprimir() {
		for (Lance lance : lances) {
			System.out.println(lance.toString());
		}
	}
	
	@Override
	public void adicionar(Object lance) {
		try {
			Lance lanceSave = (Lance) lance;
			Object lanceSearch = consultar(lanceSave.getId());
				
			if (lanceSearch instanceof String) {
				getLances().add(lanceSave);
				System.out.println("Lance cadastrado com sucesso.");
			} else {
				System.out.println("Lance já cadastrado anteriormente.");
			}
		} catch (Exception e) {
			// e.printStackTrace();
			throw new IllegalArgumentException("O item não é um lance.");
		}
	}

	@Override
	public Object consultar(String id) {
		for (Lance lance : lances) {
			if(lance.getId().equals(id)) {
				return lance;
			}
		}
		return "Nenhum lance encontrado com este ID.";
	}

	@Override
	public void atualizar(String id, Object lanceNew) {
		Lance lanceNewCasted = (Lance) lanceNew;
			
		Object lanceOld = consultar(id);
			
		if (lanceOld instanceof Lance) {
			Lance lanceOldCasted = (Lance) lanceOld;
			
			lanceOldCasted.setId(lanceNewCasted.getId());
			lanceOldCasted.setCliente(lanceNewCasted.getCliente());
			lanceOldCasted.setProduto(lanceNewCasted.getProduto());
			lanceOldCasted.setValor(lanceNewCasted.getValor());
		}
	}

	@Override
	public Boolean remover(String id) {
		Object lance = consultar(id);
			
		if (lance instanceof Lance) {
			return lances.remove(lances);
		}
		return false;
	}
	
	public void retornarMaiorLance() {
		if(Database.produtos.getProdutos().size() > 0) {
			for (Produto produto : Database.produtos.getProdutos()) {
				produto.getLances().getLances().getLast();
			}
		}
	}
	
}
