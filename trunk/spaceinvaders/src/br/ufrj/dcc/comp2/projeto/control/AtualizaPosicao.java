package br.ufrj.dcc.comp2.projeto.control;

import br.ufrj.dcc.comp2.projeto.model.*;
import br.ufrj.dcc.comp2.projeto.view.Teclado;

/** 
 * Classe responsável por atualizar a posição dos objetos na tela.
 * @author Arêas, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.0
*/
public class AtualizaPosicao extends Thread {
	ControleRegras regras;
	Teclado t;
	private int aliensMortos = 0;
	private int fase = 1;
	
	public AtualizaPosicao(ControleRegras regras, Teclado t) {
		super();
		this.regras = regras;
		this.t = t;
	}

	public void run() {
		int velocidadeAlien = 0;
		
		while(!regras.getJogador().situacaogameover()) {
			if(!t.getPause()) {
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
						regras.getAliens().get(i).setEmExplosao(true);
						regras.getExplodir().add(regras.getAliens().get(i));
						regras.getTiros().remove(cont);
						regras.getAliens().remove(i);
						regras.getPontuacao().aumentaPonto();
						if (regras.getPontuacao().getPontuacaoAcumulada() >= 1000) {
							regras.getJogador().ganhaVida();
							regras.getPontuacao().zeraPontuacaoAcumulada();
						}
						aliensMortos++;
						System.out.println(aliensMortos);
						if (aliensMortos >= 50) {
							fase++;
							System.out.println("fase atual: " + fase);
							regras.setFase(fase);
							aliensMortos = 0;
						}
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
								if (regras.getJogador().getVida() < 0) {
									regras.getJogador().gameover();
								}
							}
	
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
						if (alien.equals(regras.getNave()) && !regras.getNave().isEmExplosao()) {
							System.out.println("Boom!!!");
							regras.getAliens().get(cont).setEmExplosao(true);
							regras.getExplodir().add(regras.getAliens().get(cont));
							regras.getNave().setEmExplosao(true);
							regras.getAliens().remove(cont);
							regras.getJogador().perdeVida();
							if (regras.getJogador().getVida() < 0) {
								regras.getJogador().gameover();
							}
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
		
		regras.getJogo().VerificaScore();
		
		regras.getJogo().teclado.stop();
		regras.getJogo().repintor.stop();
		regras.getJogo().regras.stop();
		regras.getJogo().animador.stop();
		
//		Aqui tem que ficar as coisas de tela de game over e sumir a tela de jogo.
		
		
	}
	

}
