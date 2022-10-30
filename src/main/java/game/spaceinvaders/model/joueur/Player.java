package game.spaceinvaders.model.joueur;

import game.spaceinvaders.Controller;
import game.spaceinvaders.model.Position;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.tirsGraphiques.JTir;
import game.spaceinvaders.tirsGraphiques.Tir;
import game.spaceinvaders.vueTirs.IVueTirs;
import game.spaceinvaders.vueTirs.joueur.vueTirJoueur1;
import game.spaceinvaders.vueTirs.joueur.vueTirJoueur2;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.tirs.joueur.TirJoueur1;
import game.spaceinvaders.tirs.joueur.TirJoueur2;


public class Player implements IMobile {

    private Position position;
    private Controller f;
    private ITirs t;
    private IVueTirs vt;
    boolean collision;
    boolean gameOver = false, touche = false;
    private int depx = 7;
    private int vie;
    private int dir = 0, cptTirs = 0, cpt = 0;
    private long interval = 100;
    private long dateDernierTir = 0;
    private long bip = 0;

    public Player(Controller f, Position position, int vie, boolean collision) {
        this.f = f;
        this.position = position;
        this.vie = vie;
        this.collision = collision;
    }


    @Override
    public void move() {

        int x = position.getXpix();
        int y = position.getYpix();

        if (f.keyPressed) {
            if (f.key == 'q' && x > 0) {
                position.setXpix(x - depx);
                dir = -depx;
            }
            if (f.key == 'd' && x < 1220) {
                position.setXpix(x + depx);
                dir = depx;
            }

        } else
            dir = 0;
        if (f.keyPressed) {
            if (f.key == 'z') {
                if (cptTirs % 2 > 0)
                    tir(typeTir2(x, y));
                else
                    tir(typeTir1(x, y));
            }
        }
        if (f.keyPressed) {
            if (f.key == 's') {
                if (System.currentTimeMillis() > bip + 500) {
                    bip = System.currentTimeMillis();
                    cptTirs++;
                    if (cptTirs % 2 > 0)
                        typeTir2(x, y);
                    else
                        typeTir1(x, y);
                }
                f.key = ' ';
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

        ITirs t = new TirJoueur1(f, 0.52, new Position(x + 35, y), false, 50);
        IVueTirs vt = new vueTirJoueur1(f, t);
        Tir jt = new Tir(t, vt);

        return jt;

    }

    public int getCptTirs() {
        return cptTirs;
    }

    protected Tir typeTir2(int x, int y) {
        ITirs t = new TirJoueur2(f, new Position(x + 35, y), false, 75);
        IVueTirs vt = new vueTirJoueur2(f, t);
        Tir jt = new Tir(t, vt);

        return jt;
    }

    protected void tir(Tir jt) {
        if (cptTirs % 2 > 0)
            interval = 500;
        else
            interval = 100;
        if (System.currentTimeMillis() - dateDernierTir > interval) {
            f.getProjectilesJ().add(jt);
            dateDernierTir = System.currentTimeMillis();
        }
    }

    @Override
    public int getR() {
        return 0;
    }

    @Override
    public boolean collisionJ(JTir tirs) {
        // PAS DE COLLISIONS AVEC SES PROPRES TIRS
        return false;
    }

    @Override
    public boolean collisionA(JTir tirs) {

        touche = false;
        if ((tirs.getPosition().getXpix() > getPosition().getXpix()) && (tirs.getPosition().getXpix() < getPosition().getXpix() + 55)
                && (tirs.getPosition().getYpix() < getPosition().getYpix() + 50) && (tirs.getPosition().getYpix() > getPosition().getYpix())) {
            setVie(tirs.getPointTirs());
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

}

