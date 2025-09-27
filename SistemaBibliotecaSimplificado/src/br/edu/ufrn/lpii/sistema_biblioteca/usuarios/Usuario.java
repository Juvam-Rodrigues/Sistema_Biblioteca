package br.edu.ufrn.lpii.sistema_biblioteca.usuarios;

public abstract class Usuario {
	private String matricula, nome, curso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean equals(Object obj) {

		Usuario outro = (Usuario) obj;
		
		if (this.getNome().equalsIgnoreCase(outro.getNome()) && this.getCurso().equalsIgnoreCase(outro.getCurso())
				&& this.getMatricula().equalsIgnoreCase(outro.getMatricula())) {

			return true;
		} else {
			return false;
		}
	}
	
	public void imprimirUsuario() {
		System.out.println("Matricula: " + this.matricula +" - Nome: "+ this.nome);
	}
	public abstract int getPrazoDias();
}