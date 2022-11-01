package game.spaceinvaders.view.shots;

import game.spaceinvaders.Controller;
import game.spaceinvaders.model.shots.ITirs;
import game.spaceinvaders.utils.FileUtils;

public class ViewShotPlayer1 extends AbstractShotSprite {

    int width = 10;
    int height = 8;

    public ViewShotPlayer1(Controller controller, ITirs tir) {
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
