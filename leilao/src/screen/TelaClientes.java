package screen;

import database.Database;
import entities.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.Confirmacao;
import services.EntradaDados;

@NoArgsConstructor
@Getter
@Setter
public class TelaClientes {
	
	private Boolean confirmacao;
	private Cliente cliente;
	
	public void opcoesClientes() {
		
		int escolha;
		
		do {
			System.out.println("Escolha uma das operações abaixo:");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Consutar cliente");
			System.out.println("3 - Atualizar cliente");
			System.out.println("4 - Excluir cliente");
			System.out.println("5 - Visualizar clientes cadastrados");
			System.out.println("6 - Retornar ao menu inicial");
			
			System.out.println("Insira sua opção: ");
			escolha = EntradaDados.inputInt();
			System.out.println();
			
			switch (escolha) {
			case 1:
				Database.clientes.adicionar(cadastrarCliente());
				break;
				
			case 2:
				consultarCliente();
				break;
				
			case 3:
				atualizarCliente();
				break;
				
			case 4:
				excluirCliente();
				break;
				
			case 5:
				imprimirClientes();
				break;
				
			case 6:
				break;

			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while(escolha != 6);
	}
	
	public Cliente cadastrarCliente() {
		
		cliente = new Cliente();
		
		System.out.println("CADASTRAR CLIENTE (╯°□°)╯︵ ┻━┻\n");
		
		setConfirmacao(false);
		while (!confirmacao) {
			System.out.println("Insira o CPF do cliente: ");
			cliente.setCpf(EntradaDados.inputString());
			setConfirmacao(Confirmacao.confirmar());
	 	}
		
		setConfirmacao(false);
		while (!confirmacao) {
			System.out.println("Insira o RG do cliente: ");
			cliente.setRg(EntradaDados.inputString());
			setConfirmacao(Confirmacao.confirmar());
		}
		
		setConfirmacao(false);
		while (!confirmacao) {
			System.out.println("Insira o nome completo do cliente: ");
			cliente.setNomeCompleto(EntradaDados.inputString());
			setConfirmacao(Confirmacao.confirmar());
		}
		
		setConfirmacao(false);
		while (!confirmacao) {
			System.out.println("Insira o endereço do cliente: ");
			cliente.setEndereco(EntradaDados.inputString());
			setConfirmacao(Confirmacao.confirmar());
		}
		
		setConfirmacao(false);
		while (!confirmacao) {
			System.out.println("Insira o e-mail do cliente: ");
			cliente.setEmail(EntradaDados.inputString());
			setConfirmacao(Confirmacao.confirmar());
		}
		
		setConfirmacao(false);
		while (!confirmacao) {
			System.out.println("Dados do Cliente");
			System.out.println("\tCPF: " + cliente.getCpf());
			System.out.println("\tRG: " + cliente.getRg());
			System.out.println("\tNome completo: " + cliente.getNomeCompleto());
			System.out.println("\tEndereço: " + cliente.getEndereco());
			System.out.println("\tE-mail: " + cliente.getEmail());
			setConfirmacao(Confirmacao.confirmar());
			
			if(!confirmacao) cadastrarCliente();
		}
		
		return cliente;
	}
	
	public void consultarCliente() {
		
		System.out.println("CONSULTAR CLIENTE (╯°□°)╯︵ ┻━┻\n");
		
		System.out.println("Digite o CPF do cliente: ");
		
		String cpfCliente = EntradaDados.inputString();
		
		Cliente clienteDatabase = (Cliente) Database.clientes.consultar(cpfCliente);
		
		if(clienteDatabase != null) {
			System.out.println(clienteDatabase.toString());
		} else {
			System.out.println("Nenhum cliente encontrado com este CPF.");
		}
	}
	
	public void atualizarCliente() {
		
		cliente = new Cliente();
		
		System.out.println("ATUALIZAR CLIENTE (╯°□°)╯︵ ┻━┻\n");
		
		System.out.println("Digite o CPF do cliente que será alterado: ");
		
		String cpfCliente = EntradaDados.inputString();			
		
		if(Database.clientes.consultar(cpfCliente) != null) {
			Database.clientes.atualizar(cpfCliente, cadastrarCliente());			
		} else {
			System.out.println("Nenhum cliente encontrado com este CPF.");
		}
	}
	
	public void excluirCliente() {
		
		System.out.println("EXCLUIR CLIENTE (╯°□°)╯︵ ┻━┻\n");
		
		System.out.println("Digite o CPF do cliente que será excluído: ");
		
		String cpfCliente = EntradaDados.inputString();
		
		Cliente clienteDatabase = (Cliente) Database.clientes.consultar(cpfCliente);
		
		if(clienteDatabase != null) {
			Database.clientes.remover(cpfCliente);
			System.out.println("Cliente removido com sucesso.");
		}
		else {
			System.out.println();
			return;
		}
	}
	
	public void imprimirClientes() {
		
		System.out.println("LISTA DE CLIENTES (╯°□°)╯︵ ┻━┻\n");
		
		Database.clientes.imprimir();
	}
	
}
