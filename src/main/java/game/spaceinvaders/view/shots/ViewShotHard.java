package game.spaceinvaders.view.shots;

import game.spaceinvaders.Controller;
import game.spaceinvaders.model.shots.ITirs;
import game.spaceinvaders.utils.FileUtils;

public class ViewShotHard extends AbstractShotSprite {

    private int cpt = 0;
    int width = 5;
    int height = 5;

    public ViewShotHard(Controller controller, ITirs tir) {
        super(controller, tir);
        jSpriteTir = controller.loadImage(FileUtils.getImagePath("missile1.png", getClass()));
        jSpriteTir.resize(20, 0);
    }

    @Override
    public void draw() {

        int x = tir.getPosition().getXpix();
        int y = tir.getPosition().getYpix();

        if (cpt > 50) {
            cpt = 0;
        }
        if (controller.getLoader().getPlayer().getDir() - y < 300 && cpt > 25) {
            controller.fill(255, 0, 0);
        } else {
            controller.fill(255, 200, 200);
        }
        controller.ellipse(x, y + 20, width * 4, height * 4);
        controller.fill(200, 0, 220);
        controller.ellipse(x, y + 20, width * 2, height * 2);
        controller.fill(100, 100, 220);
        controller.ellipse(x, y + 20, width, height);
        cpt++;
    }

}
