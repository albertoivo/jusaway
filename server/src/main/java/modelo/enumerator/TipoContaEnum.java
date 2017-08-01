package modelo.enumerator;

public enum TipoContaEnum {

	CONTA_CORRENTE("cc", "Conta Corrente"), POUPANCA("po", "Poupança"), CONTA_CONJUNTA("cj", "Conta Conjunta");
	
	public String valor, nome;

	private TipoContaEnum(String valor, String nome) {
		this.valor = valor;
		this.nome = nome;
	}
	
}
