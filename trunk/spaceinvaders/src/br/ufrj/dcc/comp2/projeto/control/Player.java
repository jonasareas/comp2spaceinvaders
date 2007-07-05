package br.ufrj.dcc.comp2.projeto.control;

public class Player {
	private int vida;
	private boolean gameover;
	private int fasejogador;
	
	public Player() {
		vida = 3;
		gameover = false;
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
	
	public void gameover() {
		gameover = true;
	}
	
	public boolean situacaogameover() {
		return gameover;
	}
	
	public void setFase(int fase) {
		this.fasejogador = fase;
	}
	
	public int getFase() {
		return fasejogador;
	}
	
	
}
