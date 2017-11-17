package br.ifce.java.agenda.controles;

import br.ifce.java.agenda.entidades.Contato;

public class Agenda {
	private Contato[] contatos;

	public Contato[] getContatos() {
		return contatos;
	}

	public void adicionarContato(Contato contato) {
		if (contatos == null) {
			contatos = new Contato[1];
			
			contatos[0] = contato;
		} else {
			contatos = ajustarArrayParaInclusao(contatos);
			
			int qtdAtualDeContatos = contatos.length;
			
			contatos[qtdAtualDeContatos - 1] = contato;
		}
	}

	private Contato[] ajustarArrayParaInclusao(Contato[] contatos) {
		int qtdContatos = contatos.length;
		
		Contato[] novoContatos = new Contato[qtdContatos + 1];
		
		for (int i = 0; i < qtdContatos; i++) {
			novoContatos[i] = contatos[i];
		}
		
		return novoContatos;
	}
}
