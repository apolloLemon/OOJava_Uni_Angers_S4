import java.util.*;
abstract class Agence {
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

	abstract int taillePersonnelNonAdmin ();

	String getName(){
		return nom;
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
	int taillePersonnelNonAdmin (){
		return mechaniciens;
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

	int taillePersonnelNonAdmin(){
		return commerciaux;
	}

	void ajoutGarage(Garage g){
		if(garages.size()<4) garages.add(g);
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

class Entreprise {
	private Set<Agence> agences;

	Entreprise(){
		agences = new HashSet<Agence>();
	}

	void ajouter(Agence A){
		agences.add(A);
	}

	int taillePersonnel() {
		int out=0;
		for(Agence a : agences){
			out += a.taillePersonnel();
		}
		return out;
	}

	int taillePersonnelNonAdmin() {
		int out=0;
		for(Agence a : agences){
			out += a.taillePersonnelNonAdmin();
		}
		return out;
	}

	Agence recherche(String nom){
		for(Agence a : agences){
			if(a.getName() == nom) {
				return a;
			}
		}
		return null;
	}
}

class Main {
	public static void main (String[] args){
		Entreprise E = new Entreprise();

		Garage G1 = new Garage("G1","001",3,15);
		Bureau B1 = new Bureau("B1","100",3,15);
		G1.ajoutBureau(B1);
		B1.ajoutGarage(G1);

		E.ajouter(B1);
		Agence B2 = E.recherche("Bab");
		System.out.println(B1);
		System.out.println(B2);
	}
}