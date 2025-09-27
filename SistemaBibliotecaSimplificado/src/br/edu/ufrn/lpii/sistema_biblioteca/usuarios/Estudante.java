package br.edu.ufrn.lpii.sistema_biblioteca.usuarios;

public class Estudante extends Usuario {

	@Override
	public int getPrazoDias() {
		return 7;
	}

	public Estudante(String matricula, String nome, String curso) {
		setMatricula(matricula);
		setNome(nome);
		setCurso(curso);
	}

}
