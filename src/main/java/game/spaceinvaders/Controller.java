package game.spaceinvaders;

import java.util.ArrayList;
import java.util.Arrays;

import game.spaceinvaders.controller.InterfaceJeu;
import game.spaceinvaders.controller.Loader;
import game.spaceinvaders.tirsGraphiques.JTir;
import game.spaceinvaders.vaisseauxGraphiques.AVaisseau;
import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.model.ennemis.Boss;
import processing.core.PApplet;
import processing.core.PImage;

public class Controller extends PApplet {

    PImage fond;
    InterfaceJeu interfaceJeu;

    public Loader getLoader() {
        return loader;
    }

    Loader loader;
    boolean pause = false;
    private int cpt = 0;
    public ArrayList<JTir> projectilesJ;

    public ArrayList<JTir> projectilesA;
    public ArrayList<AVaisseau> vExplosion;
    long bip = 0;

    public void setup() {
        projectilesJ = new ArrayList<>();
        projectilesA = new ArrayList<>();
        vExplosion = new ArrayList<>();
        // fenetre
        loader = new Loader(this);
        printGameInfo();
        frameRate(60);
        fond = loadImage(FileUtils.getImagePath("universFond.jpg", getClass()));
    }

    private void printGameInfo() {
        long ennemies = loader.getSpaceShips().stream().filter(aVaisseau -> !(aVaisseau.getMobile() instanceof Boss)).count();
        long boss = loader.getSpaceShips().stream().filter(aVaisseau -> aVaisseau.getMobile() instanceof Boss).count();

        System.out.printf("il y a %d vaisseaux ennemis%n", ennemies);
        System.out.printf("il y a %d boss%n", boss);
    }

    public void settings() {
        size(1280, 800);
    }

    public void draw() {
        // fond
        image(fond, 0, 0);


        if (!isPause()) {
            // Listes des tirs et des vaisseaux qui seront d�truits
            ArrayList<JTir> tirDetruit = new ArrayList<>();
            ArrayList<AVaisseau> vaisseauDetruit = new ArrayList<>();
            // D�claration liste des tirs Aliens � d�truire
            ArrayList<JTir> tirADetruit = new ArrayList<>();
            // vaisseaux : deplacement et dessin
            for (AVaisseau v : loader.getSpaceShips()) {
                if (!v.isFini()) {
                    v.move();
                    v.draw();
                }
                // Si collision --> ajout vaisseau et tir aux listes respectives
                for (JTir t : projectilesJ) {
                    loader.getBoss().setTouche(false);
                    if (v.collisionJ(t)) {
                        tirDetruit.add(t);
                        vaisseauDetruit.add(v);
                        vExplosion.add(v);
                        break;
                    }
                    if (loader.getBoss().isTouche()) {
                        tirDetruit.add(t);
                        break;
                    }
                }
                // Si collision --> ajout vaisseau et tir aux listes respectives
                for (JTir t : projectilesA) {
                    if (v.collisionA(t)) {
                        tirADetruit.add(t);
                        vaisseauDetruit.add(v);
                        vExplosion.add(v);
                        break;
                    }
                    if (!loader.getPlayer().isGameOver()) {
                        if (loader.getPlayer().isTouche())
                            tirADetruit.add(t);
                    }
                }
            }

            // Dessins et d�placements des tirs du Joueur
            for (JTir t : projectilesJ) {
                // Si tir hors �cran : ajout liste tirD�truit
                if (t.isDetruit())
                    tirDetruit.add(t);
                t.move();
                t.draw();

            }

            // Dessins et d�placements des tirs des Aliens
            for (JTir t : projectilesA) {
                // Si tir hors �cran : ajout liste tirD�truit
                if (t.isDetruit())
                    tirADetruit.add(t);
                t.move();
                t.draw();
            }

            // Suppression tirs Joueur
            for (JTir td : tirDetruit) {
                destructionTir(td, projectilesJ);
            }

            // Suppression tirs Aliens
            for (JTir td : tirADetruit) {
                destructionTir(td, projectilesA);
            }

            // Suppression vaisseaux d�truits et modifications du score total
            for (AVaisseau v : vaisseauDetruit) {
                loader.getInterfaceJeu().setScore(v.getPoints());
                destructionVaisseau(v, loader.getSpaceShips());
            }

            // display animation explosion
            for (AVaisseau v : vExplosion) {
                if (!v.isFini()) {
                    v.explosion(v);
                } else {
                    vaisseauDetruit.add(v);
                }
            }

            // Add BOSS to spaceships
            if (loader.getInterfaceJeu().getScore() == 4750 && !loader.getBoss().isBossStarted()) {
                loader.getBoss().setBossStarted(true);
                loader.getSpaceShips().add(loader.getVBoss());
            }

        } else {
            for (AVaisseau v : loader.getSpaceShips()) {
                v.draw();
            }
        }
        // display du cadre
        loader.getInterfaceJeu().show();
    }

    /****************************************************************
     *  La m�thode suivante parcourt la liste des tirs � d�truire   *
     *    - Si le tir dans la liste � d�truire correspond � un tir  *
     *      de la liste des tirs cr��s :                             *
     *		==> Suppression du tir                                  *
     ****************************************************************/
    public void destructionTir(JTir tDetruit, ArrayList<JTir> list) {
        for (JTir t : list) {
            if (t.equals(tDetruit)) {
                list.remove(t);
                break;
            }

        }
    }

    /******************************************************************
     * La m�thode suivante parcourt la liste des vaisseaux � d�truire *
     *    - Si le vaisseau dans la liste � d�truire correspond � un   *
     *      vaisseau de la liste des vaisseaux cr��s :                *
     *		==> Suppression du vaisseau                               *
     ******************************************************************/
    public void destructionVaisseau(AVaisseau vDetruit, ArrayList<AVaisseau> list) {
        for (AVaisseau v : list) {
            if (v.equals(vDetruit)) {
                list.remove(v);
                break;
            }

        }
    }

    public boolean isPause() {
        if (this.key == 'p') {
            if (System.currentTimeMillis() > bip + 500) {
                bip = System.currentTimeMillis();
                cpt++;
                pause = cpt % 2 != 0;
            }
            this.key = ' ';
        }
        return pause;

    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[]{Controller.class.getName()};
        if (Arrays.asList(passedArgs).isEmpty()) {
            PApplet.main(appletArgs);
        } else {
            PApplet.main(concat(appletArgs, passedArgs));
        }
    }

    public ArrayList<JTir> getProjectilesJ() {
        return projectilesJ;
    }

    public ArrayList<JTir> getProjectilesA() {
        return projectilesA;
    }

}
