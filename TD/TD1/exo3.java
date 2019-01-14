class Vehicule {
	string modele;
	int anneAchat;
	int prixAchat;
	string immatriculation;
	char permis;

	Vehicule(string m,int y,int p,string i, char l) {
		modele = m;
		anneAchat = y;
		prixAchat = p;
		immatriculation = i;
		permis = l;

	}

	int age(){
		return CurrentYear()-anneAchat;
	}

	int coutLocation() {
		if(age<1) return prixAchat/200;
		else return prixAchat/250;
	}

	void afficher() {
		System.out.println(modele+" "+immatriculation);
	}
}

class Voiture extends Vehicule {
	bool autoradio;

	Voiture(string m,int y,int p,string i, char l, bool r){
		super(string m,int y,int p,string i, char l);
		autoradio = r;
	}

	void ADDautoradio () {
		autoradio = true;
	}

	void RMautoradio () {
		this.autoradio = false;
	}
}

class Utilitaire extends Vehicule {
	float volume;

	Utilitaire(string m,int y,int p,string i, char l, float v){
		super(string m,int y,int p,string i, char l);
		volume = v;
	}

	bool peutTransporterVolume (int v) {
		return (v<=volume);
	}
}

class AutoCar extends Utilitaire {
	int voyageurs;

	AutoCar(string m,int y,int p,string i, char l, float v, int t){
		super(string m,int y,int p,string i, char l, float v);
		voyageurs = t;
	}

	bool peutTransporterPassagers(int p, int v){
		return (p<=voyageurs && peutTransporterVolume(p*v));
	}
}


//Code Test
class Tester () {
	static void main () {
		Voiture V1 = new Voiture("Twingo",2005,10000,"1234 TZ 49","B",true);
		V1.afficher();

		Utilitaire CA1 = new Utilitaire("J9",CurrentYear()-5,20000,"2345 FA 49","B",5);
		System.out.println(CA1.coutLocation()+" "+CA1.peutTransporterVolume(4));

		System.out.println(V1.coutLocation());

		AutoCar AU1 = new AutoCar("FR1",CurrentYear()-2,"3456 IJ 49","D",3,53);
		System.out.println(AU1.peutTransporterPassagers(40,0.1));
	}
}