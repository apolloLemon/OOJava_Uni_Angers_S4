import java.util.*;

class Agence {
	private String nom, tel;
	private int admin;
	public String commentaire;

	Agence(String n, String t,int a){
		nom = n;
		tel = t;
		admin = a;
	}
	int taillePersonnel () {
		return admin;
	}
}

class Garage extends Agence {
	private int mechaniciens;
	private Set<Bureau> bureaux = new HashSet<Bureau>();


	Garage(String n, String t, int a, int m){
		super(n,t,a);
		mechaniciens = m;
		bureaux.clear();
	}

	int taillePersonnel () {
		return mechaniciens + super.taillePersonnel();
	}

	void ajoutBureau(Bureau g){
		bureaux.add(g);
	}
	void retraitBureau(Bureau g){
		bureaux.remove(g);
	}

	int nbMecaniciens(){
		return mechaniciens;
	}
}

class Bureau extends Agence {
	private int commerciaux;
	private Set<Garage> garages = new HashSet<Garage>();

	Bureau(String n, String t, int a, int c){
		super(n,t,a);
		commerciaux=c;
		garages.clear();
	}

	int taillePersonnel () {
		return commerciaux + super.taillePersonnel();
	}

	void ajoutGarage(Garage g){
		garages.add(g);
	}
	void retraitGarage(Garage g){
		garages.remove(g);
	}

	int nbGarages(){
		return garages.size();
	}

	int nbMecaniciens(){
		int out = 0;
		for(Garage g : garages){
			out += g.nbMecaniciens();
		}
		return out;
	}
}

class Main {
	public static void main(String args[]){
		Garage G1 = new Garage("G1","001",3,15);
		Garage G2 = new Garage("G2","002",4,25);
		Garage G3 = new Garage("G3","003",1,5);

		Bureau B1 = new Bureau("B1","100",3,15);
		Bureau B2 = new Bureau("B2","101",4,25);
		Bureau B3 = new Bureau("B3","102",1,5);

		G1.ajoutBureau(B1);
		G1.ajoutBureau(B2);
		B1.ajoutGarage(G1);
		B2.ajoutGarage(G1);

		G2.ajoutBureau(B3);
		G2.ajoutBureau(B2);
		B3.ajoutGarage(G2);
		B2.ajoutGarage(G2);

		G3.ajoutBureau(B1);
		G3.ajoutBureau(B2);
		G3.ajoutBureau(B3);
		B1.ajoutGarage(G3);
		B2.ajoutGarage(G3);
		B3.ajoutGarage(G3);

		System.out.println(B3.nbMecaniciens());
	}
}