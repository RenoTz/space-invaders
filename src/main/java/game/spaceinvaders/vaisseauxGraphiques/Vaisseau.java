package game.spaceinvaders.vaisseauxGraphiques;

import game.spaceinvaders.vue.IVue;
import game.spaceinvaders.tirsGraphiques.JTir;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;

public class Vaisseau extends AVaisseau {

	@Override
	public IMobile getMobile() {
		return mobile;
	}

	IMobile mobile;
	IVue vue;
	
	public Vaisseau(IMobile mobile, IVue vue){
		this.mobile=mobile;
		this.vue=vue;
	}
	
	@Override
	public void move() {
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
	public boolean collisionJ(JTir tirs) {
		return mobile.collisionJ(tirs);
	}
	
	@Override 
	public boolean collisionA(JTir tirs) {
		return mobile.collisionA(tirs);
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
	public void explosion(AVaisseau v) {
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

}
