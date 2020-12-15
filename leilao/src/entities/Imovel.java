package entities;

import enums.TipoImovel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Imovel extends Produto {

	private String endereco;
    private TipoImovel tipoImovel;
    
	
	public Imovel(String matricula, String descricao, Double valorMinimoProduto, 
				  String endereco, TipoImovel tipoImovel) {
		super(matricula, descricao, valorMinimoProduto);
		setEndereco(endereco);
		setTipoImovel(tipoImovel);
	}
    
	@Override
	public String toString() {
		return("Matrícula do imóvel: " + getMatricula() + ",\n" +
			   "Endereço do imóvel: " + getEndereco() + ",\n" +
		       "Descrição do imóvel: " + getDescricao() + ",\n" +
		       "Valor mínimo do imóvel: " + String.format("%.2f", getValorMinimoProduto()) + ",\n" +
		       "Tipo do imóvel: " + getTipoImovel().toString() + ",\n"+
		       "Quantidade Lances: " + getLances().getLances().size() + ",\n"+
		       "Lances: " + getLances().toString()) + ".\n";
	}
	
}
