package entities;

import enums.TipoVeiculo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Veiculo extends Produto {
	
	private String placa;
	private Integer kilometragem;
	private String cor;
	private TipoVeiculo tipoVeiculo;
	
	public Veiculo(String matricula, String descricao, Double valorMinimoProduto,
				   String placa, Integer kilometragem, String cor, TipoVeiculo tipoVeiculo) {
		super(matricula, descricao, valorMinimoProduto);
		setPlaca(placa);
		setKilometragem(kilometragem);
		setCor(cor);
		setTipoVeiculo(tipoVeiculo);
	}
    
    @Override
	public String toString() {
		return("Matrícula do veículo: " + getMatricula() + ",\n" +
			   "Placa do veículo: " + getPlaca() + "\n" +
		       "Kilometragem rodada: " + getKilometragem() + ",\n" +
		       "Cor do veículo: " + getCor() + ",\n" +
		       "Descrição do veículo: " + getDescricao().toString() + ",\n" +
		       "Valor mínimo do veículo: " + String.format("%.2f", getValorMinimoProduto()) + ",\n" +
		       "Tipo do imóvel: " + getTipoVeiculo().toString() + ",\n" + 
		       "Quantidade Lances: " + getLances().getLances().size() + ",\n"+
		       "Lances: " + getLances().toString()) + ".\n";
	}
    
}
