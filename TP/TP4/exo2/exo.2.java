class Point {
	int x,y;
	Point(int _x, int _y){
		x=_x;
		y=_y;
	}
}

abstract class Shape {
	abstract double perimeter ();
}

class Circle extends Shape {
	Point centre;
	double radius;
	String nom;

	Circle(String n, Point c, double r){
		nom=n;
		centre=c;
		radius=r;
	}

	double perimeter(){
		return 2*radius*3.1415;
	}

	public String toString(){
		return nom+"("+centre.x+","+centre.y+")\nradius: "+radius+"\nperimeter: "+this.perimeter();
	}
}

class TestCircle {
	public static void main (String args[]){
		Point o = new Point(0,0);
		Point p = new Point(1,2);
		Circle g = new Circle("God",o,999.9);
		Circle c = new Circle("Bob",p,1.0);

		System.out.println(g);
		System.out.println(c);
	}
}