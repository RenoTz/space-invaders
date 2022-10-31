package game.spaceinvaders.tirs;

import game.spaceinvaders.view.shots.IVueTir;
import game.spaceinvaders.model.Position;

public class Tir implements IVueTir, ITirs {

    private final ITirs tirs;
    private final IVueTir vueTirs;

    public Tir(ITirs tirs, IVueTir vueTirs) {
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
    public boolean isDetruit() {
        return tirs.isDetruit();
    }

    @Override
    public boolean hit(Tir t) {
        return tirs.hit(t);
    }

    @Override
    public int getPointTirs() {
        return tirs.getPointTirs();
    }

}
