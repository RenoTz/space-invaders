package fr.renotz.com.space_invaders.modele.bouclier;

import fr.renotz.com.space_invaders.modele.IMobile;
import fr.renotz.com.space_invaders.modele.Position;
import fr.renotz.com.space_invaders.tirsGraphiques.JTir;

public class Bouclier implements IMobile{

	Position position;	
	boolean collision;
	
	public Bouclier (Position position,boolean collision){
		this.position = position;
		this.collision=collision;
	}
	
	@Override
	public void deplacer() {}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public int getR() {
		return 0;
	}

	@Override
	public boolean collisionJ(JTir tirs) {
		if((tirs.getPosition().getXpix() > getPosition().getXpix()) && (tirs.getPosition().getXpix() < getPosition().getXpix() + 20) 
				&& (tirs.getPosition().getYpix() < getPosition().getYpix() + 20) && (tirs.getPosition().getYpix() > getPosition().getYpix()))			
			collision = true;
		return collision;
	}

	@Override
	public boolean collisionA(JTir tirs) {
		if((tirs.getPosition().getXpix() > getPosition().getXpix()) && (tirs.getPosition().getXpix() < getPosition().getXpix() + 20) 
				&& (tirs.getPosition().getYpix() + 20 < getPosition().getYpix() + 20) && (tirs.getPosition().getYpix() + 20 > getPosition().getYpix()))			
			collision = true;
		return collision;
	}
	
	public boolean isCollision() {
		return collision;
	}

	public void setCollision(boolean collision) {
		this.collision = collision;
	}

	@Override
	public int getPoints() {
		return 0;
	}

}
