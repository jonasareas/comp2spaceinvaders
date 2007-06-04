package br.ufrj.dcc.comp2.testeprojeto;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

public class TesteMovimento implements ActionListener {

	JFrame frame;
	
	public static void main (String[] args) {
		TesteMovimento teste = new TesteMovimento();
		teste.go();
	}

	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Change Colors");
		button.addActionListener(this);
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		frame.repaint();
	}
}
