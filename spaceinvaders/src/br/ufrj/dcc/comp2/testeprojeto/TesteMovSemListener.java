package br.ufrj.dcc.comp2.testeprojeto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TesteMovSemListener {
	
	int x = 70;
	int y = 70;
	
	public static void main (String[] args) {
		TesteMovSemListener teste = new TesteMovSemListener();
		teste.go();
	}

	private void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PainelDesenho painel = new PainelDesenho();
		
		frame.getContentPane().add(painel);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		for (int i = 0; i < 80; i++) {
			x++;
			y++;
			
			painel.repaint();
			
			try {
				Thread.sleep(10);
			} catch (Exception ex) { }
		}
		
	}
	
	class PainelDesenho extends JPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		Image nave = new ImageIcon("./imagens/nave.JPG").getImage();		

		public void paintComponent(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());			
			
			g.drawImage(nave, x, y, this);
		}
	}

}
