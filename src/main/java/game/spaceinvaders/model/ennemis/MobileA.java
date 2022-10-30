package game.spaceinvaders.model.ennemis;

import java.util.Random;

import game.spaceinvaders.Controller;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.tirsGraphiques.JTir;
import game.spaceinvaders.tirsGraphiques.Tir;
import game.spaceinvaders.vueTirs.IVueTirs;
import game.spaceinvaders.vueTirs.ennemis.vueTirNormal;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;
import game.spaceinvaders.tirs.ennemis.TirAlien2;

public class MobileA implements IMobile {
    double t;
    double gap = -0.02;
    int rayon = 100;
    int points;
    Position position;
    Controller f;
    private int rand;
    boolean collision;

    public MobileA(Controller f, double t, Position position, boolean collision, int points) {
        this.f = f;
        this.t = t;
        this.position = position;
        this.collision = collision;
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
            ITirs ta = new TirAlien2(f, new Position(x + 18, y), false, 50);
            IVueTirs vta = new vueTirNormal(f, ta);
            Tir jta = new Tir(ta, vta);
            f.getProjectilesA().add(jta);
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

    public void random() {
        Random rand = new Random();
        setR(rand.nextInt(1000));
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
    public boolean collisionJ(JTir tirs) {
        if ((tirs.getPosition().getXpix() > getPosition().getXpix()) && (tirs.getPosition().getXpix() < getPosition().getXpix() + 40)
                && (tirs.getPosition().getYpix() < getPosition().getYpix() + 40) && (tirs.getPosition().getYpix() > getPosition().getYpix())) {
            collision = true;
        }
        return collision;
    }

    @Override
    public boolean collisionA(JTir tirs) {
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
