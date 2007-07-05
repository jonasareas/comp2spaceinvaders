package br.ufrj.dcc.comp2.projeto.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.ufrj.dcc.comp2.projeto.control.Player;
import br.ufrj.dcc.comp2.projeto.model.Nave;

/** 
 * Classe respons�vel pelo controle do teclado, usando a interface KeyListener
 * @author Ar�as, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.5
*/
public class Teclado extends Thread implements KeyListener  {
	
	/** Campo booleano para saber se a tecla para esquerda foi pressionada. */
	private boolean left;
	
	/** Campo booleano para saber se a tecla para direita foi pressionada. */
	private boolean right;
	
	/** Campo booleano para saber se a tecla para a atirar foi pressionada. */
	private boolean shot;
	
	/** Campo booleano para a situa��o de pause. */
	private boolean pause = false;
	
	private boolean saiuQ = false;
	/* Qualquer coisa comentada nesta classe � com 
	 * rela��o a movimenta��o vertical da nave!!!
	 * private boolean up;
	 * private boolean down;
	 */
	
	/** Campo para refer�ncia do tipo Nave. */
	private Nave nave;
	
	/** Campo para refer�ncia do tipo Player. */
	private Player j;

	/** Campo controlador de velocidade da nave. */
	private int ctrlVelocidade;

	/**
	 * @param nave Instancia da classe Nave
	 * @param j Instancia da class Player
	 */
	public Teclado(Nave nave, Player j) {
		super();
		this.nave = nave;
		ctrlVelocidade = 0;
		this.j = j;
	}

	/**
	 * M�todo respons�vel pela pausa do jogo.
	 * @return Situa��o de pausa.
	 */
	public boolean getPause() {
		return this.pause;
	}
	
	public boolean getsaiuQ() {
		return this.saiuQ;
	}

	/**
	 * M�todo requerido pela interface KeyListener, respons�vel pelas a��es � serem
	 * executadas quando determinada tecla for pressionada.
	 * @param arg KeyEvent
	 */
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

	/**
	 * M�todo requerido pela interface KeyListener, respons�vel pelas a��es � serem
	 * executadas quando determinada tecla for solta.
	 * @param arg KeyEvent
	 */
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
		
		if(tecla == KeyEvent.VK_Q) {
			this.saiuQ = true;
		}
	}

	/**
	 * M�todo requerido pela interface KeyListener, respons�vel pelas a��es � serem
	 * executadas quando determinada tecla for pressionada e solta logo em seguida.
	 * @param arg KeyEvent
	 */
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	/** 
	* Redefini��o do m�todo run da interface Runnable.
	* @throws InterruptedException
	*/
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
