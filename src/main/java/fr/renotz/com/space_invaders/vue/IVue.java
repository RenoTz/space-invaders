package fr.renotz.com.space_invaders.vue;

import fr.renotz.com.space_invaders.vaisseauxGraphiques.AVaisseau;

public interface IVue {
	public void dessiner();

	public void explosion(AVaisseau v);

	public boolean isFini();


}
