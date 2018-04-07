package fr.renotz.com.space_invaders.modele.ennemis;

import java.util.Random;

import fr.renotz.com.space_invaders.controleur.Play;
import fr.renotz.com.space_invaders.modele.IMobile;
import fr.renotz.com.space_invaders.modele.Position;
import fr.renotz.com.space_invaders.tirs.ITirs;
import fr.renotz.com.space_invaders.tirs.ennemis.TirAlien1;
import fr.renotz.com.space_invaders.tirsGraphiques.JTir;
import fr.renotz.com.space_invaders.tirsGraphiques.Tir;
import fr.renotz.com.space_invaders.vueTirs.IVueTirs;
import fr.renotz.com.space_invaders.vueTirs.ennemis.vueTirNormal;

public class MobileC implements IMobile{

	int Xdir=1, Ydir=10, XpixInit,YpixInit;
	Position position;
	Play f;
	private int rand;
	int points;
	boolean collision;
	
	public MobileC(Play f, Position position,boolean collision,int points){
		this.f=f;
		this.position = position;
		this.collision=collision;
		this.points=points;
		random();
		XpixInit = position.getXpix();
		YpixInit = position.getYpix();		
	}
	
	@Override
	public void deplacer() {
				
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
			Play.projectilesA.add(jta);					
		}		
			
	}

	@Override
	public Position getPosition() {
		return position;
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

}