package fr.renotz.com.space_invaders.vue;

import fr.renotz.com.space_invaders.modele.IMobile;
import processing.core.PApplet;

public abstract class ASprite implements IVue {
	protected IMobile mobile;
	protected PApplet fenetre;
	
	public ASprite(PApplet fenetre, IMobile mobile){
		this.fenetre=fenetre;
		this.mobile=mobile;
	}
	
	
}
