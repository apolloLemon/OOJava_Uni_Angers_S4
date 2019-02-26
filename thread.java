class Essai extends Thread {
	String Nom;
	Essai(String N){Nom=N;}
	public void run(){
		for(int i=0;i<10000;i++) System.out.println(Nom);
	}
}

class ThreadTest {
	public static void main (String[] args){
		Essai E1;Essai E2;Essai E3;
		E1= new Essai("Dupont");
		E2= new Essai("Durant");
		E3= new Essai("Bobbie");
		E1.start();
		E2.start();
		E3.start();
	}
}