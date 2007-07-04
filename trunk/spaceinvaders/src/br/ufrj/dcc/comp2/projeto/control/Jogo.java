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
	public Score pontuacao;
	
	public Jogo() {
	}
	
	public Jogo(Tela tela) {
		this.tela = tela;
	}
	
	public void run() {
		this.regras = new ControleRegras(this);
		this.nave = new Nave(regras);
		this.atualizador = new AtualizaPosicao(regras);
		this.pontuacao = new Score();
		
		atualizador.setPriority(10);
		
		this.painel = new Painel(this.nave, regras);
		this.teclado = new Teclado(this.nave);
		
		teclado.setPriority(10);
		
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
		this.regras.start();
	}
}
