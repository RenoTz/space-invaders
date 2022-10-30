package game.spaceinvaders.vue;

import processing.core.PApplet;
import game.spaceinvaders.model.IMobile;

public abstract class ASprite implements IVue {
	protected IMobile mobile;
	protected PApplet fenetre;
	
	public ASprite(PApplet fenetre, IMobile mobile){
		this.fenetre=fenetre;
		this.mobile=mobile;
	}
	
	
}
