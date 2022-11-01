package game.spaceinvaders.view.enemies;

import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.Controller;
import game.spaceinvaders.model.IMobile;
import processing.core.PImage;
import game.spaceinvaders.view.ASprite;

public class SpriteBoss extends ASprite {

    private final PImage sprite;

    public SpriteBoss(Controller controller, IMobile mobile) {
        super(controller, mobile);
        sprite = controller.loadImage(FileUtils.getImagePath("boss.png", getClass()));
        sprite.resize(250, 0);

    }

    @Override
    public void draw() {
        int x = mobile.getPosition().getXpix();
        int y = mobile.getPosition().getYpix();
        controller.image(sprite, x, y);
    }

    @Override
    protected PImage getSprite(int number) {
        return sprite;
    }

    @Override
    protected int getResize() {
        return 250;
    }

    @Override
    protected int getOffset() {
        return OFFSET_DEFAULT;
    }

}
