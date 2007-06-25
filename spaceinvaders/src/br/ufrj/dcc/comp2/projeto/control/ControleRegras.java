package br.ufrj.dcc.comp2.projeto.control;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import br.ufrj.dcc.comp2.projeto.model.*;

public class ControleRegras extends Thread {
	private Set<Tiro> tiros;
	//private Set<Alien> aliens;
	
	public ControleRegras() {
		this.tiros = Collections.synchronizedSet(new HashSet<Tiro>());
		//this.aliens = Collections.synchronizedSet(new HashSet<Alien>());
	}
	public Set<Tiro> getTiros() {
		return this.tiros;
	}

	public void novoTiro(int x, int y) {
		Tiro tiro = new Tiro(x, y);
		this.tiros.add(tiro);
	}
}
