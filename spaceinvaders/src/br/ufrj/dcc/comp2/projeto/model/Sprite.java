package br.ufrj.dcc.comp2.projeto.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/** 
 * Classe abstrata responsável pela inicialização das principais componentes do jogo.
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
abstract class Sprite {
	
	/** Campo armazenador da posição em relação ao eixo "x" da tela. */
	protected int x;
	
	/** Campo armazenador da posição em relação ao eixo "y" da tela. */
	protected int y;
	
	/** Campo para referência ao tipo Image. */
	protected Image imagem;
	
	/** Campo que contêm a referência ao nome do arquivo. */
	protected String file;

	/**
	 * @param nomeArq Nome do arquivo que contêm a imagem a ser carregada.
	 * @throws IOException
	 */
	public Sprite(String nomeArq) {
		this.file = nomeArq;

		try {
			imagem = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que retorna a posição em relação ao eixo "x" da tela.
	 * @return Um inteiro contendo o valor da posição do objeto em relação ao eixo "x".
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Método responsável por atribuir uma nova posição ao objeto em relação ao eixo "x".
	 * @param posicaonova Um inteiro contendo o valor da nova posição do objeto em relação
	 * ao eixo "x".  
	 */
	public void setX(int posicaonova) {
		this.x = posicaonova;
	}

	/**
	 * Método que retorna a posição em relação ao eixo "y" da tela.
	 * @return Um inteiro contendo o valor do objeto em relação ao eixo "y".
	 */
	public int getY() {
		return y;
	}

	/**
	 * Método responsável por atribuir uma nova posição ao objeto em relação ao eixo "y".
	 * @param posicaonova Um inteiro contendo o valor da nova posição do objeto em relação
	 * ao eixo "y".  
	 */
	public void setY(int posicaonova) {
		this.y = posicaonova;
	}

	/**
	 * Método responsável pela referência ao nome da imagem carregada.
	 * @return Atributo Imagem
	 */
	public Image getImagem() {
		return this.imagem;
	}
	
	/**
	 * Método responsável pela referência ao nome da nova imagem a ser carregada.
	 * @return Atributo Imagem
	 */
	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	// Comparação de posição dos objetos a se colidir.
	/**
	 * Método comparador de colisão entre os objetos na tela.
	 * @return true Se os objetos colidirem.
	 */
	public boolean equals(Object o) {
		Sprite obj = (Sprite) o;

		if( (this.menorY() >= obj.menorY() && this.menorY() <= obj.maiorY()) || (this.maiorY() >= obj.menorY() && this.maiorY() <= obj.maiorY()) ) {
			if( (this.menorX() >= obj.menorX() && this.menorX() <= obj.maiorX()) || (this.maiorX() >= obj.menorX() && this.maiorX() <= obj.maiorX()) ) {
				return true;
			}

			if( this.getImagem().getWidth(null) > obj.getImagem().getWidth(null)) {
				if (obj.menorX() >= this.menorX() && obj.menorX() <= this.maiorX() && obj.maiorX() >= this.menorX() && obj.maiorX() <= this.maiorX()) {
					return true;
				}
			}
		}

		return false;

	}

	/**
	 * Método responsável por retornar a maior posição legal da tela em relação ao eixo "x".
	 * @return Inteiro contendo uma referência ao valor de maior posição permitida em 
	 * relação ao eixo "x".
	 */
	private int maiorX() {
		return this.x + this.getImagem().getWidth(null);
	}
	
	/**
	 * Método responsável por retornar a maior posição legal da tela em relação ao eixo "y".
	 * @return Inteiro contendo uma referência ao valor de maior posição permitida em 
	 * relação ao eixo "y".
	 */
	private int maiorY() {
		return this.y + this.getImagem().getHeight(null);
	}
	
	/**
	 * Método responsável por retornar a menor posição legal da tela em relação ao eixo "x".
	 * @return Inteiro contendo uma referência ao valor de menor posição permitida em 
	 * relação ao eixo "x".
	 */
	private int menorX() {
		return this.x;
	}
	
	/**
	 * Método responsável por retornar a menor posição legal da tela em relação ao eixo "y".
	 * @return Inteiro contendo uma referência ao valor de menor posição permitida em 
	 * relação ao eixo "y".
	 */
	private int menorY() {
		return this.y;
	}
}
