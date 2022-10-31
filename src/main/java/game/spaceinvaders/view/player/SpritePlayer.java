package game.spaceinvaders.view.player;

import game.spaceinvaders.controller.SpaceShip;
import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.Controller;
import game.spaceinvaders.model.IMobile;
import processing.core.PImage;
import game.spaceinvaders.view.ASprite;

public class SpritePlayer extends ASprite {

    private static final Class<SpritePlayer> CLASS = SpritePlayer.class;

    private int cptAnim = 0, cpt = 0, range = 25;
    private final PImage spritePlayer;
    private final PImage spritePlayer2;
    private final PImage spritePlayer3;
    private final PImage spritePlayer4;
    private final PImage spritePlayer5;
    private final PImage spritePlayer6;
    private final PImage spritePlayerG;
    private final PImage spritePlayerD;

    public SpritePlayer(Controller controller, IMobile mobile) {
        super(controller, mobile);
        spritePlayer = controller.loadImage(getImagePath("Joueur/sfighter.PNG"));
        spritePlayer2 = controller.loadImage(getImagePath("Joueur/sfighter2.PNG"));
        spritePlayer3 = controller.loadImage(getImagePath("Joueur/sfighter3.PNG"));
        spritePlayer4 = controller.loadImage(getImagePath("Joueur/sfighter4.PNG"));
        spritePlayer5 = controller.loadImage(getImagePath("Joueur/sfighter5.PNG"));
        spritePlayer6 = controller.loadImage(getImagePath("Joueur/sfighter6.PNG"));
        spritePlayerG = controller.loadImage(getImagePath("Joueur/sfighterG2.png"));
        spritePlayerD = controller.loadImage(getImagePath("Joueur/sfighterD2.png"));

        spritePlayer.resize(60, 0);
        spritePlayer2.resize(60, 0);
        spritePlayer3.resize(60, 0);
        spritePlayer4.resize(60, 0);
        spritePlayer5.resize(60, 0);
        spritePlayer6.resize(60, 0);
        spritePlayerG.resize(60, 0);
        spritePlayerD.resize(60, 0);
    }

    @Override
    public void draw() {
        int x = mobile.getPosition().getXpix();
        int y = mobile.getPosition().getYpix();

        //Animation sprite joueur
        if (controller.getLoader().getPlayer().getDir() < 0) {
            controller.image((spritePlayerG), x, y);
            cpt = 0;
        } else if (controller.getLoader().getPlayer().getDir() > 0) {
            controller.image((spritePlayerD), x, y);
            cpt = 0;
        } else {
			if (cpt == 60) {
				cpt = 0;
			}
			if (cpt < 10) {
				controller.image((spritePlayer), x, y);
			}
			if (cpt < 20 && cpt >= 10) {
                controller.image((spritePlayer2), x, y);
			}
			if (cpt < 30 && cpt >= 20) {
                controller.image((spritePlayer3), x, y);
			}
			if (cpt < 40 && cpt >= 30) {
                controller.image((spritePlayer4), x, y);
			}
			if (cpt < 50 && cpt >= 40) {
				controller.image((spritePlayer5), x, y);
			}
			if (cpt < 60 && cpt >= 50) {
				controller.image((spritePlayer6), x, y);
			}
            cpt++;
        }
    }

    @Override
    public void explosion(SpaceShip v) {
        int x = v.getPosition().getXpix();
        int y = v.getPosition().getYpix();
        controller.image(controller.getLoader().boom[cptAnim], x - range, y - range);
        cptAnim++;
        if (cptAnim == controller.getLoader().boom.length) {
            cptAnim = 0;
            v.setFini(true);
        }
    }

    @Override
    protected PImage getSprite(int number) {
        return null;
    }

    private String getImagePath(String fileName) {
        return FileUtils.getImagePath(fileName, CLASS);
    }

    @Override
    protected int getSize() {
        return 0;
    }

}
