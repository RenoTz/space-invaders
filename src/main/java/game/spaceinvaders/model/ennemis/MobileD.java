package game.spaceinvaders.model.ennemis;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import game.spaceinvaders.Controller;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.tirs.Tir;
import game.spaceinvaders.view.shots.IVueTir;
import game.spaceinvaders.view.shots.vueTirHard;
import game.spaceinvaders.tirs.ennemis.TirAlien2;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;

public class MobileD implements IMobile {

    int xPixInit;
    int yPixInit;
    Position position;
    Controller controller;
    private int rand;
    int points;
    double t;
    double gap = -0.05;
    int rayon = 90;
    boolean collision;

    public MobileD(Controller controller, double t, Position position, int points) throws NoSuchAlgorithmException {
        this.controller = controller;
        this.t = t;
        this.position = position;
        this.points = points;
        random();
        xPixInit = position.getXpix();
        yPixInit = position.getYpix();
    }

    @Override
    public void move() throws NoSuchAlgorithmException {
        t += gap;
        this.rand = getR() + 1;
        int x = 1000 + (int) (rayon * Math.sin(t));
        int y = 280 + (int) (rayon * Math.sin(0.1 * t)) + (int) (rayon * Math.sin(0.1 * t));
        position.setXpix(x);
        position.setYpix(y);

        // Creation des tirs
        this.rand = getR() + 1;
        if (rand > 1000) {
            ITirs ta = new TirAlien2(new Position(position.getXpix() + 10, position.getYpix()), false, 75);
            IVueTir vta = new vueTirHard(controller, ta);
            Tir jta = new Tir(ta, vta);
            controller.getProjectilesA().add(jta);
        }

        if (rand > 1000) {
            random();
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
        this.rand = random.nextInt(1000);
    }

    @Override
    public int getR() {
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
        // TODO Auto-generated method stub
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
