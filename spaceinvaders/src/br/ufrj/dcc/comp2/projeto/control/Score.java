package br.ufrj.dcc.comp2.projeto.control;

public class Score {
	private int pontuacao;
	private int pontuacaoAcumulada;
	public Score() {
		pontuacao = 0;
		pontuacaoAcumulada = 0;
	}

	public void aumentaPonto() {
		pontuacao += 15;
		pontuacaoAcumulada += 15;
	}
	
	public void diminuiPonto() {
		if (pontuacao > 0) {
			pontuacao -= 5;
			pontuacaoAcumulada -= 5;
		}
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public int getPontuacaoAcumulada() {
		return pontuacaoAcumulada;
	}
	
	public void zeraPontuacaoAcumulada() {
		pontuacaoAcumulada = 0;
	}
}
