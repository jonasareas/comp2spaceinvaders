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
				//Colisão Tiro-Alien
				if(i<regras.getAliens().size()) {
					System.out.println("Boom!!!");
					regras.getTiros().remove(cont);
					regras.getAliens().remove(i);
					regras.getPontuacao().aumentaPonto();
					if (regras.getPontuacao().getPontuacaoAcumulada() >= 500) {
						regras.getJogador().ganhaVida();
						regras.getPontuacao().zeraPontuacaoAcumulada();
					}
					System.out.println(regras.getPontuacao().getPontuacao());
				}
			}

			if(velocidadeAlien == 3) {
				velocidadeAlien = 0;
				for(int cont=0; cont < regras.getAliens().size(); cont++) {
					
					// int j; Só usado para a colisão alien-tiro
					
					Alien alien = regras.getAliens().get(cont);
					
					if ( !(alien.goDown()) ) {
						regras.getAliens().remove(cont);
						cont--;
						if (regras.getPontuacao().getPontuacao() > 0 ) {
							regras.getPontuacao().diminuiPonto();
						} else {
							regras.getJogador().perdeVida();
							System.out.println(regras.getJogador().getVida());
						}
						
						System.out.println(regras.getPontuacao().getPontuacao());

					}
				
					/* ISSO SERIA A COLISAO "ALIEN-TIRO", A PRINCIPIO, DESNECESSARIA!!
					//Captura o valor na ArrayList do alien que colidiu.
					for(j=0; j<regras.getTiros().size() && !regras.getTiros().get(j).equals(alien); j++);
					
					//Remove o alien
					//Colisão Alien-Tiro
					if(j<regras.getTiros().size()) {
						System.out.println("Boom!!!");
						regras.getTiros().remove(j);
						regras.getAliens().remove(cont);
					}*/

					// Se o alien colidiu com nave, remove da Arraylist.
					// Colisão alien-nave
					if (alien.equals(regras.getNave())) {
						regras.getAliens().remove(cont);
						regras.getJogador().perdeVida();
						System.out.println(regras.getJogador().getVida());
					}
				}
			}

			try {
				AtualizaPosicao.sleep(1000/400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
