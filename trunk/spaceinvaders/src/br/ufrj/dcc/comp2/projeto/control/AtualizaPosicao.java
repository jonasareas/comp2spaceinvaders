package br.ufrj.dcc.comp2.projeto.control;

import java.util.Iterator;

import br.ufrj.dcc.comp2.projeto.model.Tiro;

public class AtualizaPosicao extends Thread {
	ControleRegras regras;

	public AtualizaPosicao(ControleRegras regras) {
		super();
		this.regras = regras;
	}

	public void run() {
		while(true) {
			Iterator<Tiro> it = regras.getTiros().iterator();
			while (it.hasNext()){
				Tiro tiro = it.next();
				if ( !(tiro.goUp()) ) {
					/*System.out.println("Destruído! " + tiro.getImagem().getHeight(null));
					System.out.println("Destruído! " + tiro.getY());*/
					it.remove();
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
