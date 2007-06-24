package br.ufrj.dcc.comp2.projeto.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import br.ufrj.dcc.comp2.projeto.control.*;
import br.ufrj.dcc.comp2.projeto.model.*;

public class Painel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Nave nave;
	private ControleRegras regras;
	private Image desenho;
	
	public Painel(Nave nave, ControleRegras regras) {
		this.nave = nave;
		this.regras = regras;
	}
	
	public Painel(Image desenho) {
		this.desenho = desenho;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());			
		
		if (desenho == null){
			if(regras.getTiro() != null) {
				g.drawImage(regras.getTiro().getImagem(), regras.getTiro().getX(), regras.getTiro().getY(), null);
			}
			g.drawImage(nave.getImagem(), nave.getX(), nave.getY(), null);
		}
		else {
			g.setColor(Color.white);
			//g.fillRect(0, 0, this.getWidth(), this.getHeight());			
			g.drawImage(desenho, 0, 0, this);
		}
	
	}

}