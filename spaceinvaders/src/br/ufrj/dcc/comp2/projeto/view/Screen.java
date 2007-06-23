package br.ufrj.dcc.comp2.projeto.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Screen extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	static Screen teste = new Screen();
	JFrame frame = new JFrame("Space Invaders - Frankenstein Games"); //novo frame

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		teste.constroitela();
	}

	public void run() {
		// aqui começa o jogo. =)
	}

	public void constroitela() {
		JMenuBar menu = new JMenuBar(); //cria o JMenuBar. O menu fica dentro de JMenubar.

		PainelDesenho painel = new PainelDesenho();
		
		JMenu menuJogo = new JMenu("Jogo"); //novo menu
		JMenuItem item1 = new JMenuItem("Novo Jogo"); //novo item de menu
		JMenuItem item2 = new JMenuItem("Pause"); //novo item de menu
		JMenuItem item3 = new JMenuItem("Ranking");
		JMenuItem item4 = new JMenuItem("Créditos");
		JMenuItem item5 = new JMenuItem("Sair");

		item1.addActionListener(new item1Listener());
		item2.addActionListener(new item2Listener());
		item3.addActionListener(new item3Listener());
		item4.addActionListener(new item4Listener());
		item5.addActionListener(new item5Listener());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para fechar ao clicar em X

		menuJogo.add(item1);
		menuJogo.add(item2);
		menuJogo.addSeparator();
		menuJogo.add(item3);
		menuJogo.addSeparator();
		menuJogo.add(item4);
		menuJogo.addSeparator();
		menuJogo.add(item5);

		menu.add(menuJogo);
		
		frame.getContentPane().add(painel);

		frame.setJMenuBar(menu);

		frame.setSize(808,650);
		frame.setVisible(true);
	}

	
	class PainelDesenho extends JPanel {
		private static final long serialVersionUID = 1L;
		
		Image universo = new ImageIcon("./imagens/universotela.JPG").getImage();		

		public void paintComponent(Graphics g) {
			g.setColor(Color.white);
			//g.fillRect(0, 0, this.getWidth(), this.getHeight());			
			g.drawImage(universo, 0, 0, this);
		}
	}
	
	//classes internas para fazer os Listeners funcionarem
	class item1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Começa um novo jogo");
		}
	}

	class item2Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Pausa o jogo");
		}
	}

	class item3Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			HighScores telaRanking = new HighScores();
			telaRanking.constroiTela();
		}
	}

	class item4Listener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Credits telaCreditos = new Credits();
			telaCreditos.constroiTela();
		}
	}

	class item5Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}

}
