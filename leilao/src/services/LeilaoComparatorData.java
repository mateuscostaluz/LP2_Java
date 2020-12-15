package services;

import java.util.Comparator;

import entities.Leilao;

public class LeilaoComparatorData implements Comparator {
	
	@Override
    public int compare(Object objLeilao, Object objOutroLeilao) {
		Leilao leilao = (Leilao) objLeilao;
		Leilao outroLeilao = (Leilao) objOutroLeilao;
		
        return leilao.getDataHoraInicio().compareTo(outroLeilao.getDataHoraInicio());
    }
	
}
