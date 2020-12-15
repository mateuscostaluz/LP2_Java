package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
public class Lance {
	
	private static Integer idLance = 0;
	private String id;
	private Cliente cliente;
	private Produto produto;
	private Double valor;
	
	@Override
	public String toString() {
		return("ID do lance: " + getId() + "\n" +
			   getCliente().toString() +			   
			   "Valor do lance: R$ " + String.format("%.2f", getValor()) + ".\n");
	}

	public Lance(Cliente cliente, Produto produto, Double valor) {
		idLance++;
		setId(idLance.toString());
		setCliente(cliente);
		setProduto(produto);
		setValor(valor);
	}
	
}
