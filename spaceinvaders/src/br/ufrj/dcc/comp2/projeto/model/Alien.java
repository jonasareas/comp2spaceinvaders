package br.ufrj.dcc.comp2.projeto.model;

import br.ufrj.dcc.comp2.projeto.control.*;

/** 
 * Subclasse de ExplodedSprite respons�vel pelos aliens do jogo.
 * @author Ar�as, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Alien extends ExplodedSprite {
	
	/**
	 * @param x Posi��o referente ao eixo x na tela de jogo.
	 * @param y Posi��o referente ao eixo x na tela de jogo.
	 * @param regras Refer�ncia aos collections criados na classe ControleRegras.
	 */
	public Alien(int x, int y, ControleRegras regras) {
		super("imagens/Alien.gif");
		this.x = x;
		this.y = y-this.getImagem().getHeight(null);
	}

	/**
	 * M�todo booleano para saber se o alien pode aparecer na tela e incrementar sua posi��o
	 * em rela��o ao eixo "y" se for poss�vel.
	 * @return true Se a posi��o do alien � v�lida
	 * @return false Caso o alien esteja fora dos limites da tela.
	 */
	public boolean goDown() {
		this.y += 1;
		if (this.y == 600 + this.getImagem().getHeight(null))
			return false;
		else
			return true;
	}

}