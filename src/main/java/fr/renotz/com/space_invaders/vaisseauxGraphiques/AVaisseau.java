package fr.renotz.com.space_invaders.vaisseauxGraphiques;

import fr.renotz.com.space_invaders.modele.IMobile;
import fr.renotz.com.space_invaders.vue.IVue;

public abstract class AVaisseau implements IVue, IMobile {

	@Override
	public abstract void deplacer();

	@Override
	public abstract void dessiner();
	
	@Override 
	public abstract void explosion(AVaisseau v);
	
}
