import java.util.*;
import java.io.*;

class Calculatrice {

	//Calculatrice(){}

	double saisieNombre() throws InputMismatchException {
		System.out.println("Saisie un Double: ");
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble(); //throws InputMismatchException
		/*
		we could try to handle this exception here (loop until user input is valid)

		instead saisieNombre() also throws the exception "up a level"
		and we'll take care of it in lancementCalcul() who calls this f()
		*/
		//sc.close();
		return a;
	}

	class InvalidOpExecption extends Exception {} //simplest custom exception

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
				throw new InvalidOpExecption(); //here we manually throw our exception
			/*
			like with saisieNombre, we could try to loop in this function until we get 
			the user input we want, but instead we'll handle both problems together one level up
			*/
		}
	}

	double lancementCalcul() throws IOException{
		/*
		In the same way saisieNombre didn't handle the InputMismatchException
		lancementCalcule will just throw "up" all IOExceptions (in fact we don't really care about this problem and in the main we'll do fuckall about these exceptions)

		but here we have a good place to handle/use InputMismatchException and our InvalidOpExecption
		// I'm not sure, I think this might be mostly a philosophical choice
		*/
		double a=0, b=0;
		String op="";

		/*
			Here we have a very procedural bit of code (step 1-5)
			like in early code where we'd loop until user input was what we needed
			here we'll loop until the functions we call don't throw exceptions (step 1-3)
			which in turn means we have the user input we need
		*/
		Boolean flag; //this will be used to lock us into a loop if there is an exception
		do { //step 1 get A
			flag = false; //we assume it will be fine (this time)
			try {
				a = saisieNombre();
			} catch (InputMismatchException e) {
				System.out.println("Erreur de saisi");
				flag = true; // aw shit, here we go again .jpg
			}

		} while(flag); //did things do to plan?

		do { //step 2 get operator
			flag = false;
			try {
				op = saisieOperation();
			} catch (InvalidOpExecption e) {
				System.out.println("Erreur de saisi");
				flag = true;
			}

		} while(flag);

		do { //step 3 get B
			flag = false;
			try {
				b = saisieNombre();
			} catch (InputMismatchException e) {
				System.out.println("Erreur de saisi");
				flag = true;
			}

		} while(flag);

		double out;
		switch(op){ //step 4 do (A operator B)
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
				out = a; //this would be a greate place for a WTFException 
		}

		//step 5 give the result
		Date d = new Date();
		FileWriter fw = new FileWriter("log.txt",true);
		fw.write(d+" :: "+a+op+b+"="+out+"\n"); //Throws IOException
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