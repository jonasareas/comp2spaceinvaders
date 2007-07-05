package br.ufrj.dcc.comp2.projeto.control;

public class Player {
	private int vida;
	private boolean gameover;
	private int fasejogador;
	private String nome;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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
	
	public boolean situacaogameover() {
		return gameover;
	}
	
	public void setFase(int fase) {
		this.fasejogador = fase;
	}
	
	public int getFase() {
		return fasejogador;
	}
	
	public void setGameover(boolean b) {
		this.gameover = b;
	}
	
	public boolean getGameover() {
		return this.gameover;
	}
	
	
}
