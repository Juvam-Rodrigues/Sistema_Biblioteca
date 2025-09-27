package br.edu.ufrn.lpii.sistema_biblioteca.interface_texto;
public abstract class InterfaceTexto {

	public static void imprimirOpcoesMenuPrincipal() {
		System.out.println("Qual tipo de ação você deseja fazer? Opções:\n1 - Criar usuário"
				+ "\n2 - Cadastrar livro \n3 - Realizar empréstimo \n4 - Devolver empréstimo  \n5- Sair");
	}
	
	public static void imprimirOpcaoUsuario() {
		System.out.println("Qual tipo de usuário? Opções:\n1 - Estudante"
				+ "\n2 - Professor \n3 - Sair");
	}
	
	public static void imprimirFormatoInvalidoData() {
	    System.out.println("Formato inválido! Use dd/MM/yyyy. Tente novamente.\n");

	}
	
}
