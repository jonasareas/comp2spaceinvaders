package br.ufrj.dcc.comp2.testeprojeto;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class TesteNave extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static JFrame frame;

	public static void main(String[] args) {
		
		TesteNave t = new TesteNave();
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER, t);	
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.repaint();

	}
	public void paintComponent(Graphics g) {
	
		Image nave = new ImageIcon("nave.JPG").getImage();
		
		g.drawImage(nave, 100, 100, this);

	}

}
