package br.ufrj.dcc.comp2.projeto.control;

import br.ufrj.dcc.comp2.projeto.view.Tela;

public class Main {
	static Tela tela = new Tela();
	
	public static void main(String[] args) {
		tela.constroiTelaInicial(tela);
	}

}
