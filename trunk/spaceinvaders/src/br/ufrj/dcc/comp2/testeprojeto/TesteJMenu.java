package br.ufrj.dcc.comp2.testeprojeto;
import javax.swing.*;
import java.awt.event.*;

public class TesteJMenu implements ActionListener{

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
		JMenuItem item5 = new JMenuItem("Créditos");
		JMenuItem item7 = new JMenuItem("Sair");
		
		JMenu menuCred = new JMenu("Créditos");
		
		JMenu menuSair = new JMenu("Sair");
		
		item3.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para fechar ao clicar em X
					
		menuJogo.add(item1);
		menuJogo.add(item2);
		menuJogo.add(item3);
		menuJogo.addSeparator();
		menuJogo.add(item5);
		menuJogo.addSeparator();
		menuJogo.add(item7);
		
		menu.add(menuJogo);
		menu.add(menuCred);
		menu.add(menuSair);
		
		frame.setJMenuBar(menu);
		
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		JFrame novoFrame = new JFrame();
		novoFrame.setSize(100,100);
		novoFrame.setVisible(true);
		
	}

}
