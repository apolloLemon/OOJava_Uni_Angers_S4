class C {int n;}

class Aa {
	C c = new C();
	Aa() {System.out.println("c dans Aa : "+c);}
}

class Bb {
	C c;
	Bb(C _c){
		c = _c; System.out.println("c dans Bb : "+c);}
	void valuer(int x){
	c.n=x;}}

class Partage {
	public static void main(String[] arg){
		Aa a = new Aa();
		Bb b = new Bb(a.c);
		b.valuer(2);
		System.out.println(a.c.n);}}