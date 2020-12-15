package enums;

public enum TipoVeiculo {
	
	CARRO("Carro"), MOTOCICLETA("Motocicleta");
	
	private final String tipoVeiculo;
	
	TipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	
	@Override
	public String toString(){
		return tipoVeiculo;
	}
	
}
