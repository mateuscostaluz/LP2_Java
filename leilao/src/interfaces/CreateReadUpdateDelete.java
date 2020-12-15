package interfaces;

public interface CreateReadUpdateDelete {
	
	void imprimir();
	void adicionar (Object dado);
	Object consultar (String dado);
	void atualizar (String dado, Object novo);
	Boolean remover (String dado);

}
