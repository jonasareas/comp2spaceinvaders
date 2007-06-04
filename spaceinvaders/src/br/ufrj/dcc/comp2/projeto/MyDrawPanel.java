package br.ufrj.dcc.comp2.projeto;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			
			Color cor = new Color(red,green,blue); 
			g.setColor(cor);
			g.fillOval(70, 70, 100, 100);
		}
}
