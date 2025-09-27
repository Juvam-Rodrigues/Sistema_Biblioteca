package br.edu.ufrn.lpii.sistema_biblioteca.usuarios;

public class Professor extends Usuario {

	@Override
	public int getPrazoDias() {
		return 14;
	}

	public Professor(String matricula, String nome, String curso) {
		setMatricula(matricula);
		setNome(nome);
		setCurso(curso);
	}
}
