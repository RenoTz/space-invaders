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
import fr.renotz.com.space_invaders.vueTirs.ennemis.vueTirHard;

public class MobileD implements IMobile{
	
	int Xdir=1, Ydir=10, XpixInit,YpixInit;
	Position position;
	Play f;
	private int rand;
	int points;	
	double t=0.0;
	double gap=-0.05;
	int rayon=90;
	boolean collision;
	
	public MobileD(Play f,double t, Position position,boolean collision,int points){
		this.f=f;
		this.t=t;
		this.position = position;
		this.collision=collision;
		this.points=points;
		random();
		XpixInit = position.getXpix();
		YpixInit = position.getYpix();		
	}

	@Override
	public void deplacer() {
		t+=gap;
		setR(getR() + 1);
		int x = position.getXpix();
		int y = position.getYpix();	
		x = 1000+ (int) (rayon*Math.sin(t));
		y = 280 + (int) (rayon*Math.sin(0.1*t))+ (int) (rayon*Math.sin(0.1*t));
		position.setXpix(x);
		position.setYpix(y);
		
		// Creation des tirs
		setR(getR() + 1);
		if (rand > 1000) {	
			ITirs ta = new TirAlien2(f, new Position(position.getXpix()+10,position.getYpix()), false,75);
			IVueTirs vta = new vueTirHard(f,ta);
			Tir jta = new Tir(ta,vta);
			f.getProjectilesA().add(jta);					
		}	
		
		if(rand > 1000)
			random();
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
