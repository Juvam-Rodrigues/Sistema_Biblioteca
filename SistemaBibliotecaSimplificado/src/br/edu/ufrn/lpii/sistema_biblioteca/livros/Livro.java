package br.edu.ufrn.lpii.sistema_biblioteca.livros;

public class Livro {
	private String titulo, autor;
	private int ano, quantidade;

	public Livro() {

	}

	public Livro(String titulo, String autor, int ano, int quantidade) {
		this.titulo = titulo;
		this.autor = autor;
		this.quantidade = quantidade;
		this.ano = ano;

	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean equals(Object obj) {
		
		Livro outro = (Livro) obj;

		if (this.getAno() == outro.getAno() && this.getAutor().equalsIgnoreCase(outro.getAutor())
				&& this.getTitulo().equalsIgnoreCase(outro.getTitulo())) {

			return true;
		} else {
			return false;
		}
	}
	
	public void imprimirLivro() {
		System.out.println(this.titulo +" - "+ this.autor + " - " + this.quantidade + " unidades disponíveis");
	}
}
