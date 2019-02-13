class Vehicule {
	static int idNonUtilisee = 1;
	static void RAZ(){
		idNonUtilisee = 1;
	}

	String modele;
	int anneAchat;
	int prixAchat;
	String immatriculation;
	char permis;
	int ID;

	public Vehicule(String m,int y,int p,String i, char l) {
		modele = m;
		anneAchat = y;
		prixAchat = p;
		immatriculation = i;
		permis = l;
		ID = Vehicule.idNonUtilisee++;
	}

	int age(){
		return 2019-anneAchat;
	}

	int coutLocation() {
		if(this.age()<1) return prixAchat/200;
		else return prixAchat/250;
	}

	void afficher() {
		System.out.println(modele+" "+immatriculation);
	}
}

class Voiture extends Vehicule {
	Boolean autoradio;

	Voiture(String m,int y,int p,String i, char l, Boolean r){
		super(m,y,p,i,l);
		autoradio = r;
	}

	void ADDautoradio () {
		autoradio = true;
	}

	void RMautoradio () {
		this.autoradio = false;
	}

	void afficher(){
		super.afficher();
		System.out.println("Voiture "+(autoradio?"avec":"sans")+" autoradio");
	}
}

class Utilitaire extends Vehicule {
	float volume;

	Utilitaire(String m,int y,int p,String i, char l, float v){
		super(m,y,p,i,l);
		volume = v;
	}

	Boolean peutTransporterVolume (float v) {
		return (v<=volume);
	}
	void afficher(){
		super.afficher();
		System.out.println("Volume = "+volume);
	}
}

final class AutoCar extends Utilitaire {
	int voyageurs;
	int majoration;

	AutoCar(String m,int y,int p,String i, char l, float v, int t){
		super(m,y,p,i,l,v);
		voyageurs = t;
		majoration = 50;
	}

	Boolean peutTransporterPassagers(int p, float v){
		return (p<=voyageurs && peutTransporterVolume(p*v));
	}

	int coutLocation() {
		return super.coutLocation() + (voyageurs>40 ? majoration : 0);
	}

	void fixerMajoration(int a){
		majoration = a;
	}

	void afficher(){
		super.afficher();
		System.out.println("Places = "+voyageurs);
	}
}


//Code Test
class Main {
	public static void main (String args[]) {
		Voiture V1 = new Voiture("Twingo",2005,10000,"1234 TZ 49",'B',true);
		V1.afficher();

		Utilitaire CA1 = new Utilitaire("J9",2018-5,20000,"2345 FA 49",'B',5);
		System.out.println(CA1.coutLocation()+" "+CA1.peutTransporterVolume(4));

		System.out.println(V1.coutLocation());

		AutoCar AU1 = new AutoCar("FR1",2018-2,90000,"3456 IJ 49",'D',3.0f,53);
		System.out.println(AU1.coutLocation()+" "+AU1.peutTransporterPassagers(40,0.1f));
		AU1.afficher();

	}
}