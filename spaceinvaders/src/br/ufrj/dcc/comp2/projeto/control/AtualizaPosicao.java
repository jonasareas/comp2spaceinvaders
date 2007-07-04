package br.ufrj.dcc.comp2.projeto.control;

import br.ufrj.dcc.comp2.projeto.model.*;

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

			for (int cont = 0; cont < regras.getTiros().size(); cont++) {
				int i;
				Tiro tiro = regras.getTiros().get(cont);
				
				// Quando tiro chegar fora da tela(por cima), remove da ArrayList
				if (!(tiro.goUp())) {
					regras.getTiros().remove(cont);
				}
				
				// Captura o valor na ArrayList do alien que colidiu.
				for(i=0; i<regras.getAliens().size() && !regras.getAliens().get(i).equals(tiro); i++);
				
				//Remove o alien.
				//Colis�o Tiro-Alien
				if(i<regras.getAliens().size()) {
					System.out.println("Boom!!!");
					regras.getTiros().remove(cont);
					regras.getAliens().remove(i);
					regras.getPontuacao().aumentaponto();
					System.out.println(regras.getPontuacao().getpontuacao());
				}
			}

			if(velocidadeAlien == 3) {
				velocidadeAlien = 0;
				for(int cont=0; cont < regras.getAliens().size(); cont++) {
					
					// int j; S� usado para a colis�o alien-tiro
					
					Alien alien = regras.getAliens().get(cont);
					
					if ( !(alien.goDown()) ) {
						regras.getAliens().remove(cont);
						cont--;
						regras.getPontuacao().diminuiponto();
						System.out.println(regras.getPontuacao().getpontuacao());

					}
				
					/* ISSO SERIA A COLISAO "ALIEN-TIRO", A PRINCIPIO, DESNECESSARIA!!
					//Captura o valor na ArrayList do alien que colidiu.
					for(j=0; j<regras.getTiros().size() && !regras.getTiros().get(j).equals(alien); j++);
					
					//Remove o alien
					//Colis�o Alien-Tiro
					if(j<regras.getTiros().size()) {
						System.out.println("Boom!!!");
						regras.getTiros().remove(j);
						regras.getAliens().remove(cont);
					}*/

					// Se o alien colidiu com nave, remove da Arraylist.
					// Colis�o alien-nave
					if (alien.equals(regras.getNave())) {
						regras.getAliens().remove(cont);
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
