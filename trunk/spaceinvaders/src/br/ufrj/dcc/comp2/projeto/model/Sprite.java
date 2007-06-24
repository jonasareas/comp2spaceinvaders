package br.ufrj.dcc.comp2.projeto.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	protected int x;
	protected int y;
	protected Image imagem;
	protected String file;
	
	public Sprite(String nomeArq) {
		this.file = nomeArq;
				
		try {
			imagem = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int posicaonova) {
		this.x = posicaonova;
	}

	public int getY() {
		return y;
	}

	public void setY(int posicaonova) {
		this.y = posicaonova;
	}

	public Image getImagem() {
		return this.imagem;
	}

}
