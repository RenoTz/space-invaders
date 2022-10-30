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
import game.spaceinvaders.tirs.ennemis.TirAlien1;

public class MobileB implements IMobile {

    double t;
    double gap = -0.02;
    int rayon = 240;
    int points;
    Position position;
    Controller f;
    private int rand;
    boolean collision;

    public MobileB(Controller f, double t, Position position, boolean collision, int points) {
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
        int x = position.getXpix();
        int y = position.getYpix();

        if (getR() == 1000) {
            ITirs ta = new TirAlien1(f, new Position(x + 18, y), false, 25);
            IVueTirs vta = new vueTirNormal(f, ta);
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

    public void random() {
        Random rand = new Random();
        setR(rand.nextInt(1000));
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
    public boolean collisionJ(JTir tirs) {
        if ((tirs.getPosition().getXpix() > getPosition().getXpix()) && (tirs.getPosition().getXpix() < getPosition().getXpix() + 40)
                && (tirs.getPosition().getYpix() < getPosition().getYpix() + 40) && (tirs.getPosition().getYpix() > getPosition().getYpix())) {
            collision = true;
        }
        return collision;
    }

    @Override
    public boolean collisionA(JTir tirs) {
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
