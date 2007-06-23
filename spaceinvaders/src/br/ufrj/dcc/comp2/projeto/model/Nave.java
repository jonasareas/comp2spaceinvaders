package br.ufrj.dcc.comp2.projeto.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.ufrj.dcc.comp2.projeto.control.*;

public class Nave {
	private int x;
	private int y;
	private Image nave;
	private ControleRegras regras;
	
	public Nave(ControleRegras regras) {
		try {
			nave = ImageIO.read(new File("imagens/nave.JPG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.regras = regras;
		this.x = (800 - nave.getWidth(null))/2;
		this.y = 600 - 2*nave.getHeight(null);
	}

	public Image getNave() {
		return this.nave;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public void goRight() {
		if(this.x < 800 - this.nave.getWidth(null) - 5) {
			this.x += 1;
		}
	}
	public void goLeft() {
		if(this.x > 0) {
			this.x -= 1;
		}
	}
	public void fire() {
		regras.novoTiro(x+(this.getNave().getWidth(null))/2, y);
	}
}
