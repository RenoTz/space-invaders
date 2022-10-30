package game.spaceinvaders.vueTirs.ennemis;

import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.utils.FileUtils;
import processing.core.PApplet;
import game.spaceinvaders.vueTirs.TSprite;

public class vueTirBoss2 extends TSprite {

	public vueTirBoss2(PApplet fenetre, ITirs tir) {
		super(fenetre, tir);
		JspriteTir = fenetre.loadImage(FileUtils.getImagePath("tirBoss.png", getClass()));
		JspriteTir.resize(20, 0);			
	}

	@Override
	public void draw() {

		int x = tir.getPosition().getXpix() - 10;
		int y = tir.getPosition().getYpix();
		
		fenetre.image((JspriteTir), x, y - 10);
		
	}

}
