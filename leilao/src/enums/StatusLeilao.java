package enums;

public enum StatusLeilao {
	
	ABERTO("Aberto"), ANDAMENTO("Andamento"), FINALIZADO("Finalizado");
	
	private final String statusLeilao;
	
	StatusLeilao(String statusLeilao) {
		this.statusLeilao = statusLeilao;
	}
	
	@Override
	public String toString(){
		return statusLeilao;
	}
	
}
