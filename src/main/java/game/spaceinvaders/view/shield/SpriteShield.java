package game.spaceinvaders.view.shield;

import game.spaceinvaders.Controller;
import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.model.IMobile;
import processing.core.PImage;
import game.spaceinvaders.view.ASprite;

public class SpriteShield extends ASprite {

    private final PImage image;

    public SpriteShield(Controller controller, IMobile mobile) {
        super(controller, mobile);
        image = controller.loadImage(FileUtils.getImagePath("brique2.png", getClass()));
        image.resize(10, 0);
    }

    @Override
    public void draw() {
        int x = mobile.getPosition().getXpix();
        int y = mobile.getPosition().getYpix();
        controller.image(image, x, y);
    }

    @Override
    protected PImage getSprite(int number) {
        return null;
    }

    @Override
    protected int getResize() {
        return 0;
    }

    @Override
    protected int getOffset() {
        return OFFSET_DEFAULT;
    }

}
