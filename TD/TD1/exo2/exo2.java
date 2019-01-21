class produit {
	int prix;
	string nom;
}

class produitPerissable extends produit {
	int dateFabrication;
	int joursConservation;
	bool refrigere;
}

class habits extends produit {
	int taille;
	string paysFabrication;
}

class habitsMode extends habits {
	int saison;
	int annee;
}