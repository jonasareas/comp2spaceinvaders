package br.ufrj.dcc.comp2.projeto.model;

public class Tiro extends Sprite {
	public Tiro(int x, int y) {
		super("imagens/tiro.gif");
		this.x = x - this.getImagem().getWidth(null);
		this.y = y - this.getImagem().getHeight(null);
	}

	public void goUp() {
		this.y -= 1;
	}
	
}
