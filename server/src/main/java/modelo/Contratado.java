package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;;

/**
 *
 * @author Ivo
 */
public class Contratado implements Serializable {

	private static final long serialVersionUID = 9158420480917965341L;

	private Escritorio escritorio;

	private Usuario advogado;

	private List<Telefone> telefones;

	private String email;

	private String cidade;

	private String uf;

	private BigDecimal precoDeslocamento;

	private BigDecimal precoPreposto;

	private BigDecimal precoDiligencia;

	private BigDecimal precoAdvgado;

	private String descricao;

	private DadosBancarios dadosBancarios;

	public Contratado() {

	}

	public Usuario getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Usuario advogado) {
		this.advogado = advogado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public DadosBancarios getDadosBancarios() {
		return dadosBancarios;
	}

	public void setDadosBancarios(DadosBancarios dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Escritorio getEscritorio() {
		return escritorio;
	}

	public void setEscritorio(Escritorio escritorio) {
		this.escritorio = escritorio;
	}

	public BigDecimal getPrecoAdvgado() {
		return precoAdvgado;
	}

	public void setPrecoAdvgado(BigDecimal precoAdvgado) {
		this.precoAdvgado = precoAdvgado;
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

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
