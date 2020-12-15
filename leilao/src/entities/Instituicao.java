package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Instituicao {
	
	private String cnpj;
	private String nome;
	private String endereco;
	private String email;
	
	@Override
	public String toString() {
		return("CNPJ da institu��o: " + getCnpj() +
			   ", Nome da institu��o: " + getNome() +
			   ", Endere�o da institui��o: " + getEndereco() +
		       ", Email da institui��o: " + getEmail()) + ".";
	}
	
}
