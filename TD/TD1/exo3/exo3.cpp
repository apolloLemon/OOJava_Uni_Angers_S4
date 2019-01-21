#include <string>
#include <iostream>

class Vehicule {
private:
	std::string modele;
	int anneAchat;
	int prixAchat;
	std::string immatriculation;
	char permis;

public:
	Vehicule(std::string m,int y,int p,std::string i, char l) {
		modele = m;
		anneAchat = y;
		prixAchat = p;
		immatriculation = i;
		permis = l;

	}

	int age(){
		return 2019-anneAchat;
	}

	int coutLocation() {
		if(age()<1) return prixAchat/200;
		else return prixAchat/250;
	}

	void afficher() {
		std::cout<<modele<<" "<<immatriculation<<std::endl;
	}
};

class Voiture : public Vehicule {
private:
	bool autoradio;

public:
	Voiture(std::string m,int y,int p,std::string i, char l, bool r) : 
	Vehicule(m,y,p,i,l), autoradio(r){
	}

	void ADDautoradio () {
		autoradio = true;
	}

	void RMautoradio () {
		this->autoradio = false;
	}
};

class Utilitaire : public Vehicule {
private:
	float volume;

public:
	Utilitaire(std::string m,int y,int p,std::string i, char l, float v) : 
	Vehicule(m,y,p,i,l){
		volume = v;
	}

	bool peutTransporterVolume (int v) {
		return (v<=volume);
	}
};

class AutoCar : public Utilitaire {
private:
	int voyageurs;

public:
	AutoCar(std::string m,int y,int p,std::string i, char l, float v, int t):
	Utilitaire(m,y,p,i,l,v){
		voyageurs = t;
	}

	bool peutTransporterPassagers(int p, int v){
		return (p<=voyageurs && peutTransporterVolume(p*v));
	}
};



int main () {
	Voiture V1 = new Voiture("Twingo",2005,10000,"1234 TZ 49",'B',true);
	V1.afficher();

	Utilitaire CA1 = new Utilitaire("J9",2018-5,20000,"2345 FA 49",'B',5);
	//std::cout<<(CA1.coutLocation()+" "+CA1.peutTransporterVolume(4));

	//std::cout<<(V1.coutLocation());

	AutoCar AU1 = new AutoCar("FR1",2018-2,"3456 IJ 49",'D',3.0,53);
	//std::cout<<(AU1.peutTransporterPassagers(40,0.1));
}