package game.spaceinvaders.model.ennemis;

import java.util.Random;

import game.spaceinvaders.Controller;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.tirsGraphiques.JTir;
import game.spaceinvaders.tirsGraphiques.Tir;
import game.spaceinvaders.vueTirs.IVueTirs;
import game.spaceinvaders.vueTirs.ennemis.vueTirBoss;
import game.spaceinvaders.tirs.ennemis.TirBoss;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;

public class Boss implements IMobile {

    double t = 0.0;
    double gap = -0.03;
    int rayon = 220;
    private int vie;
    private int rand;
    private Position position;
    private Controller f;
    private boolean collision;
    private boolean bossStarted = false;
    public boolean touche = false;

    public Boss(Controller f, Position position, boolean collision, int vie) {
        this.f = f;
        this.position = position;
        this.collision = collision;
        this.vie = vie;
        random();
    }

    @Override
    public void move() {

        t += gap;
        int x = 500 + (int) (rayon * Math.sin(t)) + (int) (rayon * Math.cos(3 * t));
        int y = 270 + (int) (rayon * Math.cos(2 * t));

        position.setXpix(x);
        position.setYpix(y);

        setR(getR() + 1);
        if (getR() > 100) {
            random();
            for (int i = 0; i < 5; i++) {
                if (i > 0 && i < 4) {
                    if (i == 2) {
                        ITirs tb1 = new TirBoss(f, new Position(x + 55 + (35 * i), y + 140), false, 80);
                        IVueTirs vtb1 = new vueTirBoss(f, tb1);
                        Tir jtb = new Tir(tb1, vtb1);
                        f.getProjectilesA().add(jtb);
                    } else {
                        ITirs tb1 = new TirBoss(f, new Position(x + 55 + (35 * i), y + 120), false, 80);
                        IVueTirs vtb1 = new vueTirBoss(f, tb1);
                        Tir jtb = new Tir(tb1, vtb1);
                        f.getProjectilesA().add(jtb);
                    }
                } else {
                    ITirs tb1 = new TirBoss(f, new Position(x + 62 + (31 * i), y + 40), false, 80);
                    IVueTirs vtb1 = new vueTirBoss(f, tb1);
                    Tir jtb = new Tir(tb1, vtb1);
                    f.getProjectilesA().add(jtb);
                }
            }
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

    @Override
    public boolean collisionA(JTir tirs) {
        return false;
    }

    @Override
    public boolean collisionJ(JTir tirs) {

        if ((tirs.getPosition().getXpix() > getPosition().getXpix() + 80) && (tirs.getPosition().getXpix() < getPosition().getXpix() + 200)
                && (tirs.getPosition().getYpix() < getPosition().getYpix() + 150) && (tirs.getPosition().getYpix() > getPosition().getYpix())) {
            setVie(tirs.getPointTirs());
            setTouche(true);
            if (getVie() == 0) {
                collision = true;
//                f.getInterfaceJeu().setScore(1250);
            }
        }
        return collision;
    }

    @Override
    public void setTouche(boolean touche) {
        this.touche = touche;
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public int getVie() {
        return vie;
    }

    public void setVie(int points) {
        if (vie - points > 0)
            vie -= points;
        else
            vie = 0;
    }

    @Override
    public boolean isCollision() {
        return collision;
    }

    @Override
    public boolean isTouche() {
        return touche;
    }

    public void random() {
        Random rand = new Random();
        setR(rand.nextInt(99));
    }

    public void setR(int rand) {
        this.rand = rand;
    }

    @Override
    public int getR() {
        return rand;
    }

    @Override
    public boolean isBossStarted() {
        return bossStarted;
    }

    @Override
    public void setBossStarted(boolean bossStarted) {
        this.bossStarted = bossStarted;
    }

}
