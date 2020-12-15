package services;

import java.util.Scanner;

public class Confirmacao {
	
	public static boolean confirmar() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Deseja confirmar? 1 - Sim | 2 - Não");
		int opcao = input.nextInt();
		
		if (opcao != 1 && opcao != 2) confirmar();
		
		return (opcao == 1) ? true : false;
	}

}
