package br.ufrj.dcc.comp2.projeto.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Iterator;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ufrj.dcc.comp2.projeto.control.Score;


/** 
 * Classe responsável pela tela de high scores do jogo.
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
@SuppressWarnings("serial")
public class HighScores extends JPanel {

	/** Nova instancia de JFrame. */
	JFrame frame = new JFrame("Ranking");

	/**  Instância de Score para pegar os melhores pontuadores. */
	Score sc = Score.abreRecorde();

	/** TreeMap com os melhores pontuadores, e suas respectivas pontuações. */
	TreeMap<Integer, String> recordistas = sc.getPontos();

	/**
	 * Método responsável por desenhar a tela de ranking.
	 */
	public void paintComponent(Graphics g) {
		paintFase((Graphics2D) g);
	}

	/**
	 * Método responsável pela construção da tela de ranking do jogo.
	 */
	public void constroiTela() {
		
		/** Novo objeto imagem que carrega a imagem de fundo da tela inicial. */
		Image universo = new ImageIcon("./imagens/Ranking.JPG").getImage();

		/** Novo objeto da classe Painel. */
		Painel painel = new Painel(universo);

		/* Novo objeto da classe JButton. */
		//JButton botao_Fechar = new JButton("Fechar");

		frame.add(painel);
		/*
		frame.getContentPane().add(BorderLayout.SOUTH, botao_Fechar);
		botao_Fechar.addActionListener(new botao_Fechar_Listener());
		*/

		this.repaint();

		frame.setLocation(3, 45);
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

	/**
	 * Método responsável por exibir os pontuadores na tela de ranking.
	 * @param g Instancia de Graphics
	 */
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

	
	/*
	 * Classe interna que implementa a interface ActionListener
	 * @author Lopes, R.
	*/
	/*
	class botao_Fechar_Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.setVisible(false);
			frame.dispose();
		}
	}
	*/

}
