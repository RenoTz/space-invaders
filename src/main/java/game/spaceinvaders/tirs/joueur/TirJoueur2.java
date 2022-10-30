package game.spaceinvaders.tirs.joueur;

import game.spaceinvaders.Controller;
import game.spaceinvaders.model.Position;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.tirsGraphiques.JTir;

public class TirJoueur2 implements ITirs {

	int depy = 8;
	Position position;
	Controller f;
	boolean detruit,collision;
	int pointsTirs;

	public TirJoueur2(Controller f, Position position, boolean detruit, int pointsTirs){
		this.f = f;
		this.position = position;
		this.detruit = detruit;
		this.pointsTirs=pointsTirs;
	}
	
	@Override
	public void move() {
		
		int x = position.getXpix();
		int y = position.getYpix();
		
		position.setXpix(x);
		position.setYpix(y - depy);
		
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
	public boolean hit(JTir t) {
		return collision;
	}

	@Override
	public int getPointTirs() {
		// TODO Auto-generated method stub
		return pointsTirs;
	}

}
