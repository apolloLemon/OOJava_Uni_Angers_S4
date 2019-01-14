class Compte {
	int credit;
	int debit;

	public void deposer (int v){
		credit += v;
	}
	
	public void retirer (int v){
		debit += v;
	}
	
	public int voirSold (){
		return(credit-debit);
	}
}

class CompteEpargne extends Compte {
	float taux;

	public float calculerTaux () {}
}

Compte C1;
Compte C2;
C1 = new Compte();
C2 = new Compte();

C1.deposer(3);