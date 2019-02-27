import java.util.Scanner;

class Compte {
	int credit, debit;

	Compte(){
		credit = 0;
		debit = 0;
	}

	Compte(int a, int b){
		credit = a;
		debit=b;
	}

	void deposer(int a) throws CompteException {
		if(a<=0) throw new CompteException(0,"deposer");
		else credit += a;
	}
	void retirer(int a) throws CompteException {		
		if(a<=0) throw new CompteException(0,"retirer");
		debit += a;
	}
}

class CompteEpargne extends Compte {
	double taux;

	CompteEpargne(int a,int b, double c) {
		super(a,b);
		taux = c;
	}

	void deposer(int a) throws CompteException {
		if(a<=0) throw new CompteException(1,"deposer");
		else super.deposer(a-1);
	}

	void retirer(int a) throws CompteException {
		if(a<=0) throw new CompteException(1,"retirer");
		super.retirer(a);
	}
}

class CompteException extends Exception{
	private int errnum;
	private String errMethod;
	CompteException(int a, String b){
		errnum = a;
		errMethod = b;
	}
	int getErrNum(){
		return errnum;
	}
	String getErrMethod(){
		return errMethod;
	}
}


class Test{
	public static void main (String[] args){
		Compte C1 = new Compte();
		CompteEpargne CE1 = new CompteEpargne(0,0,1.2);

		Scanner in = new Scanner(System.in);
		int num = 0;
		while(num >= 0){
			num  = in.nextInt();
			try {
				switch(num){
					case 1:
						C1.deposer(-10);
						break;
					case 2:
						C1.retirer(-10);
						break;
					case 3:
						CE1.deposer(-10);
						break;
					case 4:
						CE1.retirer(-10);
						break;
					default: break;
				}
			} catch (CompteException e) System.out.println("erreur de "+((e.getErrNum()==1)?"CompteEpargne":"Compte")+", dans "+e.getErrMethod());
			
		}
	}
}