class Vehicule:
	def __init__(self,m,y,c,i,l):
		self.modele=m
		self.annee=y
		self.prix=c
		self.immatriculation=i
		self.permis=l

	def age(self):
		return 2019-self.annee

	def coutLocation(self):
		if(age()<1): return self.prix/200
		else: return self.prix/250

	def __str__(self):
		return self.modele +" "+ self.immatriculation

class Voiture(Vehicule):
	def __init__(self,m,y,c,i,l,r):
		Vehicule.__init__(self,m,y,c,i,l)
		self.autoradio = r

	def ADDautoradio(self):
		self.autoradio = True

	def RMautoradio(self):
		self.autoradio = False

class Utilitaire(Vehicule):
	def __init__(self,m,y,c,i,l,v):
		Vehicule.__init__(self,m,y,c,i,l)
		self.volume = v

		def peutTransporterVolume(self,v):
			return v<=self.volume

class AutoCar(Utilitaire):
	def __init__(self,m,y,c,i,l,v,p):
		Utilitaire.__init__(self,m,y,c,i,l,v)
		self.passagers = p

	def peutTransporterPassagers(self,p,v):
		return p<=self.passagers and super().peutTransporterVolume(p*v)



car = Voiture("Twingo",2005,10000,"1234 TZ 49",'B',True)
print(car)
car.RMautoradio()

van = Utilitaire("J9",2018-5,20000,"2345 FA 49",'B',5)
print(van)
a= van.peutTransporterVolume()

bus = AutoCar("FR1",2018-2,90000,"3456 IJ 49",'D',3.0,53)
b= bus.peutTransporterPassagers(40,0.1)