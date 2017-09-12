package com.sort.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sort.form.UsuarioCadastroForm;
import com.sort.model.Usuario;
import com.sort.repository.UsuarioRepository;
import com.sort.repository.UsuarioTipoRepository;



@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioTipoRepository usuarioTipoRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Usuario findUsuarioByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}

	@Override
	public void saveUsuario(UsuarioCadastroForm usuarioCadastroForm) {
		Usuario usuario = new Usuario();
		try {
			usuario.setAtivo(1);
			usuario.setNome(usuarioCadastroForm.getNome());
			usuario.setEmail(usuarioCadastroForm.getEmail());
			usuario.setUsuarioTipo(
					usuarioTipoRepository.getOne(Integer.parseInt(usuarioCadastroForm.getUsuarioTipo())));
			usuario.setLogin(usuarioCadastroForm.getLogin());
			usuario.setSenha(bCryptPasswordEncoder.encode(usuarioCadastroForm.getSenha()));
			usuario.setTelefone(usuarioCadastroForm.getTelefone());
			usuario.setNascimento(toDateNascimento(usuarioCadastroForm.getNascimento()));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		usuarioRepository.saveAndFlush(usuario);

	}

	@Override
	public Date toDateNascimento(String nascimento) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(nascimento);
		return date;
	}

}
