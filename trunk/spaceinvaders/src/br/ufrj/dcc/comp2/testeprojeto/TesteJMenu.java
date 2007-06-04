package br.ufrj.dcc.comp2.testeprojeto;
import javax.swing.*;

public class TesteJMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TesteJMenu.constroitela();
	}
	
	public static void constroitela() {
		JFrame frame = new JFrame(); //novo frame
		
		JMenuBar menu = new JMenuBar(); //cria o JMenuBar. O menu fica dentro de JMenubar.
		
		JMenu menuJogo = new JMenu("Jogo"); //novo menu
		JMenuItem item1 = new JMenuItem("Novo Jogo"); //novo item de menu
		JMenuItem item2 = new JMenuItem("Pause"); //novo item de menu
		JMenuItem item3 = new JMenuItem("Ranking");
		JMenuItem item4 = new JMenuItem("-------");
		JMenuItem item5 = new JMenuItem("Créditos");
		JMenuItem item6 = new JMenuItem("-------");
		JMenuItem item7 = new JMenuItem("Sair");
		
		JMenu menuCred = new JMenu("Créditos");
		
		JMenu menuSair = new JMenu("Sair");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para fechar ao clicar em X
					
		menuJogo.add(item1);
		menuJogo.add(item2);
		menuJogo.add(item3);
		menuJogo.add(item4);
		menuJogo.add(item5);
		menuJogo.add(item6);
		menuJogo.add(item7);
		
		menu.add(menuJogo);
		menu.add(menuCred);
		menu.add(menuSair);
		
		frame.setJMenuBar(menu);
		
		//menu.setSize(50,50);
		
		frame.setSize(300,300);
		frame.setVisible(true);
	}

}
