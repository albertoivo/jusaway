package modelo;

import java.io.Serializable;

import modelo.enumerator.LitisEnum;

/**
 * @author Ivo
 */
public class Litisconsorcio implements Serializable {

	private static final long serialVersionUID = 4043789290670958217L;

    private String nome;

	private String cpf;
	
	private String cnpj;
	
    private LitisEnum status;

    public Litisconsorcio() {
    }

    public Litisconsorcio(String nome) {
    	this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public LitisEnum getStatus() {
		return status;
	}
	
	public void setStatus(LitisEnum status) {
		this.status = status;
	}

}
