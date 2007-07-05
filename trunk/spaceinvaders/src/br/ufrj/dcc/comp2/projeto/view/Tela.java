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
	Painel painel;
	Teclado teclado;

	private JFrame frame = new JFrame("Space Invaders - Frankenstein Games"); //novo frame
	private Tela telaAtual;
	Image universo = new ImageIcon("./imagens/Abertura.jpg").getImage();

	public Tela(Painel painel, Teclado teclado) {
		/* Coisas comentadas nesta classe foram feitas 
		 * pelo Bola... Pergunte a ele!! =P 
		 * this.painel = painel;
		 * this.teclado = teclado;
		 * this.constroitelajogo();
		 */
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(0, 0, 800, 600);
		this.add(painel);
		this.addKeyListener(teclado);
		this.setResizable(false);
		this.setVisible(true);
	}

	public Tela() {

	}

	public void run() {

	}

	/* Analisar esta bobagem quando for jogar para Panels...
	 * 
	 *  public void constroitelajogo() {
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
	
	public void alteracondicaojanela() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void constroiTelaInicial(Tela teste) {
		telaAtual = teste;

		Painel painel = new Painel(universo);
		JMenuBar menu = new JMenuBar();

		JMenu menuJogo = new JMenu("Jogo");
		JMenuItem item1 = new JMenuItem("Novo Jogo");
		JMenuItem item3 = new JMenuItem("Ranking");
		JMenuItem item4 = new JMenuItem("Cr�ditos");
		JMenuItem item5 = new JMenuItem("Sair");
		
		menuJogo.setDisplayedMnemonicIndex(0);
		menuJogo.setMnemonic('J');
		item1.setDisplayedMnemonicIndex(0);
		item1.setMnemonic('N');
		item3.setDisplayedMnemonicIndex(0);
		item3.setMnemonic('R');
		item4.setDisplayedMnemonicIndex(0);
		item4.setMnemonic('C');
		item5.setDisplayedMnemonicIndex(0);
		item5.setMnemonic('S');
		
		item1.addActionListener(new item1Listener());
		item3.addActionListener(new item3Listener());
		item4.addActionListener(new item4Listener());
		item5.addActionListener(new item5Listener());

		menuJogo.add(item1);
		menuJogo.addSeparator();
		menuJogo.add(item3);
		menuJogo.addSeparator();
		menuJogo.add(item4);
		menuJogo.addSeparator();
		menuJogo.add(item5);

		menu.add(menuJogo);

		frame.add(painel);

		frame.setLocation(100,60);
		frame.setJMenuBar(menu);
		frame.setSize(808,650);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	class item1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Jogo game = new Jogo(telaAtual);
			game.start();
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
