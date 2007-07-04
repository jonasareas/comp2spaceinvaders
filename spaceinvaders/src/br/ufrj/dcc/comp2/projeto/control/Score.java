package br.ufrj.dcc.comp2.projeto.control;

public class Score {
	private int pontuacao;
	private int pontuacao_acumulada;
	public Score() {
		pontuacao = 0;
		pontuacao_acumulada = 0;
	}

	public void aumentaponto() {
		pontuacao += 15;
		pontuacao_acumulada += 15;
	}
	
	public void diminuiponto() {
		if (pontuacao > 0) {
			pontuacao -= 5;
			pontuacao_acumulada -= 5;
		}
	}
	
	public int getpontuacao() {
		return pontuacao;
	}
	
	public int getpontuacao_acumulada() {
		return pontuacao_acumulada;
	}
	
	public void zerapontuacaoacumulada() {
		pontuacao_acumulada = 0;
	}
}
