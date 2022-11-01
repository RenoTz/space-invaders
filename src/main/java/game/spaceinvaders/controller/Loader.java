package game.spaceinvaders.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import game.spaceinvaders.Controller;
import game.spaceinvaders.view.IVue;
import game.spaceinvaders.view.shield.SpriteShield;
import game.spaceinvaders.view.enemies.SpriteA;
import game.spaceinvaders.view.enemies.SpriteB;
import game.spaceinvaders.view.enemies.SpriteBoss;
import game.spaceinvaders.view.enemies.SpriteC;
import game.spaceinvaders.view.player.SpritePlayer;
import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;
import game.spaceinvaders.model.shield.Shield;
import game.spaceinvaders.model.spaceships.enemies.Boss;
import game.spaceinvaders.model.spaceships.enemies.MobileA;
import game.spaceinvaders.model.spaceships.enemies.MobileB;
import game.spaceinvaders.model.spaceships.enemies.MobileC;
import game.spaceinvaders.model.spaceships.enemies.MobileD;
import game.spaceinvaders.model.spaceships.player.Player;
import processing.core.PImage;


public class Loader {

    private static final Class<Loader> CLASS = Loader.class;

    private final Controller controller;
    private final GameInterface gameInterface;
    private final List<SpaceShip> spaceChips;

    private Player player;
    private Boss boss;
    private SpaceShip vBoss;

    public PImage[] boom;

    public Loader(Controller controller) throws NoSuchAlgorithmException {
        this.controller = controller;
        this.spaceChips = new ArrayList<>();
        this.gameInterface = new GameInterface(controller);
        loadObject();
        loadImageAnimationBoom();
    }

    private void loadImageAnimationBoom() {
        boom = new PImage[60];
        for (int i = 0; i < 6; i++) {
            boom[i] = controller.loadImage(getImagePath("animations/explosion3/boom1.png"));
            boom[i + 6] = controller.loadImage(getImagePath("animations/explosion3/boom2.png"));
            boom[i + 12] = controller.loadImage(getImagePath("animations/explosion3/boom3.png"));
            boom[i + 18] = controller.loadImage(getImagePath("animations/explosion3/boom4.png"));
            boom[i + 24] = controller.loadImage(getImagePath("animations/explosion3/boom5.png"));
            boom[i + 30] = controller.loadImage(getImagePath("animations/explosion3/boom6.png"));
            boom[i + 36] = controller.loadImage(getImagePath("animations/explosion3/boom7.png"));
            boom[i + 42] = controller.loadImage(getImagePath("animations/explosion3/boom8.png"));
            boom[i + 48] = controller.loadImage(getImagePath("animations/explosion3/boom9.png"));
            boom[i + 54] = controller.loadImage(getImagePath("animations/explosion3/boom10.png"));
        }

    }

    private void loadObject() throws NoSuchAlgorithmException {

        // Premier groupe d'ennemis - Huit
        for (int i = 0; i < 14; i++) {
            IMobile m1 = new MobileA(controller, i * 0.45, new Position((150 * i), 50), 50);
            if (i % 2 != 0) {
                IVue v = new SpriteA(controller, m1);
                SpaceShip a = new SpaceShip(m1, v);
                spaceChips.add(a);
            } else {
                IVue v1 = new SpriteB(controller, m1);
                SpaceShip b = new SpaceShip(m1, v1);
                spaceChips.add(b);
            }
        }
        // Deuxieme groupe d'ennemis - Cercle
        for (int i = 0; i < 18; i++) {
            IMobile m2 = new MobileB(controller, i * 0.35, new Position((75 * i), 200), 50);
            if (i % 2 != 0) {
                IVue v2 = new SpriteA(controller, m2);
                SpaceShip c = new SpaceShip(m2, v2);
                spaceChips.add(c);
            } else {
                IVue v3 = new SpriteB(controller, m2);
                SpaceShip d = new SpaceShip(m2, v3);
                spaceChips.add(d);
            }
        }

        //Troisi�me groupe d'ennemis - Gauche/Droite
        for (int j = 1; j < 8; j++) {
            for (int i = 0; i < 5; i++) {
                if (j % 2 != 0) {
                    IMobile mb1 = new MobileC(controller, new Position((50 + (i * 50)), 50 * j), 50);
                    IVue vb1 = new SpriteC(controller, mb1);
                    SpaceShip b1 = new SpaceShip(mb1, vb1);
                    spaceChips.add(b1);
                } else {
                    IMobile mb2 = new MobileC(controller, new Position((75 + (i * 50)), 50 * j), 50);
                    IVue vb2 = new SpriteC(controller, mb2);
                    SpaceShip b2 = new SpaceShip(mb2, vb2);
                    spaceChips.add(b2);
                }
            }
        }

        //Quatri�me groupe d'ennemis - Serpent
        for (int i = 0; i < 28; i++) {
            IMobile mb3 = new MobileD(controller, i * 0.58, new Position((600 + (i * 120)), 50), 50);
            IVue vb3 = new SpriteC(controller, mb3);
            SpaceShip b3 = new SpaceShip(mb3, vb3);
            spaceChips.add(b3);
        }

        // Create boss
        boss = new Boss(controller, new Position(500, 250), 3000);
        IVue vB = new SpriteBoss(controller, boss);
        vBoss = new SpaceShip(boss, vB);

        //Cr�ation du joueur
        player = new Player(controller, new Position(620, 700), 500);
        IVue vj = new SpritePlayer(controller, player);
        SpaceShip j = new SpaceShip(player, vj);
        spaceChips.add(j);

        //Cr�ation des boucliers
        for (int n = 1; n < 6; n++) {
            for (int i = 0; i < 128; i++) {
                if (n % 2 != 0) {
                    IMobile b1 = new Shield(new Position(i * 10, 620 +(10 * n)));
                    IVue bc = new SpriteShield(controller, b1);
                    SpaceShip bcl = new SpaceShip(b1, bc);
                    spaceChips.add(bcl);
                } else {
                    IMobile b1 = new Shield(new Position(5 + (i * 10), 620 + (10 * n)));
                    IVue bc = new SpriteShield(controller, b1);
                    SpaceShip bcl = new SpaceShip(b1, bc);
                    spaceChips.add(bcl);
                }
            }
        }


    }

    private String getImagePath(String fileName) {
        return FileUtils.getImagePath(fileName, CLASS);
    }

    public Player getPlayer() {
        return player;
    }

    public Boss getBoss() {
        return boss;
    }

    public List<SpaceShip> getSpaceShips() {
        return spaceChips;
    }

    public SpaceShip getVBoss() {
        return vBoss;
    }

    public GameInterface getGameInterface() {
        return gameInterface;
    }
}
