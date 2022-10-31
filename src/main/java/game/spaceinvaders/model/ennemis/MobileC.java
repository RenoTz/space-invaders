package game.spaceinvaders.model.ennemis;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import game.spaceinvaders.Controller;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.tirs.Tir;
import game.spaceinvaders.view.shots.IVueTir;
import game.spaceinvaders.view.shots.vueTirNormal;
import game.spaceinvaders.tirs.ennemis.TirAlien1;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;

public class MobileC implements IMobile {

    int xdir = 1, yDir = 10, xPixInit, yPixInit;
    Position position;
    Controller controller;
    private int rand;
    int points;
    boolean collision;

    public MobileC(Controller controller, Position position, int points) throws NoSuchAlgorithmException {
        this.controller = controller;
        this.position = position;
        this.points = points;
        random();
        xPixInit = position.getXpix();
        yPixInit = position.getYpix();
    }

    @Override
    public void move() {

        if (position.getXpix() > xPixInit + 40) {
            xdir = -1;
            position.setYpix(position.getYpix() + yDir);
            if (position.getYpix() > yPixInit + 100) {
                yDir = -10;
            }
            if (position.getYpix() < yPixInit) {
                yDir = 10;
            }
        }
        if (position.getXpix() < xPixInit - 40) {
            xdir = 1;
            position.setYpix(position.getYpix() + yDir);
            if (position.getYpix() > yPixInit + 100) {
                yDir = -10;
            }
            if (position.getYpix() < yPixInit) {
                yDir = 10;
            }
        }
        position.setXpix(position.getXpix() + xdir);

        setR(getR() + 1);
        if (rand > 1000) {
            ITirs ta = new TirAlien1(new Position(position.getXpix() + 18, position.getYpix()), false, 50);
            IVueTir vta = new vueTirNormal(controller, ta);
            Tir jta = new Tir(ta, vta);
            controller.getProjectilesA().add(jta);
        }

    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public IMobile getMobile() {
        return this;
    }

    public void random() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        setR(random.nextInt(1000));
    }

    private void setR(int rand) {
        this.rand = rand;
    }

    @Override
    public int getR() {
        if (rand > 1000) {
            rand = 0;
        }
        return rand;
    }

    @Override
    public boolean collisionJ(Tir tir) {
        if ((tir.getPosition().getXpix() > getPosition().getXpix()) && (tir.getPosition().getXpix() < getPosition().getXpix() + 40)
                && (tir.getPosition().getYpix() < getPosition().getYpix() + 40) && (tir.getPosition().getYpix() > getPosition().getYpix())) {
            collision = true;
        }
        return collision;
    }

    @Override
    public boolean collisionA(Tir tir) {
        return false;
    }

    public int getPoints() {
        return points;
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
    public boolean isCollision() {
        return false;
    }

    @Override
    public int getVie() {
        return 0;
    }

    @Override
    public void setTouche(boolean touche) {

    }

}