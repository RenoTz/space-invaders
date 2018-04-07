package fr.renotz.com.space_invaders.vueTirs.ennemis;

import fr.renotz.com.space_invaders.tirs.ITirs;
import fr.renotz.com.space_invaders.vueTirs.TSprite;
import processing.core.PApplet;

public class vueTirEasy extends TSprite {

	
	public vueTirEasy(PApplet fenetre, ITirs tir, int couleur) {
		super(fenetre, tir);
		JspriteTir = fenetre.loadImage("../images/missile1.png");
		JspriteTir.resize(10, 0);
	}

	@Override
	public void dessiner() {
		
		int x = tir.getPosition().getXpix();
		int y = tir.getPosition().getYpix();
		
		fenetre.image((JspriteTir), x, y);	
		
	}

}
