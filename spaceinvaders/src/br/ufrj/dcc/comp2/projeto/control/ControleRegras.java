package br.ufrj.dcc.comp2.projeto.control;

import br.ufrj.dcc.comp2.projeto.model.*;

public class ControleRegras extends Thread {
	private Tiro tiro;
	
	public Tiro getTiro() {
		return this.tiro;
	}
	public void setTiro(Tiro tiro) {
		this.tiro = tiro;
	}
	public void novoTiro(int x, int y) {
		this.tiro = new Tiro(x, y);
	}
}
