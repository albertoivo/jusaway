package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Escritorio implements Serializable {

	private static final long serialVersionUID = -7120828352142061468L;

	private String nome;

	private String email;

	private String cnpj;

	private String senha;

	private String subDominio;

	private List<Telefone> telefones;

	private Endereco endereco;

	private DadosBancarios dadosBancarios;

	private LocalDateTime dataCadastro;

	private LocalDateTime dataAtualizacao;

	public Escritorio() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public DadosBancarios getDadosBancarios() {
		return dadosBancarios;
	}

	public void setDadosBancarios(DadosBancarios dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSubDominio() {
		return subDominio;
	}

	public void setSubDominio(String subDominio) {
		this.subDominio = subDominio;
	}

}
