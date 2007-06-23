package br.ufrj.dcc.comp2.projeto.model;

public class Sprite {
	public int x;
	public int y;
	public String file;
	
	public Sprite(String nomeArq, int x, int y) {
		this.file = nomeArq;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
