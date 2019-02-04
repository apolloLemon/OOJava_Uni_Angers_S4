class Compte {
	static int nombreComptes;
	private int credit, debit;
	int NumeroCompte;

	Compte(){
		credit=0;
		debit=0;
		NumeroCompte = ++nombreComptes;
	}

	Compte(int c, int d){
		credit=c;
		debit=d;
		NumeroCompte = ++nombreComptes;
	}

	static void resetNombreComptes () {
		nombreComptes=0;
	}

	public void deposer (int v){
		credit += v;
	}
	
	public void retirer (int v){
		debit += v;
	}
	
	public int voirSold (){
		return(credit-debit);
	}

	public int voirNumCompte (){
		return NumeroCompte;
	}
}

class CompteEpargne extends Compte {
	float taux;
	CompteEpargne(){
		super();
		taux=0;
	}
	public float calculerTaux () {return 0;}
}


class Main {
	public static void main (String[] args){
		Compte C1;
		Compte C2;
		C1 = new Compte();
		C2 = new Compte();

		C1.deposer(3);

		System.out.println(Compte.nombreComptes);
		Compte.resetNombreComptes();
		System.out.println(Compte.nombreComptes);
	}
}