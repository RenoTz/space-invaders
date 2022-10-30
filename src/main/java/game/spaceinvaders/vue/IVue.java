package game.spaceinvaders.vue;

import game.spaceinvaders.vaisseauxGraphiques.AVaisseau;

public interface IVue {
	void draw();

	void explosion(AVaisseau v);

	boolean isFini();

	void setFini(boolean fini);

}
