package fr.renotz.com.space_invaders.modele;

import fr.renotz.com.space_invaders.tirsGraphiques.JTir;

public interface IMobile {
	public void deplacer();
	public Position getPosition();	
	public int getR();
	public boolean collisionA(JTir tirs);
	public boolean collisionJ(JTir tirs);
	public int getPoints();
	
}
