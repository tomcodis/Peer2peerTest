package test;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Paire Source = new Paire (20,null);   // initialisation 
		Paire Destination = new Paire (20,null);
		Paire[] ListeConnection = new Paire[10];
		String[] ListeNoms = new String[10];
			for (int i=0 ; i<10 ; i++){
				String a = String.valueOf(i);
				double b = Math.random();
				ListeConnection[i]  = new Paire(i, "paire " + a);
					if (b < 0.5 == true){// on cr�e l'ensemble des paires du syst�me et on stocke le nom de chaque paires
						ListeNoms[i] = ListeConnection[i].name + "  online";// le but �tant de choisir le sender ( on prend donc l'ensemble des paires)
					}else{
						ListeConnection[i].isConnected = false ;
						ListeNoms[i] = ListeConnection[i].name + "  offline";
					
						}
					
			}
		for (int k = 0 ; k<10 ; k++){
			for ( int p = 0 ; p<10 ; p++){
				ListeConnection[k].cacheDePaires[p] = ListeConnection[p];//on remplit le cache de paires de la paire k
				if (ListeConnection[p].isConnected = true){
					ListeConnection[k].listeNomsCache[p] =ListeNoms[p] ;} // on fait correspondre � chaque cache de paire le nom (l'utilisateur choisit la paire � qui envoyer le message selon son nom)
				else{
					ListeConnection[k].listeNomsCache[p] =ListeNoms[p] ;}
						
					}
				}                                                                                  					 // le but ici est de pouvoir choisir seulement les paires qui figurent dans le cache du sender
		maFenetre fenetre = new maFenetre();
		fenetre.setVisible(true);
		while(true){
			String src = (String)JOptionPane.showInputDialog(fenetre, "choisir un sender","boite d'options",JOptionPane.QUESTION_MESSAGE,null,ListeNoms,null);
				if (src == null){
					System.out.println("annulation");
				}else{
					for (int i =0 ; i<10 ; i++){
						if ( src == ListeNoms[i]){
							 Source = ListeConnection[i];
							 if(Source.isConnected = false){
								 System.out.println("Vous n'�tes pas connect�");
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
									System.out.println(dst + " n'est pas connect�");
								}
						}
					}
				}
				String contenu = JOptionPane.showInputDialog(fenetre,"contenu");
			Source.sendMessage(contenu, Destination);
			}
		}
}
	
				
			
		
	
		
		

