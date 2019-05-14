import java.io.*;
import java.util.*;

/**
 * La classe Bagage
 * @author meLon@apolloLemon
 * @version 1.0
 */
public class Bagage implements Comparable<Bagage> {
	/**
	 *poids
	 */
	int kg;
	/**
	 *numero d'identifiant
	 */
	int id;

	/**
	 *@param p poids
	 *@param i id
	 */
	Bagage(int p,int i){
		kg=p;
		id=i;
	}

	public String toString() {
		return id+","+kg;
	}

	public int compareTo(Bagage other){
		return this.kg-other.kg;
	}
}

/**
 * La classe Passager
 * @author meLon@apolloLemon
 * @version 1.0
 */
public class Passager {
	String nom;
	int age;
	Bagage bag;

	Passager (String n, int a, Bagage b){
		nom=n;
		age=a;
		bag=b;
	}

	public String toString() {
		return nom+","+age+","+bag.kg;
	}	
}

/**
 * La classe Cabine
 * @author meLon@apolloLemon
 * @version 1.0
 */
public class Cabine {
	int col, row;
	/**
	 *Nombre de Passagers
	 */
	int nbPass;
	/**
	 *Matrice des Places
	 */
	Passager[][] seats;

	/**
	 *@param c colonnes
	 *@param r rangees
	 */
	Cabine(int c,int r){
		col=c;
		row=r;
		seats = new Passager[col][row];
		nbPass=0;
	}

	void ajouterPassager(Passager pass){
		nbPass++;
		//Passager[nbPass/col][nbPass%col]=pass;//ceci prends pas en compte les places liberees

		for(int i=0;i<col;i++){
			for (int j=0;j<row;j++){
				if(seats[i][j]==null){
					seats[i][j]=pass;
					i=col; j=row;
				}
			}
		}
	}

	void enleverPassager(Passager pass){
		nbPass--;
		for(int i=0;i<col;i++){
			for(int j=0;j<row;j++){
				if(seats[i][j]==pass){
					seats[i][j]=null;
					i=col;j=row;
				}
			}
		}
	}

	Boolean estRemplie() {
		for(int i=0;i<col;i++){
			for(int j=0;j<row;j++){
				if(seats[i][j]==null)
					return false;
			}
		}
		return true;	
	}

}

/**
 * La classe Soute
 * @author meLon@apolloLemon
 * @version 1.0
 */
public class Soute {
	ArrayList<Bagage> bags;
	int kgMax, kg;

	/**
	 *@param m poidsMax
	 */
	Soute(int m){
		kgMax=m;
		bags=new ArrayList<Bagage>();
	}

	void ajouterBagage(Bagage bag){
		//System.out.println(bag);
		bags.add(bag);
		kg+=bag.kg;
	}

	void enleverBagage(Bagage bag){
		bags.remove(bag);
		kg-=bag.kg;
	}

	Boolean peutTransporter(Bagage bag){
		return (kg+bag.kg<kgMax);
	}

	void trierBagages() {
		Collections.sort(bags);
	}

}

/**
 * La classe Abstraite Avion
 * @author meLon@apolloLemon
 * @version 1.0
 */
abstract public class Avion {
	Cabine cab;
	Soute sou;
	String model;

	abstract void decoller();

	Boolean ajouterPassager(Passager pass) {
		if(cab.estRemplie() || !sou.peutTransporter(pass.bag)) return false;
		cab.ajouterPassager(pass);
		sou.ajouterBagage(pass.bag);
		return true;
	}

	void enleverPassager(Passager pass){
		cab.enleverPassager(pass);
		sou.enleverBagage(pass.bag);
	}

	void chargerAvion(String fileName) throws IOException {
		int bagnum = 0;
		BufferedReader in = null;
		try {
			// ouverture du fichier
			in = new BufferedReader(
				new FileReader(fileName)
			);
			// lecture des données
			String ligne = null;
			while ((ligne=in.readLine()) != null) {
				String[] words = ligne.split(",");
				if(words[0].equals("Nom") || words[2].equals("Bagage")) continue;

				//System.out.println(words[0]+","+words[1]+","+words[2]);
				Bagage bag = new Bagage(Integer.parseInt(words[2]),++bagnum);
				ajouterPassager(new Passager(words[0],Integer.parseInt(words[1]),bag));
			}
		} finally {
		// fermeture du fichier
			if (in != null)      
			in.close();
		}
	}

	void sauvgardeListeBagages(String fileName) throws IOException{
		sou.trierBagages();

		PrintWriter out = null;
		try {
			// ouverture du fichier
			out = new PrintWriter(
				new FileWriter(fileName)
			);
			//System.out.println(out.)
			for (Bagage bag : sou.bags) {
				out.println(bag);
			}
		} finally {
		// fermeture du fichier
			if (out != null)      
			out.close();
		}
	}
}

/**
 * La classe A320
 * @author meLon@apolloLemon
 * @version 1.0
 */
public class AThreeTwenty extends Avion {
	AThreeTwenty() {
		cab = new Cabine(30,6);
		sou = new Soute(1000);
		model="A320";
	}

	void decoller(){
		System.out.println(model+" en vol avec "+cab.nbPass+" passagers");
	}
}

/**
 * La classe Jet
 * @author meLon@apolloLemon
 * @version 1.0
 */
public class Jet extends Avion {
	/**
	 *@param c Cabine
	 *@param s Soute
	 */
	Jet(Cabine c, Soute s){
		cab=c;
		sou=s;
		model="Jet";
	}

	void decoller(){
		System.out.println(model+" en vol avec "+cab.nbPass+" passagers");
	}
}

/**
 * La classe Aeroport
 * @author meLon@apolloLemon
 * @version 1.0
 */
public class Aeroport {
	public static void main (String[] args) {
		AThreeTwenty a320 = new AThreeTwenty();
		try{
			a320.chargerAvion("Avion1.csv");
			a320.sauvgardeListeBagages("ListeBagage1.csv");
		} catch (IOException e){;}

		AThreeTwenty a321 = new AThreeTwenty();
		try{
			a321.chargerAvion("Avion2.csv");
			a321.sauvgardeListeBagages("ListeBagage2.csv");
		} catch (IOException e) {;}

		Jet topgun = new Jet(new Cabine(1,2),new Soute(20));
		topgun.ajouterPassager(new Passager("Maverik",27,new Bagage(9,1)));
		topgun.ajouterPassager(new Passager("Goose",30,new Bagage(9,2)));
		try{
			topgun.sauvgardeListeBagages("ListeBagage3.csv");
		} catch (IOException e) {;}

		a320.decoller();
		a321.decoller();
		topgun.decoller();
	}
}