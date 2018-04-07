package fr.renotz.com.space_invaders.controleur;

import processing.core.PImage;
import fr.renotz.com.space_invaders.modele.ennemis.Boss;
import fr.renotz.com.space_invaders.modele.joueur.Joueur;

public class InterfaceJeu {

	private Play play;
	private int minute = 3, seconde = 00;
	private long intervalle = 1000;
	private long lastTime = 0;
	private String time = "";
	private static int score = 0;
	private PImage JspriteTir1, JspriteTir2;
	
	public InterfaceJeu(Play play) {
		this.play = play;
		this.JspriteTir1 = play.loadImage("../images/boule.png");
		this.JspriteTir2 = play.loadImage("../images/Missile.png");
		this.JspriteTir1.resize(45, 0);
		this.JspriteTir2.resize(12, 0);
	}

	public void cadre() {
		
		//Affichage du score
		rect(2, 0, 200, 40);
		text("Score : " + getScore() , 10, 30, 30);
		
		//Affichage du titre/�v�nements
		rect(200, 0, 1155, 40);
		if (Joueur.isGameOver() || minute == 0 && seconde == 0) 
		{
			play.frameRate(30);
			text("***       GAME OVER       ***", 440, 30, 30);			
		} else if (Boss.isCollision() && minute >= 0 && seconde > 0) {
			text("***        YOU WON        ***", 440, 30, 30);
		} else if (!Boss.isCollision())
		{
			text("*** Space Invader Project ***", 440, 30, 30);
			rect(1155, 0, 224, 40);
			text(rebours(), 1175, 30, 30);
		}
		
		//Affichage vie du BOSS
		if(Boss.isBoss()){
			rectVieBoss(775, 40, getNiveauHPBoss(), 15);
		}		
		
		//Affichage du type tir du joueur
		rect(1240,80,40,40);
		if(Joueur.getCptTirs()% 2 > 0)
			play.image(JspriteTir2, 1255, 82);		
		else
			play.image(JspriteTir1, 1240, 80);
		
		//Affichage Commandes de jeu
		rect(0,780,1280,20);
		text("Commandes : Q = Gauche ; D = Droite ; Z = Tirer ; S = changer tir",25,795,15);
		text("HP ", 550,795,15);
		rectVieJoueur(570, 780, getNiveauHP(), 15);
		text("P = Pause ; Echap = Quitter", 1070 , 795 , 15);
		
		//Pause
		if(play.isPause()){
			text("PAUSE", 385,400,150);
		}
	}

	public int getNiveauHP() {
		return Joueur.getVie() / 2;
	}
	
	public int getNiveauHPBoss() {
		return Boss.getVie() / 2;
	}

	public void setNiveauHP(int niveauHP) {
	}

	public String rebours() {

		if(!play.isPause()){
			if (seconde < 10)
				time = minute + " : 0" + seconde;
			else
				time = minute + " : " + seconde;
			if (System.currentTimeMillis() - lastTime > intervalle) {
				if (seconde == 0 && minute > 0) {
					minute--;
					seconde = 60;
				}
				lastTime = System.currentTimeMillis();
				if (seconde > 0 && minute >= 0) {
					seconde--;
				}
			}
		}
		return time;
	}

	public void rect(int x, int y, int w, int h) {
		play.fill(0, 45, 20);
		play.rect(x, y, w, h);
	}
	
	public void rectVieJoueur(int x, int y, int w, int h) {
		play.fill(70, 0, 220);
		play.rect(x, y, w, h);
	}
	
	public void rectVieBoss(int x, int y, int w, int h) {
		play.fill(220, 0, 20);
		play.rect(x, y, w, h);
	}

	public void text(String str, int x, int y, int s) {
		play.textSize(s);
		play.fill(240, 195, 0);
		play.text(str, x, y);
	}

	public static int getScore() {
		return score;
	}

	public void setScore(int score) {
		InterfaceJeu.score += score;
	}

}
