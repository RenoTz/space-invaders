package game.spaceinvaders.tirsGraphiques;

import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.vueTirs.IVueTirs;
import game.spaceinvaders.model.Position;

public class Tir extends JTir{
	
	ITirs tirs;
	IVueTirs vueTirs;

	public Tir(ITirs tirs, IVueTirs vueTirs){
		this.tirs=tirs;
		this.vueTirs=vueTirs;
	}

	@Override
	public void move() {
		tirs.move();
	}

	@Override
	public void draw() {
		vueTirs.draw();
		
	}

	@Override
	public Position getPosition() {
		return tirs.getPosition();
		
	}

	@Override
	public boolean isDetruit() {
		return tirs.isDetruit();
	}

	@Override
	public boolean hit(JTir t) {
		return tirs.hit(t);
	}
	

	@Override
	public int getPointTirs() {
		return tirs.getPointTirs();
	}

}
