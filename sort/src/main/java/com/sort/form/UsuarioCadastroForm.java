package com.sort.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class UsuarioCadastroForm {

	private String tipo;

	@NotBlank(message = "*Por favor! insira um [Nome]")
	private String nome;

	@Email(message = "*Por favor! insira um [e-mail] válido")
	@NotBlank(message = "*Por favor! insira um [E-mail]")
	private String email;

	@NotBlank(message = "*Por favor! insira um [Telefone] válido")
	private String telefone;

	@NotBlank(message = "*Por favor! insira um [Login]")
	private String login;

	@NotBlank(message = "*Por favor! insira uma [Senha]")
	private String senha;

	@NotBlank(message = "*Por favor! insira uma [Confirmação de Senha]")
	private String confirmaSenha;

	@NotBlank(message = "*Por favor! insira uma data de [Nascimento] válida")
	private String nascimento;

	@NotBlank(message = "*Por favor! insira um [Tipo de usuário]")
	private String usuarioTipo;

	public UsuarioCadastroForm() {

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getUsuarioTipo() {
		return usuarioTipo;
	}

	public void setUsuarioTipo(String usuarioTipo) {
		this.usuarioTipo = usuarioTipo;
	}

}
