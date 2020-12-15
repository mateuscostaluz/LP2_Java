package collections;

import java.util.LinkedList;

import entities.Cliente;
import interfaces.CreateReadUpdateDelete;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Clientes implements CreateReadUpdateDelete {
	
	private LinkedList<Cliente> clientes = new LinkedList<Cliente>();
	
	@Override
	public String toString() {
		String listaClientes = "";
		for (Cliente cliente : clientes) {
			listaClientes += cliente.toString();
		};
		return listaClientes;
	}
	
	@Override
	public void imprimir() {
		for (Cliente cliente : clientes) {
			System.out.println(cliente.toString());
		}
	}

	@Override
	public void adicionar(Object cliente) {
		try {
			Cliente clienteSave = (Cliente) cliente;
			Object clienteSearch = consultar(clienteSave.getCpf());
				
			if (clienteSearch == null) {
				getClientes().add(clienteSave);
				System.out.println("Cliente cadastrado com sucesso.");
			} else {
				System.out.println("Cliente já cadastrado anteriormente.");
			}
		} catch (Exception e) {
			// e.printStackTrace();
			throw new IllegalArgumentException("O item não é um cliente.");
		}
	}

	@Override
	public Object consultar(String cpf) {
		for (Cliente cliente : clientes) {
			if(cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}

	@Override
	public void atualizar(String cpf, Object clienteNew) {
		Cliente clienteNewCasted = (Cliente) clienteNew;
			
		Object clienteOld = consultar(cpf);
			
		if (clienteOld != null) {
			Cliente clienteOldCasted = (Cliente) clienteOld;
			
			clienteOldCasted.setCpf(clienteNewCasted.getCpf());
			clienteOldCasted.setRg(clienteNewCasted.getRg());
			clienteOldCasted.setNomeCompleto(clienteNewCasted.getNomeCompleto());
			clienteOldCasted.setEndereco(clienteNewCasted.getEndereco());
			clienteOldCasted.setEmail(clienteNewCasted.getEmail());
		}
	}

	@Override
	public Boolean remover(String cpf) {
		Object cliente = consultar(cpf);
			
		if (cliente != null) {
			return clientes.remove(cliente);
		}
		return false;
	}
	
}
