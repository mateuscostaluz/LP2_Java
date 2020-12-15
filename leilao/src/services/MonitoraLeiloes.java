package services;

import java.util.Timer;
import java.util.TimerTask;

import collections.Leiloes;
import database.Database;
import entities.Leilao;

public class MonitoraLeiloes {
	
	public static void AtualizaLeiloes() {
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {				
				if (Database.leiloes.getLeiloes().size() > 0) {
					for (Leilao leilao : Database.leiloes.getLeiloes()) {
						leilao.updateStatusLeilao();
					}
				}
	        }
	    }, 0, 60 * 1000);
	}
	
}
