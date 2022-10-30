package game.spaceinvaders.model.ennemis;

import java.util.Random;

import game.spaceinvaders.Controller;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.tirsGraphiques.JTir;
import game.spaceinvaders.tirsGraphiques.Tir;
import game.spaceinvaders.vueTirs.IVueTirs;
import game.spaceinvaders.vueTirs.ennemis.vueTirNormal;
import game.spaceinvaders.tirs.ennemis.TirAlien1;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;

public class MobileC implements IMobile{

	int Xdir=1, Ydir=10, XpixInit,YpixInit;
	Position position;
	Controller f;
	private int rand;
	int points;
	boolean collision;
	
	public MobileC(Controller f, Position position, boolean collision, int points){
		this.f=f;
		this.position = position;
		this.collision=collision;
		this.points=points;
		random();
		XpixInit = position.getXpix();
		YpixInit = position.getYpix();		
	}
	
	@Override
	public void move() {
				
		if(position.getXpix() > XpixInit + 40){
			Xdir = -1;
			position.setYpix(position.getYpix() + Ydir);
			if(position.getYpix() > YpixInit + 100)
				Ydir = -10;
			if(position.getYpix() < YpixInit)
				Ydir = 10;
		}
		if(position.getXpix() < XpixInit - 40){
			Xdir = 1;
			position.setYpix(position.getYpix() + Ydir);
			if(position.getYpix() > YpixInit + 100)
				Ydir = -10;
			if(position.getYpix() < YpixInit)
				Ydir = 10;
		}
		position.setXpix(position.getXpix() + Xdir);
		
		setR(getR() + 1);
		if (rand > 1000) {	
			ITirs ta = new TirAlien1(f, new Position(position.getXpix()+18,position.getYpix()), false, 50);
			IVueTirs vta = new vueTirNormal(f,ta);
			Tir jta = new Tir(ta,vta);
			f.getProjectilesA().add(jta);
		}		
			
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public IMobile getMobile() {
		return this;
	}

	public void random(){
		Random rand = new Random();
		setR(rand.nextInt(1000));		
	}

	private void setR(int rand) {
		this.rand = rand;		
	}

	@Override
	public int getR() {
		if (rand > 1000)
			rand = 0;
		return rand;
	}

	@Override
	public boolean collisionJ(JTir tirs) {
		if((tirs.getPosition().getXpix() > getPosition().getXpix()) && (tirs.getPosition().getXpix() < getPosition().getXpix() + 40) 
				&& (tirs.getPosition().getYpix() < getPosition().getYpix() + 40) && (tirs.getPosition().getYpix() > getPosition().getYpix())){		
			collision = true;
		}
		return collision;
	}

	@Override
	public boolean collisionA(JTir tirs) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getPoints() {
		return points;
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

}