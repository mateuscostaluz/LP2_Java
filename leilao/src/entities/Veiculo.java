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
		return("Matr�cula do ve�culo: " + getMatricula() + ",\n" +
			   "Placa do ve�culo: " + getPlaca() + "\n" +
		       "Kilometragem rodada: " + getKilometragem() + ",\n" +
		       "Cor do ve�culo: " + getCor() + ",\n" +
		       "Descri��o do ve�culo: " + getDescricao().toString() + ",\n" +
		       "Valor m�nimo do ve�culo: " + String.format("%.2f", getValorMinimoProduto()) + ",\n" +
		       "Tipo do im�vel: " + getTipoVeiculo().toString() + ",\n" + 
		       "Quantidade Lances: " + getLances().getLances().size() + ",\n"+
		       "Lances: " + getLances().toString()) + ".\n";
	}
    
}
