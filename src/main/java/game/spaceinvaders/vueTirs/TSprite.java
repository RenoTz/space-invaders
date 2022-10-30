package game.spaceinvaders.vueTirs;

import game.spaceinvaders.tirs.ITirs;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class TSprite implements IVueTirs {
	protected ITirs tir;
	protected PApplet fenetre;
	protected PImage sprite,JspriteTir;
	
	public PImage getSprite() {
		return sprite;
	}

	public void setSprite(PImage sprite) {
		this.sprite = sprite;
	}

	public PImage getJspriteTir() {
		return JspriteTir;
	}

	public TSprite(PApplet fenetre, ITirs tir){
		this.fenetre=fenetre;
		this.tir=tir;
	}
	
}
	