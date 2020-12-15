package collections;

import java.util.LinkedList;

import entities.Imovel;
import entities.Produto;
import entities.Veiculo;
import interfaces.CreateReadUpdateDelete;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Produtos implements CreateReadUpdateDelete {
	
	private LinkedList<Produto> produtos = new LinkedList<Produto>();
	
	public Produtos filtroFaixaValores(Double min, Double max){
		Produtos encontrados = new Produtos();
		int contador = 0;
		for (Produto produto: produtos) {
			if (produto.getValorMinimoProduto() >= min && produto.getValorMinimoProduto() <= max) {
				encontrados.adicionar(produto);
				contador++;
			}		 
		}
		return (contador > 0) ? encontrados : null;
	}
	
	public Produtos filtroPalavraChave(String palavra){
		Produtos encontrados = new Produtos();
		int contador = 0;
		for (Produto produto: produtos) {
			if (produto.getDescricao().contains(palavra)) {
				encontrados.adicionar(produto);
				contador++;
			}
		}
		return (contador > 0) ? encontrados : null;
	}
	
	public Produtos filtroTipoProduto (String tipo){
		Produtos encontrados = new Produtos();
		int contador = 0;
		for (Produto produto : produtos) {
			if (produto instanceof Imovel) {
				Imovel imovel = (Imovel) produto;
				if (imovel.getTipoImovel().toString().equals(tipo)) {
					encontrados.adicionar(imovel);
					contador++;
				}
			}
			else if (produto instanceof Veiculo) {
				Veiculo veiculo = (Veiculo) produto;
				if (veiculo.getTipoVeiculo().toString().equals(tipo)) {
					encontrados.adicionar(veiculo);
					contador++;
				}
			}
		}		
		return (contador > 0) ? encontrados : null;
	}
	
	@Override
	public String toString() {
		String listaProdutos = "";
		for (Produto produto : produtos) {
			listaProdutos += produto.toString();
		};
		return listaProdutos;
	}
	
	@Override
	public void imprimir() {
		for (Produto produto : produtos) {
			if(produto instanceof Imovel) {
				Imovel imovel = (Imovel) produto;
				System.out.println(imovel.toString());
			} else if(produto instanceof Veiculo) {
				Veiculo veiculo = (Veiculo) produto;
				System.out.println(veiculo.toString());
			}
		}
	}
	
	@Override
	public void adicionar(Object produto) {
		try {
			Produto produtoSave = (Produto) produto;
			Object produtoSearch = consultar(produtoSave.getMatricula());
				
			if(produtoSearch == null) {
				getProdutos().add(produtoSave);
				System.out.println("Imóvel ou veículo cadastrado com sucesso.");
			} else {
				System.out.println("Imóvel ou veículo já cadastrado anteriormente.");
			}
		} catch (Exception e) {
			// e.printStackTrace();
			throw new IllegalArgumentException("O item não é um imóvel ou um veículo.");
		}
	}
	
	@Override
	public Object consultar(String matricula) {
		for (Produto produto : produtos) {
			if(produto.getMatricula().equals(matricula)) {
				if(produto instanceof Imovel) {
					Imovel imovel = (Imovel) produto;
					return imovel;
				} else if(produto instanceof Veiculo) {
					Veiculo veiculo = (Veiculo) produto;
					return veiculo;
				}
			}
		}
		return null;
	}

	@Override
	public void atualizar(String matricula, Object produtoNew) {
		Object produtoOld = consultar(matricula);
		
		if((produtoNew instanceof Imovel) && (produtoOld instanceof Imovel)) {
			Imovel imovelNew = (Imovel) produtoNew;
			Imovel imovelOld = (Imovel) produtoOld;
			
			imovelOld.setMatricula(imovelNew.getMatricula());
			imovelOld.setDescricao(imovelNew.getDescricao());
			imovelOld.setEndereco(imovelNew.getEndereco());
			imovelOld.setTipoImovel(imovelNew.getTipoImovel());
			
			
		} else if((produtoNew instanceof Veiculo) && (produtoOld instanceof Veiculo)) {
			Veiculo veiculoNew = (Veiculo) produtoNew;
			Veiculo veiculoOld = (Veiculo) produtoOld;
			
			veiculoOld.setMatricula(veiculoNew.getMatricula());
			veiculoOld.setDescricao(veiculoNew.getDescricao());
			veiculoOld.setPlaca(veiculoNew.getPlaca());
			veiculoOld.setKilometragem(veiculoNew.getKilometragem());
			veiculoOld.setCor(veiculoNew.getCor());
			veiculoOld.setTipoVeiculo(veiculoNew.getTipoVeiculo());
		}
	}

	@Override
	public Boolean remover(String matricula) {
		Object produto = consultar(matricula);
			
		if (produto != null) {
			return produtos.remove(produto);
		}
		return false;
	}	

}
