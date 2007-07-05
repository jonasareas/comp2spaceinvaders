package br.ufrj.dcc.comp2.projeto.control;

import br.ufrj.dcc.comp2.projeto.model.*;
import br.ufrj.dcc.comp2.projeto.view.*;

/** 
 * Classe responsável pela inicialização das principais threads do jogo.
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.4
*/
public class Jogo extends Thread {
	/** Campo para uma referência ao objeto Nave. */
	public Nave nave;
	
	/** Campo para uma referência ao objeto Tela. */
	public Tela tela;
	
	/** Campo para uma referência ao objeto controlador do Teclado. */
	public Teclado teclado;
	
	/** Campo para uma referência ao objeto Painel. */
	public Painel painel;
	
	/** Campo para uma referência ao objeto Repinta, responsável por repintar a tela de jogo. */
	public Repinta repintor;
	
	/** Campo para uma referência ao objeto ControleRegras, responsável pelos collections do jogo. */
	public ControleRegras regras;
	
	/** Campo para uma referência ao objeto AtualizaPosicao, responsável por atualizar a posição dos objetos na tela. */
	public AtualizaPosicao atualizador;
	
	/** Campo para uma referência ao objeto Anima, responsável pelas animações. */
	public Anima animador;
	
	/** Campo para uma referência ao objeto Score. */
	public Score pontuacao;
	
	/** Campo para uma referência ao objeto Player. */
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
	 * Método responsável pela pausa do jogo.
	*/
	public void pause() {

	}
	
	/**
	 * Método verificador de pontuação.
	*/
	public void VerificaScore() {
		Score.abreRecorde();
		pontuacao.AdicionarRecorde(pontuacao.getPontuacao(), "jogador");
		pontuacao.salvarRecorde();
	}

	@SuppressWarnings("deprecation")
	/** 
	* Redefinição do método run da interface Runnable.
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
