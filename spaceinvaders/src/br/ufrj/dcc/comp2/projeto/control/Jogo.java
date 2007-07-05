package br.ufrj.dcc.comp2.projeto.control;

import br.ufrj.dcc.comp2.projeto.model.*;
import br.ufrj.dcc.comp2.projeto.view.*;

public class Jogo extends Thread {
	public Nave nave;
	public Tela tela;
	public Teclado teclado;
	public Painel painel;
	public Repinta repintor;
	public ControleRegras regras;
	public AtualizaPosicao atualizador;
	public Anima animador;
	public Score pontuacao;
	public Player jogador;
	
	public Jogo() {
	}
	
	public Jogo(Tela tela) {
		this.tela = tela;
	}
	
	public void pause() {
	
	}
	
	public void VerificaScore() {
		Score.abreRecorde();
		pontuacao.AdicionarRecorde(pontuacao.getPontuacao(), "jogador");
		pontuacao.salvarRecorde();
	}
	
	@SuppressWarnings("deprecation")
	public void run() {
		this.jogador = new Player();
		this.regras = new ControleRegras(this);
		this.nave = new Nave(regras);
		this.teclado = new Teclado(this.nave);
		this.animador = new Anima(regras);
		this.atualizador = new AtualizaPosicao(regras,teclado);
		this.pontuacao = new Score();
		
		System.out.println(jogador.getVida());
		
		atualizador.setPriority(10);
		teclado.setPriority(10);
		
		this.painel = new Painel(this.nave, regras);
				
		this.regras.setPainel(this.painel);
		this.regras.setNave(nave);
		
		/*if (this.tela == null) {*/
			this.tela = new Tela(this.painel, this.teclado);
		/*} else {
			this.tela.vaitela(this.painel, this.teclado);
		}*/
		
		this.repintor = new Repinta(this.tela, this.painel);
		//repintor.setPriority(10);
		this.teclado.start();
		this.repintor.start();
		this.atualizador.start();
		this.animador.start();
		this.regras.start();


		/*
		if (regras.getJogador().situacaogameover()) {
			System.out.println("Cabo!");
			this.atualizador.stop();
			this.VerificaScore();
			this.stop();
		}
		*/
	}
}
