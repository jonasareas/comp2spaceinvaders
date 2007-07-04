package br.ufrj.dcc.comp2.projeto.control;

public class Score {
	private int pontuacao;
	public Score() {
		pontuacao = 0;
	}

	public void aumentaponto() {
		pontuacao += 15;
	}
	
	public void diminuiponto() {
		if (pontuacao > 0) {
			pontuacao -= 5;
		}
		
	}
	
	public int getpontuacao() {
		return pontuacao;
	}
}
