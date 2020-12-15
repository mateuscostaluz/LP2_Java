package services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import enums.TipoImovel;
import enums.TipoVeiculo;

public class EntradaDados {
	
	private static Scanner input;

	public static String inputString() {
		input = new Scanner(System.in);
		
		return input.nextLine();
	}
	
	public static int inputInt() {
		input = new Scanner(System.in);
		
		return input.nextInt();
	}
	
	public static Double inputDouble() {
		input = new Scanner(System.in);
		input.useLocale(Locale.ENGLISH);
		
		return input.nextDouble();
	}
	
	public static LocalDateTime inputDataHora() {
		input = new Scanner(System.in);		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		System.out.println("Digite uma data e hora (exemplo: 01/01/2001 18:00): ");
		String inputDate = inputString();
		LocalDateTime dateTime = LocalDateTime.parse(inputDate, dateFormat);	
		return dateTime;		
	}
	
	public static TipoImovel inputTipoImovel() {
		
		System.out.println("Qual o tipo do imóvel?");
		System.out.println("1 - " + TipoImovel.APARTAMENTO.toString());
		System.out.println("2 - " + TipoImovel.CASA.toString());
		System.out.println("3 - " + TipoImovel.EDIFICIO.toString());
		System.out.println("4 - " + TipoImovel.TERRENO.toString());
		
		System.out.println("Insira sua opção: ");
		int tipoProduto = inputInt();
		
		switch (tipoProduto) {
		case 1:
			return TipoImovel.APARTAMENTO;
		case 2:
			return TipoImovel.CASA;
		case 3:
			return TipoImovel.EDIFICIO;
		case 4:
			return TipoImovel.TERRENO;
		default:
			System.out.println("Opção inválida . Tente novamente.");
			inputTipoImovel();
		}
		return null;
	}
	
public static TipoVeiculo inputTipoVeiculo() {
		
		System.out.println("Qual o tipo do veículo?");
		System.out.println("1 - " + TipoVeiculo.CARRO.toString());
		System.out.println("2 - " + TipoVeiculo.MOTOCICLETA.toString());
		
		System.out.println("Insira sua opção: ");
		int tipoProduto = inputInt();
		
		switch (tipoProduto) {
		case 1:
			return TipoVeiculo.CARRO;
		case 2:
			return TipoVeiculo.MOTOCICLETA;
		default:
			System.out.println("Opção inválida . Tente novamente.");
			inputTipoVeiculo();
		}
		return null;
	}

}
