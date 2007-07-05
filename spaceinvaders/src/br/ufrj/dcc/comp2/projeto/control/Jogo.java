package br.ufrj.dcc.comp2.projeto.control;

import br.ufrj.dcc.comp2.projeto.model.*;
import br.ufrj.dcc.comp2.projeto.view.*;

/** 
 * Classe respons�vel pela inicializa��o das principais threads do jogo.
 * @author Ar�as, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.4
*/
public class Jogo extends Thread {
	/** Campo para uma refer�ncia ao objeto Nave. */
	public Nave nave;
	
	/** Campo para uma refer�ncia ao objeto Tela. */
	public Tela tela;
	
	/** Campo para uma refer�ncia ao objeto controlador do Teclado. */
	public Teclado teclado;
	
	/** Campo para uma refer�ncia ao objeto Painel. */
	public Painel painel;
	
	/** Campo para uma refer�ncia ao objeto Repinta, respons�vel por repintar a tela de jogo. */
	public Repinta repintor;
	
	/** Campo para uma refer�ncia ao objeto ControleRegras, respons�vel pelos collections do jogo. */
	public ControleRegras regras;
	
	/** Campo para uma refer�ncia ao objeto AtualizaPosicao, respons�vel por atualizar a posi��o dos objetos na tela. */
	public AtualizaPosicao atualizador;
	
	/** Campo para uma refer�ncia ao objeto Anima, respons�vel pelas anima��es. */
	public Anima animador;
	
	/** Campo para uma refer�ncia ao objeto Score. */
	public Score pontuacao;
	
	/** Campo para uma refer�ncia ao objeto Player. */
	public Player jogador;

	/* Pra que este construtor vazio?? */
	public Jogo() {
	}

	/** 
	 * @param tela - Uma instancia de Tela
	 */
	public Jogo(Tela tela) {
		this.tela = tela;
	}

	/**
	 * M�todo respons�vel pela pausa do jogo.
	*/
	public void pause() {

	}
	
	/**
	 * M�todo verificador de pontua��o.
	*/
	public void VerificaScore() {
		Score.abreRecorde();
		pontuacao.AdicionarRecorde(pontuacao.getPontuacao(), "jogador");
		pontuacao.salvarRecorde();
	}

	@SuppressWarnings("deprecation")
	/** 
	* Redefini��o do m�todo run da interface Runnable.
	*/
	public void run() {
		this.jogador = new Player();
		this.regras = new ControleRegras(this);
		this.nave = new Nave(regras);
		this.teclado = new Teclado(this.nave, this.jogador);
		this.animador = new Anima(regras);
		this.atualizador = new AtualizaPosicao(regras,teclado);
		this.pontuacao = new Score();

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
	}
}
