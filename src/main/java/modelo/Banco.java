package modelo;

import java.io.Serializable;

public class Banco implements Serializable {

	private static final long serialVersionUID = 6042401974605791128L;

	// PK
	private String numero;

	private String nome;

	public Banco() {
	}

	public Banco(String numero, String nome) {
		super();
		this.numero = numero;
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
