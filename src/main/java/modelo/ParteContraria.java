package modelo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ivo
 */
public class ParteContraria implements Serializable {
    
	private static final long serialVersionUID = -7514430410251473052L;

    private String nome;

    private Endereco endereco;

    private List<Telefone> telefone;

    private String email;

    private String cpf;
    
    private String cnpj;

    private String rg;

    private Litisconsorcio litisconsorcio;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Litisconsorcio getLitisconsorcio() {
        return litisconsorcio;
    }

    public void setLitisconsorcio(Litisconsorcio litisconsorcio) {
        this.litisconsorcio = litisconsorcio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
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

	public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

}
