package br.ufrj.dcc.comp2.projeto.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.ufrj.dcc.comp2.projeto.control.Player;
import br.ufrj.dcc.comp2.projeto.model.Nave;

public class Teclado extends Thread implements KeyListener  {
	private boolean left;
	private boolean right;
	private boolean shot;
	private boolean pause = false;
	/* Qualquer coisa comentada nesta classe é com 
	 * relação a movimentação vertical da nave!!!
	 * private boolean up;
	 * private boolean down;
	 */
	private Nave nave;
	private Player j;

	private int ctrlVelocidade;

	public Teclado(Nave nave, Player j) {
		super();
		this.nave = nave;
		ctrlVelocidade = 0;
		this.j = j;
	}

	public boolean getPause() {
		return this.pause;
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
		/*if (tecla ==  KeyEvent.VK_UP) {
			this.up = true;
		}
		if (tecla ==  KeyEvent.VK_DOWN) {
			this.down = true;
		}*/
		if (tecla == KeyEvent.VK_SPACE && !this.shot) {
			this.shot = true;
			ctrlVelocidade=60;
		}		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int tecla = arg0.getKeyCode();
		
		if(tecla == KeyEvent.VK_LEFT) {
			this.left = false;
		}
		
		if(tecla ==  KeyEvent.VK_RIGHT) {
			this.right = false;
		}
		/*if (tecla ==  KeyEvent.VK_UP) {
			this.up = false;
		}
		if (tecla ==  KeyEvent.VK_DOWN) {
			this.down = false;
		}*/
		if(tecla == KeyEvent.VK_SPACE) {
			this.shot = false;
		}
		
		if(tecla == KeyEvent.VK_P) {
			this.pause = !this.pause;
		}
  	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void run() {
		while(!j.getGameover()){
			if(!pause) {
				if(left) {
					this.nave.goLeft();
				}
				if(right) {
					this.nave.goRight();
				}
				/*if(up) {
					this.nave.goUp();
				}
				if(down) {
					this.nave.goDown();
				}*/
				if(shot) {
					if(ctrlVelocidade==60) {
						this.nave.fire();
						ctrlVelocidade=0;
					}
					ctrlVelocidade++;
				}
		
				try {
					Teclado.sleep(1000/200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
