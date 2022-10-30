package game.spaceinvaders.vueTirs.ennemis;

import game.spaceinvaders.Controller;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.vueTirs.TSprite;

public class vueTirHard extends TSprite{

	private Controller f;
	private int cpt = 0, w = 5, h = 5;
		
	public vueTirHard(Controller fenetre, ITirs tir) {
		super(fenetre, tir);
		this.f = fenetre;
		JspriteTir = fenetre.loadImage(FileUtils.getImagePath("missile1.png", getClass()));
		JspriteTir.resize(20, 0);		
	}

	@Override
	public void draw() {

		int x = tir.getPosition().getXpix();
		int y = tir.getPosition().getYpix();
		
		if (cpt > 50)
			cpt = 0;
		if (f.getLoader().getPlayer().getDir() - y < 300 && cpt > 25) {
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
