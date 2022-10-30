package game.spaceinvaders.model.ennemis;

import java.util.Random;

import game.spaceinvaders.Controller;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.tirsGraphiques.JTir;
import game.spaceinvaders.tirsGraphiques.Tir;
import game.spaceinvaders.vueTirs.IVueTirs;
import game.spaceinvaders.vueTirs.ennemis.vueTirHard;
import game.spaceinvaders.tirs.ennemis.TirAlien2;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;

public class MobileD implements IMobile {

    int XpixInit;
    int YpixInit;
    Position position;
    Controller f;
    private int rand;
    int points;
    double t;
    double gap = -0.05;
    int rayon = 90;
    boolean collision;

    public MobileD(Controller f, double t, Position position, boolean collision, int points) {
        this.f = f;
        this.t = t;
        this.position = position;
        this.collision = collision;
        this.points = points;
        random();
        XpixInit = position.getXpix();
        YpixInit = position.getYpix();
    }

    @Override
    public void move() {
        t += gap;
        this.rand = getR() + 1;
        int x = 1000 + (int) (rayon * Math.sin(t));
        int y = 280 + (int) (rayon * Math.sin(0.1 * t)) + (int) (rayon * Math.sin(0.1 * t));
        position.setXpix(x);
        position.setYpix(y);

        // Creation des tirs
        this.rand = getR() + 1;
        if (rand > 1000) {
            ITirs ta = new TirAlien2(f, new Position(position.getXpix() + 10, position.getYpix()), false, 75);
            IVueTirs vta = new vueTirHard(f, ta);
            Tir jta = new Tir(ta, vta);
            f.getProjectilesA().add(jta);
        }

        if (rand > 1000)
            random();
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
        this.rand = rand.nextInt(1000);
    }

    @Override
    public int getR() {
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
