package fr.renotz.com.space_invaders.tirs;

import fr.renotz.com.space_invaders.modele.Position;
import fr.renotz.com.space_invaders.tirsGraphiques.JTir;

public interface ITirs {
	
	public void deplacer();
	public Position getPosition();
	public boolean isDetruit();
	boolean collision(JTir t);
	public int getPointTirs();

}
