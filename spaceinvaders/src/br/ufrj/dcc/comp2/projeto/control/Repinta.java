package br.ufrj.dcc.comp2.projeto.control;

import br.ufrj.dcc.comp2.projeto.view.*;

public class Repinta extends Thread {
	private Tela tela;
	private Painel painel;

	public Repinta(Tela tela, Painel painel) {
		this.painel = painel;
		this.tela = tela;
	}

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
