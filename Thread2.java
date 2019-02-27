//Pour Clavier.lireligne()
import java.util.Scanner;

class ReserveAjoutPuise {
	public static void main (String args[]) {
		Reserve r = new Reserve();
		Ajout ta1 = new Ajout(r,100);
		Ajout ta2 = new Ajout(r,50);
		Puise tp = new Puise(r,300);
		
		System.out.println("entree pour arreter");
		
		ta1.start();
		ta2.start();
		tp.start();
		

		//Clavier.lireLine();
		Scanner input = new Scanner (System.in);
		String a = input.nextLine();
		
		ta1.interrupt(); ta2.interrupt(); tp.interrupt();

		System.out.println("Fin // reserve: "+r.stock);
	}
}

class Reserve extends Thread {
	int stock = 500; // ici !private pour pouvoir log
	public synchronized void puise (int v) throws InterruptedException {
		if(v<=stock) stock -=v; else wait();
	}
	public synchronized void ajoute (int v) {
		stock += v; notifyAll();
	} 
}

class Ajout extends Thread {
	private int vol;
	private Reserve r;
	public Ajout(Reserve r, int vol){
		this.vol = vol;
		this.r = r;
	}
	public void run(){
		try{
			while(!interrupted()){
				r.ajoute(vol);
				System.out.println("ajoute : "+vol);
				sleep(100);
			}
		} catch (InterruptedException e){}
	}
}

class Puise extends Thread{
	private int vol;
	private Reserve r;
	public Puise(Reserve r, int vol){
		this.vol = vol;
		this.r = r;
	}
	public void run(){
		try{
			while(!interrupted()){
				r.puise(vol);
				System.out.println("puise : "+vol);
				sleep(100);
			}
		} catch (InterruptedException e){}
	} 
}