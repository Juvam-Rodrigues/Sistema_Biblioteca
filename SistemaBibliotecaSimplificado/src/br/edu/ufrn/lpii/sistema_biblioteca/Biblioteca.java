package br.edu.ufrn.lpii.sistema_biblioteca;

import java.util.ArrayList;

import java.util.List;

import br.edu.ufrn.lpii.sistema_biblioteca.livros.Livro;
import br.edu.ufrn.lpii.sistema_biblioteca.usuarios.Usuario;

public class Biblioteca {

	private List<Emprestimo> emprestimos;
	private List<Usuario> usuarios;
	private List<Livro> livros;

	public Biblioteca() {
		emprestimos = new ArrayList<>();
		usuarios = new ArrayList<>();
		livros = new ArrayList<>();
	}

	public void adicionarEmprestimo(Emprestimo objEmprestimo) {
		if (objEmprestimo.getObjLivro() != null && objEmprestimo.getObjLivro() != null) {
			emprestimos.add(objEmprestimo);
			System.out.println("Empréstimo cadastrado com sucesso!\n");

		}
	}

	
	public void adicionarUsuarios(Usuario objUsuario) {
		if (usuarios.contains(objUsuario)) {
			System.out.println("Usuário já cadastrado anteriormente...\n");
			return;
		} else {
			usuarios.add(objUsuario);
			System.out.println("Usuário cadastrado com sucesso!\n");
		}

	}

	public void adicionarLivros(Livro objLivro) {
		if (livros.contains(objLivro)) {
			System.out.println("Livro já cadastrado. Adicionando quantidade...");

			for (Livro l : livros) {
				if (l.equals(objLivro)) {
					l.setQuantidade(l.getQuantidade() + 1);
					break;
				}
			}
		} else {
			livros.add(objLivro);
			System.out.println("Livro adicionado com sucesso!\n");
		}
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario getUsuarioPorMatricula(String matricula) {
		for (Usuario usuario : this.getUsuarios()) {
			if (usuario.getMatricula().equalsIgnoreCase(matricula)) {
				return usuario;

			}
		}
		return null;
	}

	public Livro getLivroPorTitulo(String titulo) {
		for (Livro livro : this.getLivros()) {
			if (livro.getTitulo().equalsIgnoreCase(titulo)) {
				return livro;
			}
		}
		return null;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void imprimirEmprestimos() {

		for (Emprestimo emprestimo : this.getEmprestimos()) {
			emprestimo.imprimirEmprestimo();
		}
	}


	public void imprimirUsuarios() {

		for (Usuario usuario : this.getUsuarios()) {
			if(usuario != null) {
				usuario.imprimirUsuario();
			}
		}
	}

	public void imprimirLivros() {

		for (Livro livro : this.getLivros()) {
			if(livro != null) {
				livro.imprimirLivro();
			}
		}
	}


}
