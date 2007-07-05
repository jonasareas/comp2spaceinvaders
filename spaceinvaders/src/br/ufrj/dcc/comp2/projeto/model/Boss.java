package br.ufrj.dcc.comp2.projeto.model;

import br.ufrj.dcc.comp2.projeto.control.*;

/** 
 * Subclasse de alien respons�vel pelo �ltimo alien do jogo. 
 * @author Ar�as, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.3
*/
public class Boss extends Alien {
	
	/** Campo controlador do alien final. */
	public int life;

	/**
	 * @param x Posi��o referente ao eixo x na tela de jogo.
	 * @param y Posi��o referente ao eixo x na tela de jogo.
	 * @param regras Refer�ncia aos collections criados na classe ControleRegras.
	 */
	public Boss(int x, int y, ControleRegras regras) {
		super(x, y, regras);
		this.life = 50;
	}
}
