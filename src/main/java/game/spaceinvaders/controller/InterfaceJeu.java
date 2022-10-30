package game.spaceinvaders.controller;

import game.spaceinvaders.Controller;
import game.spaceinvaders.utils.FileUtils;
import processing.core.PImage;

public class InterfaceJeu {

    private static final Class<InterfaceJeu> CLASS = InterfaceJeu.class;

    private final Controller controller;
    private final PImage jSpriteTir1;
    private final PImage jSpriteTir2;

    private int minute = 3, second = 0;
    private long interval = 1000;
    private long lastTime = 0;
    private String time;
    private int score = 0;

    public InterfaceJeu(Controller controller) {
        this.controller = controller;
        jSpriteTir1 = controller.loadImage(FileUtils.getImagePath("boule.png", CLASS));
        jSpriteTir2 = controller.loadImage(FileUtils.getImagePath("missile.png", CLASS));
        jSpriteTir1.resize(45, 0);
        jSpriteTir2.resize(12, 0);
    }

    public void show() {

        // Display score
        rect(2, 0, 200, 40);
        text("Score : " + getScore(), 10, 30, 30);

        // Display title/event
        rect(200, 0, 1155, 40);
        if (controller.getLoader().getPlayer().isGameOver() || minute == 0 && second == 0) {
            controller.frameRate(30);
            text("***       GAME OVER       ***", 440, 30, 30);
        } else if (controller.getLoader().getBoss().isCollision() && minute >= 0 && second > 0) {
            text("***        YOU WON        ***", 440, 30, 30);
        } else if (!controller.getLoader().getBoss().isCollision()) {
            text("*** Space Invader Project ***", 440, 30, 30);
            rect(1155, 0, 224, 40);
            text(rebours(), 1175, 30, 30);
        }

        // Display vie du BOSS
        if (controller.getLoader().getBoss().isBossStarted()) {
            rectVieBoss(775, 40, getBossHP(), 15);
        }

        // Display du type tir du joueur
        rect(1240, 80, 40, 40);
        if (controller.getLoader().getPlayer().getCptTirs() % 2 > 0)
            controller.image(jSpriteTir2, 1255, 82);
        else
            controller.image(jSpriteTir1, 1240, 80);

        // Display commands
        rect(0, 780, 1280, 20);
        text("Commands : Q = Gauche ; D = Droite ; Z = Tirer ; S = changer tir", 25, 795, 15);
        text("HP ", 550, 795, 15);
        rectVieJoueur(570, 780, getPlayerHP(), 15);
        text("P = Pause ; Echap = Quitter", 1070, 795, 15);

        //Pause
        if (controller.isPause()) {
            text("PAUSE", 385, 400, 150);
        }
    }

    public int getPlayerHP() {
        return controller.getLoader().getPlayer().getVie() / 2;
    }

    public int getBossHP() {
        return controller.getLoader().getBoss().getVie() / 2;
    }

    public String rebours() {

        if (!controller.isPause()) {
            if (second < 10) {
                time = minute + " : 0" + second;
            } else {
                time = minute + " : " + second;
            }
            if (System.currentTimeMillis() - lastTime > interval) {
                if (second == 0 && minute > 0) {
                    minute--;
                    second = 60;
                }
                lastTime = System.currentTimeMillis();
                if (second > 0 && minute >= 0) {
                    second--;
                }
            }
        }
        return time;
    }

    public void rect(int x, int y, int w, int h) {
        controller.fill(0, 45, 20);
        controller.rect(x, y, w, h);
    }

    public void rectVieJoueur(int x, int y, int w, int h) {
        controller.fill(70, 0, 220);
        controller.rect(x, y, w, h);
    }

    public void rectVieBoss(int x, int y, int w, int h) {
        controller.fill(220, 0, 20);
        controller.rect(x, y, w, h);
    }

    public void text(String str, int x, int y, int s) {
        controller.textSize(s);
        controller.fill(240, 195, 0);
        controller.text(str, x, y);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

}
