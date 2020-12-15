package enums;

public enum TipoImovel {
	
	APARTAMENTO("Apartamento"), TERRENO("Terreno"), CASA("Casa"), EDIFICIO("Edifício");
	
	private final String tipoImovel;
	
	TipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}
	
	@Override
	public String toString(){
		return tipoImovel;
	}
	
}
