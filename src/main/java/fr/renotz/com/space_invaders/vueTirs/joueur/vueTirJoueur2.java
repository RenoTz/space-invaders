package fr.renotz.com.space_invaders.vueTirs.joueur;

import fr.renotz.com.space_invaders.tirs.ITirs;
import fr.renotz.com.space_invaders.vueTirs.TSprite;
import processing.core.PApplet;

public class vueTirJoueur2 extends TSprite{
	
	int Jheight = 20, Jwidth = 10;
	
	public vueTirJoueur2(PApplet fenetre, ITirs tir) {
		super(fenetre, tir);
		
		JspriteTir = fenetre.loadImage("../images/Missile.png");
	}	

	@Override
	public void dessiner() {

		int x = tir.getPosition().getXpix() - Jwidth;
		int y = tir.getPosition().getYpix() - Jheight;
		
		fenetre.image((JspriteTir), x, y);
		
	}	

}
