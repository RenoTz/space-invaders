package game.spaceinvaders.model.shots.enemies;

import game.spaceinvaders.model.Position;
import game.spaceinvaders.model.shots.ITirs;

public class TirAlien2 implements ITirs {

    private final Position position;
    private boolean destroy;
    private final int pointsTirs;
    private final int depy = 5;
    private final int rayon = 10;
    private final double gap = 0.05;
    private double t = 0.0;

    public TirAlien2(Position position, boolean destroy, int pointsTirs) {
        this.position = position;
        this.destroy = destroy;
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
    public boolean isDestroy() {
        if (position.getYpix() > 800) {
            setDestroy(true);
        }
        return destroy;
    }

    public void setDestroy(boolean destroy) {
        this.destroy = destroy;
    }

    @Override
    public int getPointTirs() {
        return pointsTirs;
    }

}
