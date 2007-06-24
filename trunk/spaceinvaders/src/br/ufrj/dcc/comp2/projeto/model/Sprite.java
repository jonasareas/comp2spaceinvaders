package br.ufrj.dcc.comp2.projeto.model;

import java.awt.Image;

public class Sprite {
	protected int x;
	protected int y;
	protected Image imagem;
	private String file;


	/*
	public Sprite(String nomeArq, int x, int y) {
		this.file = nomeArq;
		this.x = x;
		this.y = y;
	}
	 */

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
