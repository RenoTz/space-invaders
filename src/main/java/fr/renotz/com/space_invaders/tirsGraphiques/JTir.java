package fr.renotz.com.space_invaders.tirsGraphiques;

import fr.renotz.com.space_invaders.tirs.ITirs;
import fr.renotz.com.space_invaders.vueTirs.IVueTirs;

public abstract class JTir implements IVueTirs, ITirs{
	
	@Override
	public abstract void deplacer();
	

	@Override
	public abstract void dessiner();

	@Override
	public abstract boolean collision(JTir t);

}
