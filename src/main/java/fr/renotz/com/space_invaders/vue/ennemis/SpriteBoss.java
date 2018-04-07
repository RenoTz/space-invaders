package fr.renotz.com.space_invaders.vue.ennemis;

import fr.renotz.com.space_invaders.controleur.Loader;
import fr.renotz.com.space_invaders.modele.IMobile;
import fr.renotz.com.space_invaders.vaisseauxGraphiques.AVaisseau;
import fr.renotz.com.space_invaders.vue.ASprite;
import processing.core.PApplet;
import processing.core.PImage;

public class SpriteBoss extends ASprite{
	
	private int cptAnim = 0,decalage = 20;
	PImage spriteBoss;
	private boolean fini = false;
	
	public SpriteBoss(PApplet fenetre, IMobile mobile) {
		super(fenetre, mobile);
		spriteBoss = fenetre.loadImage("../images/boss.png");
		spriteBoss.resize(250,0);
		
	}

	@Override
	public void dessiner() {

		int x = mobile.getPosition().getXpix();
		int y = mobile.getPosition().getYpix();

		fenetre.image((spriteBoss), x, y);			
		
	}
	
	@Override
	public void explosion(AVaisseau v){
		
		
		int x = v.getPosition().getXpix();
		int y = v.getPosition().getYpix();
		
		Loader.boom[cptAnim].resize(250,0);
		fenetre.image((Loader.boom[cptAnim]), x , y - decalage);
		
		cptAnim++;
		
		if(cptAnim == Loader.boom.length){
			cptAnim = 0;
			fini = true;
		}
		
	}

	public boolean isFini() {
		return fini;
	}

}
