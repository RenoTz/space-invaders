package game.spaceinvaders.view.model;

import game.spaceinvaders.Controller;
import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.view.shots.IVueTir;
import processing.core.PImage;

public abstract class TSprite implements IVueTir {
    protected ITirs tir;
    protected Controller controller;
    protected PImage jSpriteTir;

    protected TSprite(Controller controller, ITirs tir) {
        this.controller = controller;
        this.tir = tir;
    }

}
	