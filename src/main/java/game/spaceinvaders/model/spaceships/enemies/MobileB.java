package game.spaceinvaders.model.spaceships.enemies;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import game.spaceinvaders.Controller;
import game.spaceinvaders.model.shots.ITirs;
import game.spaceinvaders.model.shots.Tir;
import game.spaceinvaders.view.shots.IVueTir;
import game.spaceinvaders.view.shots.vueTirNormal;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;
import game.spaceinvaders.model.shots.enemies.TirAlien1;

public class MobileB implements IMobile {

    double t;
    double gap = -0.02;
    int rayon = 240;
    int points;
    Position position;
    Controller f;
    private int rand;
    boolean collision;

    public MobileB(Controller f, double t, Position position, int points) throws NoSuchAlgorithmException {
        this.f = f;
        this.t = t;
        this.position = position;
        this.points = points;
        random();
    }

    @Override
    public void move() {
        t += gap;
        setR(getR() + 1);
        int x = position.getXpix();
        int y = position.getYpix();

        if (getR() == 1000) {
            ITirs ta = new TirAlien1(new Position(x + 18, y), false, 25);
            IVueTir vta = new vueTirNormal(f, ta);
            Tir jta = new Tir(ta, vta);
            f.getProjectilesA().add(jta);
        }

        setR(getR() + 1);
        position.setXpix((int) (600 + (rayon * Math.cos(t))));
        position.setYpix((int) (280 + (rayon * Math.sin(t))));
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
        if (rand > 1000)
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
