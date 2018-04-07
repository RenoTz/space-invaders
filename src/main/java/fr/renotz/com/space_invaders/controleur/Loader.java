package fr.renotz.com.space_invaders.controleur;

import java.util.ArrayList;

import fr.renotz.com.space_invaders.modele.IMobile;
import fr.renotz.com.space_invaders.modele.Position;
import fr.renotz.com.space_invaders.modele.bouclier.Bouclier;
import fr.renotz.com.space_invaders.modele.ennemis.Boss;
import fr.renotz.com.space_invaders.modele.ennemis.MobileA;
import fr.renotz.com.space_invaders.modele.ennemis.MobileB;
import fr.renotz.com.space_invaders.modele.ennemis.MobileC;
import fr.renotz.com.space_invaders.modele.ennemis.MobileD;
import fr.renotz.com.space_invaders.modele.joueur.Joueur;
import fr.renotz.com.space_invaders.vaisseauxGraphiques.AVaisseau;
import fr.renotz.com.space_invaders.vaisseauxGraphiques.Vaisseau;
import fr.renotz.com.space_invaders.vue.IVue;
import fr.renotz.com.space_invaders.vue.bouclier.SpriteBouclier;
import fr.renotz.com.space_invaders.vue.ennemis.SpriteA;
import fr.renotz.com.space_invaders.vue.ennemis.SpriteB;
import fr.renotz.com.space_invaders.vue.ennemis.SpriteBoss;
import fr.renotz.com.space_invaders.vue.ennemis.SpriteC;
import fr.renotz.com.space_invaders.vue.joueur.SpriteJoueur;
import processing.core.PImage;


public class Loader{

	Play f;
	InterfaceJeu i;
	
	static ArrayList<AVaisseau> vaisseaux = new ArrayList<>();
	Joueur j;
	public static PImage [] boom;

	public Loader(Play f) {
		this.f=f;
		i = new InterfaceJeu(f);
		loadObject();
		loadImageAnimationBoom();

	}

	private void loadImageAnimationBoom() {
		boom = new PImage[60];
		for(int i = 0; i < 6;i++){
			boom[i] = f.loadImage("../../../src/main/ressources/images/Animation/explosion3/boom1.png");		
			boom[i+6] =  f.loadImage("../../../src/main/ressources/images/Animation/explosion3/boom2.png");			
			boom[i+12] =  f.loadImage("../../../src/main/ressources/images/Animation/explosion3/boom3.png");	
			boom[i+18] = f.loadImage("../../../src/main/ressources/images/Animation/explosion3/boom4.png");		
			boom[i+24] =  f.loadImage("../../../src/main/ressources/images/Animation/explosion3/boom5.png");			
			boom[i+30] =  f.loadImage("../../../src/main/ressources/images/Animation/explosion3/boom6.png");	
			boom[i+36] =  f.loadImage("../../../src/main/ressources/images/Animation/explosion3/boom7.png");	
			boom[i+42] = f.loadImage("../../../src/main/ressources/images/Animation/explosion3/boom8.png");		
			boom[i+48] =  f.loadImage("../../../src/main/ressources/images/Animation/explosion3/boom9.png");			
			boom[i+54] =  f.loadImage("../../../src/main/ressources/images/Animation/explosion3/boom10.png");	
		}
		
	}

	private void loadObject() {

		// Premier groupe d'ennemis - Huit
		for(int i=0; i<14; i++){

			IMobile m1 = new MobileA(f,i*0.45, new Position((150*i),50),false, 50);
			if(i%2 != 0){
				IVue v = new SpriteA(f, m1);
				Vaisseau a =  new Vaisseau(m1,v);
				vaisseaux.add(a);
			}
			else{
				IVue v1 = new SpriteB(f, m1);
				Vaisseau b =  new Vaisseau(m1,v1);
				vaisseaux.add(b);
			}			
		}
		// Deuxieme groupe d'ennemis - Cercle
		for(int i=0; i<18; i++){
			IMobile m2 = new MobileB(f,i*0.35, new Position((75*i),200),false,50);

			if(i%2 != 0){
				IVue v2 = new SpriteA(f, m2);
				Vaisseau c =  new Vaisseau(m2,v2);
				vaisseaux.add(c);
			}
			else{
				IVue v3 = new SpriteB(f, m2 );
				Vaisseau d =  new Vaisseau(m2,v3);
				vaisseaux.add(d);
			}
		}
		
		//Troisi�me groupe d'ennemis - Gauche/Droite
		for(int j=1; j<8 ; j++){
			for(int i=0; i<5; i++){			
				if(j%2 != 0){
					IMobile mb1 = new MobileC(f, new Position((50+(i*50)),50*j),false,50);
					IVue vb1 = new SpriteC(f, mb1 );
					Vaisseau b1 =  new Vaisseau(mb1,vb1);
					vaisseaux.add(b1);
				}else{
					IMobile mb2 = new MobileC(f, new Position((75+(i*50)),50*j),false,50);
					IVue vb2 = new SpriteC(f, mb2);
					Vaisseau b2 =  new Vaisseau(mb2,vb2);
					vaisseaux.add(b2);
				}
			}
		}
		
		//Quatri�me groupe d'ennemis - Serpent
		for(int i=0; i<28; i++){			
			IMobile mb3 = new MobileD(f,i*0.58, new Position((600+(i*120)),50),false,50);
			IVue vb3 = new SpriteC(f, mb3);
			Vaisseau b3 =  new Vaisseau(mb3,vb3);
			vaisseaux.add(b3);
		}
		
		//Cr�ation du joueur
		IMobile mj = new Joueur(f,new Position(620,700),500,false);
		IVue vj = new SpriteJoueur(f, mj );
		Vaisseau j =  new Vaisseau(mj,vj);
		vaisseaux.add(j);		
		
		//Cr�ation des boucliers
		for(int n=1; n<6 ; n++){
			for(int i=0; i<128; i++){			
				if(n%2 != 0){
					IMobile b1 = new Bouclier(new Position((0+(i*10)),620+(10*n)),false);
					IVue bc = new SpriteBouclier(f, b1);
					Vaisseau bcl =  new Vaisseau(b1,bc);
					vaisseaux.add(bcl);
				}else{
					IMobile b1 = new Bouclier(new Position((5+(i*10)),620+(10*n)),false);
					IVue bc = new SpriteBouclier(f, b1);
					Vaisseau bcl =  new Vaisseau(b1,bc);
					vaisseaux.add(bcl);
				}
			}
		}
		
		
	}

	public void loadBoss(){
		
		IMobile mB = new Boss(f, new Position(500,250),false, 1000);
		IVue vB = new SpriteBoss(f, mB);
		Vaisseau B =  new Vaisseau(mB,vB);
		vaisseaux.add(B);
	}

	public PImage[] getBoom() {
		return boom;
	}
}
