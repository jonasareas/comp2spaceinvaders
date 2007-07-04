package br.ufrj.dcc.comp2.projeto.control;

public class Player {
	private int vida;
	
	public Player() {
		vida = 3;
	}
	
	public void ganhaVida() {
		vida++;
	}

	public void perdeVida() {
		vida--;
	}
	
	public int getVida() {
		return vida;
	}
}
