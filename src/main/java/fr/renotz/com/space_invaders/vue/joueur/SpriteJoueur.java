package fr.renotz.com.space_invaders.vue.joueur;

import fr.renotz.com.space_invaders.controleur.Loader;
import fr.renotz.com.space_invaders.modele.IMobile;
import fr.renotz.com.space_invaders.modele.joueur.Joueur;
import fr.renotz.com.space_invaders.vaisseauxGraphiques.AVaisseau;
import fr.renotz.com.space_invaders.vue.ASprite;
import processing.core.PApplet;
import processing.core.PImage;

public class SpriteJoueur extends ASprite {
	
	private int cptAnim = 0, cpt = 0, decalage = 25;
	private boolean fini = false;
	PImage spriteJoueur,spriteJoueur2,spriteJoueur3,
	spriteJoueur4,spriteJoueur5,spriteJoueur6,spriteJoueurG,spriteJoueurD;
	
	public SpriteJoueur(PApplet fenetre, IMobile mobile) {
		super(fenetre, mobile);
		
		spriteJoueur = fenetre.loadImage("../images/Joueur/sfighter.PNG");
		spriteJoueur2 = fenetre.loadImage("../images/Joueur/sfighter2.PNG");
		spriteJoueur3 = fenetre.loadImage("../images/Joueur/sfighter3.PNG");
		spriteJoueur4 = fenetre.loadImage("../images/Joueur/sfighter4.PNG");
		spriteJoueur5 = fenetre.loadImage("../images/Joueur/sfighter5.PNG");
		spriteJoueur6 = fenetre.loadImage("../images/Joueur/sfighter6.PNG");
		spriteJoueurG = fenetre.loadImage("../images/Joueur/sfighterG2.png");
		spriteJoueurD = fenetre.loadImage("../images/Joueur/sfighterD2.png");		
		
		spriteJoueur.resize(60,0);spriteJoueur2.resize(60,0);spriteJoueur3.resize(60,0);
		spriteJoueur4.resize(60,0);spriteJoueur5.resize(60,0);spriteJoueur6.resize(60,0);
		spriteJoueurG.resize(60,0);spriteJoueurD.resize(60,0);
				
	}

	@Override
	public void dessiner() {
		
		int x = mobile.getPosition().getXpix();
		int y = mobile.getPosition().getYpix();
		
		
		//Animation sprite joueur
		if (Joueur.getDir() < 0) {
			fenetre.image((spriteJoueurG), x, y);
			cpt = 0;
		}else if (Joueur.getDir() > 0) {
			fenetre.image((spriteJoueurD), x, y);
			cpt = 0;
		} else {
			if (cpt == 60)
				cpt = 0;
			if (cpt < 10)
				fenetre.image((spriteJoueur), x, y);
			if (cpt < 20 && cpt >= 10)
				fenetre.image((spriteJoueur2), x, y);
			if (cpt < 30 && cpt >= 20)
				fenetre.image((spriteJoueur3), x, y);
			if (cpt < 40 && cpt >= 30)
				fenetre.image((spriteJoueur4), x, y);
			if (cpt < 50 && cpt >= 40)
				fenetre.image((spriteJoueur5), x, y);
			if (cpt < 60 && cpt >= 50)
				fenetre.image((spriteJoueur6), x, y);			
			cpt++;

		}
	}
	
	@Override
	public void explosion(AVaisseau v){
		
		
		int x = v.getPosition().getXpix();
		int y = v.getPosition().getYpix();
		
		fenetre.image((Loader.boom[cptAnim]), x - decalage , y - decalage);
		
		cptAnim++;
		
		if(cptAnim == Loader.boom.length){
			fini = true;
		}
		

	}

	public boolean isFini() {
		return fini;
	}

}
