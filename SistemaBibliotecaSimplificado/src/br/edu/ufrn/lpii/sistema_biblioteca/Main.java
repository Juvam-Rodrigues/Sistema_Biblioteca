package br.edu.ufrn.lpii.sistema_biblioteca;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.edu.ufrn.lpii.sistema_biblioteca.interface_texto.InterfaceTexto;
import br.edu.ufrn.lpii.sistema_biblioteca.livros.Livro;
import br.edu.ufrn.lpii.sistema_biblioteca.usuarios.Estudante;
import br.edu.ufrn.lpii.sistema_biblioteca.usuarios.Professor;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int respostaOpcoesMenuPrincipal = 0;
		Biblioteca objBiblioteca = new Biblioteca(); // Classe com todos os registros

		int id = 0;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		while (true) {
			InterfaceTexto.imprimirOpcoesMenuPrincipal();
			respostaOpcoesMenuPrincipal = scanner.nextInt();
			scanner.nextLine(); // Limpa o scanner depois do nextInt

			switch (respostaOpcoesMenuPrincipal) {

			case 1: // Cadastro de usuário
				System.out.println();
				InterfaceTexto.imprimirOpcaoUsuario();
				int respostaOpcoes = scanner.nextInt();
				scanner.nextLine(); // Limpa o scanner após nextInt

				if (respostaOpcoes == 1) { // Estudante
					System.out.println();
					System.out.println("Digite o nome: ");
					String nome = scanner.nextLine();
					System.out.println("Digite o curso: ");
					String curso = scanner.nextLine();
					System.out.println("Digite a matrícula: ");
					String matricula = scanner.nextLine();

					Estudante estudante = new Estudante(matricula, nome, curso);
					objBiblioteca.adicionarUsuarios(estudante);

				} else if (respostaOpcoes == 2) { // Professor
					System.out.println();
					System.out.println("Digite o nome: ");
					String nome = scanner.nextLine();
					System.out.println("Digite o curso: ");
					String curso = scanner.nextLine();
					System.out.println("Digite a matrícula: ");
					String matricula = scanner.nextLine();

					Professor professor = new Professor(matricula, nome, curso);
					objBiblioteca.adicionarUsuarios(professor);

				} else if (respostaOpcoes == 3) { // Voltar
					break;
				} else {
					System.out.println("Opção inválida.\n");
					break;
				}
				break;

			case 2: // Cadastro de livro
				System.out.println();
				System.out.println("Digite o título do livro: ");
				String titulo = scanner.nextLine();
				System.out.println("Digite o autor do livro: ");
				String autor = scanner.nextLine();
				System.out.println("Digite o ano do livro: ");
				int ano = scanner.nextInt();
				scanner.nextLine(); // Limpa buffer após nextInt
				System.out.println("Digite a quantidade do livro: ");
				int quantidade = scanner.nextInt();
				scanner.nextLine(); // Limpa buffer após nextInt

				Livro livro = new Livro(titulo, autor, ano, quantidade);
				if(livro.getTitulo() != null) {
					objBiblioteca.adicionarLivros(livro);
					break;
				}
				else {
					break;
				}
				
			case 3: // Realizar empréstimo
				
				//Verifica se tem usuários e livros cadastrados
				if (objBiblioteca.getLivros().isEmpty()) {
					System.out.println("Não há livros cadastrados.\n");
					break;
				}if (objBiblioteca.getUsuarios().isEmpty()) {
					System.out.println("Não há usuários cadastrados.\n");
					break;
				}

				//Tem alundos e livros, podemos realizar empréstimos
				System.out.println();
				objBiblioteca.imprimirUsuarios();
				System.out.println("Qual a matrícula do usuário:");
				String matricula = scanner.nextLine();
				if (objBiblioteca.getUsuarioPorMatricula(matricula) == null) {
					System.out.println("Usuário não encontrado!\n");
					break;
				}

				objBiblioteca.imprimirLivros();
				System.out.println("Qual o título do livro:");
				String tituloLivro = scanner.nextLine();
				Livro l = objBiblioteca.getLivroPorTitulo(tituloLivro);
				
				//Verifica se pode emprestar o livro
				if (l == null) {
					System.out.println("Livro não encontrado!\n");
					break;
				}
				if (l.getQuantidade() <= 0) {
					System.out.println("Livro indisponível!\n");
					break;
				}

				System.out.println("Qual a data atual (dd/MM/yyyy):");
				String dataAtual = scanner.nextLine();

				LocalDate dataEmprestimo;
				LocalDate dataPrevista;

				try {
					dataEmprestimo = LocalDate.parse(dataAtual, formatter);
					dataPrevista = dataEmprestimo
							.plusDays(objBiblioteca.getUsuarioPorMatricula(matricula).getPrazoDias());
				} catch (Exception e) {
					InterfaceTexto.imprimirFormatoInvalidoData();
					break;
				}

				//Adiciona o emprestimo de fato
				id++;
				Emprestimo emprestimo = new Emprestimo(objBiblioteca.getUsuarioPorMatricula(matricula), l, id,
						dataEmprestimo.format(formatter), dataPrevista.format(formatter));

				objBiblioteca.adicionarEmprestimo(emprestimo);
				break;

			case 4: // Devolver livro
				//Verifica se existe emprestimos
				if (objBiblioteca.getEmprestimos().isEmpty()) {
					System.out.println("Nenhum empréstimo realizado.\n");
					break;
				}

				System.out.println();
				System.out.println("Empréstimos em andamento:");
				objBiblioteca.imprimirEmprestimos();

				System.out.println("Digite o ID do empréstimo que será devolvido:");
				int idQueSeraDevolvido = scanner.nextInt();
				scanner.nextLine(); // Limpa buffer após nextInt

				if (idQueSeraDevolvido > objBiblioteca.getEmprestimos().size()) { //Tratamento para não pegar um id maior que o tamanho da lista
					System.out.println("ID inválido.\n");
					break;
				}
				
				Emprestimo emprestimoDevolver = objBiblioteca.getEmprestimos().get(idQueSeraDevolvido - 1);
				if (emprestimoDevolver == null) {
					System.out.println("Empréstimo inválido.\n");
					break;
				}

				// Atualiza estoque
				if(emprestimoDevolver.getDataDevolucao().equalsIgnoreCase("")) { //Ele já não foi devolvido antes, logo pode ser devolvido
					System.out.println("Qual a data da devolução (dd/MM/yyyy):");
					String dataDevolucaoStr = scanner.nextLine();
					try {
					    LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoStr, formatter);
					    emprestimoDevolver.setDataDevolucao(dataDevolucao.format(formatter));
					} catch (Exception e) {
						InterfaceTexto.imprimirFormatoInvalidoData();
						break; // sai do case 4 se a data for inválida
					}
					objBiblioteca.devolverLivro(emprestimoDevolver.getObjLivro());
					System.out.println("Livro devolvido com sucesso!\n");
					break;
				}
				else {
					System.out.println("Empréstimo já foi devolvido antes...\n");
					break;
				}
				
			case 5:
				System.out.println("Saindo...");
				return;

			default:
				System.out.println("Opção inválida.\n");
			}
		}
	}
}
