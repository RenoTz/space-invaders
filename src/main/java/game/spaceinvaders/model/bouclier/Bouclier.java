package game.spaceinvaders.model.bouclier;

import game.spaceinvaders.tirsGraphiques.JTir;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;

public class Bouclier implements IMobile {

    Position position;
    boolean collision;

    public Bouclier(Position position, boolean collision) {
        this.position = position;
        this.collision = collision;
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
    public boolean collisionJ(JTir tirs) {
        if ((tirs.getPosition().getXpix() > getPosition().getXpix()) && (tirs.getPosition().getXpix() < getPosition().getXpix() + 20)
                && (tirs.getPosition().getYpix() < getPosition().getYpix() + 20) && (tirs.getPosition().getYpix() > getPosition().getYpix()))
            collision = true;
        return collision;
    }

    @Override
    public boolean collisionA(JTir tirs) {
        if ((tirs.getPosition().getXpix() > getPosition().getXpix()) && (tirs.getPosition().getXpix() < getPosition().getXpix() + 20)
                && (tirs.getPosition().getYpix() + 20 < getPosition().getYpix() + 20) && (tirs.getPosition().getYpix() + 20 > getPosition().getYpix()))
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

    public void setCollision(boolean collision) {
        this.collision = collision;
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

}
