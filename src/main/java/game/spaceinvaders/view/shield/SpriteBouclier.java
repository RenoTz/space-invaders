package game.spaceinvaders.view.shield;

import game.spaceinvaders.Controller;
import game.spaceinvaders.controller.SpaceShip;
import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.model.IMobile;
import processing.core.PImage;
import game.spaceinvaders.view.ASprite;

public class SpriteBouclier extends ASprite {

    private final PImage spriteBouclier;
    public boolean fini;

    public SpriteBouclier(Controller controller, IMobile mobile) {
        super(controller, mobile);
        spriteBouclier = controller.loadImage(FileUtils.getImagePath("brique2.png", getClass()));
        spriteBouclier.resize(10, 0);
    }

    @Override
    public void draw() {
        int x = mobile.getPosition().getXpix();
        int y = mobile.getPosition().getYpix();
        controller.image((spriteBouclier), x, y);
    }

    @Override
    public void explosion(SpaceShip v) {}

    public boolean isFini() {
        return fini;
    }

    @Override
    public void setFini(boolean fini) {
        this.fini = fini;
    }

    @Override
    protected PImage getSprite(int number) {
        return null;
    }

    @Override
    protected int getSize() {
        return 0;
    }

}
