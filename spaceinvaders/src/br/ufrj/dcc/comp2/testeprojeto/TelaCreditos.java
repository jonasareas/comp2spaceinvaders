package br.ufrj.dcc.comp2.testeprojeto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaCreditos {

	/**
	 * @param args
	 */
	JFrame frame = new JFrame("Créditos");
	public void constroiTela() {
				JButton botao_Fechar = new JButton("Fechar");
		
		frame.getContentPane().add(BorderLayout.SOUTH, botao_Fechar);
		botao_Fechar.addActionListener(new botao_Fechar_Listener());
		
		frame.setSize(200,200);
		frame.setVisible(true);
		
		frame.setSize(200,200);
		frame.setVisible(true);
	}
	class botao_Fechar_Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.setVisible(false);
			frame.dispose();
		}
	}
}
