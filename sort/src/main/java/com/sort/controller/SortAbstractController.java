package com.sort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.sort.model.Tarefa;
import com.sort.model.Usuario;
import com.sort.repository.TarefaRepository;
import com.sort.repository.UsuarioRepository;
import com.sort.service.TarefaService;
import com.sort.service.UsuarioService;

public class SortAbstractController {

	@Autowired
	protected UsuarioService usuarioService;

	@Autowired
	protected UsuarioRepository usuarioRepository;
	
	@Autowired
	protected TarefaRepository tarefaRepository;
	
	@Autowired
	protected TarefaService tarefaService;


	protected Usuario getUsuarioLogado() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario user = usuarioService.findUsuarioByLogin(auth.getName());
		return user;
	}

	public ModelAndView getHome() {
		ModelAndView modelAndView = new ModelAndView();
		List<Usuario> listaUsuarioTipo = usuarioRepository.findAll();
		modelAndView.addObject("listarUsuarios", listaUsuarioTipo);
		
		List<Tarefa> listaTarefaMes = tarefaRepository.tarefaByFimTeste();
		

		if (getUsuarioLogado() != null) {
			modelAndView.addObject("userTipo", getUsuarioLogado().getUsuarioTipo().getId());
			modelAndView.addObject("userName", "Bem vindo" + ", " + getUsuarioLogado().getNome().toUpperCase() + " ["
					+ getUsuarioLogado().getEmail() + "]" + " [" + getUsuarioLogado().getUsuarioTipo().getNome() + "]");
			modelAndView.addObject("adminMessage", "Acesso restrito apenas para usu�rios Administradores!");
			modelAndView.addObject("listarTarefasMes", listaTarefaMes);
		} else {
			modelAndView.addObject("userTipo", 4);
		}

		return modelAndView;
	}
	

}
