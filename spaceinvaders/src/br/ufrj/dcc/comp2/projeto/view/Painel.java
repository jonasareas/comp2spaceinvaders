package br.ufrj.dcc.comp2.projeto.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import br.ufrj.dcc.comp2.projeto.control.*;
import br.ufrj.dcc.comp2.projeto.model.*;

/** 
 * Classe responsável pelos painéis do jogo.
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Painel extends JPanel {
	
	/** Serial da classe. */
	private static final long serialVersionUID = 1L;

	/** Campo para referência do tipo Nave. */ 
	private Nave nave;
	
	/** Campo para referência do tipo ControleRegras. */
	private ControleRegras regras;
	
	/** Campo para referência do tipo Image, usada como tela de abertura. */
	private Image desenho;
	
	/** Campo para referência do tipo Image, usada como tela de fundo do jogo. */
	private Image fundoJogo;
	
	/** Campo para referência do tipo Image, usada como tela de GameOver. */
	private Image fundoGameOver;
	
	/** Campo para referência do tipo Image, usada como tela quando o jogador vence o jogo. */
	private Image fundoZerou;
	
	/** Campo booleano para verificar situação de GameOver. */
	private boolean gameOver = false;
	
	/** Campo booleano para verificar situação de ganho de jogo. */
	private boolean zerou = false;

	/**
	 * Construtor para a tela de jogo. 
	 * @param nave Instancia da classe Nave
	 * @param regras Instancia da classe ControleRegras
	 * @throws IOException A imagem não puder ser carregada.
	 */
	public Painel(Nave nave, ControleRegras regras) {
		this.nave = nave;
		this.regras = regras;
		try {
			fundoJogo = ImageIO.read(new File("./imagens/universo.jpg"));
			fundoGameOver = ImageIO.read(new File("./imagens/tela_BadEnd.jpg"));
			fundoZerou = ImageIO.read(new File("./imagens/tela_gameOver.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Construtor para a tela de abertura.
	 * @param desenho - Instancia da classe Image
	 */
	public Painel(Image desenho) {
		this.desenho = desenho;
	}

	/**
	 * Método resposáel por desenhar os componentes na tela.
	*/
	public void paintComponent(Graphics g) {
		if (desenho == null && !this.gameOver && !zerou){
			g.drawImage(this.fundoJogo, 0, 0, null);

			for(int cont=0; cont<regras.getTiros().size();cont++) {
				Tiro tiro = regras.getTiros().get(cont);
				g.drawImage(tiro.getImagem(), tiro.getX(), tiro.getY(), null);
			}
			for(int cont=0; cont<regras.getAliens().size();cont++) {
				Alien alien = regras.getAliens().get(cont);
				g.drawImage(alien.getImagem(), alien.getX(), alien.getY(), null);
			}
			for(int cont=0; cont<regras.getExplodir().size();cont++) {
				ExplodedSprite explode = regras.getExplodir().get(cont);
				g.drawImage(explode.getImagem(), explode.getX(), explode.getY(), null);
			}
			g.drawImage(nave.getImagem(), nave.getX(), nave.getY(), null);
			paintScore((Graphics2D) g);
			paintLife((Graphics2D) g);
			paintFase((Graphics2D) g);
		}
		else {
			if (desenho != null) {
				g.setColor(Color.white);
				g.drawImage(desenho, 0, 0, this);
			}
			if (gameOver) {
				paintGameOver((Graphics2D) g);
			}
			if (zerou) {
				paintZerou((Graphics2D) g);
			}
		}

	}

	/**
	 * Método que pinta na tela a pontuação do jogador. 
	 * @param g Instancia de Graphics
	 */
	public void paintScore(Graphics2D g) {
		g.setFont(new Font("./fontes/AbstractClassicFont.ttf",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("Score:",675,40);
		g.drawString(regras.getPontuacao().getPontuacao()+"",750,40);
	}

	/**
	 * Método que pinta na tela a quantidade de vidas do jogador. 
	 * @param g Instancia de Graphics
	 */
	public void paintLife(Graphics2D g) {
		g.setFont(new Font("./fontes/AbstractClassicFont.ttf",Font.BOLD,20));
		g.setPaint(Color.red);
		g.drawString("Vidas:",675,80);
		g.drawString((regras.getJogador().getVida() + 1)+"",750,80);
	}	

	/**
	 * Método que pinta na tela a fase atual do jogo. 
	 * @param g Instancia de Graphics
	 */
	public void paintFase(Graphics2D g) {
		g.setFont(new Font("./fontes/AbstractClassicFont.ttf",Font.BOLD,20));
		g.setPaint(Color.yellow);
		g.drawString("Fase:",675,120);
		g.drawString(regras.getJogador().getFase()+"",750,120);
	}

	/**
	 * Método que pinta a tela de GameOver. 
	 * @param g Instancia de Graphics
	 */
	public void paintGameOver(Graphics2D g) {
		g.drawImage(this.fundoGameOver, 0, 0, null);
	}

	/**
	 * Método que pinta a tela de ganho de jogo. 
	 * @param g Instancia de Graphics
	 */
	public void paintZerou(Graphics2D g) {
		g.drawImage(this.fundoZerou, 0, 0, null);
	}

	/**
	 * Método que redefine a situação de GameOver para verdadeiro.
	*/
	public void pintaGameOver() {
		this.gameOver = true;
	}

	/**
	 * Método que redefine a situação de ganho de jogo para verdadeiro.
	*/
	public void pintaZerou() {
		this.zerou = true;
	}
}