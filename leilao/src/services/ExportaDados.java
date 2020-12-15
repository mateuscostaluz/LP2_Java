package services;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import entities.Leilao;

public class ExportaDados {
	
	public void exportarDadosLeilao(Leilao leilao) throws IOException {
		String nameFile = "leilao" + leilao.getId() + ".DET";		
		FileWriter file = new FileWriter(nameFile);
		PrintWriter writer = new PrintWriter(file);		
		writer.printf("Dados leilão %n%n");
		writer.printf(leilao.toString());		
		writer.close();
	}

}
