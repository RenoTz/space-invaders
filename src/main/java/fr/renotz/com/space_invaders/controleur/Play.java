package fr.renotz.com.space_invaders.controleur;

import java.util.ArrayList;

import fr.renotz.com.space_invaders.modele.ennemis.Boss;
import fr.renotz.com.space_invaders.modele.joueur.Joueur;
import fr.renotz.com.space_invaders.tirsGraphiques.JTir;
import fr.renotz.com.space_invaders.vaisseauxGraphiques.AVaisseau;
import processing.core.PApplet;
import processing.core.PImage;

@SuppressWarnings("serial")
public class Play extends PApplet{
	
	PImage fond; 
	InterfaceJeu i;
	Loader l;
	boolean pause = false;
	private int cpt = 0;
	public static ArrayList<JTir> projectilesJ = new ArrayList<>();
	public static ArrayList<JTir> projectilesA = new ArrayList<>();
	public static ArrayList<AVaisseau> vExplosion = new ArrayList<>();
	long bip = 0; 
	
	public void setup(){
		// fenetre
		size(1280,800);
		l = new Loader(this);
		frameRate(60);
		fond=loadImage("../../../src/main/ressources/images/universFond.jpg");
	}

	public void draw(){
		// fond
		image(fond,0,0);
		
		
		if(!isPause()){
			// Listes des tirs et des vaisseaux qui seront d�truits 
			ArrayList<JTir> tirDetruit = new ArrayList<>();
			ArrayList<AVaisseau> vaisseauDetruit = new ArrayList<>();
			// D�claration liste des tirs Aliens � d�truire
			ArrayList<JTir> tirADetruit = new ArrayList<>();
		// vaisseaux : deplacement et dessin		
		for (AVaisseau v : Loader.vaisseaux){				
			v.deplacer();
			v.dessiner();
			// Si collision --> ajout vaisseau et tir aux listes respectives
			for (JTir t : projectilesJ){
				Boss.setTouche(false);
				if(v.collisionJ(t)){
					tirDetruit.add(t);
					vaisseauDetruit.add(v);
					vExplosion.add(v);
					break;
				}				
				if(Boss.isTouche()){
					tirDetruit.add(t);
					break;
				}
			}
			// Si collision --> ajout vaisseau et tir aux listes respectives
			for (JTir t : projectilesA){
				if(v.collisionA(t)){
					tirADetruit.add(t);
					vaisseauDetruit.add(v);
					vExplosion.add(v);
					break;
				}
				if(!Joueur.isGameOver()){
					if(Joueur.isTouche())
						tirADetruit.add(t);	
				}
			}
		}
				
		// Dessins et d�placements des tirs du Joueur
		for (JTir t : projectilesJ){
			// Si tir hors �cran : ajout liste tirD�truit
			if(t.isDetruit())
				tirDetruit.add(t);
			t.deplacer();
			t.dessiner();				
				
		}		
			
		// Dessins et d�placements des tirs des Aliens	
		for (JTir t : projectilesA){
			// Si tir hors �cran : ajout liste tirD�truit
			if(t.isDetruit())
				tirADetruit.add(t);	
			t.deplacer();
			t.dessiner();
							
		}
		
		// Suppression tirs Joueur
		for (JTir td : tirDetruit){			
			destructionTir(td,projectilesJ);							
		}	
		
		// Suppression tirs Aliens
		for (JTir td : tirADetruit){			
			destructionTir(td,projectilesA);							
		}		
		
		// Suppression vaisseaux d�truits et modifications du score total
		for (AVaisseau v : vaisseauDetruit){			
			InterfaceJeu.setScore(v.getPoints());
			destructionVaisseau(v,Loader.vaisseaux);			
		}
				
		//Affichage animation explosion
		for(AVaisseau v : vExplosion){
			if(!v.isFini()){				
				v.explosion(v);
			}else{
				vaisseauDetruit.add(v);
			}
		}		
		
		// Creation du BOSS
		if( InterfaceJeu.getScore() == 4750 &&  !Boss.boss){
			l.loadBoss();
			Boss.boss = true;
		}
		
		}else{
			for (AVaisseau v : Loader.vaisseaux){				
				v.dessiner();
			}
		}		
		// Affichage du cadre
		l.i.cadre();
	}

	/****************************************************************
	 *  La m�thode suivante parcourt la liste des tirs � d�truire   *
	 *    - Si le tir dans la liste � d�truire correspond � un tir  *
	 *      de la liste des tirs cr��s :                             *
	 *		==> Suppression du tir                                  *
	 ****************************************************************/
	public void destructionTir(JTir tDetruit,ArrayList<JTir> list)
	{		
		for(JTir t : list){
			if(t.equals(tDetruit))
			{
				list.remove(t);	
				break;
			}
			
		}
	}

	/******************************************************************  
	 * La m�thode suivante parcourt la liste des vaisseaux � d�truire *
	 *    - Si le vaisseau dans la liste � d�truire correspond � un   *
	 *      vaisseau de la liste des vaisseaux cr��s :                *
	 *		==> Suppression du vaisseau                               *
	 ******************************************************************/
	public void destructionVaisseau(AVaisseau vDetruit,ArrayList<AVaisseau> list)
	{		
		for(AVaisseau v : list){
			if(v.equals(vDetruit))
			{
				list.remove(v);	
				break;
			}
			
		}
	}
	
	public boolean isPause(){
		
		if(this.key == 'p'){
			if (System.currentTimeMillis()>bip+500){
				bip= System.currentTimeMillis();
			    cpt ++;
			if(cpt % 2 != 0)
				pause = true;
			else
				pause = false;
			
			}
			this.key = ' ';
		}
		return pause;
		
	}
	
}
