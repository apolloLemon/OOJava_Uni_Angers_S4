//CODE EXO
import java.io.*;
import java.util.*;

interface IOForme {
	public Collection<Forme> lire(String fileName) throws IOException;
	public void sauver(Collection<Forme> formes, String fileName) throws IOException;
} 
class RUN {
	public static void main(String[] args) throws IOException {
		String fileName = "Stockage";
		IOForme io = new PlainIOForme(); // PlainIOForme, ObjectIOForme…
		IOForme iob = new ObjectIOForme();
		Collection<Forme> formes1 = new ArrayList<Forme>();
		
		Cercle c = new Cercle(0,0,1);
		Rectangle r = new Rectangle(0,0,1,2);

		formes1.add(c);
		formes1.add(r);

		io.sauver(formes1,fileName+"Plain");
		Collection<Forme> formes2 = io.lire(fileName+"Plain");
		for (Forme f : formes2) { // on vérifie que formes1 = formes 2
			System.out.println(f);
		}
		iob.sauver(formes1,fileName+"Object");
		Collection<Forme> formes3 = iob.lire(fileName+"Object");
		for (Forme f : formes3) { // on vérifie que formes1 = formes 2
			System.out.println(f);
		}
	}
}//FIN CODE EXO

//UML EXO
abstract class Forme implements Serializable{
	int x;
	int y;

	Forme(int _x, int _y){
		x=_x;
		y=_y;
	}
}
class Cercle extends Forme {
	int rayon;

	Cercle(int x, int y, int r){
		super(x,y);
		rayon=r;
	}

	public String toString() {
		return "Cercle "+x+" "+y+" "+rayon;
	}
}
class Rectangle extends Forme {
	int longeur;
	int largeur;

	Rectangle(int x,int y,int lo,int la){
		super(x,y);
		longeur = lo;
		largeur = la;
	}

	public String toString() {
		return "Rectangle "+x+" "+y+" "+longeur+" "+largeur;
	}
}//FIN UML EXO


class PlainIOForme implements IOForme{
	public Collection<Forme> lire(String fileName) throws IOException{
		//System.out.println("lire");
		Collection<Forme> out = new ArrayList<Forme>();
		BufferedReader in = null;
		try {
			// ouverture du fichier
			in = new BufferedReader(
				new FileReader(fileName)
			);
			// lecture des données
			String ligne = null;
			while ((ligne=in.readLine()) != null) {
				String[] words = ligne.split(" ");
				//System.out.println(words[0]+"==Cercle:"+(words[0]=="Cercle"));
				int x = Integer.parseInt(words[1]);
				int y = Integer.parseInt(words[2]);
				if(words[0].equals("Cercle")){
					Cercle c = new Cercle(x,y,Integer.parseInt(words[3]));
					//System.out.println("circle");
					out.add(c);
				} else if (words[0].equals("Rectangle")){
					Rectangle r = new Rectangle(x,y,Integer.parseInt(words[3]),Integer.parseInt(words[4]));
					out.add(r);
				}
			}
		} finally {
		// fermeture du fichier
			if (in != null)      
			in.close();
		}
		return out;
	}
	public void sauver(Collection<Forme> formes, String fileName) throws IOException{
		//System.out.println("sauver");
		PrintWriter out = null;
		try {
			// ouverture du fichier
			out = new PrintWriter(
				new FileWriter(fileName)
			);
			//System.out.println(out.)
			for (Forme f : formes) {
				String s = f.toString();
				//System.out.println(s);
				out.println(s);
			}
		} finally {
		// fermeture du fichier
			if (out != null)      
			out.close();
		}
	}
}

class ObjectIOForme implements IOForme{
	public Collection<Forme> lire(String fileName) throws IOException{
		//System.out.println("lire");
		Collection<Forme> out = new ArrayList<Forme>();
		BufferedReader in = null;
		ObjectInputStream ois;
		ois = new ObjectInputStream(
			new FileInputStream(fileName)
		);
		try {
			while (true) {
				out.add((Forme)ois.readObject());
			}
		} catch (ClassNotFoundException cnfe) {} 
		catch (EOFException eofe) {}
		
		ois.close();
		return out;
	}
	public void sauver(Collection<Forme> formes, String fileName) throws IOException{
		//System.out.println("sauver");
		ObjectOutputStream oos;
		oos = new ObjectOutputStream(
			new FileOutputStream(fileName)
		);

		for (Forme f : formes) {
			oos.writeObject(f);
		}
		oos.close();
	}
}