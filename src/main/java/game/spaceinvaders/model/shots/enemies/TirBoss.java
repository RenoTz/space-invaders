package game.spaceinvaders.model.shots.enemies;

import game.spaceinvaders.model.Position;
import game.spaceinvaders.model.shots.ITirs;
import game.spaceinvaders.model.shots.Tir;

public class TirBoss implements ITirs {
	
	int depy = 12;
	Position position;
	boolean detruit,collision;
	int pointsTirs;

	public TirBoss(Position position, boolean detruit, int pointsTirs){
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
	public boolean hit(Tir t) {
		return collision;
	}

	@Override
	public int getPointTirs() {
		return pointsTirs;
	}

}