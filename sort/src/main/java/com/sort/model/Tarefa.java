package com.sort.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TAREFA")
public class Tarefa implements Serializable {

	/**
	 * @author Alderian
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tar_id")
	private Long id;

	@Column(name = "tar_qtd_erros")
	private int qtdErros;

	@Column(name = "tar_sev_1")
	private int severidade1 = 0;

	@Column(name = "tar_sev_2")
	private int severidade2 = 0;

	@Column(name = "tar_sev_3")
	private int severidade3 = 0;

	@Column(name = "tar_sev_4")
	private int severidade4 = 0;

	@Column(name = "tar_erroCaminhoFeliz")
	private boolean erroCaminhoFeliz;

	@Column(name = "tar_num_tarefa")
	private Long numeroTarefa;

	@Column(name = "tar_num_tarefa_pai")
	private Long numeroTarefaPai;

	@ManyToOne
	@JoinColumn(name = "flu_id")
	private Fluxo fluxo;

	@Column(name = "tar_data_criacao")
	private Date dataCriacao;

	@Column(name = "tar_deadline")
	private Date deadLine;

	@Column(name = "tar_data_inicio_tarefa")
	private Date inicioTeste;

	@Column(name = "tar_data_fim_tarefa")
	private Date fimTeste;

	@Column(name = "tar_descricao")
	private String descricao;

	@Column(name = "tar_observacao")
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "mod_id")
	private Modulo modulo;

	@ManyToOne
	@JoinColumn(name = "usu_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "tst_id")
	private TarefaStatus status;

	@ManyToOne
	@JoinColumn(name = "ttp_id")
	private TarefaTipo tipo;

	@ManyToOne
	@JoinColumn(name = "etp_id")
	private ErroTipo erroTipo;

	@ManyToOne
	@JoinColumn(name = "tpa_id")
	private TarefaParentesco tarefaParentesco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQtdErros() {
		return qtdErros;
	}

	public void setQtdErros(int qtdErros) {
		this.qtdErros = qtdErros;
	}

	public boolean isErroCaminhoFeliz() {
		return erroCaminhoFeliz;
	}

	public void setErroCaminhoFeliz(boolean erroCaminhoFeliz) {
		this.erroCaminhoFeliz = erroCaminhoFeliz;
	}

	public Long getNumeroTarefa() {
		return numeroTarefa;
	}

	public void setNumeroTarefa(Long numeroTarefa) {
		this.numeroTarefa = numeroTarefa;
	}

	public Fluxo getFluxo() {
		return fluxo;
	}

	public void setFluxo(Fluxo fluxo) {
		this.fluxo = fluxo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getInicioTeste() {
		return inicioTeste;
	}

	public void setInicioTeste(Date inicioTeste) {
		this.inicioTeste = inicioTeste;
	}

	public Date getFimTeste() {
		return fimTeste;
	}

	public void setFimTeste(Date fimTeste) {
		this.fimTeste = fimTeste;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TarefaStatus getStatus() {
		return status;
	}

	public void setStatus(TarefaStatus status) {
		this.status = status;
	}

	public TarefaTipo getTipo() {
		return tipo;
	}

	public void setTipo(TarefaTipo tipo) {
		this.tipo = tipo;
	}

	public ErroTipo getErroTipo() {
		return erroTipo;
	}

	public void setErroTipo(ErroTipo erroTipo) {
		this.erroTipo = erroTipo;
	}

	public TarefaParentesco getTarefaParentesco() {
		return tarefaParentesco;
	}

	public void setTarefaParentesco(TarefaParentesco tarefaParentesco) {
		this.tarefaParentesco = tarefaParentesco;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public Long getNumeroTarefaPai() {
		return numeroTarefaPai;
	}

	public void setNumeroTarefaPai(Long numeroTarefaPai) {
		this.numeroTarefaPai = numeroTarefaPai;
	}

	public int getSeveridade1() {
		return severidade1;
	}

	public void setSeveridade1(int severidade1) {
		this.severidade1 = severidade1;
	}

	public int getSeveridade2() {
		return severidade2;
	}

	public void setSeveridade2(int severidade2) {
		this.severidade2 = severidade2;
	}

	public int getSeveridade3() {
		return severidade3;
	}

	public void setSeveridade3(int severidade3) {
		this.severidade3 = severidade3;
	}

	public int getSeveridade4() {
		return severidade4;
	}

	public void setSeveridade4(int severidade4) {
		this.severidade4 = severidade4;
	}

}
