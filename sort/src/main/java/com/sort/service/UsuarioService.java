package com.sort.service;

import java.text.ParseException;
import java.util.Date;

import com.sort.form.UsuarioCadastroForm;
import com.sort.model.Usuario;



public interface UsuarioService {

	public Usuario findUsuarioByLogin(String login);

	public void saveUsuario(UsuarioCadastroForm usuarioCadastroForm);

	public Date toDateNascimento(String nascimento) throws ParseException;
}
