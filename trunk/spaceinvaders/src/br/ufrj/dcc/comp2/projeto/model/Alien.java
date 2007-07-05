package br.ufrj.dcc.comp2.projeto.model;

import br.ufrj.dcc.comp2.projeto.control.*;

/** 
 * Subclasse de ExplodedSprite responsável pelos aliens do jogo.
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Alien extends ExplodedSprite {
	
	/**
	 * @param x Posição referente ao eixo x na tela de jogo.
	 * @param y Posição referente ao eixo x na tela de jogo.
	 * @param regras Referência aos collections criados na classe ControleRegras.
	 */
	public Alien(int x, int y, ControleRegras regras) {
		super("imagens/Alien.gif");
		this.x = x;
		this.y = y-this.getImagem().getHeight(null);
	}

	/**
	 * Método booleano para saber se o alien pode aparecer na tela e incrementar sua posição
	 * em relação ao eixo "y" se for possível.
	 * @return true Se a posição do alien é válida
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