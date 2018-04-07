package fr.renotz.com.space_invaders.modele.ennemis;

import java.util.Random;

import fr.renotz.com.space_invaders.controleur.InterfaceJeu;
import fr.renotz.com.space_invaders.controleur.Play;
import fr.renotz.com.space_invaders.modele.IMobile;
import fr.renotz.com.space_invaders.modele.Position;
import fr.renotz.com.space_invaders.tirs.ITirs;
import fr.renotz.com.space_invaders.tirs.ennemis.TirBoss;
import fr.renotz.com.space_invaders.tirsGraphiques.JTir;
import fr.renotz.com.space_invaders.tirsGraphiques.Tir;
import fr.renotz.com.space_invaders.vueTirs.IVueTirs;
import fr.renotz.com.space_invaders.vueTirs.ennemis.vueTirBoss;

public class Boss implements IMobile{
	
	double t=0.0;
	double gap=-0.03;
	int rayon=220;
	public static int vie;
	private int rand;
	Position position;
	Play f;
	static boolean collision;
	public static boolean boss = false;
	public static boolean touche = false;

	public Boss(Play f, Position position,boolean collision,int vie){
		this.f=f;
		this.position = position;
		Boss.collision=collision;
		Boss.vie=vie;
		random();
	}

	@Override
	public void deplacer() {
		
		t+=gap;
		int x = position.getXpix();
		int y = position.getYpix();	
	    x = 500 + (int) (rayon*Math.sin(t))+(int) (rayon*Math.cos(3*t));
		y = 270 + (int) (rayon*Math.cos(2*t));
		
		position.setXpix(x);
		position.setYpix(y);
		
		setR(getR() + 1);
		if(getR() > 100){
			random();
			for(int i = 0; i < 5 ; i++){
				if(i > 0 && i < 4){
					if(i == 2){
						ITirs tb1 = new TirBoss(f, new Position(x + 55+(35*i),y+140), false, 80);
						IVueTirs vtb1 = new vueTirBoss(f,tb1);
						Tir jtb = new Tir(tb1,vtb1);
						Play.projectilesA.add(jtb);
					}else{
						ITirs tb1 = new TirBoss(f, new Position(x + 55 +(35*i),y+120), false, 80);
						IVueTirs vtb1 = new vueTirBoss(f,tb1);
						Tir jtb = new Tir(tb1,vtb1);
						Play.projectilesA.add(jtb);
					}
				}else{
					ITirs tb1 = new TirBoss(f, new Position(x+ 62 +(31*i),y+ 40), false, 80);
					IVueTirs vtb1 = new vueTirBoss(f,tb1);
					Tir jtb = new Tir(tb1,vtb1);
					Play.projectilesA.add(jtb);
				}
			}
		}		
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public boolean collisionA(JTir tirs) {
		return false;
	}

	@Override
	public boolean collisionJ(JTir tirs) {
		
		if((tirs.getPosition().getXpix() > getPosition().getXpix()+80) && (tirs.getPosition().getXpix() < getPosition().getXpix() + 200) 
				&& (tirs.getPosition().getYpix() < getPosition().getYpix() + 150) && (tirs.getPosition().getYpix() > getPosition().getYpix())){
			setVie(tirs.getPointTirs());
			setTouche(true);
			if(getVie() == 0){
				collision = true;
				InterfaceJeu.setScore(1250);
			}	
		}
		return collision;
	}

	public static void setTouche(boolean touche) {
		Boss.touche = touche;
	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int getVie() {
		// TODO Auto-generated method stub
		return vie;
	}
	
	public void setVie(int points) {
		if(vie - points > 0)
			Boss.vie -= points;
		else
			Boss.vie = 0;
	}
	
	public static boolean isCollision() {
		return collision;
	}
	
	public static boolean isTouche() {
		return touche;
	}
	
	public void random(){
		Random rand = new Random();
		setR(rand.nextInt(99));		
	}

	public void setR(int rand) {
		this.rand = rand;		
	}
	
	@Override
	public int getR() {
		return rand;
	}
	
	public static boolean isBoss() {
		return boss;
	}

}
