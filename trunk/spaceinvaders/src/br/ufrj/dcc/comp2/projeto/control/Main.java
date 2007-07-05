package br.ufrj.dcc.comp2.projeto.control;

import br.ufrj.dcc.comp2.projeto.view.Tela;

/** 
 * Classe principal do jogo, na qual � instanciada uma nova tela do jogo.
 * @author Ar�as, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Main {
	
	/** Campo est�tico na qual uma nova tela de jogo � instanciada. */
	static Tela tela = new Tela();
	
	/** M�todo principal do jogo. */
	public static void main(String[] args) {
		tela.constroiTelaInicial(tela);
	}

}
