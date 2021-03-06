package com.sort.controller;

/**@author Alderian**/

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sort.form.TarefaCadastroForm;
import com.sort.model.ErroTipo;
import com.sort.model.Fluxo;
import com.sort.model.Modulo;
import com.sort.model.Tarefa;
import com.sort.model.TarefaStatus;
import com.sort.model.TarefaTipo;
import com.sort.repository.ErroTipoRepository;
import com.sort.repository.FluxoRepository;
import com.sort.repository.ModuloRepository;
import com.sort.repository.StatusRepository;
import com.sort.repository.TarefaRepository;
import com.sort.repository.TarefaTipoRepository;
import com.sort.service.TarefaService;

@Controller
public class TarefaController extends SortAbstractController {

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

	@RequestMapping(value = { "/index", "/listarTarefa" }, method = RequestMethod.GET)
	public ModelAndView listarTarefas() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		carregarTestes(modelAndView);
		carregarUsuarioLogado(modelAndView);
		return modelAndView;
	}

	@RequestMapping(value = "/listarTarefaUsuario", method = RequestMethod.GET)
	public ModelAndView listarTarefasUsuario() {
		ModelAndView modelAndView = new ModelAndView("tarefa_listar");

		List<Tarefa> listaTarefaUsuario = tarefaRepository.tarefaByUsuario(getUsuarioLogado().getId());
		modelAndView.addObject("listarTarefasUsuario", listaTarefaUsuario);

		carregarUsuarioLogado(modelAndView);
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrarTarefa", method = RequestMethod.GET)
	public ModelAndView novaTarefa(TarefaCadastroForm tarefaCadastroForm) {
		Tarefa tarefa = new Tarefa();
		ModelAndView modelAndView = new ModelAndView("tarefa_cadastrar");

		Calendar cal = Calendar.getInstance();
		tarefa.setDataCriacao(cal.getTime());

		modelAndView.addObject("userNome", getUsuarioLogado().getNome().toUpperCase());

		List<TarefaTipo> listaTarefaTipo = tarefaTipoRepository.findAll();
		modelAndView.addObject("tarefaTipoLista", listaTarefaTipo);

		List<Modulo> listaModulo = moduloRepository.findAll();
		modelAndView.addObject("moduloLista", listaModulo);

		List<Fluxo> listaFluxo = fluxoRepository.findAll();
		modelAndView.addObject("fluxoLista", listaFluxo);

		List<TarefaStatus> listaStatus = statusRepository.findAll();
		modelAndView.addObject("statusLista", listaStatus);

		List<ErroTipo> listaErroTipo = erroTipoRepository.findAll();
		modelAndView.addObject("erroTipoLista", listaErroTipo);

		modelAndView.addObject("tarefaCadastroForm", tarefaCadastroForm);

		carregarUsuarioLogado(modelAndView);
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrarTarefa", method = RequestMethod.POST)
	public ModelAndView salvarTarefa(@Valid TarefaCadastroForm tarefaCadastroForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			return novaTarefa(tarefaCadastroForm);
		} else {
			tarefaService.saveTarefa(tarefaCadastroForm);
			modelAndView.addObject("tarefaCadastroForm", new TarefaCadastroForm());

		}
		modelAndView = new ModelAndView("redirect:/cadastrarTarefa");
		redirectAttributes.addFlashAttribute("successMessage", "Tarefa cadastrada com sucesso.");
		return modelAndView;
	}
	
	@RequestMapping(value = "/alterarTarefa", method = RequestMethod.POST)
	public ModelAndView alterarTarefa(@Valid TarefaCadastroForm tarefaCadastroForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			return novaTarefa(tarefaCadastroForm);
		} else {
			//tarefaRepository.getOne
			tarefaService.saveTarefa(tarefaCadastroForm);
			modelAndView.addObject("tarefaCadastroForm", new TarefaCadastroForm());

		}
		
		redirectAttributes.addFlashAttribute("successMessage", "status alterado com sucesso.");
		return modelAndView;
	}
	
	@RequestMapping(value = "/listarRankingTarefaUsuario", method = RequestMethod.GET)
	public ModelAndView listarRankingTarefasUsuario() {
		ModelAndView modelAndView = new ModelAndView("ranking");

		List<Tarefa> listaRankingTarefaUsuario = tarefaRepository.quantidadeTarefasByUsuario();// tarefaByUsuario(getUsuarioLogado().getId());
		modelAndView.addObject("listarRankingTarefasUsuario", listaRankingTarefaUsuario);

		carregarUsuarioLogado(modelAndView);
		return modelAndView;
	}

	

}
