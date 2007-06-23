package br.ufrj.dcc.comp2.projeto.control;

public class AtualizaPosicao extends Thread {
	ControleRegras regras;

	public AtualizaPosicao(ControleRegras regras) {
		super();
		this.regras = regras;
	}

	public void run() {
		while(true) {
			if(regras.getTiro() != null)
				regras.getTiro().goUp();
			
			try {
				AtualizaPosicao.sleep(1000/400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
