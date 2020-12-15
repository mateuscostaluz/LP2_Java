package screen;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.TimeZone;

import collections.Clientes;
import collections.Lances;
import collections.Leiloes;
import collections.Produtos;
import database.Database;
import entities.Cliente;
import entities.Instituicao;
import entities.Lance;
import entities.Leilao;
import entities.Produto;
import enums.StatusLeilao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.Confirmacao;
import services.EntradaDados;
import services.ExportaDados;

@NoArgsConstructor
@Getter
@Setter
public class TelaLeilao {
	
	private Leilao leilao;
	private Boolean confirmacao;
	private TelaProdutos telaProdutos = new TelaProdutos();
	private TelaClientes telaClientes  = new TelaClientes();
	private TelaInstituicoes telaInstituicoes = new TelaInstituicoes();
	
	public void opcaoLeilao() {
		int escolha;
		
		do {
			System.out.println("Escolha uma das operações abaixo:");
			System.out.println("1 - Cadastrar Leilão");
			System.out.println("2 - Vincular dados ao Leilão");
			System.out.println("3 - Registrar Lance em Leilão");
			System.out.println("4 - Consultar leilão");
			System.out.println("5 - Atualizar Leilão");
			System.out.println("6 - Excluir Leilão");
			System.out.println("7 - Visualizar Filtro dos Produtos de um Leilão");
			System.out.println("8 - Exportar leilão para arquivo.DET");
			System.out.println("9 - Retornar ao menu inicial");
			
			System.out.println("Insira sua opção: ");
			escolha = EntradaDados.inputInt();
			System.out.println();
			
			switch (escolha) {
			case 1:				
				Database.leiloes.adicionar(cadastroLeilao());
				break;
			
			case 2:
				vincularDadosLeilao();
				break;
				
			case 3:
				registrarLance();
				break;
				
			case 4:
				consultarLeilao();
				break;
				
			case 5:
				atualizarLeilao();
				break;
				
			case 6:
				removerLeilao();
				break;
				
			case 7:
				filtroProdutosLeilao();
				break;
				
			case 8:
				exportarLeilao();
				break;
				
			case 9:
				break;

			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while(escolha != 6);
	}
	
	public Leilao cadastroLeilao() {
		leilao = new Leilao();
		
		System.out.println("CADASTRAR NOVO LEILÃO (╯°□°)╯︵ ┻━┻\n");
		
		setConfirmacao(false);
		while (!confirmacao) {
			System.out.println("Insira data e hora do inicio do leilão: ");
			leilao.setDataHoraInicio(EntradaDados.inputDataHora());			
			setConfirmacao(Confirmacao.confirmar());			
		}
		
		setConfirmacao(false);
		while (!confirmacao) {
			System.out.println("Insira data e hora do fim do leilão: ");
			leilao.setDataHoraFim(EntradaDados.inputDataHora());			
			setConfirmacao(Confirmacao.confirmar());			
		}
		
		setConfirmacao(false);
		while (!confirmacao) {
			
			System.out.println("1 - Deseja cadastrar uma nova instituição  \n"
					+ "2 - deseja selecionar uma instituição já cadastrada no sistema");
			int escolha = EntradaDados.inputInt();
			if (escolha == 1) {
				System.out.println("Cadastre a instituição: ");
				leilao.setInstituicao(telaInstituicoes.cadastrarInstituicao());
				setConfirmacao(Confirmacao.confirmar());
			}
			if (escolha == 2) {
				System.out.println("Selecione a instituição de acordo com o cnpj cadastrado: ");
				String var = EntradaDados.inputString();
				leilao.setInstituicao((Instituicao)Database.instituicoes.consultar(var));;
				setConfirmacao(Confirmacao.confirmar());
			}
			if(escolha != 1 && escolha != 2) {
				System.out.println("Operação invalida");
			}						
		}
		
		leilao.setClientes(new Clientes());
		leilao.setProdutos(new Produtos());
		leilao.updateStatusLeilao();
		
		return leilao;
		
	}
	
	public void vincularDadosLeilao() {
		System.out.println("Vincular dados ao leilão: ");
		System.out.println("Informe o id do leilão: ");
		String id = EntradaDados.inputString();
		Leilao	encontrado =(Leilao) Database.leiloes.consultar(id);
		if(encontrado != null) {
			System.out.println("Escolha:\n"
					+ "1 - Cadastrar Produto\n"
					+ "2 - Cadastrar Cliente");
			int escolha = EntradaDados.inputInt();			
			if(escolha == 1) {
				System.out.println("1 - Deseja cadastrar um novo produto ao leilão \n"
						+ "2 - deseja selecionar um produto já cadastrado no sistema");
				int escolha2 = EntradaDados.inputInt();
				if (escolha2 == 1) {
					System.out.println("Cadastre os produtos que estarão no leilão: ");
					encontrado.getProdutos().adicionar(telaProdutos.cadastrarProduto());						
				}
				if (escolha2 == 2) {
					System.out.println("Selecione o produto de acordo com a matricula do produto cadastrado: ");
					String var = EntradaDados.inputString();
					leilao.getProdutos().adicionar(Database.produtos.consultar(var));
				}
			}
			if (escolha == 2) {
				System.out.println("1 - Deseja cadastrar um novo cliente ao leilão \n"
						+ "2 - deseja selecionar um cliente já cadastrado no sistema");
				int escolha3 = EntradaDados.inputInt();
				if (escolha3 == 1) {
					System.out.println("Cadastre o cliente: ");
					leilao.getClientes().adicionar(telaClientes.cadastrarCliente());									
				}
				if (escolha3 == 2) {
					System.out.println("Selecione o cliente de acordo com o cpf cadastrado: ");
					String var = EntradaDados.inputString();
					leilao.getClientes().adicionar(Database.clientes.consultar(var));						
				}
			}
		}

	}
	
	public void registrarLance() {
		System.out.println("AVISO: Para registro de lance é necessario que os envolvidos já estejam registrados no leião pertencente!\n");
		System.out.println("Informe qual leilão deseja registrar o lance: \n");
		if (visualizarLeiloesAndamento()) {
			visualizarLeiloesAndamento();
			
			System.out.println("Informe os dados para registrar o lance: ");			
			
			setConfirmacao(false);
			while(!confirmacao) {
				System.out.println("Informe o ID do Leilão onde deseja efetuar o Lance: ");
				String id = EntradaDados.inputString();
				Leilao leilao = (Leilao) Database.leiloes.consultar(id);
				if(leilao != null) {
					System.out.println("Informe o CPF do cliente já registrado no leilão: ");
					String cpf = EntradaDados.inputString();
					System.out.println("Informe a matricula do produto já registrado no leilão: ");
					String matricula = EntradaDados.inputString();
					System.out.println("Informe o valor do lance: ");
					Double valor = EntradaDados.inputDouble();
					Produto produto = (Produto) leilao.getProdutos().consultar(matricula);
					if (produto == null) System.out.println("produto não encontrado");
					Cliente cliente = (Cliente) leilao.getClientes().consultar(cpf);
					if (cliente == null) System.out.println("cliente não encontrado");
					produto.getLances().adicionar(new Lance(cliente, produto, valor));
					setConfirmacao(Confirmacao.confirmar());
				}
			}			
		} else {
			System.out.println("Nenhum leilão disponivel no momento!");
		}				
	}
	
	public Boolean visualizarLeiloesAndamento() {
		Boolean viu = false;
		try {
			for (Leilao leilao : Database.leiloes.getLeiloes()) {
				if (leilao.getStatusLeilao().equals(StatusLeilao.ANDAMENTO)) {
					System.out.println(leilao.toString());
					viu = true;
				}
			}						
		} catch (Exception e) {
			System.out.println("Nenhum leilão disponivel no momento");
		}
		return viu;
	}
	
	public void consultarLeilao() {
		System.out.println("Escolha a forma que seja informada a lista de leilões:\n"
				+ "1 - Ordenados por Data\n"
				+ "2 - Ordenados pelo ID\n"
				+ "3 - Detalhes de um leilao");
		int escolha = EntradaDados.inputInt();
		try {
			if (escolha == 1) {
				Database.leiloes.ordenarLeiloesPorData();
				Database.leiloes.imprimir();
			}
			if (escolha == 2) {
				Database.leiloes.ordenarLeiloesPeloId();
				Database.leiloes.imprimir();
			}
			if (escolha == 3) {
				System.out.println("Informe o id do leilao para maiores detalhes: ");
				String id = EntradaDados.inputString();
				try {
					Leilao detalhes = (Leilao) Database.leiloes.consultar(id);					
					if (detalhes != null) {
						detalhes.toString();
					} else {
						System.out.println("Nenhum leilão encontrado");
					}
					
				} catch (Exception e) {
					System.out.println("falha na operação, tente novamente!");
				}
			}
		} catch (Exception e) {
			System.out.println("Operação invalida ou nenhum registro encontrado.");
		}
	}
	
	public void atualizarLeilao() {
		System.out.println("ATUALIZAR LEILÃO (╯°□°)╯︵ ┻━┻\n");
		System.out.println("AVISO: Ao atulizar a lista de lances referente ao leilão será zerado\n"
				+ "para que não haja conflitos, então após atualização recadastre os lances novamente !");
		System.out.println("Digite o id do leilão que será alterado: ");
		
		String id = EntradaDados.inputString();			
		
		if(Database.leiloes.consultar(id) != null) {
			Database.leiloes.atualizar(id, cadastroLeilao());			
		} else {
			System.out.println("Nenhum leilão encontrado com este ID.");
		}
	}
	
	public void removerLeilao() {
		System.out.println("REMOVER LEILÃO (╯°□°)╯︵ ┻━┻\n");
		System.out.println("Informe o ID do leilão a ser removido: ");
		String id = EntradaDados.inputString();
		try {
			Database.leiloes.remover(id);
		} catch (Exception e) {
			System.out.println("Falha na operação, revise as informação e tente novamente !");
		}
	}
	
	public void filtroProdutosLeilao() {
		System.out.println("FILTROS DOS PRODUTOS DO LEILÃO (╯°□°)╯︵ ┻━┻\n");
		System.out.println("Informe o id Leilao que deseja realizar a consulta: ");
		String id = EntradaDados.inputString();
		try {
			Leilao leilaovar = (Leilao) Database.leiloes.consultar(id);
			System.out.println("As operações dos filtros são:\n"
					+ "1 - filtrar os produtos por uma faixa de preço min e max\n"
					+ "2 - filtrar os produtos pelo tipo\n"
					+ "3 - filtrar os produtos por palavra chave");
			int escolha = EntradaDados.inputInt();
			if (escolha == 1) {
				System.out.println("informe o valor minimo para o produto");
				Double min = EntradaDados.inputDouble();
				System.out.println("informe o valor maximo para o produto");
				Double max = EntradaDados.inputDouble();
				Produtos encontrados = leilaovar.getProdutos().filtroFaixaValores(min, max);
				if (encontrados != null) {
					encontrados.imprimir();
				} else {
					System.out.println("Nenhum produto encontrado!");
				}
			}
			if (escolha == 2) {
				System.out.println("informe o tipo de produto: ");
				String tipo = EntradaDados.inputString();
				Produtos encontrados = leilaovar.getProdutos().filtroTipoProduto(tipo);
				if (encontrados != null) {
					encontrados.imprimir();
				} else {
					System.out.println("Nenhum produto encontrado!");
				}
			}
			if (escolha == 3) {
				System.out.println("informe a palavra chave do produto: ");
				String chave = EntradaDados.inputString();
				Produtos encontrados = leilaovar.getProdutos().filtroPalavraChave(chave);
				if (encontrados != null) {
					encontrados.imprimir();
				} else {
					System.out.println("Nenhum produto encontrado!");
				}
			} 
		} catch (Exception e) {
			System.out.println("Operação inválida, tente novamente!");
		}		
	}
	
	public void exportarLeilao() {
		System.out.println("EXPORTAR DADOS LEILÃO (╯°□°)╯︵ ┻━┻\n");
		System.out.println("informe o id do leilão que deseja exportar: ");
		String id = EntradaDados.inputString();
		try {
			Leilao exportado = (Leilao) Database.leiloes.consultar(id); 
			ExportaDados exp = new ExportaDados();
			exp.exportarDadosLeilao(exportado);
			System.out.println("Arquivo gerado com sucesso!");
		} catch (Exception e) {
			System.out.println("Falha na operação");
		}
		
	}
	
}
