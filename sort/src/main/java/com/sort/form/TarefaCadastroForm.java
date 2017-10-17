package com.sort.form;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author Alderian
 *
 */
public class TarefaCadastroForm {

	@NotBlank(message = "*Por favor! insira o [Nº da Tarefa]")
	private String numeroTarefa;

	/*
	 * @NotBlank(message = "*Por favor! insira o [Nº de Erros Encontrados]") private
	 * String qtdErros;
	 */

	private boolean erroCaminhoFeliz;

	@NotBlank(message = "*Por favor! insira um [Fluxo]")
	private String fluxo;

	private String inicioTeste;

	private String fimTeste;

	@NotBlank(message = "*Por favor! insira um [Módulo]")
	private String modulo;

	private String usuario;

	@NotBlank(message = "*Por favor! insira um [Status]")
	private String status;

	@NotBlank(message = "*Por favor! insira um [Tipo de Teste]")
	private String tipo;

	private String erroTipo;

	private String nome;

	private String observacaoTarefa;

	private String tarefaParentesco;

	private String deadLine;

	private int severidade1;

	private int severidade2;

	private int severidade3;

	private int severidade4;

	public TarefaCadastroForm() {

	}

	public String getNumeroTarefa() {
		return numeroTarefa;
	}

	public void setNumeroTarefa(String numeroTarefa) {
		this.numeroTarefa = numeroTarefa;
	}

	/*
	 * public String getQtdErros() { return qtdErros; }
	 * 
	 * public void setQtdErros(String qtdErros) { this.qtdErros = qtdErros; }
	 */
	public boolean isErroCaminhoFeliz() {
		return erroCaminhoFeliz;
	}

	public void setErroCaminhoFeliz(boolean erroCaminhoFeliz) {
		this.erroCaminhoFeliz = erroCaminhoFeliz;
	}

	public String getFluxo() {
		return fluxo;
	}

	public void setFluxo(String fluxo) {
		this.fluxo = fluxo;
	}

	public String getInicioTeste() {
		return inicioTeste;
	}

	public void setInicioTeste(String inicioTeste) {
		this.inicioTeste = inicioTeste;
	}

	public String getFimTeste() {
		return fimTeste;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFimTeste(String fimTeste) {
		this.fimTeste = fimTeste;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getErroTipo() {
		return erroTipo;
	}

	public void setErroTipo(String erroTipo) {
		this.erroTipo = erroTipo;
	}

	public String getObservacaoTarefa() {
		return observacaoTarefa;
	}

	public void setObservacaoTarefa(String observacaoTarefa) {
		this.observacaoTarefa = observacaoTarefa;
	}

	public String getTarefaParentesco() {
		return tarefaParentesco;
	}

	public void setTarefaParentesco(String tarefaParentesco) {
		this.tarefaParentesco = tarefaParentesco;
	}

	public String getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
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
