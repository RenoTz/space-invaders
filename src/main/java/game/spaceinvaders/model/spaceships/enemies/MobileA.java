package game.spaceinvaders.model.spaceships.enemies;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import game.spaceinvaders.Controller;
import game.spaceinvaders.model.shots.ITirs;
import game.spaceinvaders.model.shots.Tir;
import game.spaceinvaders.view.shots.IViewShot;
import game.spaceinvaders.view.shots.ViewShotMedium;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;
import game.spaceinvaders.model.shots.enemies.TirAlien2;

public class MobileA implements IMobile {
    double t;
    double gap = -0.02;
    int rayon = 100;
    int points;
    Position position;
    Controller controller;
    private int rand;
    boolean collision;

    public MobileA(Controller controller, double t, Position position, int points) throws NoSuchAlgorithmException {
        this.controller = controller;
        this.t = t;
        this.position = position;
        this.points = points;
        random();
    }

    @Override
    public void move() {

        t += gap;
        setR(getR() + 1);
        int x = 600 + (int) (rayon * Math.sin(t)) + (int) (rayon * Math.cos(t));
        int y = 270 + (int) (rayon * Math.cos(2 * t));

        position.setXpix(x);
        position.setYpix(y);


        if (rand > 1000) {
            ITirs ta = new TirAlien2(new Position(x + 18, y), false, 50);
            IViewShot vta = new ViewShotMedium(controller, ta);
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

    public void setR(int rand) {
        this.rand = rand;
    }

    @Override
    public int getR() {
        if (rand > 1001)
            rand = 0;
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

    @Override
    public boolean isDestructible() {
        return true;
    }

}
