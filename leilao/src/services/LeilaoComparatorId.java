package services;

import java.util.Comparator;

import entities.Leilao;

public class LeilaoComparatorId implements Comparator {
	
	@Override
    public int compare(Object objLeilao, Object objOutroLeilao) {
		Leilao leilao = (Leilao) objLeilao;
		Leilao outroLeilao = (Leilao) objOutroLeilao;
		
        return leilao.getId().compareTo(outroLeilao.getId());
    }
	
}
