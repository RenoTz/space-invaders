package fr.renotz.com.space_invaders.modele.ennemis;

import java.util.Random;

import fr.renotz.com.space_invaders.controleur.Play;
import fr.renotz.com.space_invaders.modele.IMobile;
import fr.renotz.com.space_invaders.modele.Position;
import fr.renotz.com.space_invaders.tirs.ITirs;
import fr.renotz.com.space_invaders.tirs.ennemis.TirAlien2;
import fr.renotz.com.space_invaders.tirsGraphiques.JTir;
import fr.renotz.com.space_invaders.tirsGraphiques.Tir;
import fr.renotz.com.space_invaders.vueTirs.IVueTirs;
import fr.renotz.com.space_invaders.vueTirs.ennemis.vueTirNormal;

public class MobileA implements IMobile {
	double t=0.0;
	double gap=-0.02;
	int rayon=100;
	int points;
	Position position;
	Play f;
	private int rand;
	boolean collision;
	
	public MobileA(Play f,double t, Position position,boolean collision,int points){
		this.f=f;
		this.t = t;
		this.position = position;
		this.collision=collision;
		this.points=points;
		random();		
	}

	@Override
	public void deplacer() {
		
		t+=gap;
		setR(getR() + 1);
		int x = position.getXpix();
		int y = position.getYpix();	
		x = 600 + (int) (rayon*Math.sin(t))+(int) (rayon*Math.cos(t));
		y = 270 + (int) (rayon*Math.cos(2*t));
		
		position.setXpix(x);
		position.setYpix(y);
		
		
		if (rand > 1000) {	
			ITirs ta = new TirAlien2(f, new Position(x+18,y), false, 50);
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

	public void setR(int rand) {
		this.rand = rand;		
	}
	
	@Override
	public int getR() {
		if (rand > 1001)
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
