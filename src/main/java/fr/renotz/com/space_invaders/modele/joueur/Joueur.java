package fr.renotz.com.space_invaders.modele.joueur;

import fr.renotz.com.space_invaders.controleur.Play;
import fr.renotz.com.space_invaders.modele.IMobile;
import fr.renotz.com.space_invaders.modele.Position;
import fr.renotz.com.space_invaders.tirs.ITirs;
import fr.renotz.com.space_invaders.tirs.joueur.TirJoueur1;
import fr.renotz.com.space_invaders.tirs.joueur.TirJoueur2;
import fr.renotz.com.space_invaders.tirsGraphiques.JTir;
import fr.renotz.com.space_invaders.tirsGraphiques.Tir;
import fr.renotz.com.space_invaders.vueTirs.IVueTirs;
import fr.renotz.com.space_invaders.vueTirs.joueur.vueTirJoueur1;
import fr.renotz.com.space_invaders.vueTirs.joueur.vueTirJoueur2;


public class Joueur implements IMobile{
	static Position position;
	Play f;
	ITirs t;
	IVueTirs vt;
	boolean collision;
	static boolean gameOver = false, touche = false;
	private int depx = 7; 
	public static int vie;
	public static int dir = 0, cptTirs = 0, cpt = 0;	
	private long intervalle = 100;
	private long dateDernierTir=0;
	long bip = 0; 

	public Joueur (Play f,Position position, int vie,boolean collision){
		this.f = f;
		Joueur.position = position;
		Joueur.vie = vie;		
		this.collision=collision;
		
	}

	
	@Override
	public void deplacer() {

		int x = position.getXpix();
		int y = position.getYpix();

		if (f.keyPressed) {			
			if (f.key == 'q' && x > 0) {								
				position.setXpix(x - depx);				
				dir = -depx;
			}			
			if (f.key == 'd' && x < 1220) {							
				position.setXpix(x + depx);
				dir = depx;
			}
			
		} else
			dir = 0;
		if (f.keyPressed) {
			if (f.key == 'z') {					
				if(cptTirs % 2 > 0)
					tir(typeTir2(x,y));
				else
					tir(typeTir1(x,y));
			}
		}
		if (f.keyPressed) {
			if (f.key == 's') {	
				if (System.currentTimeMillis()>bip+500){
					bip= System.currentTimeMillis();
				    cptTirs ++;
				    if(cptTirs % 2 > 0)
				    	typeTir2(x,y);
				    else
				    	typeTir1(x,y);
			}
				f.key = ' ';
			}
		}
		
	}
	

	public static int getDir() {
		return dir;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	protected Tir typeTir1(int x, int y){

		ITirs t = new TirJoueur1(f,0.52, new Position(x+35,y), false,50);
		IVueTirs vt = new vueTirJoueur1(f,t);
		Tir jt = new Tir(t,vt);
		
		return jt;

	}

	public static int getCptTirs() {
		return cptTirs;
	}

	protected Tir typeTir2(int x, int y){
		ITirs t = new TirJoueur2(f, new Position(x+35,y), false,75);
		IVueTirs vt = new vueTirJoueur2(f,t);
		Tir jt = new Tir(t,vt);

		return jt;
	}

	protected void tir(Tir jt){
		if(cptTirs % 2 > 0)
			intervalle = 500;
		else
			intervalle = 100;
		if(System.currentTimeMillis()-dateDernierTir > intervalle){			
			Play.projectilesJ.add(jt);
			dateDernierTir = System.currentTimeMillis();
		}	
	}

	@Override
	public int getR() {
		return 0;
	}

	@Override
	public boolean collisionJ(JTir tirs) {
		// PAS DE COLLISIONS AVEC SES PROPRES TIRS
		return false;
	}

	@Override
	public boolean collisionA(JTir tirs) {
		
		touche = false;
		if((tirs.getPosition().getXpix() > getPosition().getXpix()) && (tirs.getPosition().getXpix() < getPosition().getXpix() + 55) 
				&& (tirs.getPosition().getYpix() < getPosition().getYpix() + 50) && (tirs.getPosition().getYpix() > getPosition().getYpix()))	{
			setVie(tirs.getPointTirs());
			touche = true;
			if(getVie() == 0){
				collision = true;
				setGameOver(true);
			}
		}		
		return collision;
	}
	
	public void setGameOver(boolean gameOver) {
		Joueur.gameOver = gameOver;
	}

	public static boolean isGameOver() {
		return gameOver;
	}

	public static boolean isTouche() {
		return touche;
	}

	@Override
	public int getPoints() {
		return 0;
	}


	public static int getVie() {
		return vie;
	}


	public void setVie(int points) {
		if(vie - points > 0 )
			Joueur.vie -= points;
		else
			Joueur.vie = 0;
	}
	
}

