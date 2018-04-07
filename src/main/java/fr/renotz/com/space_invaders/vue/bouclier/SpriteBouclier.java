package fr.renotz.com.space_invaders.vue.bouclier;

import fr.renotz.com.space_invaders.modele.IMobile;
import fr.renotz.com.space_invaders.vaisseauxGraphiques.AVaisseau;
import fr.renotz.com.space_invaders.vue.ASprite;
import processing.core.PApplet;
import processing.core.PImage;

public class SpriteBouclier extends ASprite{

	PImage spriteBouclier;
	public static boolean fini = true;
	
	public SpriteBouclier(PApplet fenetre, IMobile mobile) {
		super(fenetre, mobile);
		spriteBouclier = fenetre.loadImage("../images/brique2.png");
		spriteBouclier.resize(10,0);		
	}

	@Override
	public void dessiner() {

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
	
}
