package enums;

public enum TipoImovel {
	
	APARTAMENTO("Apartamento"), TERRENO("Terreno"), CASA("Casa"), EDIFICIO("Edif�cio");
	
	private final String tipoImovel;
	
	TipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}
	
	@Override
	public String toString(){
		return tipoImovel;
	}
	
}
