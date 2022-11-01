package game.spaceinvaders.model.shots;

import game.spaceinvaders.model.Position;
import game.spaceinvaders.view.shots.IViewShot;

public class Tir implements IViewShot, ITirs {

    private final ITirs tirs;
    private final IViewShot vueTirs;

    public Tir(ITirs tirs, IViewShot vueTirs) {
        this.tirs = tirs;
        this.vueTirs = vueTirs;
    }

    @Override
    public void move() {
        tirs.move();
    }

    @Override
    public void draw() {
        vueTirs.draw();
    }

    @Override
    public Position getPosition() {
        return tirs.getPosition();
    }

    @Override
    public boolean isDestroy() {
        return tirs.isDestroy();
    }

    @Override
    public int getPointTirs() {
        return tirs.getPointTirs();
    }

}
