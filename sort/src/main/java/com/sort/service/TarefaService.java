package com.sort.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.sort.form.TarefaCadastroForm;
import com.sort.model.Tarefa;



public interface TarefaService {

	public void saveTarefa(TarefaCadastroForm tarefaCadastroForm);

	public Date toDate(String dateConvert) throws ParseException;

	public List<Tarefa> findAllTarefa();
}
