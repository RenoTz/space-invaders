package fr.renotz.com.space_invaders.tirsGraphiques;

import fr.renotz.com.space_invaders.modele.Position;
import fr.renotz.com.space_invaders.tirs.ITirs;
import fr.renotz.com.space_invaders.vueTirs.IVueTirs;

public class Tir extends JTir{
	
	ITirs tirs;
	IVueTirs vueTirs;

	public Tir(ITirs tirs, IVueTirs vueTirs){
		this.tirs=tirs;
		this.vueTirs=vueTirs;
	}

	@Override
	public void deplacer() {
		tirs.deplacer();
	}

	@Override
	public void dessiner() {
		vueTirs.dessiner();
		
	}

	@Override
	public Position getPosition() {
		return tirs.getPosition();
		
	}

	@Override
	public boolean isDetruit() {
		return tirs.isDetruit();
	}

	@Override
	public boolean collision(JTir t) {
		return tirs.collision(t);
	}
	

	@Override
	public int getPointTirs() {
		return tirs.getPointTirs();
	}

}
