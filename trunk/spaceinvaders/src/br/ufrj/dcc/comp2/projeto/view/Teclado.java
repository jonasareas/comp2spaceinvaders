package br.ufrj.dcc.comp2.projeto.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.ufrj.dcc.comp2.projeto.model.*;

public class Teclado extends Thread implements KeyListener  {
	private boolean left;
	private boolean right;
	private boolean fire;
	private Nave nave;

	public Teclado(Nave nave) {
		super();
		this.nave = nave;
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int tecla = arg0.getKeyCode();
		if (tecla == KeyEvent.VK_LEFT) {
			this.left = true;
		}
		
		if (tecla ==  KeyEvent.VK_RIGHT) {
			this.right = true;
		}
			
		if (tecla == KeyEvent.VK_SPACE) {
			this.fire = true;
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int tecla = arg0.getKeyCode();
		if (tecla == KeyEvent.VK_LEFT) {
			this.left = false;
		}
		
		if (tecla ==  KeyEvent.VK_RIGHT) {
			this.right = false;
		}
			
		if (tecla == KeyEvent.VK_SPACE) {
			this.fire = false;
		}
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		while(true){
			if(fire==true) {
				this.nave.fire();
			}
			if(left==true) {
				this.nave.goLeft();
			}
			if(right==true) {
				this.nave.goRight();
			}
	
			try {
				Teclado.sleep(1000/300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
