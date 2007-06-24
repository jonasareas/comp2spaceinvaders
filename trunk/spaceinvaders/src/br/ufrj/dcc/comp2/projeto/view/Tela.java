package br.ufrj.dcc.comp2.projeto.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import br.ufrj.dcc.comp2.projeto.control.Jogo;
import br.ufrj.dcc.comp2.projeto.view.Credits;
import br.ufrj.dcc.comp2.projeto.view.HighScores;
import br.ufrj.dcc.comp2.projeto.view.Painel;
import br.ufrj.dcc.comp2.projeto.view.Teclado;

@SuppressWarnings("serial")
public class Tela extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	JFrame frame = new JFrame("Space Invaders - Frankenstein Games"); //novo frame
	Painel painel;
	Teclado teclado;
	static Tela teste = new Tela();
	Image universo = new ImageIcon("./imagens/universotela.JPG").getImage();

	public Tela(Painel painel, Teclado teclado) {
		/*this.painel = painel;
		this.teclado = teclado;*/
		//this.constroitelajogo();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 800, 600);
		this.add(painel);
		this.addKeyListener(teclado);
		this.setVisible(true);
	}

	public Tela() {
	}

	public void run() {
	}

	public static void main(String[] args) {
		teste.constroitelainicial();
	}

	/*public void constroitelajogo() {
		this.addKeyListener(teclado);
		JFrame teste1 = new JFrame();
		teste1.getContentPane().add(painel);
		teste1.setSize(808,650);
		teste1.setVisible(true);
		//frame.getContentPane().remove(paineldesenho);
		//frame.getContentPane().add(painel);
		//frame.getContentPane().repaint();
		//this.setVisible(true);
	}
	
	public void vaitela(Painel painel, Teclado teclado) {
		this.addKeyListener(teclado);
		JFrame teste1 = new JFrame();
		teste1.getContentPane().add(painel);
		teste1.setSize(808,650);
		teste1.setVisible(true);
	}*/

	public void constroitelainicial() {
		Painel painel = new Painel(universo);
		JMenuBar menu = new JMenuBar();

		JMenu menuJogo = new JMenu("Jogo");
		JMenuItem item1 = new JMenuItem("Novo Jogo");
		JMenuItem item2 = new JMenuItem("Pause");
		JMenuItem item3 = new JMenuItem("Ranking");
		JMenuItem item4 = new JMenuItem("Créditos");
		JMenuItem item5 = new JMenuItem("Sair");

		item1.addActionListener(new item1Listener());
		item2.addActionListener(new item2Listener());
		item3.addActionListener(new item3Listener());
		item4.addActionListener(new item4Listener());
		item5.addActionListener(new item5Listener());

		menuJogo.add(item1);
		menuJogo.add(item2);
		menuJogo.addSeparator();
		menuJogo.add(item3);
		menuJogo.addSeparator();
		menuJogo.add(item4);
		menuJogo.addSeparator();
		menuJogo.add(item5);

		menu.add(menuJogo);

		frame.add(painel);

		frame.setJMenuBar(menu);

		frame.setSize(808,650);
		frame.setVisible(true);
	}

	class item1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Jogo game = new Jogo(teste);
			game.start();
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
