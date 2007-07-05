package br.ufrj.dcc.comp2.projeto.control;

import br.ufrj.dcc.comp2.projeto.view.Tela;

/** 
 * Classe principal do jogo, na qual é instanciada uma nova tela do jogo.
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Main {
	
	/** Campo estático na qual uma nova tela de jogo é instanciada. */
	static Tela tela = new Tela();
	
	/** Método principal do jogo. */
	public static void main(String[] args) {
		tela.constroiTelaInicial(tela);
	}

}
