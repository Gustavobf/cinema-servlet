package br.com.batista.cinema.model;

public class Usuario {

	private Integer id;
	private String login;
	private String senha;

	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Nome: " + login + " Senha: " + senha;
	}

	public boolean equals(String login, String senha) {
		if (!this.login.equals(login)) {
			return false;
		}

		if (!this.senha.equals(senha)) {
			return false;
		}

		return true;
	}

}
