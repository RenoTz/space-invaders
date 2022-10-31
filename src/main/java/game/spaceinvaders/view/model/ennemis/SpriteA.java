package game.spaceinvaders.view.model.ennemis;

import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.Controller;
import game.spaceinvaders.model.IMobile;
import processing.core.PImage;
import game.spaceinvaders.view.model.ASprite;

public class SpriteA extends ASprite {

    private final PImage sprite1;
    private final PImage sprite2;

    public SpriteA(Controller controller, IMobile mobile) {
        super(controller, mobile);
        sprite1 = controller.loadImage(FileUtils.getImagePath("alienR.png", getClass()));
        sprite1.resize(50, 0);
        sprite2 = controller.loadImage(FileUtils.getImagePath("alienB.png", getClass()));
        sprite2.resize(50, 0);
    }

    @Override
    protected PImage getSprite(int number) {
        return number == 1 ? sprite1 : sprite2;
    }

    @Override
    protected int getSize() {
        return 0;
    }

}
