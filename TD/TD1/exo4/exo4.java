class figure {
	int X, Y;

	figure(int x, int y){
		X=x;
		Y=y;
	}

	void afficher() {
		System.out.println("Position: "X+" "+Y);
	}
}

class rectangle extends figure {
	int longeur, largeur;
	rectangle(int x,int y, int lo, int la) {
		super(x,y);
		longeur = lo;
		largeur = la;
	}

	int surface(){
		return longeur * largeur;
	}

	int perimetre () {
		return longeur*2+largeur*2;
	}

	void afficherRectangle(){
		afficher();
		System.out.println("Taille: "+longeur+"x"+largeur);
	}
}

class carre extends rectangle {
	carre(int x,int y,int c){
		super(x,y,c,c);
	}
}

class cercle extends figure {
	float PI = 3.1415;

	int rayon;
	cercle(int x, int y, int r){
		super(x,y);
		rayon = r;
	}

	int surface () {
		return PI*r*r;
	}
	int circonference () {
		return PI*r*2;
	}

	void afficherCercle(){
		afficher();
		System.out.println("Diametre: "+2*r);
	}
}