package fr.renotz.com.space_invaders.vaisseauxGraphiques;

import fr.renotz.com.space_invaders.modele.IMobile;
import fr.renotz.com.space_invaders.modele.Position;
import fr.renotz.com.space_invaders.tirsGraphiques.JTir;
import fr.renotz.com.space_invaders.vue.IVue;

public class Vaisseau extends AVaisseau {
	IMobile mobile;
	IVue vue;
	
	public Vaisseau(IMobile mobile, IVue vue){
		this.mobile=mobile;
		this.vue=vue;
	}
	
	@Override
	public void deplacer() {
		mobile.deplacer();
	}

	@Override
	public void dessiner() {
		vue.dessiner();
	}

	@Override
	public Position getPosition() {
		return mobile.getPosition();
	}

	@Override
	public int getR() {
		return mobile.getR();
	}

	@Override
	public boolean collisionJ(JTir tirs) {
		return mobile.collisionJ(tirs);
	}
	
	@Override 
	public boolean collisionA(JTir tirs) {
		return mobile.collisionA(tirs);
	}

	@Override
	public int getPoints() {
		return mobile.getPoints();
	}

	@Override
	public void explosion(AVaisseau v) {
		vue.explosion(v);	
	}
	
	@Override
	public boolean isFini() {
		return vue.isFini();
	}

}
