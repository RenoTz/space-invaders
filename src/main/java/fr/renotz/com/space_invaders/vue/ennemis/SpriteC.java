package fr.renotz.com.space_invaders.vue.ennemis;

import fr.renotz.com.space_invaders.controleur.Loader;
import fr.renotz.com.space_invaders.modele.IMobile;
import fr.renotz.com.space_invaders.vaisseauxGraphiques.AVaisseau;
import fr.renotz.com.space_invaders.vue.ASprite;
import processing.core.PApplet;
import processing.core.PImage;

public class SpriteC extends ASprite {
	
	private int cptAnim = 0, decalage = 40;
	private boolean fini = false;
	PImage sprite1, sprite2;
	private long intervalle = 600;
	private long dateDebut=0;

	public SpriteC(PApplet fenetre, IMobile mobile) {
		super(fenetre, mobile);
		sprite1 = fenetre.loadImage("../images/bonus1.png");
		sprite1.resize(40,0);
		sprite2 = fenetre.loadImage("../images/bonus2.png");
		sprite2.resize(40,0);
	}

	@Override
	public void dessiner() {
		
		int x = mobile.getPosition().getXpix();
		int y = mobile.getPosition().getYpix();

		if(System.currentTimeMillis()- dateDebut > intervalle)
			fenetre.image((sprite2), x, y);				
		else 
			fenetre.image((sprite1), x, y);			
		if(System.currentTimeMillis()-dateDebut > intervalle*2)
			dateDebut =  System.currentTimeMillis();
		
	}
	
	@Override
	public void explosion(AVaisseau v){
		
		
		int x = v.getPosition().getXpix();
		int y = v.getPosition().getYpix();
		
		fenetre.image((Loader.boom[cptAnim]), x - decalage , y - decalage);
		
		cptAnim++;
		if(cptAnim == Loader.boom.length){
			fini = true;
		}	
	}

	public boolean isFini() {
		return fini;
	}
	
}