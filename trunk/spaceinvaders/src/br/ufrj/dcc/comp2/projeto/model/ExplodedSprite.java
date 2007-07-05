package br.ufrj.dcc.comp2.projeto.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ExplodedSprite extends Sprite {
	private boolean emExplosao;
	protected Image[] vector = new Image[19];
	protected int posVetor;

	public ExplodedSprite(String file) {
		super(file);
		this.emExplosao = false;
		this.posVetor = -1;

		try {
			vector[0] = ImageIO.read(new File("./imagens/explosao/img1.gif"));
			vector[1] = ImageIO.read(new File("./imagens/explosao/img2.gif"));
			vector[2] = ImageIO.read(new File("./imagens/explosao/img3.gif"));
			vector[3] = ImageIO.read(new File("./imagens/explosao/img4.gif"));
			vector[4] = ImageIO.read(new File("./imagens/explosao/img5.gif"));
			vector[5] = ImageIO.read(new File("./imagens/explosao/img6.gif"));
			vector[6] = ImageIO.read(new File("./imagens/explosao/img7.gif"));
			vector[7] = ImageIO.read(new File("./imagens/explosao/img8.gif"));
			vector[8] = ImageIO.read(new File("./imagens/explosao/img9.gif"));
			vector[9] = ImageIO.read(new File("./imagens/explosao/img10.gif"));
			vector[10] = ImageIO.read(new File("./imagens/explosao/img9.gif"));
			vector[11] = ImageIO.read(new File("./imagens/explosao/img8.gif"));
			vector[12] = ImageIO.read(new File("./imagens/explosao/img7.gif"));
			vector[13] = ImageIO.read(new File("./imagens/explosao/img6.gif"));
			vector[14] = ImageIO.read(new File("./imagens/explosao/img5.gif"));
			vector[15] = ImageIO.read(new File("./imagens/explosao/img4.gif"));
			vector[16] = ImageIO.read(new File("./imagens/explosao/img3.gif"));
			vector[17] = ImageIO.read(new File("./imagens/explosao/img2.gif"));
			vector[18] = ImageIO.read(new File("./imagens/explosao/img1.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void anima() {
		this.posVetor++;
		if(this.posVetor==this.vector.length) {
			setEmExplosao(false);
		}
		if(this.posVetor<this.vector.length) {
			this.setImagem(this.vector[posVetor]);
		}
	}

	public boolean isEmExplosao() {
		return emExplosao;
	}

	public void setEmExplosao(boolean emExplosao) {
		this.emExplosao = emExplosao;
	}

}