package br.com.batista.cinema.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	static List<Filme> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	static Integer idFilme = 1;

	static {
		Filme filme = new Filme("Avengers", 8.5, 2018);
		filme.setId(idFilme++);
		lista.add(filme);
		Filme filme2 = new Filme("Iron Man", 7.9, 2016);
		filme2.setId(idFilme++);
		lista.add(filme2);

		Usuario u = new Usuario();
		u.setLogin("gustavo");
		u.setSenha("1");
		listaUsuarios.add(u);
		Usuario u2 = new Usuario();
		u2.setLogin("ana");
		u2.setSenha("12345");
		listaUsuarios.add(u2);
	}

	public void adiciona(Filme filme) {
		filme.setId(idFilme++);
		lista.add(filme);
	}

	public void exclue(Integer id) {
		Filme filme = buscarPeloId(id);
		lista.remove(filme);
	}

	public Filme buscarPeloId(Integer id) {
		for (Filme filme : lista) {
			if (id == filme.getId()) {
				return filme;
			}
		}
		return null;
	}

	public List<Filme> getAll() {
		return lista;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
