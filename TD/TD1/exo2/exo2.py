class produit:
	# En python vu qu'on n'as pas besoin
	# declarer les variables, je pense 
	# qu'on definit les champs d'une classe
	# directement dans le constructeur
	def __init__(self,prix,nom):
		self.prix = prix
		self.nom = nom



class produitPerissable(produit):
	def __init__(self,prix,nom,dateFabrication,joursConservation,refrigere)
		produit.__init__(self,prix,nom)
		self.dateFabrication = dateFabrication
		self.joursConservation = joursConservation
		self.refrigere = refrigere

class Vetement(produit):
	def __init__(self,prix,nom,taille,payFabrication)
		produit.__init__(self,prix,nom)
		self.taille = taille
		self.payFabrication = payFabrication

class VetementMode(Vetement):
	def __init__(self,prix,nom,taille,payFabrication,saison,annee)
		Vetement.__init__(self,prix,nom,taille,payFabrication)
		self.saison = saison
		self.annee = annee