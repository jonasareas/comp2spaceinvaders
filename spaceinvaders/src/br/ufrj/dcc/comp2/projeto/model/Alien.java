package br.ufrj.dcc.comp2.projeto.model;

import br.ufrj.dcc.comp2.projeto.control.*;

public class Alien extends ExplodedSprite {
	public Alien(int x, int y, ControleRegras regras) {
		super("imagens/Alien.gif");
		this.x = x;
		this.y = y-this.getImagem().getHeight(null);
	}

	public boolean goDown() {
		this.y += 1;
		if (this.y == 600 + this.getImagem().getHeight(null))
			return false;
		else
			return true;
	}

}