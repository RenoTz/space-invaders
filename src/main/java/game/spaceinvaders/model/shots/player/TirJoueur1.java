package game.spaceinvaders.model.shots.player;

import game.spaceinvaders.Controller;
import game.spaceinvaders.model.Position;
import game.spaceinvaders.model.shots.ITirs;
import game.spaceinvaders.model.shots.Tir;

public class TirJoueur1 implements ITirs {

	double t=0.0;
	double gap=-0.05;
	int rayon=10, depy = 2;
	Position position;
	Controller f;
	boolean detruit,collision;
	int pointsTirs;

	public TirJoueur1(Controller f, double t, Position position, boolean detruit, int pointsTirs){
		this.t=t;
		this.f = f;
		this.position = position;
		this.detruit = detruit;
		this.pointsTirs=pointsTirs;
	}

	@Override
	public void move() {
		
		t+=gap;
		
		int x = position.getXpix()+ (int) (rayon*Math.sin(10*t));
		int y = position.getYpix()+ (int) (rayon*Math.sin(0.3*t))+ (int) (rayon*Math.sin(0.3*t));
		
		position.setXpix(x);
		position.setYpix(y);	

	}

	public boolean isDetruit() {
		if(position.getYpix() < 0)
			setDetruit(true);
		return detruit;
	}

	public void setDetruit(boolean detruit) {
		this.detruit = detruit;
	}

	@Override
	public Position getPosition() {		
		return position;
	}

	@Override
	public boolean hit(Tir t) {
		return collision;
	}

	@Override
	public int getPointTirs() {
		return pointsTirs;
	}

}
