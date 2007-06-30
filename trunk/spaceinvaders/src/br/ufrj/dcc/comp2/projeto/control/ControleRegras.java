package br.ufrj.dcc.comp2.projeto.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import br.ufrj.dcc.comp2.projeto.model.Alien;
import br.ufrj.dcc.comp2.projeto.model.Tiro;

public class ControleRegras extends Thread {
	private Jogo jogo;
	
	private List<Tiro> tiros;
	private JPanel painel;
	private List<Alien> aliens;
	
	private int tammaxAliens;
	private int probAlien;
	
	
	public ControleRegras(Jogo jogo) {
		this.tiros = Collections.synchronizedList(new ArrayList<Tiro>());
		this.aliens = Collections.synchronizedList(new ArrayList<Alien>());
		
		this.tammaxAliens = 5;
		this.probAlien = 2;
		
		this.jogo = jogo;
	}
	public List<Tiro> getTiros() {
		return this.tiros;
	}
	public List<Alien> getAliens() {
		return this.aliens;
	}

	public void novoTiro(int x, int y) {
		Tiro tiro = new Tiro(x, y);
		this.tiros.add(tiro);
	}
	public void novoAlien() {
		int x = (int)(Math.random()*600);
		Alien alien = new Alien(x, 0);
		this.aliens.add(alien);
	}
	
	public void setPainel(JPanel painel) {
		this.painel = painel;
	}
	
	public synchronized void start() {
		while(true) {
			if(this.aliens.size() < this.tammaxAliens) {
				if( (int)(Math.random()*99) < this.probAlien ) {
					this.novoAlien();
				}
			}
			
			try {
				ControleRegras.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
