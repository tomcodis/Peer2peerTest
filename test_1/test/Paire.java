package test;


public class Paire {
	int id;
	String name;
	int[] listePaires;
	Message[] messagesRecus;
	Paire[] cacheDePaires;
	String[] listeNomsCache;
	int dernierMessage;
	boolean isConnected;

	
	public Paire(int id, String name){
		this.id = id; 
		this.name = name;
		this.messagesRecus = new Message[10];
		this.cacheDePaires = new Paire[10];
		this.listeNomsCache = new String[10];
		this.dernierMessage = 0;
		this.isConnected = true;
			}
		
		
		
	
	
	public int returnId(){
		return this.id;
	}
	
	public void sendMessage(String contenu,Paire receiver){ // si le sender conna�t le nom d'une autre paire dans sa listeNomsCache, il peut lui envoyer des messages
		                                                    // la connexion est donc �tablie
		if (receiver.isConnected = false){
			System.out.println(receiver.name + " n'est pas connect� ");
		}else if (this.isConnected = false){
			System.out.println(this.name + "vous n'�tes pas connect� ");
		}else{
			Message msg = new Message(this.returnId(),receiver.returnId(),contenu);
			receiver.messagesRecus[dernierMessage] = msg;
			dernierMessage++;
			System.out.println(receiver.name + " a re�u un message de " + this.name + " : " + contenu);
		}
		
	}

}
