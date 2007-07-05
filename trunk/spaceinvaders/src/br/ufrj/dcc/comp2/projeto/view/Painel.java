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

public class Painel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Nave nave;
	private ControleRegras regras;
	private Image desenho;
	private Image fundoJogo;
	private Image fundoGameOver;
	private Image fundoZerou;
	private boolean gameOver = false;
	private boolean zerou = false;
	
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
	
	public Painel(Image desenho) {
		this.desenho = desenho;
	}

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
	
	public void paintScore(Graphics2D g) {
		g.setFont(new Font("./fontes/AbstractClassicFont.ttf",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("Score:",675,40);
		g.drawString(regras.getPontuacao().getPontuacao()+"",750,40);
	}
	
	public void paintLife(Graphics2D g) {
		g.setFont(new Font("./fontes/AbstractClassicFont.ttf",Font.BOLD,20));
		g.setPaint(Color.red);
		g.drawString("Vidas:",675,80);
		g.drawString((regras.getJogador().getVida() + 1)+"",750,80);
	}	
	
	public void paintFase(Graphics2D g) {
		g.setFont(new Font("./fontes/AbstractClassicFont.ttf",Font.BOLD,20));
		g.setPaint(Color.yellow);
		g.drawString("Fase:",675,120);
		g.drawString(regras.getJogador().getFase()+"",750,120);
	}
	
	public void paintGameOver(Graphics2D g) {
		g.drawImage(this.fundoGameOver, 0, 0, null);
	}
	
	public void paintZerou(Graphics2D g) {
		g.drawImage(this.fundoZerou, 0, 0, null);
	}
	
	public void pintaGameOver() {
		this.gameOver = true;
	}
	
	public void pintaZerou() {
		this.zerou = true;
	}
}