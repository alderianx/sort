package com.sort.controller;

/**@author Alderian**/
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sort.form.UsuarioCadastroForm;
import com.sort.model.Usuario;
import com.sort.model.UsuarioTipo;
import com.sort.repository.UsuarioTipoRepository;
import com.sort.service.UsuarioService;



@Controller
public class UsuarioController extends SortAbstractController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioTipoRepository usuarioTipoRepository;
	
	@RequestMapping(value = "/listarUsuario", method = RequestMethod.GET)
	public ModelAndView listarUsuario() {
		ModelAndView modelAndView = new ModelAndView("usuario_listar");
		
		List<Usuario> listaUsuario = usuarioRepository.findAll();
		modelAndView.addObject("listarUsuarios", listaUsuario);
		
		modelAndView.addObject("userTipo", getUsuarioLogado().getUsuarioTipo().getId());
		modelAndView.addObject("userName", "Bem vindo" + ", " + getUsuarioLogado().getNome().toUpperCase() + " ["
				+ getUsuarioLogado().getEmail() + "]" + " [" + getUsuarioLogado().getUsuarioTipo().getNome() + "]");
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.GET)
	public ModelAndView novoUsuario(UsuarioCadastroForm usuarioCadastroForm) {
		ModelAndView modelAndView = new ModelAndView("usuario_cadastrar");
		
		List<UsuarioTipo> listaUsuarioTipo = usuarioTipoRepository.findAll();
		modelAndView.addObject("usuarioTipoLista", listaUsuarioTipo);
		modelAndView.addObject("userTipo", getUsuarioLogado().getUsuarioTipo().getId());
		modelAndView.addObject("usuarioCadastroForm", usuarioCadastroForm);
		
		modelAndView.addObject("userTipo", getUsuarioLogado().getUsuarioTipo().getId());
		modelAndView.addObject("userName", "Bem vindo" + ", " + getUsuarioLogado().getNome().toUpperCase() + " ["
				+ getUsuarioLogado().getEmail() + "]" + " [" + getUsuarioLogado().getUsuarioTipo().getNome() + "]");
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid UsuarioCadastroForm usuarioCadastroForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		Usuario userExists = usuarioService.findUsuarioByLogin(usuarioCadastroForm.getLogin());

		if (userExists != null) {
			bindingResult.rejectValue("login", "error.user", "Já existe um usuário cadastrado com esse login");
		}
		if (bindingResult.hasErrors()) {
			return novoUsuario(usuarioCadastroForm);
		} else {
			usuarioService.saveUsuario(usuarioCadastroForm);
			modelAndView.addObject("usuarioCadastroForm", new UsuarioCadastroForm());
			
		}
		modelAndView = new ModelAndView("redirect:/cadastrarUsuario");
		redirectAttributes.addFlashAttribute("successMessage", "Usuário cadastrado com sucesso.");
		return modelAndView;
	}

}
