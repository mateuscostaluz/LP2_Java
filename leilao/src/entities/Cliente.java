package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {
	
	private String cpf;
	private String rg;
	private String nomeCompleto;
	private String endereco;
	private String email;
	
	@Override
	public String toString() {
		return("CPF do cliente: " + getCpf() + ",\n" +
			   "RG do cliente: " + getRg() + ",\n" +
			   "Nome completo do cliente: " + getNomeCompleto() + ",\n" +
			   "Endereço do cliente: " + getEndereco() + ",\n" +
		       "Email do cliente: " + getEmail()) + ".\n\n";
	}
	
}
