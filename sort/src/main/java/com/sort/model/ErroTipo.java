package com.sort.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ERRO_TIPO")
public class ErroTipo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "etp_id")
	private int id;
	
	@Column(name = "etp_nome")
	private String nome;
	
	@Column(name = "etp_descricao")
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
	
	
}
