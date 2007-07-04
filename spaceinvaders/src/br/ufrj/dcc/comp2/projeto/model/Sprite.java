package br.ufrj.dcc.comp2.projeto.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

abstract class Sprite {
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
	protected void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	// Comparação de posição dos objetos a se colidir.
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
		
		/*
		if( (this.menorX() >= obj.menorX() && this.menorX() <= obj.maiorX()) || (this.maiorX() >= obj.menorX() && this.maiorX() <= obj.maiorX()) ) {
			if( (this.menorY() >= obj.menorY() && this.menorY() <= obj.maiorY()) || (this.maiorY() >= obj.menorY() && this.maiorY() <= obj.maiorY()) ) {
				return true;
			}
		}
		
		if( this.getImagem().getWidth(null) > obj.getImagem().getWidth(null)) {
			if (obj.menorX() >= this.menorX() && obj.menorX() <= this.maiorX() && obj.maiorX() >= this.menorX() && obj.maiorX() <= this.maiorX()) {
				if( (this.menorY() >= obj.menorY() && this.menorY() <= obj.maiorY()) || (this.maiorY() >= obj.menorY() && this.maiorY() <= obj.maiorY()) ) {
					return true;
				}
			}
		}
	 	
		return false;
		*/
	}
	
	private int maiorX() {
		return this.x + this.getImagem().getWidth(null);
	}
	private int maiorY() {
		return this.y + this.getImagem().getHeight(null);
	}
	private int menorX() {
		return this.x;
	}
	private int menorY() {
		return this.y;
	}
	
	
}
