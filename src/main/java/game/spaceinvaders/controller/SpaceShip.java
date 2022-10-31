package game.spaceinvaders.controller;

import game.spaceinvaders.model.shots.Tir;
import game.spaceinvaders.view.IVue;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;

import java.security.NoSuchAlgorithmException;

public class SpaceShip implements IVue, IMobile {

	IMobile mobile;
	IVue vue;
	
	public SpaceShip(IMobile mobile, IVue vue){
		this.mobile=mobile;
		this.vue=vue;
	}
	
	@Override
	public void move() throws NoSuchAlgorithmException {
		mobile.move();
	}

	@Override
	public void draw() {
		vue.draw();
	}

	@Override
	public Position getPosition() {
		return mobile.getPosition();
	}

	@Override
	public int getR() {
		return mobile.getR();
	}

	@Override
	public boolean collisionJ(Tir tir) {
		return mobile.collisionJ(tir);
	}
	
	@Override 
	public boolean collisionA(Tir tir) {
		return mobile.collisionA(tir);
	}

	@Override
	public int getPoints() {
		return mobile.getPoints();
	}

	@Override
	public boolean isBossStarted() {
		return false;
	}

	@Override
	public void setBossStarted(boolean bossStarted) {

	}

	@Override
	public boolean isTouche() {
		return false;
	}

	@Override
	public boolean isCollision() {
		return false;
	}

	@Override
	public int getVie() {
		return 0;
	}

	@Override
	public void setTouche(boolean touche) {

	}

	@Override
	public void explosion(SpaceShip v) {
		vue.explosion(v);	
	}
	
	@Override
	public boolean isFini() {
		return vue.isFini();
	}

	@Override
	public void setFini(boolean fini) {
		vue.setFini(fini);
	}

	@Override
	public IMobile getMobile() {
		return mobile;
	}

	@Override
	public boolean isDestructible() {
		return mobile.isDestructible();
	}

}
