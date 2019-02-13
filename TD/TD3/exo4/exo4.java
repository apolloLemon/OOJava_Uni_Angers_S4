class TriSimple {
	private int capacite;
	private int[] tab;
	private int nbElts;

	TriSimple(){
		capacite = 5;
		tab = new int[capacite];
		nbElts = 0;
	}

	public void inserer(int entier){
		if(nbElts==0) {
			tab[nbElts++]=entier;
			return;
		}

		tab[nbElts++] = tab[nbElts-2];
		System.out.println("Exec\n");
		afficher();
		System.out.println("\n");
		
		int i = nbElts-1;
		
		while(entier<tab[i] && i>0){
			System.out.println(i);
			tab[i]=tab[--i];
		}
		System.out.println(i);
		System.out.println("\n");
		tab[i]=entier;
	}
	public void supprimer(int entier){
		;
	}

	public void afficher(){
		for (int a : tab) {
			System.out.println(a);
		}
	}
}

class Main {
	public static void main (String[] args){
		TriSimple A = new TriSimple();
		A.inserer(3);
		A.inserer(1);
		A.inserer(2);
		A.afficher();
	}
}