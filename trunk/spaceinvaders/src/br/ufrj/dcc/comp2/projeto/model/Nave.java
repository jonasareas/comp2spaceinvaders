package br.ufrj.dcc.comp2.projeto.model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.ufrj.dcc.comp2.projeto.control.*;

public class Nave extends ExplodedSprite {
	private ControleRegras regras;
	
	public Nave(ControleRegras regras) {
		try {
			imagem = ImageIO.read(new File("imagens/nave.JPG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
}
