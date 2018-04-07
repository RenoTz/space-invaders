package fr.renotz.com.space_invaders.tirs.joueur;

import fr.renotz.com.space_invaders.controleur.Play;
import fr.renotz.com.space_invaders.modele.Position;
import fr.renotz.com.space_invaders.tirs.ITirs;
import fr.renotz.com.space_invaders.tirsGraphiques.JTir;

public class TirJoueur1 implements ITirs{

	double t=0.0;
	double gap=-0.05;
	int rayon=10, depy = 2;
	Position position;
	Play f;
	boolean detruit,collision;
	int pointsTirs;

	public TirJoueur1(Play f, double t, Position position, boolean detruit, int pointsTirs){
		this.t=t;
		this.f = f;
		this.position = position;
		this.detruit = detruit;
		this.pointsTirs=pointsTirs;
	}

	@Override
	public void deplacer() {
		
		t+=gap;
		
		int x = position.getXpix()+ (int) (rayon*Math.sin(10*t));
		int y = position.getYpix()+ (int) (rayon*Math.sin(0.3*t))+ (int) (rayon*Math.sin(0.3*t));
		
		position.setXpix(x);
		position.setYpix(y);	

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
	public boolean collision(JTir t) {
		return collision;
	}

	@Override
	public int getPointTirs() {
		return pointsTirs;
	}

}
