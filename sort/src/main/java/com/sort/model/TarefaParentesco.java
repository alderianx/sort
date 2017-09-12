package com.sort.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TAREFA_PARENTESCO")
public class TarefaParentesco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tpa_id")
	private int id;

	@Column(name = "tpa_nome")
	private String nome;

	@Column(name = "tpa_descricao")
	private String descricao;
}
