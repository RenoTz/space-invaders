package game.spaceinvaders.vaisseauxGraphiques;

import game.spaceinvaders.vue.IVue;
import game.spaceinvaders.model.IMobile;

public abstract class AVaisseau implements IVue, IMobile {

	@Override
	public abstract void move();

	@Override
	public abstract void draw();
	
	@Override 
	public abstract void explosion(AVaisseau v);

	@Override
	public abstract IMobile getMobile();
	
}
