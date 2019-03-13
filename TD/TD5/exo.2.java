import java.util.*;
import java.lang.Math;

class CompteARebours extends Thread {
	Date datedeb, datefin;

	CompteARebours(long d){
		datedeb = new Date();
		datefin = new Date(datedeb.getTime()+d);
	}
	synchronized long getDateFin(){
		return datefin.getTime();
	}
	synchronized void setDateFinLong(long d){
		datefin.setTime(d);
	}

	synchronized void majDateFinLong(long d){
		setDateFinLong(this.getDateFin()+d);
	}

	long getTempsRest(){
		Date d = new Date();
		return getDateFin()-d.getTime();
	}
}

class Equipe extends Thread {
	
	static CompteARebours car;

	int tReflexion, tRetard;

	Equipe(String s){
		super(s);
	}

	void reflexion () throws InterruptedException {
		tReflexion = (int)(Math.random()*5000);
		car.sleep(tReflexion);
		tRetard = (int)(Math.random()*1000);
	}

	public void run(){
		try{
			while(!interrupted()){
				reflexion();
				car.majDateFinLong(tRetard);
				System.out.println(this.getName()+" (rflx: "+tReflexion+", rtrd: "+tRetard+")");
				
			}
		} catch (Exception e){}
	}
}

class EquipeQuentin extends Thread {
	int tReflexion;
	int tRetard;
	static CompteARebours cpt;
	EquipeQuentin(String N){
		super(N);
	}
	void reflexion () {
		tReflexion = (int)(Math.random()*5000);
		Thread.sleep(tReflexion);
		tRetard = (int)(Math.random()*1000);
	}

	void run () {
		reflexion();
		cpt.majDateFinLong(tRetard);
		synchronized (System.output){
			System.out.println(this.getName()+" (rflx: "+tReflexion+", rtrd: "+tRetard+")");
		}

	}
}

class Simulation {
	public static void main (String[] args){
		CompteARebours car = new CompteARebours(10*1000);
		Equipe meteo = new Equipe("Meteo");
		Equipe securite = new Equipe("Securite");

		meteo.car = car;

		meteo.start();
		securite.start();

		Date timra = new Date();
		Date timrb;
		while(car.getTempsRest() > 0){
			timrb = new Date();
			if(timrb.getTime()-timra.getTime()>=1000){
				System.out.println(car.getTempsRest());
				timra = new Date();
			}
		}
		
		System.out.println("Decollage");
		meteo.interrupt();
		securite.interrupt();
	}
}