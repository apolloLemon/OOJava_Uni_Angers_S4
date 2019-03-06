class Client {
	static int cptClient=0;

	private int numeroClient;
	private String nom;
	private double solde;

	public Client(String n){
		numeroClient = ++cptClient;
		nom=n;
		solde=0;
	}
	public int getNum(){return numeroClient;}
	public String getNom(){return nom;}
	public double getSld(){return solde;}
	public void setNum(int a){numeroClient=a;}
	public void setNom(String a){nom=a;}
	public void setSld(double a){solde=a;}
	
	public String toString(){
		return this.nom+" #"+this.numeroClient+"\nSolde: "+this.solde;
	}

	public boolean equals(Object o){
		return (this.toString() == o.toString());
	}
}



class TestClient {
	public static void main (String args[]){
		Client C = new Client("Bob");
		Client D = new Client("Cob");
		C.setSld(1000.0);
		System.out.println(C);
		System.out.println(D);
	}
}