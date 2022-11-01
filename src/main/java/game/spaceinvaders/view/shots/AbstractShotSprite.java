package game.spaceinvaders.view.shots;

import game.spaceinvaders.Controller;
import game.spaceinvaders.model.shots.ITirs;
import processing.core.PImage;

public abstract class AbstractShotSprite implements IViewShot {
    protected ITirs tir;
    protected Controller controller;
    protected PImage jSpriteTir;

    protected AbstractShotSprite(Controller controller, ITirs tir) {
        this.controller = controller;
        this.tir = tir;
    }

}
	