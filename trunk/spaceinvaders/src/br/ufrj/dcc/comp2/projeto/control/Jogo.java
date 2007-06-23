package br.ufrj.dcc.comp2.projeto.control;

/* Pertencia ao Game.java
import java.util.TreeMap;*/

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
	
	/* Pertencia ao Game.java
	public TreeMap<Integer,Integer> shotsMap;
	public TreeMap<Integer,Integer> aliensMap;
	public int shipX, shipY; */

	public void run() {
		this.regras = new ControleRegras();
		this.nave = new Nave(regras);
		this.atualizador = new AtualizaPosicao(regras);
		this.painel = new Painel(this.nave, regras);
		this.teclado = new Teclado(this.nave);
		this.tela = new Tela(this.painel, this.teclado);
		this.repintor = new Repinta(this.tela, this.painel);

		this.teclado.start();
		this.repintor.start();
		this.atualizador.start();
		this.regras.start();
	}
}
