package fr.renotz.com.space_invaders.vueTirs.ennemis;

import fr.renotz.com.space_invaders.tirs.ITirs;
import fr.renotz.com.space_invaders.vueTirs.TSprite;
import processing.core.PApplet;

public class vueTirNormal extends TSprite {
	
	public vueTirNormal(PApplet fenetre, ITirs tir) {
		super(fenetre, tir);
		JspriteTir = fenetre.loadImage("../images/missile1.png");
		JspriteTir.resize(20, 0);
		
	}

	@Override
	public void dessiner() {

		int x = tir.getPosition().getXpix() - 10;
		int y = tir.getPosition().getYpix();
		
		fenetre.image((JspriteTir), x, y - 10);
		
	}

}
