package fr.renotz.com.space_invaders.vueTirs.joueur;

import fr.renotz.com.space_invaders.tirs.ITirs;
import fr.renotz.com.space_invaders.vueTirs.TSprite;
import processing.core.PApplet;


public class vueTirJoueur1 extends TSprite{

	int Jwidth = 10, Jheight = 8;

	public vueTirJoueur1(PApplet fenetre, ITirs tir) {
		super(fenetre, tir);

		JspriteTir = fenetre.loadImage("../images/boule.png");
		JspriteTir.resize(10, 0);
	}	

	@Override
	public void dessiner() {

		int x = tir.getPosition().getXpix() - Jwidth;
		int y = tir.getPosition().getYpix() - Jheight;
		
		fenetre.image((JspriteTir), x, y);
		
	}

}
