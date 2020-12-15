package services;

import java.util.Comparator;

import entities.Lance;

public class LanceComparatorValor implements Comparator {
	
	@Override
    public int compare(Object objLance, Object objOutroLance) {
		Lance lance = (Lance) objLance;
		Lance outroLance = (Lance) objOutroLance;
		
        return lance.getValor().compareTo(outroLance.getValor());
    }
	
}
