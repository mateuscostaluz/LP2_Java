package entities;

import java.util.Collections;

import collections.Lances;
import database.Database;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.LanceComparatorValor;

@NoArgsConstructor
@Getter
@Setter
public class Produto {
	
	private String matricula;
    private String descricao;
	private Double valorMinimoProduto;
	private Lances lances;
	
	public Produto(String matricula, String descricao, Double valorMinimoProduto) {
		setMatricula(matricula);
		setDescricao(descricao);
		setValorMinimoProduto(valorMinimoProduto);
		setLances(new Lances());
	}
	
	public void ordenarLancesPeloValor() {
		if (Database.produtos.getProdutos().size() > 0) {
			for (Produto produto : Database.produtos.getProdutos()) {
				LanceComparatorValor lanceComparator = new LanceComparatorValor();
				Collections.sort(produto.getLances().getLances(), lanceComparator);
			}						
		}	
	}
	
}
