package game.spaceinvaders.view.shots;

import game.spaceinvaders.Controller;
import game.spaceinvaders.model.shots.ITirs;
import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.view.TSprite;

public class vueTirJoueur2 extends TSprite {

    int height = 20;
    int width = 10;

    public vueTirJoueur2(Controller controller, ITirs tir) {
        super(controller, tir);
        jSpriteTir = controller.loadImage(FileUtils.getImagePath("missile.png", getClass()));
    }

    @Override
    public void draw() {
        int x = tir.getPosition().getXpix() - width;
        int y = tir.getPosition().getYpix() - height;
        controller.image((jSpriteTir), x, y);
    }

}
