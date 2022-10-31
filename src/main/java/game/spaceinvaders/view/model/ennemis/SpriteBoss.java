package game.spaceinvaders.view.model.ennemis;

import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.Controller;
import game.spaceinvaders.model.IMobile;
import processing.core.PImage;
import game.spaceinvaders.view.model.ASprite;

public class SpriteBoss extends ASprite {

    private final PImage spriteBoss;

    public SpriteBoss(Controller controller, IMobile mobile) {
        super(controller, mobile);
        spriteBoss = controller.loadImage(FileUtils.getImagePath("boss.png", getClass()));
        spriteBoss.resize(250, 0);

    }

    @Override
    public void draw() {
        int x = mobile.getPosition().getXpix();
        int y = mobile.getPosition().getYpix();
        controller.image(spriteBoss, x, y);
    }

    @Override
    protected PImage getSprite(int number) {
        return spriteBoss;
    }

    @Override
    protected int getSize() {
        return 250;
    }

}
