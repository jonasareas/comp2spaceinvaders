package br.ufrj.dcc.comp2.projeto.model;

public class Tiro extends Sprite {
	public Tiro(int x, int y) {
		super("./imagens/tiro.gif");
		this.x = x - this.getImagem().getWidth(null)/2;
		this.y = y - this.getImagem().getHeight(null);
	}

	public boolean goUp() {
		this.y -= 1;
		if (this.y == 0 - this.getImagem().getHeight(null))
			return false;
		else
			return true;
			
	}
	
}
