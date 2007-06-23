package br.ufrj.dcc.comp2.testeprojeto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaMenu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static TelaMenu teste = new TelaMenu();
	JFrame frame = new JFrame("Space Invaders Boladão 0.0.0.0.1 - Frankenstein Games"); //novo frame
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		teste.constroitela();
	}
	
	public void constroitela() {
		JMenuBar menu = new JMenuBar(); //cria o JMenuBar. O menu fica dentro de JMenubar.
		
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
		
		frame.setJMenuBar(menu);
		
		frame.setSize(800,600);
		frame.setVisible(true);
		
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
			TelaRanking telaRank = new TelaRanking();
			telaRank.constroiTela();
		}
	}
	
	class item4Listener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			TelaCreditos telaCred = new TelaCreditos();
			telaCred.constroiTela();
		}
	}
	
	class item5Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}

}
