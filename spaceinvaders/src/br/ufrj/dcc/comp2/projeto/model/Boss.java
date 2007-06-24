package br.ufrj.dcc.comp2.projeto.model;

public class Boss extends Alien {
	public int life;
	
	public Boss(String file) {
		super(file);
		this.life = 50;
	}

}
