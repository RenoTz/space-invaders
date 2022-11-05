package game.spaceinvaders.view;

import game.spaceinvaders.Controller;
import game.spaceinvaders.model.IMobile;
import game.spaceinvaders.model.SpaceShip;
import processing.core.PImage;

public abstract class ASprite implements IVue {
    protected IMobile mobile;
    protected Controller controller;

    protected static final int OFFSET_DEFAULT = 40;
    protected static final long RANGE = 600;

    private int countAnimation = 0;
    private long startTime = 0;
    private boolean fini;

    protected ASprite(Controller controller, IMobile mobile) {
        this.controller = controller;
        this.mobile = mobile;
    }

    @Override
    public void draw() {
        int x = mobile.getPosition().getXpix();
        int y = mobile.getPosition().getYpix();

        if (System.currentTimeMillis() - startTime > RANGE) {
            controller.image(getSprite(2), x, y);
        } else {
            controller.image(getSprite(1), x, y);
        }
        if (System.currentTimeMillis() - startTime > RANGE * 2) {
            startTime = System.currentTimeMillis();
        }
    }

    @Override
    public void explosion(SpaceShip v) {
        int x = v.getPosition().getXpix();
        int y = v.getPosition().getYpix();

        if (getResize() != 0) {
            controller.getLoader().boom[countAnimation].resize(getResize(), 0);
        }
        controller.image(controller.getLoader().boom[countAnimation], x - getOffset(), y - getOffset());
        countAnimation++;

        if (countAnimation == controller.getLoader().boom.length) {
            countAnimation = 0;
            v.setFini(true);
        }
    }

    @Override
    public boolean isFini() {
        return fini;
    }

    @Override
    public void setFini(boolean fini) {
        this.fini = fini;
    }

    protected abstract PImage getSprite(int number);

    protected abstract int getResize();

    protected abstract int getOffset();

}
