package br.ufrj.dcc.comp2.projeto.control;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/** 
 * Classe responsável pela atualização das explosões do jogo. 
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.4
*/
public class Anima extends Thread {
	
	/** Campo para uma referência do tipo ControleRegras. */
	private ControleRegras regras;

	/**
	 * @param regras Instancia da classe ControleRegras
	 */
	public Anima(ControleRegras regras) {
		this.regras = regras;
	}

	/** 
	* Redefinição do método run da interface Runnable.
	* @throws IOException
	*/
	public void run() {
		while(true) {
			for(int i=0;i<regras.getExplodir().size();i++) {
				if(!regras.getExplodir().get(i).isEmExplosao()) {
					regras.getExplodir().remove(i);
				} else {
					regras.getExplodir().get(i).anima();
				}
			}

			if(regras.getNave().isEmExplosao()) {
				regras.getNave().animaNave();
			} else {
				try {
					regras.getNave().setImagem(ImageIO.read(new File("./imagens/Nave.gif")));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


			try {
				Anima.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
