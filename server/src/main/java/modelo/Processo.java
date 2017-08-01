package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import modelo.enumerator.GrauImportanciaEnum;
import modelo.enumerator.StatusEnum;

/**
 *
 * @author Ivo
 */
public class Processo implements Serializable {

	private static final long serialVersionUID = -3173556930361151878L;

	// PK
	private String numero;

	private Usuario advogadoCliente;

	private Usuario advogadoParteContraria;

	private Usuario supervisor;

	private List<ParteContraria> partesContrarias;

	private Acao acao;

	private LocalTramitacao localTramitacao;

	private String vara;

	private BigDecimal valorCausa;

	private Area area;

	private SubArea subarea;

	private Procedimento procedimento;

	private Litisconsorcio litisAtivo;

	private Litisconsorcio itisPassivo;

	private GrauImportanciaEnum grauImportancia;

	private StatusEnum situacaoProcesso;

	private StatusEnum situacaoCliente;

	private StatusEnum situacaoParteContraria;

	private String referencia;

	private Comarca comarca;

	private DadosBancarios dadosBancarios;

	private List<OutrosEnvolvidos> outrosEnvolvidos;

	private LocalDateTime dataDistribuicao = LocalDateTime.now();

	private LocalDateTime dataCadastro = LocalDateTime.now();

	private LocalDateTime dataAtualizacao = LocalDateTime.now();

	private Usuario clienteFisico;

	private Usuario clienteJuridico;

	private Processo processoMae;

	public Processo() {

	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Usuario getAdvogadoCliente() {
		return advogadoCliente;
	}

	public void setAdvogadoCliente(Usuario advogadoCliente) {
		this.advogadoCliente = advogadoCliente;
	}

	public Usuario getAdvogadoParteContraria() {
		return advogadoParteContraria;
	}

	public void setAdvogadoParteContraria(Usuario advogadoParteContraria) {
		this.advogadoParteContraria = advogadoParteContraria;
	}

	public Usuario getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Usuario supervisor) {
		this.supervisor = supervisor;
	}

	public List<ParteContraria> getPartesContrarias() {
		return partesContrarias;
	}

	public void setPartesContrarias(List<ParteContraria> partesContrarias) {
		this.partesContrarias = partesContrarias;
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public LocalTramitacao getLocalTramitacao() {
		return localTramitacao;
	}

	public void setLocalTramitacao(LocalTramitacao localTramitacao) {
		this.localTramitacao = localTramitacao;
	}

	public String getVara() {
		return vara;
	}

	public void setVara(String vara) {
		this.vara = vara;
	}

	public BigDecimal getValorCausa() {
		return valorCausa;
	}

	public void setValorCausa(BigDecimal valorCausa) {
		this.valorCausa = valorCausa;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public SubArea getSubarea() {
		return subarea;
	}

	public void setSubarea(SubArea subarea) {
		this.subarea = subarea;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public Litisconsorcio getLitisAtivo() {
		return litisAtivo;
	}

	public void setLitisAtivo(Litisconsorcio litisAtivo) {
		this.litisAtivo = litisAtivo;
	}

	public Litisconsorcio getItisPassivo() {
		return itisPassivo;
	}

	public void setItisPassivo(Litisconsorcio itisPassivo) {
		this.itisPassivo = itisPassivo;
	}

	public GrauImportanciaEnum getGrauImportancia() {
		return grauImportancia;
	}

	public void setGrauImportancia(GrauImportanciaEnum grauImportancia) {
		this.grauImportancia = grauImportancia;
	}

	public StatusEnum getSituacaoProcesso() {
		return situacaoProcesso;
	}

	public void setSituacaoProcesso(StatusEnum situacaoProcesso) {
		this.situacaoProcesso = situacaoProcesso;
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

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Comarca getComarca() {
		return comarca;
	}

	public void setComarca(Comarca comarca) {
		this.comarca = comarca;
	}

	public DadosBancarios getDadosBancarios() {
		return dadosBancarios;
	}

	public void setDadosBancarios(DadosBancarios dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}

	public List<OutrosEnvolvidos> getOutrosEnvolvidos() {
		return outrosEnvolvidos;
	}

	public void setOutrosEnvolvidos(List<OutrosEnvolvidos> outrosEnvolvidos) {
		this.outrosEnvolvidos = outrosEnvolvidos;
	}

	public LocalDateTime getDataDistribuicao() {
		return dataDistribuicao;
	}

	public void setDataDistribuicao(LocalDateTime dataDistribuicao) {
		this.dataDistribuicao = dataDistribuicao;
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

	public Usuario getClienteFisico() {
		return clienteFisico;
	}

	public void setClienteFisico(Usuario clienteFisico) {
		this.clienteFisico = clienteFisico;
	}

	public Usuario getClienteJuridico() {
		return clienteJuridico;
	}

	public void setClienteJuridico(Usuario clienteJuridico) {
		this.clienteJuridico = clienteJuridico;
	}

	public Processo getProcessoMae() {
		return processoMae;
	}

	public void setProcessoMae(Processo processoMae) {
		this.processoMae = processoMae;
	}

}
