package game.spaceinvaders.view.shots;

import game.spaceinvaders.Controller;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.view.model.TSprite;

public class vueTirBoss extends TSprite {

    public vueTirBoss(Controller controller, ITirs tir) {
        super(controller, tir);
        jSpriteTir = controller.loadImage(FileUtils.getImagePath("tirBoss.png", getClass()));
        jSpriteTir.resize(20, 0);
    }

    @Override
    public void draw() {
        int x = tir.getPosition().getXpix() - 10;
        int y = tir.getPosition().getYpix();
        controller.image((jSpriteTir), x, y - 10);
    }

}
