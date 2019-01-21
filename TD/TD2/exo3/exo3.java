class Ensemble {
	void union(){;}
	void intersection(){;}
	int cardinalite(){;}
	void ajouteElt(){;}
	void enleveElt(){;}
}

class Agence {
	private String nom, tel;
	private int admin;
	public String commentaire;

	Agence(String n, String t,int a){
		nom = n;
		tel = t;
		admin = a;
	}
}

class Bureau extends Agence {
	private int commerciaux;

	Bureau(String n, String t, int a, int c){
		super(n,t,a);
		commerciaux=c;
	}
}

class Garage extends Agence {
	private int mechaniciens;

	Garage(String n, String t, int a, int m){
		super(n,t,a);
		mechaniciens = m;
	}

}