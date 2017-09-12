package com.sort.model;
/***@author Alderian**/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TAREFA_TIPO")
public class TarefaTipo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ttp_id")
	private int id;

	@Column(name = "ttp_nome")
	private String nome;

	@Column(name = "ttp_descricao")
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
