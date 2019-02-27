public interface Pile {
	void empile(Object a);
	Object depile();
	bool vide();
	Object sommet();
}

class pileATableau implements Pile {
	Object[] T;
	int sommet;
	pileATableau(){
		T = new Object[100];
		sommet = 0;
	}
	void empile(Object a){
		T[sommet++] = a;
	}
	Object depile(){
		return T[--sommet];
	}
	bool vide(){
		return (sommet==0);
	}
	Object sommet(){
		return T[sommet-1];
	}


	int viderEtSommerEntiers(){
		int out;
		while(!this.vide()){
			Object tmp = T.depile();
			if(tmp instanceof int){
				out += tmp;
			}
		}
	}
}