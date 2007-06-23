package br.ufrj.dcc.comp2.projeto.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import br.ufrj.dcc.comp2.projeto.control.*;
import br.ufrj.dcc.comp2.projeto.model.*;

public class Painel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Nave nave;
	private ControleRegras regras;
	
	public Painel(Nave nave, ControleRegras regras) {
		this.nave = nave;
		this.regras = regras;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());			
		
		if(regras.getTiro() != null)
			g.drawImage(regras.getTiro().getImagem(), regras.getTiro().getX(), regras.getTiro().getY(), null);
		g.drawImage(nave.getNave(), nave.getX(), nave.getY(), null);
	}

}