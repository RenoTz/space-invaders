package game.spaceinvaders.vue.ennemis;

import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.Controller;
import game.spaceinvaders.model.IMobile;
import processing.core.PImage;
import game.spaceinvaders.vaisseauxGraphiques.AVaisseau;
import game.spaceinvaders.vue.ASprite;

public class SpriteBoss extends ASprite {

    private static final int OFFSET = 20;
    private int cptAnim = 0;
    PImage spriteBoss;
    private boolean fini;
    private Controller controller;

    public SpriteBoss(Controller controller, IMobile mobile) {
        super(controller, mobile);
        this.controller = controller;
        spriteBoss = fenetre.loadImage(FileUtils.getImagePath("boss.png", getClass()));
        spriteBoss.resize(250, 0);

    }

    @Override
    public void draw() {
        int x = mobile.getPosition().getXpix();
        int y = mobile.getPosition().getYpix();
        fenetre.image(spriteBoss, x, y);
    }

    @Override
    public void explosion(AVaisseau v) {

        int x = v.getPosition().getXpix();
        int y = v.getPosition().getYpix();

        controller.getLoader().boom[cptAnim].resize(250, 0);
        fenetre.image(controller.getLoader().boom[cptAnim], x, y - OFFSET);

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

}
