package br.ufrj.dcc.comp2.projeto.model;

/** 
 * Subclasse de Sprite responsável pelos tiros do jogo.
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Tiro extends Sprite {
	
	/**
	 * @param x Posição referente ao eixo x na tela de jogo.
	 * @param y Posição referente ao eixo x na tela de jogo.
	 */
	public Tiro(int x, int y) {
		super("./imagens/Tiro.png");
		this.x = x - this.getImagem().getWidth(null)/2;
		this.y = y - this.getImagem().getHeight(null);
	}

	/**
	 * Método booleano para saber até quando o tiro pode aparecer na tela e decrementa sua
	 * posição em relação ao eixo "y" o quanto for possível.
	 * @return true Se a posição do tiro é válida
	 * @return false Caso o tiro já esteja fora dos limites da tela.
	 */
	public boolean goUp() {
		this.y -= 1;
		if (this.y == 0 - this.getImagem().getHeight(null))
			return false;
		else
			return true;
	}

}
