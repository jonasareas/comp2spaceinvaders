package br.ufrj.dcc.comp2.projeto.control;

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
			
			try {
				Anima.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
