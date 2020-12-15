package screen;

import java.util.Scanner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TelaInicial {
	
	private Scanner input = new Scanner(System.in);
	private Boolean confirmacao;
	
	public void opcoesTelaInicial() {
		
		int escolha;
		
		TelaClientes telaClientes = new TelaClientes();
		TelaProdutos telaProdutos = new TelaProdutos();
		TelaInstituicoes telaInstituicoes = new TelaInstituicoes();		
		TelaLeilao telaLeilao = new TelaLeilao();
		
		do {
			System.out.println("Escolha uma das operações abaixo:");
			System.out.println("1 - Clientes");
			System.out.println("2 - Instituições");
			System.out.println("3 - Produtos");
			System.out.println("4 - Leilões");
			System.out.println("5 - Sair");
			
			System.out.println("Insira sua opção: ");		
			escolha = input.nextInt();
			System.out.println();
			
			switch (escolha) {
			case 1:
				System.out.println("(╯°□°)╯︵ ┻━┻ CLIENTES\n");
				telaClientes.opcoesClientes();
				break;
				
			case 2:
				System.out.println("(╯°□°)╯︵ ┻━┻ INSTITUIÇÃO\n");
				telaInstituicoes.opcoesInstituicoes();
				break;

			case 3:
				System.out.println("(╯°□°)╯︵ ┻━┻ PRODUTOS\n");
				telaProdutos.opcoesProdutos();
				
			case 4:
				System.out.println("(╯°□°)╯︵ ┻━┻ LEILÃO\n");
				telaLeilao.opcaoLeilao();
				
			case 5:
				System.out.println("Tudo bem, até logo! ¯\\_(ツ)_/¯");
				System.exit(0);
				break;
				
			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while(escolha != 5);
	}
}
