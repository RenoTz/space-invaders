package game.spaceinvaders.tirs.ennemis;

import game.spaceinvaders.Controller;
import game.spaceinvaders.model.Position;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.tirsGraphiques.JTir;

public class TirBoss implements ITirs {
	
	int depy = 12;
	Position position;
	Controller f;
	boolean detruit,collision;
	int pointsTirs;

	public TirBoss(Controller f, Position position, boolean detruit, int pointsTirs){
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
		position.setYpix(y + depy);
		
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public boolean isDetruit() {
		if(position.getYpix() > 800)
			setDetruit(true);
		return detruit;
	}
	
	public void setDetruit(boolean detruit) {
		this.detruit = detruit;
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
