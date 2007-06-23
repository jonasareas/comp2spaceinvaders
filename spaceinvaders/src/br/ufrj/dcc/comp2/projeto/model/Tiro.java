package br.ufrj.dcc.comp2.projeto.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tiro {
	private int x;
	private int y;
	private Image imagem;
	
	public Tiro(int x, int y) {
		try {
			imagem = ImageIO.read(new File("imagens/tiro.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.x = x-this.getImagem().getWidth(null);
		this.y = y-this.getImagem().getHeight(null);
	}

	public Image getImagem() {
		return this.imagem;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void goUp() {
		this.y -= 1;
	}
}
