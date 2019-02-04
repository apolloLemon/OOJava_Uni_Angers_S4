abstract class Reglement {
	int somme;
	abstract int credit();
}

class Cheque extends Reglement {
	int credit(){
		//qqch
	}
}

class Virement extends Reglement {
	int credit(){
		//qqch
	}	
}