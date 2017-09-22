package com.sort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sort.model.Tarefa;
import com.sort.repository.ErroTipoRepository;
import com.sort.repository.FluxoRepository;
import com.sort.repository.ModuloRepository;
import com.sort.repository.StatusRepository;
import com.sort.repository.TarefaRepository;
import com.sort.repository.TarefaTipoRepository;
import com.sort.service.TarefaService;

@Controller
public class GraficoDesempenhoController extends SortAbstractController {
	@Autowired
	private TarefaService tarefaService;

	@Autowired
	private TarefaRepository tarefaRepository;

	@Autowired
	private TarefaTipoRepository tarefaTipoRepository;

	@Autowired
	private ModuloRepository moduloRepository;

	@Autowired
	private FluxoRepository fluxoRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private ErroTipoRepository erroTipoRepository;

	@RequestMapping(value = "/desempenhoTarefa", method = RequestMethod.GET)
	public ModelAndView desempenhoTarefas() {
		ModelAndView modelAndView = new ModelAndView("graficoDesempenho");
		List<Tarefa> listaTarefaMes = tarefaRepository.tarefaByFimTeste();
		modelAndView.addObject("listarTarefasMes", listaTarefaMes);

		List<Tarefa> listaTarefa = tarefaService.findAllTarefa();
		modelAndView.addObject("listarTarefas", listaTarefa);

		modelAndView.addObject("userTipo", getUsuarioLogado().getUsuarioTipo().getId());
		modelAndView.addObject("userName", "Bem vindo" + ", " + getUsuarioLogado().getNome().toUpperCase() + " ["
				+ getUsuarioLogado().getEmail() + "]" + " [" + getUsuarioLogado().getUsuarioTipo().getNome() + "]");
		return modelAndView;
	}

}
