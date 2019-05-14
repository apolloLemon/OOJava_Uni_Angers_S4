class Tonneau extends Thread{
	String nom;
	int vol,deb;
	Tonneau other;
	static int maxVol;

	static void SETMAX (int a) {
		maxVol=a;
	}

	Tonneau(String n, int v, int d){
		nom=n; vol=v; deb=d;
	}

	Tonneau(String n,int v, int d, Tonneau o){
		nom=n; vol=v; deb=d; other=o;
	}

	synchronized int ajouteVolume(int a){
		if((vol+a)>maxVol) {
			int trop = a-(maxVol-vol);
			vol=maxVol;
			System.out.println(nom+" deborde");
			return a-trop;
		} //cas ajouter plus que max
		vol+=a;
		System.out.println(a+" ajoute' a' "+nom);
		return a;
	}

	synchronized int retireVolume(int a){
		if((vol-a)<0) {
			int manq = a-vol;
			vol=0;
			System.out.println(nom+" n'as pas assez");
			return a-manq;
		} //cas retirer plus que dispo
		vol-=a;
		System.out.println(a+" retire' a' "+nom);
		return a;
	}

	boolean vide () {
		return (vol==0);
	}

	public void run(){
		while(!vide()){
			try {
				if(this.other==null) retireVolume(this.deb);
				else this.other.ajouteVolume(retireVolume(this.deb));
				sleep(1000);
			} catch (Exception e){
				System.out.println(e);
			}
		}
	}
}

class RUN {
	public static void main (String[] args){
		Tonneau.SETMAX(12);
		Tonneau t1 = new Tonneau("T1",5,1);
		Tonneau t2 = new Tonneau("T2",12,4,t1);

		t1.start(); 
		t2.start();
	}
}