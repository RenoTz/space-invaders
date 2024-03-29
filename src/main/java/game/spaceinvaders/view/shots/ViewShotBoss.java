package game.spaceinvaders.view.shots;

import game.spaceinvaders.Controller;
import game.spaceinvaders.model.shots.ITirs;
import game.spaceinvaders.utils.FileUtils;

public class ViewShotBoss extends AbstractShotSprite {

    public ViewShotBoss(Controller controller, ITirs tir) {
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
