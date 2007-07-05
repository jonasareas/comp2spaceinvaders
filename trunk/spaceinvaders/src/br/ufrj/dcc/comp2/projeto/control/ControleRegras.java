package br.ufrj.dcc.comp2.projeto.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import br.ufrj.dcc.comp2.projeto.model.Alien;
import br.ufrj.dcc.comp2.projeto.model.ExplodedSprite;
import br.ufrj.dcc.comp2.projeto.model.Nave;
import br.ufrj.dcc.comp2.projeto.model.Tiro;

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
	private List<ExplodedSprite> explodir;
	
	private Nave nave;
	
	private int tammaxAliens;
	private int probAlien;
	
	//private Player jogador;
	
	//int fase = 1;
	
	public ControleRegras(Jogo jogo) {
		this.explodir = Collections.synchronizedList(new ArrayList<ExplodedSprite>());
		this.tiros = Collections.synchronizedList(new ArrayList<Tiro>());
		this.aliens = Collections.synchronizedList(new ArrayList<Alien>());
				
		/* Controle das fases:
		 * Fase 1: tammaxaliens = 5 / probaliens = 2
		 * Fase 2: tammaxaliens = 7 / probaliens = 3
		 * Fase 3: tammaxaliens = 9 / probaliens = 4
		 * Fase 4: tammaxaliens = 11/ probaliens = 5
		 * Fase 5: tammaxaliens = 15/ probaliens = 10
		 * Fase Suprema: tammaxaliens = 30 / probaliens = 20
		 * Fase Suprema se !Chefao
		 * Fase Bonus Track(Se vida ao zerar >=4)
		 * tamaxaliens = 50 / probaliens = 30
		 */
		//this.tammaxAliens = 5;
		//this.probAlien = 2;
		this.jogo = jogo;
		this.setFase(1);
	}
	public List<Tiro> getTiros() {
		return this.tiros;
	}
	public List<Alien> getAliens() {
		return this.aliens;
	}
	
	public List<ExplodedSprite> getExplodir() {
		return this.explodir;
	}

	public Nave getNave() {
		return this.nave;
	}
	
	public Score getPontuacao() {
		return this.jogo.pontuacao;
	}
	
	public Player getJogador() {
		return this.jogo.jogador;
	}
	
	public void setNave(Nave nave) {
		this.nave = nave;
	}
	
	public void setJogador(Player jogador) {
		this.jogo.jogador = jogador;
	}
	
	public void novoTiro(int x, int y) {
		Tiro tiro = new Tiro(x, y);
		this.tiros.add(tiro);
	}
	
	public Jogo getJogo() {
		return this.jogo;
	}
	
	public void novoAlien() {
		int x = (int)(Math.random()*600); /* modificar pra n vir no canto! */
		Alien alien = new Alien(x, 0, this);
		this.aliens.add(alien);
	}
	
	public void setFase(int fase) {
		jogo.jogador.setFase(fase);
		switch(fase){
		case 1:
			this.tammaxAliens = 9;
			this.probAlien = 4;
			break;
		case 2:
			this.tammaxAliens = 11;
			this.probAlien = 5;
			break;
		case 3:
			this.tammaxAliens = 15;
			this.probAlien = 10;
			break;
		case 4:
			this.tammaxAliens = 15;
			this.probAlien = 15;
			break;
		case 5: 
			this.tammaxAliens = 25;
			this.probAlien = 20;
			break;
		case 6: 
			this.tammaxAliens = 30;
			this.probAlien = 25;
			break;
		case 7:
			this.tammaxAliens = 35;
			this.probAlien = 30;
			break;
		case 8:
			this.tammaxAliens = 40;
			this.probAlien = 35;
			break;
		default: 
		}
	}
	
	public void setTamMaxAliens(int tamanho) {
		this.tammaxAliens = tamanho;
	}
	
	public void setprobAliens(int tamanho) {
		this.probAlien = tamanho;
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
