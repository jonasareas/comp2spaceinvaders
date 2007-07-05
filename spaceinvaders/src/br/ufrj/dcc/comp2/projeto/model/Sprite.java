package br.ufrj.dcc.comp2.projeto.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/** 
 * Classe abstrata respons�vel pela inicializa��o das principais componentes do jogo.
 * @author Ar�as, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
abstract class Sprite {
	
	/** Campo armazenador da posi��o em rela��o ao eixo "x" da tela. */
	protected int x;
	
	/** Campo armazenador da posi��o em rela��o ao eixo "y" da tela. */
	protected int y;
	
	/** Campo para refer�ncia ao tipo Image. */
	protected Image imagem;
	
	/** Campo que cont�m a refer�ncia ao nome do arquivo. */
	protected String file;

	/**
	 * @param nomeArq Nome do arquivo que cont�m a imagem a ser carregada.
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
	 * M�todo que retorna a posi��o em rela��o ao eixo "x" da tela.
	 * @return Um inteiro contendo o valor da posi��o do objeto em rela��o ao eixo "x".
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * M�todo respons�vel por atribuir uma nova posi��o ao objeto em rela��o ao eixo "x".
	 * @param posicaonova Um inteiro contendo o valor da nova posi��o do objeto em rela��o
	 * ao eixo "x".  
	 */
	public void setX(int posicaonova) {
		this.x = posicaonova;
	}

	/**
	 * M�todo que retorna a posi��o em rela��o ao eixo "y" da tela.
	 * @return Um inteiro contendo o valor do objeto em rela��o ao eixo "y".
	 */
	public int getY() {
		return y;
	}

	/**
	 * M�todo respons�vel por atribuir uma nova posi��o ao objeto em rela��o ao eixo "y".
	 * @param posicaonova Um inteiro contendo o valor da nova posi��o do objeto em rela��o
	 * ao eixo "y".  
	 */
	public void setY(int posicaonova) {
		this.y = posicaonova;
	}

	/**
	 * M�todo respons�vel pela refer�ncia ao nome da imagem carregada.
	 * @return Atributo Imagem
	 */
	public Image getImagem() {
		return this.imagem;
	}
	
	/**
	 * M�todo respons�vel pela refer�ncia ao nome da nova imagem a ser carregada.
	 * @return Atributo Imagem
	 */
	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	// Compara��o de posi��o dos objetos a se colidir.
	/**
	 * M�todo comparador de colis�o entre os objetos na tela.
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
	 * M�todo respons�vel por retornar a maior posi��o legal da tela em rela��o ao eixo "x".
	 * @return Inteiro contendo uma refer�ncia ao valor de maior posi��o permitida em 
	 * rela��o ao eixo "x".
	 */
	private int maiorX() {
		return this.x + this.getImagem().getWidth(null);
	}
	
	/**
	 * M�todo respons�vel por retornar a maior posi��o legal da tela em rela��o ao eixo "y".
	 * @return Inteiro contendo uma refer�ncia ao valor de maior posi��o permitida em 
	 * rela��o ao eixo "y".
	 */
	private int maiorY() {
		return this.y + this.getImagem().getHeight(null);
	}
	
	/**
	 * M�todo respons�vel por retornar a menor posi��o legal da tela em rela��o ao eixo "x".
	 * @return Inteiro contendo uma refer�ncia ao valor de menor posi��o permitida em 
	 * rela��o ao eixo "x".
	 */
	private int menorX() {
		return this.x;
	}
	
	/**
	 * M�todo respons�vel por retornar a menor posi��o legal da tela em rela��o ao eixo "y".
	 * @return Inteiro contendo uma refer�ncia ao valor de menor posi��o permitida em 
	 * rela��o ao eixo "y".
	 */
	private int menorY() {
		return this.y;
	}
}
