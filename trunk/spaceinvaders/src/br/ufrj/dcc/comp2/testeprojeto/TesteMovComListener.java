package br.ufrj.dcc.comp2.testeprojeto;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class TesteMovComListener implements KeyListener {
	
	static TesteMovComListener teste = new TesteMovComListener();
	
	JFrame frame = new JFrame();
	
    JTextField typingArea;
	
	int x = 70;
	int y = 70;
	
	public static void main (String[] args) {
		teste.goEsq();
	}

	private void goEsq() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PainelDesenho painel = new PainelDesenho();
		
		frame.getContentPane().add(painel);
		
        typingArea = new JTextField(20);
        typingArea.addKeyListener(this);
        
        painel.add(typingArea, BorderLayout.PAGE_START);
        
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		x -= 3;
			
		painel.repaint();
			
		try {
			Thread.sleep(10);
		} catch (Exception ex) { }
		
	}
	
	private void goDir() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PainelDesenho painel = new PainelDesenho();
		
		frame.getContentPane().add(painel);
		
        typingArea = new JTextField(20);
        typingArea.addKeyListener(this);
        
        painel.add(typingArea, BorderLayout.PAGE_START);
        
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		x += 3;
			
		painel.repaint();
			
		try {
			Thread.sleep(10);
		} catch (Exception ex) { }
		
	}
	

	class PainelDesenho extends JPanel {

		private static final long serialVersionUID = 1L;
		
		Image nave = new ImageIcon("./imagens/nave.JPG").getImage();		

		public void paintComponent(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());			
			
			g.drawImage(nave, x, y, this);
		}
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int tecla = e.getKeyCode();
		if (tecla == 37) {
			teste.goEsq();
		} else {
			if (tecla == 39) {
				teste.goDir();
			}
		}
			 
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}