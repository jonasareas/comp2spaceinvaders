package br.ufrj.dcc.comp2.projeto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ufrj.dcc.comp2.projeto.control.Score;

@SuppressWarnings("serial")
public class HighScores extends JPanel {

	/**
	 * @param args
	 */
	JFrame frame = new JFrame("Ranking");

	/**  Instância de Score para pegar os recordistas. */
	Score sc = Score.abreRecorde();

	/** TreeMap com os recordistas, e suas respectivas pontuações */
	TreeMap<Integer, String> recordistas = sc.getPontos();

	public void paintComponent(Graphics g) {
		paintFase((Graphics2D) g);
	}

	public void constroiTela() {
		/** */
		Image universo = new ImageIcon("./imagens/Ranking.JPG").getImage();

		/** */
		Painel painel = new Painel(universo);

		/** */
		JButton botao_Fechar = new JButton("Fechar");

		frame.add(painel);
		frame.getContentPane().add(BorderLayout.SOUTH, botao_Fechar);
		botao_Fechar.addActionListener(new botao_Fechar_Listener());

		this.repaint();

		frame.setResizable(false);
		frame.setSize(800,600);
		frame.setVisible(true);
		/*
		paintFase(Graphics);

		frame.setResizable(false);
		frame.setSize(800,600);
		frame.setVisible(true);
		 */
	}

	public void paintFase(Graphics2D g) {
		g.setFont(new Font("./fontes/AbstractClassicFont.ttf",Font.BOLD,20));
		g.setPaint(Color.YELLOW);

		Iterator it1 = recordistas.entrySet().iterator();
		Iterator it2 = recordistas.values().iterator();

		while (it1.hasNext() && it2.hasNext()) {
			g.drawString((String) it1.next(),200,120);
			g.drawString((String) it2.next(),250,120);
		}
	}

	class botao_Fechar_Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.setVisible(false);
			frame.dispose();
		}
	}

}
