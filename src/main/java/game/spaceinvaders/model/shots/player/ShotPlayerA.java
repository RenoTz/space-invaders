package game.spaceinvaders.model.shots.player;

import game.spaceinvaders.model.Position;
import game.spaceinvaders.model.shots.ITirs;

public class ShotPlayerA implements ITirs {

    private final Position position;
    private final int pointsTirs;
    private boolean destroy;

    private double t = 0.52;
    private static final double GAP = -0.05;
    private static final int RAYON = 10;

    public ShotPlayerA(Position position, boolean destroy, int pointsTirs) {
        this.position = position;
        this.destroy = destroy;
        this.pointsTirs = pointsTirs;
    }

    @Override
    public void move() {
        t += GAP;
        int x = position.getXpix() + (int) (RAYON * Math.sin(10 * t));
        int y = position.getYpix() + (int) (RAYON * Math.sin(0.3 * t)) + (int) (RAYON * Math.sin(0.3 * t));
        position.setXpix(x);
        position.setYpix(y);
    }

    public boolean isDestroy() {
		if (position.getYpix() < 0) {
			setDestroy(true);
		}
        return destroy;
    }

    public void setDestroy(boolean destroy) {
        this.destroy = destroy;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public int getPointTirs() {
        return pointsTirs;
    }

}
