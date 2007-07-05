package br.ufrj.dcc.comp2.projeto.model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.ufrj.dcc.comp2.projeto.control.*;

public class Nave extends ExplodedSprite {
	private ControleRegras regras;
	private boolean emExplosao;
	protected int pos;

	public Nave(ControleRegras regras) {
		super("./imagens/Nave.gif");

		this.regras = regras;
		this.x = (800 - imagem.getWidth(null))/2;
		this.y = 600 - 2*imagem.getHeight(null);
	}

	public void goRight() {
		if(this.x < 800 - this.imagem.getWidth(null) - 5) {
			this.x += 1;
		}
	}

	public void goLeft() {
		if(this.x > 0) {
			this.x -= 1;
		}
	}

	public void fire() {
		regras.novoTiro(x+(this.getImagem().getWidth(null))/2, y);
	}

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

	public boolean isEmExplosao() {
		return emExplosao;
	}

	public void setEmExplosao(boolean emExplosao) {
		this.emExplosao = emExplosao;
	}

}