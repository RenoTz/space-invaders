package game.spaceinvaders.controller;

import java.util.ArrayList;

import game.spaceinvaders.Controller;
import game.spaceinvaders.vaisseauxGraphiques.AVaisseau;
import game.spaceinvaders.vaisseauxGraphiques.Vaisseau;
import game.spaceinvaders.vue.IVue;
import game.spaceinvaders.vue.bouclier.SpriteBouclier;
import game.spaceinvaders.vue.ennemis.SpriteA;
import game.spaceinvaders.vue.ennemis.SpriteB;
import game.spaceinvaders.vue.ennemis.SpriteBoss;
import game.spaceinvaders.vue.ennemis.SpriteC;
import game.spaceinvaders.vue.joueur.SpritePlayer;
import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.Position;
import game.spaceinvaders.model.bouclier.Bouclier;
import game.spaceinvaders.model.ennemis.Boss;
import game.spaceinvaders.model.ennemis.MobileA;
import game.spaceinvaders.model.ennemis.MobileB;
import game.spaceinvaders.model.ennemis.MobileC;
import game.spaceinvaders.model.ennemis.MobileD;
import game.spaceinvaders.model.joueur.Player;
import processing.core.PImage;


public class Loader {

    private static final Class<Loader> CLASS = Loader.class;

    private final Controller controller;
    private final InterfaceJeu interfaceJeu;
    private final ArrayList<AVaisseau> spaceChips;

    private Player player;
    private Boss boss;
    private Vaisseau vBoss;

    public PImage[] boom;

    public Loader(Controller controller) {
        this.controller = controller;
        this.spaceChips = new ArrayList<>();
        this.interfaceJeu = new InterfaceJeu(controller);
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

    private void loadObject() {

        // Premier groupe d'ennemis - Huit
        for (int i = 0; i < 14; i++) {

            IMobile m1 = new MobileA(controller, i * 0.45, new Position((150 * i), 50), false, 50);
            if (i % 2 != 0) {
                IVue v = new SpriteA(controller, m1);
                Vaisseau a = new Vaisseau(m1, v);
                spaceChips.add(a);
            } else {
                IVue v1 = new SpriteB(controller, m1);
                Vaisseau b = new Vaisseau(m1, v1);
                spaceChips.add(b);
            }
        }
        // Deuxieme groupe d'ennemis - Cercle
        for (int i = 0; i < 18; i++) {
            IMobile m2 = new MobileB(controller, i * 0.35, new Position((75 * i), 200), false, 50);

            if (i % 2 != 0) {
                IVue v2 = new SpriteA(controller, m2);
                Vaisseau c = new Vaisseau(m2, v2);
                spaceChips.add(c);
            } else {
                IVue v3 = new SpriteB(controller, m2);
                Vaisseau d = new Vaisseau(m2, v3);
                spaceChips.add(d);
            }
        }

        //Troisi�me groupe d'ennemis - Gauche/Droite
        for (int j = 1; j < 8; j++) {
            for (int i = 0; i < 5; i++) {
                if (j % 2 != 0) {
                    IMobile mb1 = new MobileC(controller, new Position((50 + (i * 50)), 50 * j), false, 50);
                    IVue vb1 = new SpriteC(controller, mb1);
                    Vaisseau b1 = new Vaisseau(mb1, vb1);
                    spaceChips.add(b1);
                } else {
                    IMobile mb2 = new MobileC(controller, new Position((75 + (i * 50)), 50 * j), false, 50);
                    IVue vb2 = new SpriteC(controller, mb2);
                    Vaisseau b2 = new Vaisseau(mb2, vb2);
                    spaceChips.add(b2);
                }
            }
        }

        //Quatri�me groupe d'ennemis - Serpent
        for (int i = 0; i < 28; i++) {
            IMobile mb3 = new MobileD(controller, i * 0.58, new Position((600 + (i * 120)), 50), false, 50);
            IVue vb3 = new SpriteC(controller, mb3);
            Vaisseau b3 = new Vaisseau(mb3, vb3);
            spaceChips.add(b3);
        }

        // Create boss
        boss = new Boss(controller, new Position(500, 250), false, 1000);
        IVue vB = new SpriteBoss(controller, boss);
        vBoss = new Vaisseau(boss, vB);

        //Cr�ation du joueur
        player = new Player(controller, new Position(620, 700), 500, false);
        IVue vj = new SpritePlayer(controller, player);
        Vaisseau j = new Vaisseau(player, vj);
        spaceChips.add(j);

        //Cr�ation des boucliers
        for (int n = 1; n < 6; n++) {
            for (int i = 0; i < 128; i++) {
                if (n % 2 != 0) {
                    IMobile b1 = new Bouclier(new Position(((i * 10)), 620 + (10 * n)), false);
                    IVue bc = new SpriteBouclier(controller, b1);
                    Vaisseau bcl = new Vaisseau(b1, bc);
                    spaceChips.add(bcl);
                } else {
                    IMobile b1 = new Bouclier(new Position((5 + (i * 10)), 620 + (10 * n)), false);
                    IVue bc = new SpriteBouclier(controller, b1);
                    Vaisseau bcl = new Vaisseau(b1, bc);
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

    public ArrayList<AVaisseau> getSpaceShips() {
        return spaceChips;
    }

    public Vaisseau getVBoss() {
        return vBoss;
    }

    public InterfaceJeu getInterfaceJeu() {
        return interfaceJeu;
    }
}
