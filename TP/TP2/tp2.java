/**
 * La classe Batiment
 * @author meLon@apolloLemon
 * @version 1.0
 */
public class Batiment {
	/**
	 *adresse
	 */
	private String adresse;
	/**
	 *surface
	 */
	private int surface;

	/**
	 *@param a adresse
	 *@param s surface
	 */
	public Batiment(String a, int s){
		adresse = a;
		surface = s;
	}

	public int getSurface(){
		return surface;
	}

	public String toString(){
		return adresse+" ("+surface+"m2)";
	} 

	/**
	 *retourne la categorie pour la superficie du batiment
	 */
	public int Categorie(){
		if(surface < 30) return 1;
		if(surface < 70) return 2;
		return 3;
	}

	/**
	 *retourne le plus gros batiement entre this et b2
	 *@param b2 batiment avec lequel on compare
	 */
	public Batiment comparer(Batiment b2){
		if(surface > b2.getSurface()) return this;
		else return b2;
	}
}

/**
 * La classe Maison est un type de Batiment
 * @author meLon@apolloLemon
 * @version 1.0
 */
public class Maison extends Batiment {
	private int nbPieces;
	private int surfaceJardin;

	public Maison(String a, int s, int sJ, int nP){
		super(a,s);
		nbPieces = nP;
		surfaceJardin = sJ;
	}

	public String toString(){
		return super.toString()+"\nPieces: "+nbPieces+"\nJardin: "+surfaceJardin+"m2";
	}
}

public class Immeuble extends Batiment {
	private int nbAppart;

	public Immeuble(String a, int s, int nA){
		super(a,s);
		nbAppart = nA;
	}

	public String toString(){
		return super.toString()+"\nAppatements: "+nbAppart;
	}
}

public class Quartier {
	public Batiment[] Batiments;

	public Quartier(int s){
		Batiments = new Batiment[s];
	}

	public void ajouteBatiment(Batiment b){
		for (int i = 0; i < Batiments.length;i++){
			if(Batiments[i]==null){
				Batiments[i] = b;
				return;
			}
		}
		System.out.println("Quartier Rempli");
	}

	public void afficherBatiments(int c){
		for(Batiment e : Batiments){
			if (e==null) continue;
			if (e.Categorie()<c) continue;
			System.out.println(e);
		}
	}

	public Batiment plusGrandBatiement(){
		Batiment out = Batiments[0];
		for(Batiment b : Batiments){
			if (b==null) continue;
			out = out.comparer(b);
		}
		return out;
	}

}

public class Main {

	static void afficherTabBat (Batiment[] E){
		for(Batiment e : E){
			if (e==null) continue;
			System.out.println(e);
		}
	}

	public static void main (String[] args){

		Batiment B = new Batiment("my place",15);
		//System.out.println(B);

		Maison M = new Maison("her place",10,4,3);
		//System.out.println(M);

		Immeuble I = new Immeuble("my mistresse's appartment",100,10);
		//System.out.println(I);

		System.out.println("Bat B est de Categorie "+B.Categorie());
		System.out.println("Bat M est de Categorie "+M.Categorie());
		System.out.println("Bat I est de Categorie "+I.Categorie());

		Batiment[] E = {B,M,I};

		//afficherTabBat(E);

		Quartier Q = new Quartier(10);
		Q.ajouteBatiment(B);
		//afficherTabBat(Q.Batiments);
		Q.ajouteBatiment(M);
		//afficherTabBat(Q.Batiments);
		//Q.ajouteBatiment(I);

		Q.afficherBatiments(2);

		System.out.println(B.comparer(M));
		//System.out.println(M.comparer(B));

		System.out.println(Q.plusGrandBatiement());
	}
}