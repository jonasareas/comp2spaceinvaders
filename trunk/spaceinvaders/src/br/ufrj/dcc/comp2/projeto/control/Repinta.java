package br.ufrj.dcc.comp2.projeto.control;

import br.ufrj.dcc.comp2.projeto.view.*;

/** 
 * Classe respons�vel por repintar a tela de jogo.
 * @author Ar�as, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Repinta extends Thread {
	
	/** Campo contendo refer�ncia ao tipo Tela */
	private Tela tela;
	
	/** Campo contendo refer�ncia ao tipo Painel */
	private Painel painel;

	/**
	 * @param tela Instancia da classe tela
	 * @param painel Instancia da classe Painel
	 */
	public Repinta(Tela tela, Painel painel) {
		this.painel = painel;
		this.tela = tela;
	}

	/**
	* Redefini��o do m�todo run da interface Runnable.
	* @throws InterruptedException
	*/
	public void run() {
		while(true){
			painel.repaint();
			tela.repaint();
			try {
				Repinta.sleep(1000/100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
