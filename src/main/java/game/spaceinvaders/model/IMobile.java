package game.spaceinvaders.model;

import game.spaceinvaders.tirsGraphiques.JTir;

public interface IMobile {
	Position getPosition();
	IMobile getMobile();
	void move();
	int getR();
	boolean collisionA(JTir tirs);
	boolean collisionJ(JTir tirs);
	int getPoints();
	boolean isBossStarted();
	void setBossStarted(boolean bossStarted);
	boolean isTouche();
	boolean isCollision();
	int getVie();
	void setTouche(boolean touche);

}
