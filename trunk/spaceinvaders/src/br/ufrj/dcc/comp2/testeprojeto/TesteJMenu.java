package br.ufrj.dcc.comp2.testeprojeto;
import javax.swing.*;
import java.awt.event.*;

public class TesteJMenu{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TesteJMenu teste = new TesteJMenu();
		teste.constroitela();
	}
	
	public void constroitela() {
		JFrame frame = new JFrame(); //novo frame
		
		JMenuBar menu = new JMenuBar(); //cria o JMenuBar. O menu fica dentro de JMenubar.
		
		JMenu menuJogo = new JMenu("Jogo"); //novo menu
		JMenuItem item1 = new JMenuItem("Novo Jogo"); //novo item de menu
		JMenuItem item2 = new JMenuItem("Pause"); //novo item de menu
		JMenuItem item3 = new JMenuItem("Ranking");
		JMenuItem item4 = new JMenuItem("Créditos");
		JMenuItem item5 = new JMenuItem("Sair");
		
		JMenu menuCred = new JMenu("Créditos");
		
		JMenu menuSair = new JMenu("Sair");
		
		item1.addActionListener(new item1Listener());
		item2.addActionListener(new item2Listener());
		item3.addActionListener(new item3Listener());
		item4.addActionListener(new item4Listener());
		item5.addActionListener(new item5Listener());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para fechar ao clicar em X
					
		menuJogo.add(item1);
		menuJogo.add(item2);
		menuJogo.add(item3);
		menuJogo.addSeparator();
		menuJogo.add(item4);
		menuJogo.addSeparator();
		menuJogo.add(item5);
		
		menu.add(menuJogo);
		menu.add(menuCred);
		menu.add(menuSair);
		
		frame.setJMenuBar(menu);
		
		frame.setSize(300,300);
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
			System.out.println("Ranking");
		}
	}
	
	class item4Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Créditos");
		}
	}
	
	class item5Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Sair");
		}
	}
	
	/*
	 * Morre para entrar no lugar os 5 listeners diferentes.
	public void actionPerformed(ActionEvent event) {
		JFrame novoFrame = new JFrame();
		novoFrame.setSize(100,100);
		novoFrame.setVisible(true);
	}
	*/

}
