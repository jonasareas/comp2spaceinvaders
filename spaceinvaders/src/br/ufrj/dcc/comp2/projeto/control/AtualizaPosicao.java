package br.ufrj.dcc.comp2.projeto.control;

import javax.swing.JOptionPane;

import br.ufrj.dcc.comp2.projeto.model.Alien;
import br.ufrj.dcc.comp2.projeto.model.Tiro;
import br.ufrj.dcc.comp2.projeto.view.Teclado;

/** 
 * Classe respons�vel por atualizar a posi��o dos objetos na tela.
 * @author Ar�as, J. , Jochem, M. , Lopes, R. , Vianna, F.
 * @version 1.4
 */
public class AtualizaPosicao extends Thread {
	
	/** Novo campo do tipo ControleRegras */
	ControleRegras regras;
	
	/** Campo para uma ref�ncia do tipo teclado. */
	Teclado t;
	
	/** Campo armazendador da quantidade de aliens mortos. */
	private int aliensMortos = 0;
	
	/** Campo para armazenar situa��o da fase inicial. */
	private int fase = 1;

	/**
	 * @param regras Instancia da classe ControleRegras
	 * @param t Instancia da classe Teclado
	 */
	public AtualizaPosicao(ControleRegras regras, Teclado t) {
		super();
		this.regras = regras;
		this.t = t;
	}

	/** 
	* Redefini��o do m�todo run da interface Runnable.
	* @throws InterruptedException
	*/
	public void run() {
		int velocidadeAlien = 0;

		while(!regras.getJogador().getGameover() && !regras.getJogador().getZerou() && !t.getsaiuQ()) {
			if(!t.getPause()) {
				velocidadeAlien++;

				for (int cont = 0; cont < regras.getTiros().size(); cont++) {
					int i;
					Tiro tiro = regras.getTiros().get(cont);

					// Quando tiro chegar fora da tela, remove da ArrayList
					if (!(tiro.goUp())) {
						regras.getTiros().remove(cont);
					}

					// Captura o valor na ArrayList do alien que colidiu.
					for(i=0; i<regras.getAliens().size() && !regras.getAliens().get(i).equals(tiro); i++);

					//Remove o alien.
					//Colis�o Tiro-Alien
					if(i<regras.getAliens().size()) {
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
						if (aliensMortos >= 15) {
							fase++;
							if (fase > 8) {
								regras.getJogador().setZerou(true);
							}
							regras.setFase(fase);
							aliensMortos = 0;
						}
					}
				}

				if(velocidadeAlien == 3) {
					velocidadeAlien = 0;
					for(int cont=0; cont < regras.getAliens().size(); cont++) {

						Alien alien = regras.getAliens().get(cont);

						if ( !(alien.goDown()) ) {
							regras.getAliens().remove(cont);
							cont--;
							if (regras.getPontuacao().getPontuacao() > 0 ) {
								regras.getPontuacao().diminuiPonto();
							} else {
								regras.getJogador().perdeVida();
								if (regras.getJogador().getVida() < 0) {
									regras.getJogador().setGameover(true);
								}
							}

						}

						if (alien.equals(regras.getNave()) && !regras.getNave().isEmExplosao()) {
							regras.getAliens().get(cont).setEmExplosao(true);
							regras.getExplodir().add(regras.getAliens().get(cont));
							regras.getNave().setEmExplosao(true);
							regras.getAliens().remove(cont);
							regras.getJogador().perdeVida();
							if (regras.getJogador().getVida() < 0) {
								regras.getJogador().setGameover(true);
							}
						}
					}
				}

				try {
					AtualizaPosicao.sleep(1000/400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		if (t.getsaiuQ()) {
			regras.getJogador().setGameover(true);
		}
		regras.getJogo().tela.alteracondicaojanela();
		
		if(regras.getJogador().getGameover()) {
			regras.getJogo().painel.pintaGameOver();
		}
		if(regras.getJogador().getZerou()) {
			regras.getJogo().painel.pintaZerou();
		}
		regras.getJogador().setNome(JOptionPane.showInputDialog("Digite seu Nome",""));
		System.out.println(regras.getJogador().getNome());
		regras.getJogo().VerificaScore();
	}


}
