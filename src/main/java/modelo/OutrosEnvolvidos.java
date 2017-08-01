package modelo;

import java.io.Serializable;

/**
 *
 * @author Ivo
 */
public class OutrosEnvolvidos implements Serializable {

	private static final long serialVersionUID = -5810709789718186683L;

	private String nome;

    private Telefone telefone;

    private String profissao;

    public OutrosEnvolvidos() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Telefone getTelefone() {
        return telefone;
    }
    
    public void setTelefone(Telefone telefone) {
    	this.telefone = telefone;
    }

    public String getProfissao() {
		return profissao;
	}

    public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

}
