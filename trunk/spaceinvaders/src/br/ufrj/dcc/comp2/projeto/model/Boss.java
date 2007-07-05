package br.ufrj.dcc.comp2.projeto.model;

import br.ufrj.dcc.comp2.projeto.control.*;

public class Boss extends Alien {
	public int life;

	public Boss(int x, int y, ControleRegras regras) {
		super(x, y, regras);
		this.life = 50;
	}
}
