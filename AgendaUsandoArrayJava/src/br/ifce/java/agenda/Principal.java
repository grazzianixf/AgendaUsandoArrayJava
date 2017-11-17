package br.ifce.java.agenda;

import java.io.IOException;
import java.util.Scanner;

import br.ifce.java.agenda.controles.Agenda;
import br.ifce.java.agenda.entidades.Contato;

public class Principal {

	public static void main(String[] args) throws IOException {
		Agenda agenda = new Agenda();
		
        Scanner sc = new Scanner(System.in);
        
        int opcao = obterOpcao(sc);
        while(opcao != 0) {
        	processarOpcao(opcao, agenda, sc);
        	
        	opcao = obterOpcao(sc);
        }
	}
	
	private static int obterOpcao(Scanner sc) throws IOException {
		System.out.println();
		System.out.println();
		System.out.println("--- APLICAÇÃO AGENDA ---");
		System.out.println();
		System.out.println(" 1 - Listar Contatos");
		System.out.println(" 2 - Adicionar Contato");
		System.out.println(" 0 - SAIR ");
		System.out.println();
        System.out.print("Digite uma opção: ");
        
        return sc.nextInt();		
	}
	
	private static void processarOpcao(int opcao, Agenda agenda, Scanner sc) {
		System.out.println();
		
		if (opcao == 1) {
			listarContatos(agenda);
		} else if (opcao == 2) {
			adicionarContato(agenda, sc);
		} else if (opcao == 0) {
			System.out.println("Aplicação Agenda fechada.");
			System.exit(0);
		} else {
			System.out.println("Opção não identificada: " + opcao);
		}
	}

	private static void adicionarContato(Agenda agenda, Scanner sc) {
		System.out.print("Nome: ");
		String nome = sc.next();
		
		Contato contato = new Contato();
		contato.setNome(nome);
		
		agenda.adicionarContato(contato);
	}

	private static void listarContatos(Agenda agenda) {
		Contato[] contatos = agenda.getContatos();
		
		if (contatos == null) {
			System.out.println("Nenhum contato cadastrado!!!");
		} else {
			System.out.println("Contatos: ");
			for (int i = 0; i < contatos.length; i++) {
				System.out.println(contatos[i].getNome());
			}
		}
	}
}
