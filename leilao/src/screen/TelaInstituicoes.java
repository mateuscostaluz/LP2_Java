package screen;

import database.Database;
import entities.Instituicao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.Confirmacao;
import services.EntradaDados;


@NoArgsConstructor
@Getter
@Setter
public class TelaInstituicoes {
	
	private Boolean confirmacao;
	private Instituicao instituicao;
	
	public void opcoesInstituicoes() {
		int escolha;
		
		do {
			System.out.println("Escolha uma das operações abaixo:");
			System.out.println("1 - Cadastrar Instituição");
			System.out.println("2 - Consutar Instituição");
			System.out.println("3 - Atualizar Instituição");
			System.out.println("4 - Excluir Instituição");
			System.out.println("5 - Visualizar Instituições cadastrados");
			System.out.println("6 - Retornar ao menu inicial");
			
			System.out.println("Insira sua opção: ");
			escolha = EntradaDados.inputInt();
			System.out.println();
			
			switch (escolha) {
			case 1:				
				Database.instituicoes.adicionar(cadastrarInstituicao());
				break;
				
			case 2:
				consultarInstituicao();
				break;
				
			case 3:
				atualizarInstituicao();
				break;
				
			case 4:
				excluirInstituicao();
				break;
				
			case 5:
				imprimirInstituicao();
				break;
				
			case 6:
				break;

			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while(escolha != 6);
	}
	
	
		public Instituicao cadastrarInstituicao() {
		
			instituicao = new Instituicao();
			
			System.out.println("CADASTRAR NOVA INSITUIÇÃO (╯°□°)╯︵ ┻━┻\n");
			
			setConfirmacao(false);
			while (!confirmacao) {
				System.out.println("Insira o CPNJ: ");
				instituicao.setCnpj(EntradaDados.inputString());
				setConfirmacao(Confirmacao.confirmar());
			}
			
			setConfirmacao(false);
			while (!confirmacao) {
				System.out.println("Insira o Nome: ");
				instituicao.setNome(EntradaDados.inputString());
				setConfirmacao(Confirmacao.confirmar());
			}
			
			setConfirmacao(false);
			while (!confirmacao) {
				System.out.println("Insira o endereço: ");
				instituicao.setEndereco(EntradaDados.inputString());
				setConfirmacao(Confirmacao.confirmar());
			}
			
			setConfirmacao(false);
			while (!confirmacao) {
				System.out.println("Insira o e-mail: ");
				instituicao.setEmail(EntradaDados.inputString());
				setConfirmacao(Confirmacao.confirmar());
			}
			
			setConfirmacao(false);
			while (!confirmacao) {
				System.out.println("Dados da Instituição");
				System.out.println("\tCNPJ: " + instituicao.getCnpj());
				System.out.println("\tNome: " + instituicao.getNome());
				System.out.println("\tEndereço: " + instituicao.getEndereco());				
				System.out.println("\tE-mail: " + instituicao.getEmail());
				setConfirmacao(Confirmacao.confirmar());
				
				if(!confirmacao) cadastrarInstituicao();
			}
			
			return instituicao; 			
		}
		
		public void consultarInstituicao() {
			
			System.out.println("CONSULTAR INSTITUIÇÃO (╯°□°)╯︵ ┻━┻\n");
			
			System.out.println("Digite o CNPJ da instituição: ");
			
			String cnpjInstituicao = EntradaDados.inputString();
			
			Instituicao DataInstituicao = (Instituicao) Database.instituicoes.consultar(cnpjInstituicao);
			
			if(DataInstituicao != null) {
				System.out.println(DataInstituicao.toString());
			} else {
				System.out.println("Nenhuma Instituição encontrada.");
			}
		}
		
		public void atualizarInstituicao() {
			
			System.out.println("ATUALIZAR INSTITUIÇÃO (╯°□°)╯︵ ┻━┻\n");
			
			System.out.println("Digite o CNPJ da instituição que será alterado: ");
			
			String cnpjInstituicao = EntradaDados.inputString();						
			
			if (Database.instituicoes.consultar(cnpjInstituicao) != null) {
				Database.instituicoes.atualizar(cnpjInstituicao, cadastrarInstituicao());
			} else {
				System.out.println("Nenhuma instituição encontrada com este CNPJ.");
			}
						
		}
		
		public void excluirInstituicao() {
			
			System.out.println("EXCLUIR INSTITUIÇÃO (╯°□°)╯︵ ┻━┻\n");
			
			System.out.println("Digite o CNPJ da instituição que será excluído: ");
			
			String cnpjInstituicao = EntradaDados.inputString();					
			
			if(Database.instituicoes.consultar(cnpjInstituicao) != null) {
				Database.instituicoes.remover(cnpjInstituicao);
				System.out.println("Cliente removido com sucesso.");
			}
			else {
				System.out.println();
				return;
			}
		}
		
		public void imprimirInstituicao() {
			
			System.out.println("LISTA DE INSTITUIÇÕES (╯°□°)╯︵ ┻━┻\n");
			
			Database.instituicoes.imprimir();
		}
		
}
