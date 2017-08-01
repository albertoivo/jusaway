package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import modelo.enumerator.StatusEnum;


/**
 *
 * @author Ivo
 */
public class Recurso implements Serializable {

	private static final long serialVersionUID = -5235967985082958318L;

	// PK
	private String numero;

	private String descricao;
	
    private LocalDateTime dataDistribuicao = LocalDateTime.now();
    
    private LocalDateTime dataCadastro = LocalDateTime.now();
    
    private LocalDateTime dataAtualizacao = LocalDateTime.now();
	
	private LocalTramitacao localTramitacao;
	
    private StatusEnum situacaoCliente;
    
    private StatusEnum situacaoParteContraria;
    
    private List<String> recursos;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getDataDistribuicao() {
		return dataDistribuicao;
	}

	public void setDataDistribuicao(LocalDateTime dataDistribuicao) {
		this.dataDistribuicao = dataDistribuicao;
	}

	public LocalTramitacao getLocalTramitacao() {
		return localTramitacao;
	}

	public void setLocalTramitacao(LocalTramitacao localTramitacao) {
		this.localTramitacao = localTramitacao;
	}

	public StatusEnum getSituacaoCliente() {
		return situacaoCliente;
	}

	public void setSituacaoCliente(StatusEnum situacaoCliente) {
		this.situacaoCliente = situacaoCliente;
	}

	public StatusEnum getSituacaoParteContraria() {
		return situacaoParteContraria;
	}

	public void setSituacaoParteContraria(StatusEnum situacaoParteContraria) {
		this.situacaoParteContraria = situacaoParteContraria;
	}

	public List<String> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<String> recursos) {
		this.recursos = recursos;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
