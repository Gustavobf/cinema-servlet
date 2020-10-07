package br.com.batista.cinema.model;

public class Filme {
	private Integer id;
	private String nome;
	private Double nota;
	private Integer ano;

	public Filme(String nome, Double nota, Integer ano) {
		this.nome = nome;
		this.nota = nota;
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "NomeFilme: " + nome + " NotaFilme: " + nota + " AnoFilme: " + ano;
	}

}
