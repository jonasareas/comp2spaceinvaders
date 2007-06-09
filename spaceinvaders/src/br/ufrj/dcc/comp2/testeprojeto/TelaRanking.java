package br.ufrj.dcc.comp2.testeprojeto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRanking{

	JFrame frame = new JFrame("Ranking");
	/**
	 * @param args
	 */

	public void constroiTela() {
		JButton botao_Fechar = new JButton("Fechar");

		frame.getContentPane().add(BorderLayout.SOUTH, botao_Fechar);
		botao_Fechar.addActionListener(new botao_Fechar_Listener());

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
