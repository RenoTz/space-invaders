package game.spaceinvaders.model.spaceships.player;

import game.spaceinvaders.Controller;
import game.spaceinvaders.model.Position;
import game.spaceinvaders.model.shots.ITirs;
import game.spaceinvaders.model.shots.Tir;
import game.spaceinvaders.view.shots.IViewShot;
import game.spaceinvaders.view.shots.ViewShotPlayer1;
import game.spaceinvaders.view.shots.ViewShotPlayer2;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.shots.player.ShotPlayerA;
import game.spaceinvaders.model.shots.player.ShotPlayerB;


public class Player implements IMobile {

    private final Position position;
    private final Controller controller;
    boolean collision;
    boolean gameOver, touche;
    private int depx = 7;
    private int vie;
    private int dir = 0, cptTirs = 0, cpt = 0;
    private long range = 100;
    private long dateDernierTir = 0;
    private long bip = 0;

    public Player(Controller controller, Position position, int vie) {
        this.controller = controller;
        this.position = position;
        this.vie = vie;
    }


    @Override
    public void move() {

        int x = position.getXpix();
        int y = position.getYpix();

        if (controller.keyPressed) {
            if (controller.key == 'q' && x > 0) {
                position.setXpix(x - depx);
                dir = -depx;
            }
            if (controller.key == 'd' && x < 1220) {
                position.setXpix(x + depx);
                dir = depx;
            }

        } else
            dir = 0;
        if (controller.keyPressed) {
            if (controller.key == 'z') {
                if (cptTirs % 2 > 0)
                    tir(typeTir2(x, y));
                else
                    tir(typeTir1(x, y));
            }
        }
        if (controller.keyPressed) {
            if (controller.key == 's') {
                if (System.currentTimeMillis() > bip + 500) {
                    bip = System.currentTimeMillis();
                    cptTirs++;
                    if (cptTirs % 2 > 0)
                        typeTir2(x, y);
                    else
                        typeTir1(x, y);
                }
                controller.key = ' ';
            }
        }

    }


    public int getDir() {
        return dir;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public IMobile getMobile() {
        return this;
    }

    protected Tir typeTir1(int x, int y) {
        ITirs t = new ShotPlayerA(new Position(x + 35, y), false, 50);
        IViewShot vt = new ViewShotPlayer1(controller, t);
        return new Tir(t, vt);
    }

    protected Tir typeTir2(int x, int y) {
        ITirs t = new ShotPlayerB(new Position(x + 35, y), false, 75);
        IViewShot vt = new ViewShotPlayer2(controller, t);
        return new Tir(t, vt);
    }

    public int getCptTirs() {
        return cptTirs;
    }

    protected void tir(Tir jt) {
        if (cptTirs % 2 > 0)
            range = 500;
        else
            range = 100;
        if (System.currentTimeMillis() - dateDernierTir > range) {
            controller.getProjectilesJ().add(jt);
            dateDernierTir = System.currentTimeMillis();
        }
    }

    @Override
    public int getR() {
        return 0;
    }

    @Override
    public boolean collisionJ(Tir tir) {
        return false;
    }

    @Override
    public boolean collisionA(Tir tir) {

        touche = false;
        if ((tir.getPosition().getXpix() > getPosition().getXpix()) && (tir.getPosition().getXpix() < getPosition().getXpix() + 55)
                && (tir.getPosition().getYpix() < getPosition().getYpix() + 50) && (tir.getPosition().getYpix() > getPosition().getYpix())) {
            setVie(tir.getPointTirs());
            touche = true;
            if (getVie() == 0) {
                collision = true;
                setGameOver(true);
            }
        }
        return collision;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isTouche() {
        return touche;
    }

    @Override
    public boolean isCollision() {
        return false;
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

    public int getVie() {
        return vie;
    }

    @Override
    public void setTouche(boolean touche) {

    }

    public void setVie(int points) {
        if (vie - points > 0)
            this.vie -= points;
        else
            this.vie = 0;
    }

    @Override
    public boolean isDestructible() {
        return true;
    }

}

