package modelo;

import java.io.Serializable;

import modelo.enumerator.TipoContaEnum;

/**
 *
 * @author Ivo
 */
public class DadosBancarios implements Serializable {

	private static final long serialVersionUID = -5367878233192917818L;

	private Banco banco;

	private String agencia;

	private String contaCorrente;

	private TipoContaEnum tipoConta;

	private String operacao;

	private Usuario usuario;

	public DadosBancarios() {
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
