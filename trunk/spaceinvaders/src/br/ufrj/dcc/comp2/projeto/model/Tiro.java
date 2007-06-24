package br.ufrj.dcc.comp2.projeto.model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tiro extends Sprite {
	

	
	public Tiro(int x, int y) {
		try {
			imagem = ImageIO.read(new File("imagens/tiro.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.x = x-this.getImagem().getWidth(null);
		this.y = y-this.getImagem().getHeight(null);
		
	}

	public void goUp() {
		this.y -= 1;
	}
}
