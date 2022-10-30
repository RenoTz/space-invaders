package game.spaceinvaders.vueTirs.joueur;

import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.utils.FileUtils;
import processing.core.PApplet;
import game.spaceinvaders.vueTirs.TSprite;


public class vueTirJoueur1 extends TSprite{

	int Jwidth = 10, Jheight = 8;

	public vueTirJoueur1(PApplet fenetre, ITirs tir) {
		super(fenetre, tir);

		JspriteTir = fenetre.loadImage(FileUtils.getImagePath("boule.png", getClass()));
		JspriteTir.resize(10, 0);
	}	

	@Override
	public void draw() {

		int x = tir.getPosition().getXpix() - Jwidth;
		int y = tir.getPosition().getYpix() - Jheight;
		
		fenetre.image((JspriteTir), x, y);
		
	}

}
