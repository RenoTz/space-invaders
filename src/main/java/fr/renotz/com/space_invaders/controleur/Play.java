package fr.renotz.com.space_invaders.controleur;

import java.util.List;

import com.google.common.collect.Lists;

import fr.renotz.com.space_invaders.modele.ennemis.Boss;
import fr.renotz.com.space_invaders.modele.joueur.Joueur;
import fr.renotz.com.space_invaders.tirsGraphiques.JTir;
import fr.renotz.com.space_invaders.vaisseauxGraphiques.AVaisseau;
import processing.core.PApplet;
import processing.core.PImage;

@SuppressWarnings("serial")
public class Play extends PApplet{
	
	private PImage fond; 
	private InterfaceJeu interfaceJeu;
	private Loader loader;
	private List<JTir> projectilesJ;
	private List<JTir> projectilesA;
	private List<AVaisseau> vExplosion;
	private Long bip; 
	private boolean pause;
	private int cpt;
	
	public void setup(){
		// fenetre
		this.size(1280,800);
		this.loader = new Loader(this);
		this.setInterfaceJeu(loader.getInterfaceJeu());
		this.frameRate(60);
		this.fond=loadImage("../../../src/main/ressources/images/universFond.jpg");
		// init des listes et des attributs
		this.projectilesJ = Lists.newArrayList();
		this.projectilesA = Lists.newArrayList();
		this.vExplosion = Lists.newArrayList();
		this.bip = new Long(0);
		this.cpt = 0;
		this.pause = false;
	}

	public void draw(){
		// fond
		image(fond,0,0);
		
		
		if(!isPause()){
			// Listes des tirs et des vaisseaux qui seront d�truits 
			List<JTir> tirDetruit = Lists.newArrayList();
			List<AVaisseau> vaisseauDetruit = Lists.newArrayList();
			// D�claration liste des tirs Aliens � d�truire
			List<JTir> tirADetruit = Lists.newArrayList();
		// vaisseaux : deplacement et dessin		
		for (AVaisseau v : loader.getVaisseaux()){				
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
			this.getInterfaceJeu().setScore(v.getPoints());
			destructionVaisseau(v,loader.getVaisseaux());			
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
			loader.loadBoss();
			Boss.boss = true;
		}
		
		}else{
				for (AVaisseau v : loader.getVaisseaux()){				
					v.dessiner();
				}
		}		
		// Affichage du cadre
		loader.getInterfaceJeu().cadre();
	}

	/****************************************************************
	 *  La m�thode suivante parcourt la liste des tirs � d�truire   *
	 *    - Si le tir dans la liste � d�truire correspond � un tir  *
	 *      de la liste des tirs cr��s :                             *
	 *		==> Suppression du tir                                  *
	 ****************************************************************/
	public void destructionTir(JTir tDetruit,List<JTir> list)
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
	public void destructionVaisseau(AVaisseau vDetruit,List<AVaisseau> list)
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
	
	public List<JTir> getProjectilesJ() {
		return projectilesJ;
	}

	public void setProjectilesJ(List<JTir> projectilesJ) {
		this.projectilesJ = projectilesJ;
	}

	public List<JTir> getProjectilesA() {
		return projectilesA;
	}

	public void setProjectilesA(List<JTir> projectilesA) {
		this.projectilesA = projectilesA;
	}

	public List<AVaisseau> getvExplosion() {
		return vExplosion;
	}

	public void setvExplosion(List<AVaisseau> vExplosion) {
		this.vExplosion = vExplosion;
	}

	public InterfaceJeu getInterfaceJeu() {
		return interfaceJeu;
	}

	public void setInterfaceJeu(InterfaceJeu interfaceJeu) {
		this.interfaceJeu = interfaceJeu;
	}

}
