package com.sort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sort.model.Tarefa;
import com.sort.repository.TarefaRepository;
import com.sort.service.TarefaService;

@Controller
public class GraficoDesempenhoController extends SortAbstractController {
	@Autowired
	private TarefaService tarefaService;

	@Autowired
	private TarefaRepository tarefaRepository;

	@RequestMapping(value = "/desempenhoTarefa", method = RequestMethod.GET)
	public ModelAndView desempenhoTarefas() {
		ModelAndView modelAndView = new ModelAndView("graficoDesempenho");
		List<Tarefa> listaTarefaMes = tarefaRepository.tarefaByFimTeste();
		modelAndView.addObject("listarTarefasMes", listaTarefaMes);

		List<Tarefa> listaTarefa = tarefaService.findAllTarefa();
		modelAndView.addObject("listarTarefas", listaTarefa);

		carregarUsuarioLogado(modelAndView);
		return modelAndView;
	}

}