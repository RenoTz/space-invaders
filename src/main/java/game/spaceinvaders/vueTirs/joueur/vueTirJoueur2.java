package game.spaceinvaders.vueTirs.joueur;

import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.utils.FileUtils;
import processing.core.PApplet;
import game.spaceinvaders.vueTirs.TSprite;

public class vueTirJoueur2 extends TSprite{
	
	int Jheight = 20, Jwidth = 10;
	
	public vueTirJoueur2(PApplet fenetre, ITirs tir) {
		super(fenetre, tir);
		
		JspriteTir = fenetre.loadImage(FileUtils.getImagePath("missile.png", getClass()));
	}	

	@Override
	public void draw() {

		int x = tir.getPosition().getXpix() - Jwidth;
		int y = tir.getPosition().getYpix() - Jheight;
		
		fenetre.image((JspriteTir), x, y);
		
	}	

}
