package br.ufrj.dcc.comp2.projeto.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import br.ufrj.dcc.comp2.projeto.model.Alien;
import br.ufrj.dcc.comp2.projeto.model.ExplodedSprite;
import br.ufrj.dcc.comp2.projeto.model.Nave;
import br.ufrj.dcc.comp2.projeto.model.Tiro;

/** 
 * Classe responsável pela inicialização dos collections o jogo.
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.4
*/
public class ControleRegras extends Thread {

	/* Esses SuppressWarnings são para o java parar de reclamar
	 *  dizendo que estas variáveis não foram usadas!
	 */

	@SuppressWarnings("unused")
	/** Referência para a classe jogo. */
	private Jogo jogo;

	@SuppressWarnings("unused")
	/** Referência para a classe JPanel que cria um novo painel. */
	private JPanel painel;

	/** Collection que armazena os aliens do jogo. */
	private List<Alien> aliens;
	/** Collection que armazena os tiros do jogo. */
	private List<Tiro> tiros;
	/** Collection que armazena os objetos explodidos do jogo. */
	private List<ExplodedSprite> explodir;

	/** Campo para uma nova nave. */
	private Nave nave;

	/** Campo que determina o número máximo de aliens na tela de jogo. */
	private int tammaxAliens;
	/** Campo que determina a probabilidade de aliens aparecerem na tela de jogo. */
	private int probAlien;

	//private Player jogador;

	//int fase = 1;

	/**
	 * @param jogo Uma instancia da classe Jogo.
	 */
	public ControleRegras(Jogo jogo) {
		this.explodir = Collections.synchronizedList(new ArrayList<ExplodedSprite>());
		this.tiros = Collections.synchronizedList(new ArrayList<Tiro>());
		this.aliens = Collections.synchronizedList(new ArrayList<Alien>());

		this.jogo = jogo;
		this.setFase(1);
	}
	
	/** 
	 * Método que retorna um novo collection de tiros.
	 * @return Um collection de tiros.
	 */
	public List<Tiro> getTiros() {
		return this.tiros;
	}
	
	/** 
	 * Método que retorna um novo collection de aliens.
	 * @return Um collection de aliens.
	 */
	public List<Alien> getAliens() {
		return this.aliens;
	}

	/** 
	 * Método que retorna um collection de objetos que podem explodir.
	 * @return Um collection de objetos explossíveis.  
    */
	public List<ExplodedSprite> getExplodir() {
		return this.explodir;
	}

	/** 
	 * Método que retorna um objeto Nave.
	 * @return Objeto Nave.
	 */
	public Nave getNave() {
		return this.nave;
	}

	/** 
	 * Método que retorna um objeto Score.
	 * @return Objeto nave.
	 */
	public Score getPontuacao() {
		return this.jogo.pontuacao;
	}

	/** 
	 * Método que retorna um objeto Player.
	 * @return Objeto Player.
	 */
	public Player getJogador() {
		return this.jogo.jogador;
	}

	/** 
	 * Método que cria um novo objeto Nave.
	*/	
	public void setNave(Nave nave) {
		this.nave = nave;
	}

	/** 
	 * Método que cria um novo objeto Player.
	*/
	public void setJogador(Player jogador) {
		this.jogo.jogador = jogador;
	}

	/** 
	 * Método que cria um novo objeto tiro a partir de parâmetros da posição da 
	 * nave na tela.
	 * @param x Posição em relação ao eixo "x" 
	 * @param y Posição em relação ao eixo "y".
    */
	public void novoTiro(int x, int y) {
		Tiro tiro = new Tiro(x, y);
		this.tiros.add(tiro);
	}

	/** 
	 * Método que retorna um objeto Jogo.
	 * @return Objeto Player.
	 */
	public Jogo getJogo() {
		return this.jogo;
	}

	/** 
	 * Método que cria um novo objeto alien de forma randômica, considerando a probabilidade
	 * definida no campo probabilidade. 
    */
	public void novoAlien() {
		int x = (int)(Math.random()*600); /* modificar pra n vir no canto! */
		Alien alien = new Alien(x, 0, this);
		this.aliens.add(alien);
	}

	/**
	 * Método que cria as fases no decorrer do jogo, atualizando os valores
	 * de velocidade do alien e probabilidade de aparecerem na tela.
	 * @param fase Um inteiro com o número da fase atual.
	 */
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

	/**
	 * Método que atualiza a quantidade de aliens na tela.
	 * @param tamanho Inteiro referente a quantidade máxima de aliens na tela.
	 */
	public void setTamMaxAliens(int tamanho) {
		this.tammaxAliens = tamanho;
	}

	/**
	 * Método que atualiza a probabilidade de aliens na tela.
	 * @param tamanho Inteiro referente a quantidade máxima de aliens na tela.
	 */
	public void setprobAliens(int tamanho) {
		this.probAlien = tamanho;
	}

	/** 
	 * Método que cria um novo objeto Painel para o jogo  
	 * @param painel Uma instancia da classe JPanel
    */
	public void setPainel(JPanel painel) {
		this.painel = painel;
	}

	/** 
	 * Método sincronizado que instancia aliens na tela de jogo.
	 * @throws InterruptedException  
    */
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
