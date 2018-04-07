package fr.renotz.com.space_invaders.vueTirs.ennemis;

import fr.renotz.com.space_invaders.modele.joueur.Joueur;
import fr.renotz.com.space_invaders.tirs.ITirs;
import fr.renotz.com.space_invaders.vueTirs.TSprite;
import processing.core.PApplet;

public class vueTirHard extends TSprite{
	
	private int cpt = 0, w = 5, h = 5;
		
	public vueTirHard(PApplet fenetre, ITirs tir) {
		super(fenetre, tir);
		JspriteTir = fenetre.loadImage("../images/missile1.png");
		JspriteTir.resize(20, 0);		
	}

	@Override
	public void dessiner() {

		int x = tir.getPosition().getXpix();
		int y = tir.getPosition().getYpix();
		
		if (cpt > 50)
			cpt = 0;
		if (Joueur.getDir() - y < 300 && cpt > 25) {
			fenetre.fill(255, 0, 0);
			fenetre.ellipse(x, y + 20, w*4, h*4);
			fenetre.fill(200, 0, 220);
			fenetre.ellipse(x, y + 20, w*2, h*2);
			fenetre.fill(100, 100, 220);
			fenetre.ellipse(x, y + 20, w, h);
			cpt++;
		} else {
			fenetre.fill(255, 200, 200);
			fenetre.ellipse(x, y + 20, w*4, h*4);
			fenetre.fill(200, 0, 220);
			fenetre.ellipse(x, y + 20, w*2, h*2);
			fenetre.fill(100, 100, 220);
			fenetre.ellipse(x, y + 20, w, h);
			cpt++;
		}	
		
	}
	
}
