package game.spaceinvaders.model;

import game.spaceinvaders.model.shots.Tir;

import java.security.NoSuchAlgorithmException;

public interface IMobile {
	Position getPosition();
	IMobile getMobile();
	void move() throws NoSuchAlgorithmException;
	int getR();
	boolean collisionA(Tir tir);
	boolean collisionJ(Tir tir);
	int getPoints();
	boolean isBossStarted();
	void setBossStarted(boolean bossStarted);
	boolean isTouche();
	boolean isCollision();
	int getVie();
	void setTouche(boolean touche);
	boolean isDestructible();

}
