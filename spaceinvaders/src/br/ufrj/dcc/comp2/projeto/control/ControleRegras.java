package br.ufrj.dcc.comp2.projeto.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import br.ufrj.dcc.comp2.projeto.model.*;

public class ControleRegras extends Thread {
	
	/* Esses SuppressWarnings são para o java parar de reclamar
	 *  dizendo que estas variáveis não foram usadas!
	 */
	
	@SuppressWarnings("unused")
	private Jogo jogo;
		
	@SuppressWarnings("unused")
	private JPanel painel;
	
	private List<Alien> aliens;
	private List<Tiro> tiros;
	
	private Nave nave;
	
	private int tammaxAliens;
	private int probAlien;
	
	private int pontuacao;
	
	
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

	public Nave getNave() {
		return this.nave;
	}
	
	public Score getPontuacao() {
		return this.jogo.pontuacao;
	}
	
	public void setNave(Nave nave) {
		this.nave = nave;
	}
	public void novoTiro(int x, int y) {
		Tiro tiro = new Tiro(x, y);
		this.tiros.add(tiro);
	}
	public void novoAlien() {
		int x = (int)(Math.random()*600); /* modificar pra n vir no canto! */
		Alien alien = new Alien(x, 0, this);
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
