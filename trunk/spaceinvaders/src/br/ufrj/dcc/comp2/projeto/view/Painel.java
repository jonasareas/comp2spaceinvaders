package br.ufrj.dcc.comp2.projeto.view;

import java.awt.Color;
import java.awt.Graphics;
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
	
	public Painel(Nave nave, ControleRegras regras) {
		this.nave = nave;
		this.regras = regras;
		try {
			fundoJogo = ImageIO.read(new File("./imagens/universo.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Painel(Image desenho) {
		this.desenho = desenho;
	}

	public void paintComponent(Graphics g) {
		if (desenho == null){
			g.drawImage(this.fundoJogo, 0, 0, null);
			
			for(int cont=0; cont<regras.getTiros().size();cont++) {
				Tiro tiro = regras.getTiros().get(cont);
				g.drawImage(tiro.getImagem(), tiro.getX(), tiro.getY(), null);
			}
			for(int cont=0; cont<regras.getAliens().size();cont++) {
				Alien alien = regras.getAliens().get(cont);
				g.drawImage(alien.getImagem(), alien.getX(), alien.getY(), null);
			}
			g.drawImage(nave.getImagem(), nave.getX(), nave.getY(), null);
		}
		else {
			g.setColor(Color.white);
			g.drawImage(desenho, 0, 0, this);
		}
	
	}

}