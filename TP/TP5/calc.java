import java.util.Scanner;

class Calculatrice {

	double saisieNombre(){
		System.out.println("Saisie un Double: ");
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		sc.close();
		return a;
	}

	double lancementCalcul(){
		double a = saisieNombre();
	}

	
}