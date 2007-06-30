package br.ufrj.dcc.comp2.projeto.control;

import java.util.Iterator;

import br.ufrj.dcc.comp2.projeto.model.Alien;
import br.ufrj.dcc.comp2.projeto.model.Tiro;

public class AtualizaPosicao extends Thread {
	ControleRegras regras;

	public AtualizaPosicao(ControleRegras regras) {
		super();
		this.regras = regras;
	}

	public void run() {
		int velocidadeAlien = 0;
		
		while(true) {
			velocidadeAlien++;
			
			Iterator<Tiro> it = regras.getTiros().iterator();
			while (it.hasNext()){
				Tiro tiro = it.next();
				if ( !(tiro.goUp()) ) {
					/*System.out.println("Destruído! " + tiro.getImagem().getHeight(null));
					System.out.println("Destruído! " + tiro.getY());*/
					it.remove();
				}
				
				int i;
				for(i=0; i<regras.getAliens().size() && !regras.getAliens().get(i).equals(tiro); i++);
				if(i<regras.getAliens().size()) {
					System.out.println("Boom!!!");
					it.remove();
					regras.getAliens().remove(i);
				}
			}
			
			if(velocidadeAlien == 2) {
				velocidadeAlien = 0;

				Iterator<Alien> itA = regras.getAliens().iterator();
				while (itA.hasNext()){
					Alien alien = itA.next();
					if ( !(alien.goDown()) ) {
						/*System.out.println("Destruído! " + tiro.getImagem().getHeight(null));
						System.out.println("Destruído! " + tiro.getY());*/
						itA.remove();
					}
				}
			}
			
			try {
				AtualizaPosicao.sleep(1000/600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
