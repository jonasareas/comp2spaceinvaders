package br.ufrj.dcc.comp2.projeto.control;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Anima extends Thread {
	private ControleRegras regras;

	public Anima(ControleRegras regras) {
		this.regras = regras;
	}

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
