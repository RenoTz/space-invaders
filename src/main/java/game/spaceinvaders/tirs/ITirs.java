package game.spaceinvaders.tirs;

import game.spaceinvaders.tirsGraphiques.JTir;
import game.spaceinvaders.model.Position;

public interface ITirs {
	
	void move();
	Position getPosition();
	boolean isDetruit();
	boolean hit(JTir t);
	int getPointTirs();

}
