class Animal {
	int weight, age;

	Animal(int w, int a){
		weight=w;
		age=a;
	}

	void eat(){
		System.out.println("I'm eating");
	}
	void sleep(){
		System.out.println("I'm sleeping");	
	}
}

class Bird extends Animal {

	Bird(int w, int a){
		super(w,a);
	}

	// Ceci n'est pas tres propre car on
	// veux pas vraiment donner la fonction
	// a' tout les oiseaux
	/*void fly(){
		System.out.println("Fly me to the moon");
	}*/
}

interface Fly {
	void fly();
}

class Sparrow extends Animal implements Fly {

	Sparrow(int w, int a){
		super(w,a);
	}

	public void fly(){
		System.out.println("Fly me to the moon");
	}
}

class Chicken extends Bird {
	Chicken(int w, int a){
		super(w,a);
	}

	// retire' car fly n'est plus une methode
	// de Bird mais de l'interface Fly
	// Donc on n'as plus besoin d'Override
	// afin de retirer la capacite' de voler
	/*void fly(){
		System.out.println("I believe I can fly");
	}*/
}

class Fish extends Animal {
	
	Fish(int w, int a){
		super(w,a);
	}

	void swim(){
		System.out.println("Just keep swiming");
	}
}

class Question2 {
	public static void main (String args[]){
		Bird B = new Bird(125,2);
		Sparrow S = new Sparrow(125,2);
		Fish F = new Fish(1550,3);

		//B.eat();
		F.sleep();
		//B.fly(); //rm because interface
		S.fly();
		F.swim();
	}
}

class Question3 {
	public static void main (String args[]){
		Bird B = new Bird(125,2);
		Fish F = new Fish(1550,3);
		Animal A = new Animal(3,1415);

		Animal[] animals = {B,F,A};

		for(Animal a : animals){
			a.eat();
		}
	}
}

class QuestionInterface5 {
	public static void main (String args[]){
	}
}