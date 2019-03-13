import java.util.*;
import java.io.*;

class Calculatrice {

	//Calculatrice(){}

	double saisieNombre() throws InputMismatchException {
		System.out.println("Saisie un Double: ");
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		//sc.close();
		return a;
	}

	class InvalidOpExecption extends Exception {}

	String saisieOperation() throws InvalidOpExecption{
		System.out.println("Saisie une Operation: ");
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		//sc.close();

		switch(a) {
			case "+":
			case "*":
			case "-":
			case "/":
			case "%":
				return a;
			default:
				throw new InvalidOpExecption();
		}
	}

	double lancementCalcul() throws IOException{
		double a=0, b=0;
		String op="";
		Boolean flag;
		do {
			flag = false;
			try {
				a = saisieNombre();
			} catch (InputMismatchException e) {
				System.out.println("Erreur de saisi");
				flag = true;
			}

		} while(flag);

		do {
			flag = false;
			try {
				op = saisieOperation();
			} catch (InvalidOpExecption e) {
				System.out.println("Erreur de saisi");
				flag = true;
			}

		} while(flag);

		do {
			flag = false;
			try {
				b = saisieNombre();
			} catch (InputMismatchException e) {
				System.out.println("Erreur de saisi");
				flag = true;
			}

		} while(flag);

		double out;
		switch(op){
			case "+":
				out = a+b;
				break;
			case "-":
				out = a-b;
				break;
			case "*":
				out = a*b;
				break;
			case "/":
				out = a/b;
				break;
			case "%":
				out = a%b;
				break;
			default:
				out = a;
		}

		Date d = new Date();
		FileWriter fw = new FileWriter("log.txt",true);
		fw.write(d+" :: "+a+op+b+"="+out+"\n");
		fw.close();

		return out;
	}


}


class TestOne {
	public static void main (String args[]){
		Calculatrice c = new Calculatrice();
		try{
			System.out.println("Le resultat est "+c.lancementCalcul());
		} catch (IOException e) {}
	}
}