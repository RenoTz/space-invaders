package game.spaceinvaders.vue.joueur;

import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.Controller;
import game.spaceinvaders.model.IMobile;
import processing.core.PImage;
import game.spaceinvaders.vaisseauxGraphiques.AVaisseau;
import game.spaceinvaders.vue.ASprite;

public class SpritePlayer extends ASprite {

	private static final Class<SpritePlayer> CLASS = SpritePlayer.class;

	private Controller controller;
	private int cptAnim = 0, cpt = 0, decalage = 25;
	private boolean fini;
	PImage spritePlayer,spritePlayer2,spritePlayer3,
	spritePlayer4,spritePlayer5,spritePlayer6,spritePlayerG,spritePlayerD;
	
	public SpritePlayer(Controller controller, IMobile mobile) {
		super(controller, mobile);
		this.controller = controller;
		spritePlayer = controller.loadImage(getImagePath("Joueur/sfighter.PNG"));
		spritePlayer2 = controller.loadImage(getImagePath("Joueur/sfighter2.PNG"));
		spritePlayer3 = controller.loadImage(getImagePath("Joueur/sfighter3.PNG"));
		spritePlayer4 = controller.loadImage(getImagePath("Joueur/sfighter4.PNG"));
		spritePlayer5 = controller.loadImage(getImagePath("Joueur/sfighter5.PNG"));
		spritePlayer6 = controller.loadImage(getImagePath("Joueur/sfighter6.PNG"));
		spritePlayerG = controller.loadImage(getImagePath("Joueur/sfighterG2.png"));
		spritePlayerD = controller.loadImage(getImagePath("Joueur/sfighterD2.png"));
		
		spritePlayer.resize(60,0);spritePlayer2.resize(60,0);spritePlayer3.resize(60,0);
		spritePlayer4.resize(60,0);spritePlayer5.resize(60,0);spritePlayer6.resize(60,0);
		spritePlayerG.resize(60,0);spritePlayerD.resize(60,0);
				
	}

	@Override
	public void draw() {
		
		int x = mobile.getPosition().getXpix();
		int y = mobile.getPosition().getYpix();
		
		
		//Animation sprite joueur
		if (controller.getLoader().getPlayer().getDir() < 0) {
			fenetre.image((spritePlayerG), x, y);
			cpt = 0;
		}else if (controller.getLoader().getPlayer().getDir() > 0) {
			fenetre.image((spritePlayerD), x, y);
			cpt = 0;
		} else {
			if (cpt == 60)
				cpt = 0;
			if (cpt < 10)
				fenetre.image((spritePlayer), x, y);
			if (cpt < 20 && cpt >= 10)
				fenetre.image((spritePlayer2), x, y);
			if (cpt < 30 && cpt >= 20)
				fenetre.image((spritePlayer3), x, y);
			if (cpt < 40 && cpt >= 30)
				fenetre.image((spritePlayer4), x, y);
			if (cpt < 50 && cpt >= 40)
				fenetre.image((spritePlayer5), x, y);
			if (cpt < 60 && cpt >= 50)
				fenetre.image((spritePlayer6), x, y);			
			cpt++;

		}
	}
	
	@Override
	public void explosion(AVaisseau v){
		int x = v.getPosition().getXpix();
		int y = v.getPosition().getYpix();
		fenetre.image(controller.getLoader().boom[cptAnim], x - decalage , y - decalage);
		cptAnim++;
		if (cptAnim == controller.getLoader().boom.length) {
			cptAnim = 0;
			v.setFini(true);
		}
	}

	public boolean isFini() {
		return fini;
	}

	@Override
	public void setFini(boolean fini) {
		this.fini = fini;
	}

	private String getImagePath(String fileName) {
		return FileUtils.getImagePath(fileName, CLASS);
	}

}
