package fr.renotz.com.space_invaders.tirs.ennemis;

import fr.renotz.com.space_invaders.controleur.Play;
import fr.renotz.com.space_invaders.modele.Position;
import fr.renotz.com.space_invaders.tirs.ITirs;
import fr.renotz.com.space_invaders.tirsGraphiques.JTir;

public class TirBoss implements ITirs{
	
	int depy = 12;
	Position position;
	Play f;
	boolean detruit,collision;
	int pointsTirs;

	public TirBoss(Play f, Position position, boolean detruit, int pointsTirs){
		this.f = f;
		this.position = position;
		this.detruit = detruit;
		this.pointsTirs=pointsTirs;
	}

	@Override
	public void deplacer() {
		
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
	public boolean collision(JTir t) {
		return collision;
	}

	@Override
	public int getPointTirs() {
		// TODO Auto-generated method stub
		return pointsTirs;
	}

}
