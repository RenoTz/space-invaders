package game.spaceinvaders.tirs;

import game.spaceinvaders.model.Position;

public interface ITirs {
	
	void move();
	Position getPosition();
	boolean isDetruit();
	boolean hit(Tir t);
	int getPointTirs();

}
