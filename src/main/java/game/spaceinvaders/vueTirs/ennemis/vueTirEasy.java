package game.spaceinvaders.vueTirs.ennemis;

import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.utils.FileUtils;
import processing.core.PApplet;
import game.spaceinvaders.vueTirs.TSprite;

public class vueTirEasy extends TSprite {

	
	public vueTirEasy(PApplet fenetre, ITirs tir, int couleur) {
		super(fenetre, tir);
		JspriteTir = fenetre.loadImage(FileUtils.getImagePath("missile1.png", getClass()));
		JspriteTir.resize(10, 0);
	}

	@Override
	public void draw() {
		
		int x = tir.getPosition().getXpix();
		int y = tir.getPosition().getYpix();
		
		fenetre.image((JspriteTir), x, y);	
		
	}

}
