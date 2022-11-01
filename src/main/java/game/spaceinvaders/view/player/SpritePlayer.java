package game.spaceinvaders.view.player;

import game.spaceinvaders.utils.FileUtils;
import game.spaceinvaders.Controller;
import game.spaceinvaders.model.IMobile;
import processing.core.PImage;
import game.spaceinvaders.view.ASprite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class SpritePlayer extends ASprite {

    private static final int OFFSET_PLAYER = 25;
    private final Map<Predicate<Integer>, PImage> mapSprites;
    private final PImage spriteG;
    private final PImage spriteD;
    private int cpt = 0;

    public SpritePlayer(Controller controller, IMobile mobile) {
        super(controller, mobile);
        PImage sprite1 = controller.loadImage(getImagePath("Joueur/sfighter.PNG"));
        PImage sprite2 = controller.loadImage(getImagePath("Joueur/sfighter2.PNG"));
        PImage sprite3 = controller.loadImage(getImagePath("Joueur/sfighter3.PNG"));
        PImage sprite4 = controller.loadImage(getImagePath("Joueur/sfighter4.PNG"));
        PImage sprite5 = controller.loadImage(getImagePath("Joueur/sfighter5.PNG"));
        PImage sprite6 = controller.loadImage(getImagePath("Joueur/sfighter6.PNG"));
        spriteG = controller.loadImage(getImagePath("Joueur/sfighterG2.png"));
        spriteD = controller.loadImage(getImagePath("Joueur/sfighterD2.png"));

        sprite1.resize(60, 0);
        sprite2.resize(60, 0);
        sprite3.resize(60, 0);
        sprite4.resize(60, 0);
        sprite5.resize(60, 0);
        sprite6.resize(60, 0);
        spriteG.resize(60, 0);
        spriteD.resize(60, 0);

        mapSprites = new HashMap<>();
        mapSprites.put(cpt -> cpt < 10, sprite1);
        mapSprites.put(cpt -> cpt < 20 && cpt >= 10, sprite2);
        mapSprites.put(cpt -> cpt < 30 && cpt >= 20, sprite3);
        mapSprites.put(cpt -> cpt < 40 && cpt >= 30, sprite4);
        mapSprites.put(cpt -> cpt < 50 && cpt >= 40, sprite5);
        mapSprites.put(cpt -> cpt < 60 && cpt >= 50, sprite6);
    }

    @Override
    public void draw() {
        int x = mobile.getPosition().getXpix();
        int y = mobile.getPosition().getYpix();

        // animation
        if (controller.getLoader().getPlayer().getDir() < 0) {
            controller.image((spriteG), x, y);
            cpt = 0;
        } else if (controller.getLoader().getPlayer().getDir() > 0) {
            controller.image((spriteD), x, y);
            cpt = 0;
        } else {
            if (cpt == 60) {
                cpt = 0;
            }
            controller.image(getPImage(), x, y);
            cpt++;
        }
    }

    private PImage getPImage() {
        return mapSprites.entrySet()
                .stream()
                .filter(entry -> entry.getKey().test(cpt))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(null);
    }

    @Override
    protected PImage getSprite(int number) {
        return null;
    }

    private String getImagePath(String fileName) {
        return FileUtils.getImagePath(fileName, getClass());
    }

    @Override
    protected int getResize() {
        return 0;
    }

    @Override
    protected int getOffset() {
        return OFFSET_PLAYER;
    }

}
