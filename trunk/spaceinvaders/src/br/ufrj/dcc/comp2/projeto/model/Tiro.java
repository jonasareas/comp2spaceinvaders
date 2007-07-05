package br.ufrj.dcc.comp2.projeto.model;

/** 
 * Subclasse de Sprite respons�vel pelos tiros do jogo.
 * @author Ar�as, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Tiro extends Sprite {
	
	/**
	 * @param x Posi��o referente ao eixo x na tela de jogo.
	 * @param y Posi��o referente ao eixo x na tela de jogo.
	 */
	public Tiro(int x, int y) {
		super("./imagens/Tiro.png");
		this.x = x - this.getImagem().getWidth(null)/2;
		this.y = y - this.getImagem().getHeight(null);
	}

	/**
	 * M�todo booleano para saber at� quando o tiro pode aparecer na tela e decrementa sua
	 * posi��o em rela��o ao eixo "y" o quanto for poss�vel.
	 * @return true Se a posi��o do tiro � v�lida
	 * @return false Caso o tiro j� esteja fora dos limites da tela.
	 */
	public boolean goUp() {
		this.y -= 1;
		if (this.y == 0 - this.getImagem().getHeight(null))
			return false;
		else
			return true;
	}

}
