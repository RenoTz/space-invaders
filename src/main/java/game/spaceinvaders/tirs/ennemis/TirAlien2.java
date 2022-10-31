package game.spaceinvaders.tirs.ennemis;

import game.spaceinvaders.model.Position;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.tirs.Tir;

public class TirAlien2 implements ITirs {

    int depy = 5, rayon = 10;
    double t = 0.0, gap = 0.05;
    Position position;
    boolean detruit, collision;
    int pointsTirs;

    public TirAlien2(Position position, boolean detruit, int pointsTirs) {
        this.position = position;
        this.detruit = detruit;
        this.pointsTirs = pointsTirs;
    }

    @Override
    public void move() {
        t += gap;

        int x = position.getXpix() - (int) (rayon * Math.sin(2 * t));
        int y = position.getYpix();
        position.setXpix(x);
        position.setYpix(y + depy);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean isDetruit() {
        if (position.getYpix() > 800) {
            setDetruit(true);
        }
        return detruit;
    }

    public void setDetruit(boolean detruit) {
        this.detruit = detruit;
    }

    @Override
    public boolean hit(Tir t) {
        return collision;
    }

    @Override
    public int getPointTirs() {
        return pointsTirs;
    }

}
