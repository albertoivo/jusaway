package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import modelo.enumerator.FormaPagamentoEnum;

/**
 *
 * @author Ivo
 */
public class Contratante implements Serializable {

	private static final long serialVersionUID = -8608659937523439537L;

	private Escritorio escritorio;

	private Usuario advogado;

	private List<Telefone> telefones;

	private Cidade cidade;

	private BigDecimal precoDiligencia;

	private BigDecimal precoDeslocamento;

	private BigDecimal precoAdvogado;

	private BigDecimal precoPreposto;

	private String descricao;

	private FormaPagamentoEnum formaPagamento;

	public Usuario getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Usuario advogado) {
		this.advogado = advogado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Escritorio getEscritorio() {
		return escritorio;
	}

	public void setEscritorio(Escritorio escritorio) {
		this.escritorio = escritorio;
	}

	public FormaPagamentoEnum getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoEnum formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getPrecoAdvogado() {
		return precoAdvogado;
	}

	public void setPrecoAdvogado(BigDecimal precoAdvogado) {
		this.precoAdvogado = precoAdvogado;
	}

	public BigDecimal getPrecoDeslocamento() {
		return precoDeslocamento;
	}

	public void setPrecoDeslocamento(BigDecimal precoDeslocamento) {
		this.precoDeslocamento = precoDeslocamento;
	}

	public BigDecimal getPrecoDiligencia() {
		return precoDiligencia;
	}

	public void setPrecoDiligencia(BigDecimal precoDiligencia) {
		this.precoDiligencia = precoDiligencia;
	}

	public BigDecimal getPrecoPreposto() {
		return precoPreposto;
	}

	public void setPrecoPreposto(BigDecimal precoPreposto) {
		this.precoPreposto = precoPreposto;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefone(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
