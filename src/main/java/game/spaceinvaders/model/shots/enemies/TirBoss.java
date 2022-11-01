package game.spaceinvaders.model.shots.enemies;

import game.spaceinvaders.model.Position;
import game.spaceinvaders.model.shots.ITirs;
import game.spaceinvaders.model.shots.Tir;

public class TirBoss implements ITirs {

    private final Position position;
    private boolean destroy;
    private final int pointsTirs;
    private final int depy = 12;

    public TirBoss(Position position, boolean destroy, int pointsTirs) {
        this.position = position;
        this.destroy = destroy;
        this.pointsTirs = pointsTirs;
    }

    @Override
    public void move() {
        int x = position.getXpix();
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
