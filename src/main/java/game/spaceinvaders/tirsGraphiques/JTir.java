package game.spaceinvaders.tirsGraphiques;

import game.spaceinvaders.tirs.ITirs;
import game.spaceinvaders.vueTirs.IVueTirs;

public abstract class JTir implements IVueTirs, ITirs {

    @Override
    public abstract void move();


    @Override
    public abstract void draw();

    @Override
    public abstract boolean hit(JTir t);

}
