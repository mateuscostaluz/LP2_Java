package database;

import collections.Clientes;
import collections.Instituicoes;
import collections.Leiloes;
import collections.Produtos;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Database {
	
	public static Clientes clientes = new Clientes();
	public static Instituicoes instituicoes = new Instituicoes();
	public static Leiloes leiloes = new Leiloes();
	public static Produtos produtos = new Produtos();
	
}
