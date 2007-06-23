package br.ufrj.dcc.comp2.projeto.view;

import javax.swing.JFrame;

public class Tela extends JFrame {
	private static final long serialVersionUID = 1L;

	public Tela(Painel painel, Teclado teclado) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 800, 600);
		this.add(painel);
		this.addKeyListener(teclado);
		this.setVisible(true);
	}
	
}