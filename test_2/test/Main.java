package test;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Paire Source = new Paire (0,null);   // initialisation 
		Paire Destination = new Paire (0,null);
		Paire[] ListeConnection = new Paire[10];
		String[] ListeNoms = new String[10];
		for (int i=0 ; i<10 ; i++){
			String a = String.valueOf(i);
			double b = Math.random();
			ListeConnection[i]  = new Paire(i, "paire " + a);
			if (b < 0.5 == true){// on crée l'ensemble des paires du système et on stocke le nom de chaque paires
				ListeNoms[i] = ListeConnection[i].name + "  online";// le but étant de choisir le sender ( on prend donc l'ensemble des paires)
			}else{													// on initialise les paires en mettant certaines paires online et d'autres offline
				ListeConnection[i].isConnected = false ;
				ListeNoms[i] = ListeConnection[i].name + "  offline";

			}

		}
		for (int h = 0 ; h<10 ; h++){ // on remplit les caches de toutes les paires
			double x = 10* Math.random();
			int y = (int)x;
			ListeConnection[h].indiceCacheIni = y;
			for(int q = 0 ; q<10 ; q++){
				if(q == ListeConnection[h].indiceCacheIni){
					ListeConnection[h].cacheDePaires[q] = ListeConnection[q];
					ListeConnection[h].listeNomsCache[q] = ListeNoms[q];// le cache contient initialement le nom d'une seule autre paire
						//}else{
					//ListeConnection[h].cacheDePaires[q] = null;
					//ListeConnection[h].listeNomsCache[q] = null;// on ne connait pas le nom de toutes les autre paires
				}
			}
		}
	
		for (int s = 0 ; s<10 ;s++){
			for (int d = 0 ; s<10 ;d++){
				if(d != s == true){
					ListeConnection[s].askList(ListeConnection[ListeConnection[s].indiceCacheIni]);//on recupere le contenu du cache de la paire (unique) à laquelle on est connecté
				}
			}
		}
		

		maFenetre fenetre = new maFenetre();
		fenetre.setVisible(true);
		while(true){
			String src = (String)JOptionPane.showInputDialog(fenetre, "choisir un sender","boite d'options",JOptionPane.QUESTION_MESSAGE,null,ListeNoms,null);
				if (src == null){   // si on clique sur annuler dans la boite
					System.out.println("annulation");
				}else{
					for (int i =0 ; i<10 ; i++){
						if ( src == ListeNoms[i]){
							Source = ListeConnection[i];
							if(Source.isConnected = false){
								System.out.println("Vous n'êtes pas connecté");
							}
						}
					}
				}
				String dst = (String)JOptionPane.showInputDialog(fenetre, "choisir un receiver","boite d'options",JOptionPane.QUESTION_MESSAGE,null,Source.listeNomsCache,null);
				if (dst == null){
					System.out.println("annulation");
				}else{
					for (int j =0 ; j<10 ; j++){
						if ( dst == Source.listeNomsCache[j]){
							Destination = ListeConnection[j];
							if(Destination.isConnected = false){
								System.out.println(dst + " n'est pas connecté");
							}
						}
					}
				}
				String contenu = JOptionPane.showInputDialog(fenetre,"contenu");
				Source.sendMessage(contenu, Destination);
			}
		}
	}









