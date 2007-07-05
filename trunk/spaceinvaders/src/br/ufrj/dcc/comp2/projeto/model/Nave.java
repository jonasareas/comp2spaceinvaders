package br.ufrj.dcc.comp2.projeto.model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.ufrj.dcc.comp2.projeto.control.*;

/** 
 * Subclasse de ExplodedSprite responsável pela nave do jogo.
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Nave extends ExplodedSprite {
	
	/** Campo para referência ao tipo ControleRegras. */
	private ControleRegras regras;
	
	/** Campo controlador da explosão. */
	private boolean emExplosao;
	
	/** Campo armazenador da posição. */
	protected int pos;

	/**
	 * @param regras Referência aos collections criados na classe ControleRegras.
	 */
	public Nave(ControleRegras regras) {
		super("./imagens/Nave.gif");

		this.regras = regras;
		this.x = (800 - imagem.getWidth(null))/2;
		this.y = 600 - 2*imagem.getHeight(null);
	}

	/**
	 * Método responsável pela movimentação da nave para a direita.
	*/
	public void goRight() {
		if(this.x < 800 - this.imagem.getWidth(null) - 5) {
			this.x += 1;
		}
	}

	/**
	 * Método responsável pela movimentação da nave para a esquerda.
	*/
	public void goLeft() {
		if(this.x > 0) {
			this.x -= 1;
		}
	}

	/**
	 * Método responsável pela criação de um novo tiro.
	*/
	public void fire() {
		regras.novoTiro(x+(this.getImagem().getWidth(null))/2, y);
	}

	/**
	 * Método responsável pela animação da nave ao ser atingida (modo imortal).
	 * @throws IOException Não puder carregar a imagem.
	 */
	public void animaNave() {
		this.pos++;
		if (this.pos < 150) {
			try {
				this.setImagem(ImageIO.read(new File("./imagens/nave_atingida.GIF")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (this.pos == 150) {
			setEmExplosao(false);
			this.pos = 0;
		}
	}

	/**
	 * Método controlador das explosões.
	 * @return true Se o objeto estiver explodindo.
	*/
	public boolean isEmExplosao() {
		return emExplosao;
	}

	/**
	 * Método que faz explodir os componentes do jogo.
	 * @param emExplosao
	 */
	public void setEmExplosao(boolean emExplosao) {
		this.emExplosao = emExplosao;
	}

}