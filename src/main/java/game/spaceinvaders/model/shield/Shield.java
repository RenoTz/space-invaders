package game.spaceinvaders.model.shield;

import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;
import game.spaceinvaders.model.shots.Tir;

public class Shield implements IMobile {

    Position position;
    boolean collision;

    public Shield(Position position) {
        this.position = position;
    }

    @Override
    public void move() {
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public IMobile getMobile() {
        return this;
    }

    @Override
    public int getR() {
        return 0;
    }

    @Override
    public boolean collisionJ(Tir tir) {
        if ((tir.getPosition().getXpix() > getPosition().getXpix()) && (tir.getPosition().getXpix() < getPosition().getXpix() + 20)
                && (tir.getPosition().getYpix() < getPosition().getYpix() + 20) && (tir.getPosition().getYpix() > getPosition().getYpix()))
            collision = true;
        return collision;
    }

    @Override
    public boolean collisionA(Tir tir) {
        if ((tir.getPosition().getXpix() > getPosition().getXpix()) && (tir.getPosition().getXpix() < getPosition().getXpix() + 20)
                && (tir.getPosition().getYpix() + 20 < getPosition().getYpix() + 20) && (tir.getPosition().getYpix() + 20 > getPosition().getYpix()))
            collision = true;
        return collision;
    }

    public boolean isCollision() {
        return collision;
    }

    @Override
    public int getVie() {
        return 0;
    }

    @Override
    public void setTouche(boolean touche) {

    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public boolean isBossStarted() {
        return false;
    }

    @Override
    public void setBossStarted(boolean bossStarted) {

    }

    @Override
    public boolean isTouche() {
        return false;
    }

    @Override
    public boolean isDestructible() {
        return false;
    }

}
