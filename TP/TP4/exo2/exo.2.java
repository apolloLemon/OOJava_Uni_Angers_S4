import java.lang.Math.*;

class Point {
	int x,y;
	Point(int _x, int _y){
		x=_x;
		y=_y;
	}

	void translation (int dx, int dy){
		x+=dx;
		y+=dy;
	}
}

abstract class Shape {
	abstract double perimeter ();
	abstract void translation(int dx, int dy);
}

class Circle extends Shape {
	Point centre;
	double radius;
	String name;

	Circle(String n, Point c, double r){
		name=n;
		centre=c;
		radius=r;
	}

	double perimeter(){
		return 2*radius*Math.PI;
	}

	public String toString(){
		return name+"("+centre.x+","+centre.y+")\nradius: "+radius+"\nperimeter: "+this.perimeter();
	}

	void translation(int dx ,int dy){
		centre.translation(dx,dy);
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

abstract class Polygone extends Shape {
	Point[] points;
	String name;

	double dist(Point a, Point b){
		double dx = a.x-b.x;
		double dy = a.y-b.y; 
		return Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
	}

	double perimeter(){
		int n = points.length;
		double out = 0.0;
		for(int i=0;i<n;i++){
			out += dist(points[i],points[(i+1)%n]);
		}
		return out;
	}

	public String toString(){
		String out =  name+" perimeter: "+this.perimeter()+"\npoints:\n";
		for(Point p : points){
			out += "("+p.x+","+p.y+")\n";
		}
		return out;
	}

	final void translation(int dx, int dy){
		for(Point p : points){
			p.translation(dx,dy);
		}
	}
}

class Triange extends Polygone {
	Triange(String n, Point[] p){
		points = new Point[3];
		points = p;
		name = n;
	}
}

class Quad extends Polygone {
	Quad(String n, Point[] p){
		points = new Point[4];
		points = p;
		name = n;
	}
}

class TestPolygone {
	public static void main (String args[]){
		Point a = new Point(0,0);
		Point b = new Point(1,1);
		Point c = new Point(2,0);


		Triange t = new Triange("Tri", new Point[]{a,b,c});
		System.out.println(t);
	}
}

class TestTranslation {
	public static void main (String args[]){
		Point o = new Point(0,0);
		Point i = new Point(0,1);
		Point j = new Point(1,0);		
		Point a = new Point(1,1);
		Point b = new Point(2,0);
		Point c = new Point(2,1);

		//Triange t = new Triange("TriRec",new Point[]{o,i,j});
		Quad sqr = new Quad("Carre",new Point[]{i,j,b,a});
		Circle crcl = new Circle("Circle", o, 1.0); 


		Shape[] ps = new Shape[]{sqr,crcl};

		for(Shape p : ps){
			System.out.println(p);
		}
		for(Shape p : ps){
			p.translation(4,2);
		}
		for(Shape p : ps){
			System.out.println(p);
		}
	}
}