package game.spaceinvaders.vue.ennemis;

import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.Controller;
import game.spaceinvaders.model.IMobile;
import processing.core.PImage;
import game.spaceinvaders.vaisseauxGraphiques.AVaisseau;
import game.spaceinvaders.vue.ASprite;

public class SpriteC extends ASprite {
	
	private int cptAnim = 0, offset = 40;
	private boolean fini;
	PImage sprite1, sprite2;
	private long interval = 600;
	private long dateDebut=0;
	private Controller controller;

	public SpriteC(Controller controller, IMobile mobile) {
		super(controller, mobile);
		this.controller = controller;
		sprite1 = controller.loadImage(FileUtils.getImagePath("bonus1.png", getClass()));
		sprite1.resize(40,0);
		sprite2 = controller.loadImage(FileUtils.getImagePath("bonus2.png", getClass()));
		sprite2.resize(40,0);
	}

	@Override
	public void draw() {
		
		int x = mobile.getPosition().getXpix();
		int y = mobile.getPosition().getYpix();

		if(System.currentTimeMillis()- dateDebut > interval)
			fenetre.image((sprite2), x, y);				
		else 
			fenetre.image((sprite1), x, y);			
		if(System.currentTimeMillis()-dateDebut > interval *2)
			dateDebut =  System.currentTimeMillis();
		
	}
	
	@Override
	public void explosion(AVaisseau v){
		int x = v.getPosition().getXpix();
		int y = v.getPosition().getYpix();
		fenetre.image(controller.getLoader().boom[cptAnim], x - offset, y - offset);
		cptAnim++;
		if (cptAnim == controller.getLoader().boom.length) {
			cptAnim = 0;
			v.setFini(true);
		}
	}

	public boolean isFini() {
		return fini;
	}

	@Override
	public void setFini(boolean fini) {
		this.fini = fini;
	}

}