package br.edu.ufrn.lpii.sistema_biblioteca;

import br.edu.ufrn.lpii.sistema_biblioteca.livros.Livro;
import br.edu.ufrn.lpii.sistema_biblioteca.usuarios.Usuario;

public class Emprestimo {
	private Usuario objUsuario;
	private Livro objLivro;
	private int id;
	private String dataEmprestimo, dataPrevista, dataDevolucao;

	public Emprestimo() {

	}

	public Emprestimo(Usuario objUsuario, Livro objLivro, int id, String dataEmprestimo, String dataPrevista) {

		if (objLivro.getQuantidade() <= 0) {
			System.out.println("Quantidade do livro '" + objLivro.getTitulo() + "' insuficiente.\n");
			return;
		} else {
			objLivro.setQuantidade(objLivro.getQuantidade() - 1);

			this.objUsuario = objUsuario;
			this.objLivro = objLivro;
			this.id = id;
			this.dataEmprestimo = dataEmprestimo;
			this.dataPrevista = dataPrevista;
			this.dataDevolucao = ""; //Não foi entregue ainda
		}
	}

	public Usuario getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}

	public Livro getObjLivro() {
		return objLivro;
	}

	public void setObjLivro(Livro objLivro) {
		this.objLivro = objLivro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(String dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public void imprimirEmprestimo() {
		 // Dados do usuário
	    System.out.println("ID do empréstimo: " + this.getId());

	    System.out.println("Nome: " + this.getObjUsuario().getNome());
	    System.out.println("Matrícula: " + this.getObjUsuario().getMatricula());
	    System.out.println("Curso: " + this.getObjUsuario().getCurso());

	    // Dados do livro
	    System.out.println("Título: " + this.getObjLivro().getTitulo());
	    System.out.println("Autor: " +  this.getObjLivro().getAutor());
	    System.out.println("Ano: " + this.getObjLivro().getAno());

	    // Datas
	    System.out.println("Data do Empréstimo: " + this.getDataEmprestimo());
	    System.out.println("Data Prevista de Devolução: " + this.getDataPrevista());
	    System.out.println("Data de Devolução: " + this.getDataDevolucao());

	    System.out.println(); // linha em branco entre empréstimos
	}
}
