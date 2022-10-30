package game.spaceinvaders.vue.bouclier;

import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.model.IMobile;
import processing.core.PApplet;
import processing.core.PImage;
import game.spaceinvaders.vaisseauxGraphiques.AVaisseau;
import game.spaceinvaders.vue.ASprite;

public class SpriteBouclier extends ASprite{

	PImage spriteBouclier;
	public boolean fini;
	
	public SpriteBouclier(PApplet fenetre, IMobile mobile) {
		super(fenetre, mobile);
		spriteBouclier = fenetre.loadImage(FileUtils.getImagePath("brique2.png", getClass()));
		spriteBouclier.resize(10,0);		
	}

	@Override
	public void draw() {
		int x = mobile.getPosition().getXpix();
		int y = mobile.getPosition().getYpix();		
		fenetre.image((spriteBouclier), x, y);
	}

	@Override
	public void explosion(AVaisseau v) {		
		
	}

	public boolean isFini() {
		return fini;
	}

	@Override
	public void setFini(boolean fini) {
		this.fini = fini;
	}

}
