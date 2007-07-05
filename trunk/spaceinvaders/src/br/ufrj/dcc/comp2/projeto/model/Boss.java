package br.ufrj.dcc.comp2.projeto.model;

import br.ufrj.dcc.comp2.projeto.control.*;

/** 
 * Subclasse de alien responsável pelo último alien do jogo. 
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.3
*/
public class Boss extends Alien {
	
	/** Campo controlador do alien final. */
	public int life;

	/**
	 * @param x Posição referente ao eixo x na tela de jogo.
	 * @param y Posição referente ao eixo x na tela de jogo.
	 * @param regras Referência aos collections criados na classe ControleRegras.
	 */
	public Boss(int x, int y, ControleRegras regras) {
		super(x, y, regras);
		this.life = 50;
	}
}
