package br.ufrj.dcc.comp2.projeto.model;

public class Boss extends Alien {
	
	//criei esse construtor para tirar a mensagem de erro do arquivo. Bola
	public Boss(String nomeArq, int x, int y) {
		super(nomeArq, x, y);
		// TODO Auto-generated constructor stub
	}

	public int life = 50;
	
}
