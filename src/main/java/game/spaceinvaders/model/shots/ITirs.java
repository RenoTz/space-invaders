package game.spaceinvaders.model.shots;

import game.spaceinvaders.model.Position;

public interface ITirs {
	
	void move();
	Position getPosition();
	boolean isDestroy();
	int getPointTirs();

}
