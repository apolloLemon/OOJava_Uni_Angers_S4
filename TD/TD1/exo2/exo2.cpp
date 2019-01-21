class produit {
	int prix;
	std::string nom;
}

class produitPerissable : public produit {
	int dateFabrication;
	int joursConservation;
	bool refrigere;
}

class habits : public produit {
	int taille;
	string paysFabrication;
}

class habitsMode : public habits {
	int saison;
	int annee;
}