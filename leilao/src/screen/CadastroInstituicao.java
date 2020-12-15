package screen;

import java.util.Scanner;

import collections.Instituicoes;
import database.Database;
import entities.Instituicao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.Main;
import services.Confirmacao;

@NoArgsConstructor
@Getter
@Setter
public class CadastroInstituicao {
	
	private Scanner input = new Scanner(System.in);
	private Boolean confirmacao;
	
	private Instituicao instituicao = new Instituicao();
	
	public void cadastrarInstituicao() {
		
		System.out.println("CADASTRAR INSTITUIÇÃO ┬─┬ノ( º _ ºノ)\n");
		
		setConfirmacao(false);
		while (!confirmacao) {
			System.out.println("Insira o CNPJ da instituição: ");
			instituicao.setCnpj(input.nextLine());
			setConfirmacao(Confirmacao.confirmar());
	 	}
		
		setConfirmacao(false);
		while (!confirmacao) {
			System.out.println("Insira o nome da instituição: ");
			instituicao.setNome(input.nextLine());
			setConfirmacao(Confirmacao.confirmar());
		}
		
		setConfirmacao(false);
		while (!confirmacao) {
			System.out.println("Insira o endereço da instituição: ");
			instituicao.setEndereco(input.nextLine());
			setConfirmacao(Confirmacao.confirmar());
		}
		
		setConfirmacao(false);
		while (!confirmacao) {
			System.out.println("Insira o e-mail da instituição: ");
			instituicao.setEmail(input.nextLine());
			setConfirmacao(Confirmacao.confirmar());
		}
		
		setConfirmacao(false);
		while (!confirmacao) {
			System.out.println("Dados da instituição");
			System.out.println("\tCNPJ: " + instituicao.getCnpj());
			System.out.println("\tNome: " + instituicao.getNome());
			System.out.println("\tEndereço: " + instituicao.getEndereco());
			System.out.println("\tE-mail: " + instituicao.getEmail());
			setConfirmacao(Confirmacao.confirmar());
			
			if(!confirmacao) cadastrarInstituicao();
		}
		
		Database.instituicoes.adicionar(instituicao);
		
		if(!Database.instituicoes.getInstituicoes().getLast().getCnpj().equals(instituicao.getCnpj())) {
			System.out.println("Instituição não cadastrada, por favor, tente novamente.");
			cadastrarInstituicao();
		}
	}
	
}
