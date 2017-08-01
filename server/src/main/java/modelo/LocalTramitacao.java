package modelo;

import java.io.Serializable;

/**
 *
 * @author Ivo
 */
public class LocalTramitacao implements Serializable {
    
	private static final long serialVersionUID = 7085117796366527243L;

    private String nome;
    
    private String descricao;

    public LocalTramitacao() {
    }

    public LocalTramitacao(String nome) {
        this.nome = nome;
    }

    public LocalTramitacao(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalTramitacao other = (LocalTramitacao) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
