package modelo;

import java.io.Serializable;

public class Telefone implements Serializable {

	private static final long serialVersionUID = 6849677706302516043L;

	private String ddd;

	private String telefone;

	private Usuario usuario;

	public Telefone() {
	}

	public Telefone(String ddd, String telefone) {
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
