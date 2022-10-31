package game.spaceinvaders;

import game.spaceinvaders.controller.Loader;
import game.spaceinvaders.model.bouclier.Bouclier;
import game.spaceinvaders.model.ennemis.MobileA;
import game.spaceinvaders.model.ennemis.MobileB;
import game.spaceinvaders.model.ennemis.MobileC;
import game.spaceinvaders.model.ennemis.MobileD;
import game.spaceinvaders.controller.SpaceShip;
import game.spaceinvaders.tirs.Tir;
import game.spaceinvaders.utils.FileUtils;
import processing.core.PApplet;
import processing.core.PImage;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller extends PApplet {

    private PImage fond;
    private Loader loader;

    private boolean pause;
    private int cpt = 0;
    private long bip = 0;
    private List<Tir> projectilesJ;
    private List<Tir> projectilesA;
    private List<SpaceShip> spaceShipsToBlast;
    private List<SpaceShip> spaceShipsToDestroy;
    private List<Tir> shotsToDestroy;

    @Override
    public void setup() {
        projectilesJ = new ArrayList<>();
        projectilesA = new ArrayList<>();
        spaceShipsToBlast = new ArrayList<>();
        spaceShipsToDestroy = new ArrayList<>();
        shotsToDestroy = new ArrayList<>();
        // setup
        try {
            loader = new Loader(this);
            printGameInfo();
            frameRate(60);
            fond = loadImage(FileUtils.getImagePath("universFond.jpg", getClass()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private void printGameInfo() {
        long enemies = loader.getSpaceShips().stream().filter(aVaisseau -> !(aVaisseau.getMobile() instanceof Bouclier)).count();
        System.out.println(String.format("il y a %d vaisseaux ennemis", enemies));
        long shields = loader.getSpaceShips().stream().filter(spaceship -> spaceship.getMobile() instanceof Bouclier).count();
        System.out.println(String.format("il y a %d boucliers", shields));
    }

    @Override
    public void settings() {
        size(1280, 800);
    }

    @Override
    public void draw() {
        // fond
        image(fond, 0, 0);

        if (!isPause()) {
            // spaceships
            for (SpaceShip spaceShip : loader.getSpaceShips()) {
                if (!spaceShip.isFini()) {
                    try {
                        spaceShip.move();
                        spaceShip.draw();
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                }
                // Si collision --> ajout vaisseau et tir aux listes respectives
                for (Tir t : projectilesJ) {
                    loader.getBoss().setTouche(false);
                    if (spaceShip.collisionJ(t)) {
                        addDestroyLists(spaceShip, t);
                        break;
                    }
                    if (loader.getBoss().isTouche()) {
                        shotsToDestroy.add(t);
                        break;
                    }
                }
                // Si collision --> ajout vaisseau et tir aux listes respectives
                for (Tir shot : projectilesA) {
                    if (spaceShip.collisionA(shot)) {
                        addDestroyLists(spaceShip, shot);
                        break;
                    }
                    if (!loader.getPlayer().isGameOver() && loader.getPlayer().isTouche()) {
                        shotsToDestroy.add(shot);
                    }
                }
            }

            // Dessins et d�placements des tirs du Joueur
            for (Tir t : projectilesJ) {
                // Si tir hors �cran : ajout liste tirD�truit
                if (t.isDetruit()) {
                    shotsToDestroy.add(t);
                }
                t.move();
                t.draw();
            }

            // Dessins et d�placements des tirs des Aliens
            for (Tir t : projectilesA) {
                // Si tir hors �cran : ajout liste tirD�truit
                if (t.isDetruit()) {
                    shotsToDestroy.add(t);
                }
                t.move();
                t.draw();
            }

            // Suppression tirs
            projectilesJ.removeAll(shotsToDestroy);
            projectilesA.removeAll(shotsToDestroy);

            // display animation explosion
            for (SpaceShip v : spaceShipsToBlast) {
                if (!v.isFini()) {
                    v.explosion(v);
                } else {
                    spaceShipsToDestroy.add(v);
                }
            }

            // Suppression vaisseaux d�truits et modifications du score total
            loader.getSpaceShips().removeAll(spaceShipsToDestroy);

            // Add BOSS to spaceships
            if (loader.getGameInterface().getScore() == 4750 && !loader.getBoss().isBossStarted()) {
                loader.getBoss().setBossStarted(true);
                loader.getSpaceShips().add(loader.getVBoss());
            }

        } else {
            loader.getSpaceShips().forEach(SpaceShip::draw);
        }
        // display du cadre
        loader.getGameInterface().show();
    }

    private void addDestroyLists(SpaceShip spaceShip, Tir shot) {
        shotsToDestroy.add(shot);
        spaceShipsToDestroy.add(spaceShip);
        spaceShipsToBlast.add(spaceShip);
        if (spaceShip.getMobile() instanceof MobileA || spaceShip.getMobile() instanceof MobileB || spaceShip.getMobile() instanceof MobileC || spaceShip.getMobile() instanceof MobileD) {
            loader.getGameInterface().setScore(spaceShip.getPoints());
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

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[]{Controller.class.getName()};
        if (Arrays.asList(passedArgs).isEmpty()) {
            PApplet.main(appletArgs);
        } else {
            PApplet.main(concat(appletArgs, passedArgs));
        }
    }

    public List<Tir> getProjectilesJ() {
        return projectilesJ;
    }

    public List<Tir> getProjectilesA() {
        return projectilesA;
    }

    public Loader getLoader() {
        return loader;
    }

}
