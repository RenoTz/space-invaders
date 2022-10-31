package game.spaceinvaders.model.ennemis;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import game.spaceinvaders.Controller;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.tirs.Tir;
import game.spaceinvaders.view.shots.IVueTir;
import game.spaceinvaders.view.shots.vueTirBoss;
import game.spaceinvaders.tirs.ennemis.TirBoss;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;

public class Boss implements IMobile {

    private final Controller controller;
    private final Position position;
    private boolean collision;
    private boolean bossStarted;
    private boolean touche;
    private double t = 0.0;
    private int vie;
    private int rand;

    public Boss(Controller controller, Position position, int vie) throws NoSuchAlgorithmException {
        this.controller = controller;
        this.position = position;
        this.vie = vie;
        random();
    }

    @Override
    public void move() throws NoSuchAlgorithmException {

        double gap = -0.03;
        int rayon = 220;
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
                        ITirs tb1 = new TirBoss(new Position(x + 55 + (35 * i), y + 140), false, 80);
                        IVueTir vtb1 = new vueTirBoss(controller, tb1);
                        Tir jtb = new Tir(tb1, vtb1);
                        controller.getProjectilesA().add(jtb);
                    } else {
                        ITirs tb1 = new TirBoss(new Position(x + 55 + (35 * i), y + 120), false, 80);
                        IVueTir vtb1 = new vueTirBoss(controller, tb1);
                        Tir jtb = new Tir(tb1, vtb1);
                        controller.getProjectilesA().add(jtb);
                    }
                } else {
                    ITirs tb1 = new TirBoss(new Position(x + 62 + (31 * i), y + 40), false, 80);
                    IVueTir vtb1 = new vueTirBoss(controller, tb1);
                    Tir jtb = new Tir(tb1, vtb1);
                    controller.getProjectilesA().add(jtb);
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
    public boolean collisionA(Tir tir) {
        return false;
    }

    @Override
    public boolean collisionJ(Tir tir) {
        if ((tir.getPosition().getXpix() > getPosition().getXpix() + 80) && (tir.getPosition().getXpix() < getPosition().getXpix() + 200)
                && (tir.getPosition().getYpix() < getPosition().getYpix() + 150) && (tir.getPosition().getYpix() > getPosition().getYpix())) {
            setVie(tir.getPointTirs());
            setTouche(true);
            if (getVie() == 0) {
                collision = true;
                controller.getLoader().getGameInterface().setScore(1250);
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
        if (vie - points > 0) {
            vie -= points;
        } else {
            vie = 0;
        }
    }

    @Override
    public boolean isCollision() {
        return collision;
    }

    @Override
    public boolean isTouche() {
        return touche;
    }

    public void random() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        setR(random.nextInt(99));
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
