package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import modelo.enumerator.EstadoCivilEnum;
import modelo.enumerator.SexoEnum;
import modelo.enumerator.TipoUsuarioEnum;
import util.Validacoes;

/**
 *
 * @author Ivo
 */
public class Usuario implements Serializable {

	private static final long serialVersionUID = 7747384265230970550L;
	private Integer id;
	private TipoUsuarioEnum tipoUsuario;
	private String nome;
	private String email;
	private String senha;
	private Endereco endereco;
	private List<Telefone> telefones;
	private DadosBancarios dadosBancarios;
	private LocalDate dataCadastro;
	private LocalDate dataAtualizacao;
	private LocalDate dataNascimento;
	private SexoEnum sexo;
	private String naturalidade;
	private String nacionalidade;
	private EstadoCivilEnum estadoCivil;
	private String cpf;
	private String rg;
	private String ctps;
	private String oab;
	private String instituicao;
	private String profissao;
	private String razaoSocial;
	private String cnpj;
	private String inscricaoEstadual;
	private String responsavel;

	private Usuario(UsuarioBuilder builder) {
		this.tipoUsuario = builder.tipoUsuario;
		this.nome = builder.nome;
		this.email = builder.email;
		this.senha = builder.senha;
		this.endereco = builder.endereco;
		this.telefones = builder.telefones;
		this.dadosBancarios = builder.dadosBancarios;
		this.dataCadastro = builder.dataCadastro;
		this.dataAtualizacao = builder.dataAtualizacao;
		this.dataNascimento = builder.dataNascimento;
		this.sexo = builder.sexo;
		this.naturalidade = builder.naturalidade;
		this.nacionalidade = builder.nacionalidade;
		this.estadoCivil = builder.estadoCivil;
		this.cpf = builder.cpf;
		this.rg = builder.rg;
		this.ctps = builder.ctps;
		this.oab = builder.oab;
		this.instituicao = builder.instituicao;
		this.profissao = builder.profissao;
		this.razaoSocial = builder.razaoSocial;
		this.cnpj = builder.cnpj;
		this.inscricaoEstadual = builder.inscricaoEstadual;
		this.responsavel = builder.responsavel;
	}

	public Integer getId() {
		return id;
	}

	public TipoUsuarioEnum getTipoUsuario() {
		return tipoUsuario;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public DadosBancarios getDadosBancarios() {
		return dadosBancarios;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public String getCtps() {
		return ctps;
	}

	public String getOab() {
		return oab;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public String getProfissao() {
		return profissao;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public static class UsuarioBuilder {

		private TipoUsuarioEnum tipoUsuario;
		private String nome;
		private String email;
		private String senha;
		private Endereco endereco;
		private List<Telefone> telefones;
		private DadosBancarios dadosBancarios;
		private LocalDate dataCadastro;
		private LocalDate dataAtualizacao;
		private LocalDate dataNascimento;
		private SexoEnum sexo;
		private String naturalidade;
		private String nacionalidade;
		private EstadoCivilEnum estadoCivil;
		private String cpf;
		private String rg;
		private String ctps;
		private String oab;
		private String instituicao;
		private String profissao;
		private String razaoSocial;
		private String cnpj;
		private String inscricaoEstadual;
		private String responsavel;

		public UsuarioBuilder setNome(String nome) {
			this.nome = nome;
			return this;
		}

		public UsuarioBuilder setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
			this.tipoUsuario = tipoUsuario;
			return this;
		}

		public UsuarioBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public UsuarioBuilder setSenha(String senha) {
			this.senha = senha;
			return this;
		}

		public UsuarioBuilder setEndereco(Endereco endereco) {
			this.endereco = endereco;
			return this;
		}

		public UsuarioBuilder setTelefones(List<Telefone> telefones) {
			this.telefones = telefones;
			return this;
		}

		public UsuarioBuilder setDadosBancarios(DadosBancarios dadosBancarios) {
			this.dadosBancarios = dadosBancarios;
			return this;
		}

		public UsuarioBuilder setDataCadastro(LocalDate dataCadastro) {
			this.dataCadastro = dataCadastro;
			return this;
		}

		public UsuarioBuilder setDataAtualizacao(LocalDate dataAtualizacao) {
			this.dataAtualizacao = dataAtualizacao;
			return this;
		}

		public UsuarioBuilder setDataNascimento(LocalDate dataNascimento) {
			this.dataNascimento = dataNascimento;
			return this;
		}

		public UsuarioBuilder setSexo(SexoEnum sexo) {
			this.sexo = sexo;
			return this;
		}

		public UsuarioBuilder setNaturalidade(String naturalidade) {
			this.naturalidade = naturalidade;
			return this;
		}

		public UsuarioBuilder setNacionalidade(String nacionalidade) {
			this.nacionalidade = nacionalidade;
			return this;
		}

		public UsuarioBuilder setEstadoCivil(EstadoCivilEnum estadoCivil) {
			this.estadoCivil = estadoCivil;
			return this;
		}

		public UsuarioBuilder setCpf(String cpf) {
			this.cpf = cpf;
			return this;
		}

		public UsuarioBuilder setRg(String rg) {
			this.rg = rg;
			return this;
		}

		public UsuarioBuilder setCtps(String ctps) {
			this.ctps = ctps;
			return this;
		}

		public UsuarioBuilder setOab(String oab) {
			this.oab = oab;
			return this;
		}

		public UsuarioBuilder setInstituicao(String instituicao) {
			this.instituicao = instituicao;
			return this;
		}

		public UsuarioBuilder setProfissao(String profissao) {
			this.profissao = profissao;
			return this;
		}

		public UsuarioBuilder setRazaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
			return this;
		}

		public UsuarioBuilder setCnpj(String cnpj) {
			this.cnpj = cnpj;
			return this;
		}

		public UsuarioBuilder setInscricaoEstadual(String inscricaoEstadual) {
			this.inscricaoEstadual = inscricaoEstadual;
			return this;
		}

		public UsuarioBuilder setResponsavel(String responsavel) {
			this.responsavel = responsavel;
			return this;
		}

		public Usuario build() {
			Usuario usuario = new Usuario(this);

			if (!StringUtils.isBlank(cpf) && !Validacoes.isValidCPF(cpf)) {
				throw new IllegalStateException("CPF Inválido");
			}

			if (!StringUtils.isBlank(cnpj) && !Validacoes.isValidCNPJ(cnpj)) {
				throw new IllegalStateException("CNPJ Inválido");
			}

			if (dataCadastro == null) {
				usuario.dataCadastro = LocalDate.now();
			} else {
				usuario.dataAtualizacao = LocalDate.now();
			}

			return usuario;
		}

	}

}
