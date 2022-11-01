package game.spaceinvaders.model.shots.player;

import game.spaceinvaders.model.Position;
import game.spaceinvaders.model.shots.ITirs;

public class ShotPlayerB implements ITirs {

    int depy = 8;
    Position position;
    boolean destroy;
    int pointsTirs;

    public ShotPlayerB(Position position, boolean destroy, int pointsTirs) {
        this.position = position;
        this.destroy = destroy;
        this.pointsTirs = pointsTirs;
    }

    @Override
    public void move() {

        int x = position.getXpix();
        int y = position.getYpix();

        position.setXpix(x);
        position.setYpix(y - depy);

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
