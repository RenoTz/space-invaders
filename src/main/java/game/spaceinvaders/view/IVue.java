package game.spaceinvaders.view;

import game.spaceinvaders.controller.SpaceShip;

public interface IVue {
	void draw();

	void explosion(SpaceShip v);

	boolean isFini();

	void setFini(boolean fini);

}
