package game.spaceinvaders.view.shots;

import game.spaceinvaders.Controller;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.view.model.TSprite;

public class vueTirJoueur1 extends TSprite {

    int width = 10;
    int height = 8;

    public vueTirJoueur1(Controller controller, ITirs tir) {
        super(controller, tir);
        jSpriteTir = controller.loadImage(FileUtils.getImagePath("boule.png", getClass()));
        jSpriteTir.resize(10, 0);
    }

    @Override
    public void draw() {
        int x = tir.getPosition().getXpix() - width;
        int y = tir.getPosition().getYpix() - height;
        controller.image((jSpriteTir), x, y);
    }

}
