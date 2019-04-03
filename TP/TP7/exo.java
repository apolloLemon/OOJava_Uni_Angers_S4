//CODE EXO
import java.io.*;
import java.util.*;

interface IORegion {
	public ArrayList<Region> lire(String fileName) throws IOException;
	public void sauver(ArrayList<Region> regions, String fileName) throws IOException;
}
class PlainIORegion implements IORegion{
	public ArrayList<Region> lire(String fileName) throws IOException{
		System.out.println("lire");
		ArrayList<Region> out = new ArrayList<Region>();
		BufferedReader in = null;
		try {
			// ouverture du fichier
			in = new BufferedReader(
				new FileReader(fileName)
			);
			// lecture des données
			String ligne = null;
			while ((ligne=in.readLine()) != null) {
				String[] words = ligne.split(",");
				//System.out.println(words[0]);
				if(!words[0].equals("Region")) continue;
				//System.out.println("It's a Region");
				Region r = new Region(words[1],Integer.parseInt(words[2]),Integer.parseInt(words[3]),Integer.parseInt(words[4]),Integer.parseInt(words[5]));
				out.add(r);
			}
		} finally {
		// fermeture du fichier
			if (in != null)      
			in.close();
		}
		return out;
	}
	public void sauver(ArrayList<Region> regions, String fileName) throws IOException{
		//System.out.println("sauver");
		PrintWriter out = null;
		try {
			// ouverture du fichier
			out = new PrintWriter(
				new FileWriter(fileName)
			);
			//System.out.println(out.)
			for (Region r : regions) {
				String s = r.toString();
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

class Region implements Comparable<Region>{

	String nom;
	int pop;
	int pib;
	int com;
	int sup;

	Region(String n, int p, int i, int c, int s){
		nom=n;
		pop=p;
		pib=i;
		com=c;
		sup=s;
	}
	public String toString() {
		return "Region,"+nom+","+pop+","+pib+","+com+","+sup;
	}


	public int compareTo(Region r){
		return this.nom.compareTo(r.nom);
	}
}


class RUN {
	public static void main(String[] args) throws IOException {
		String fileName = "regions.csv";
		IORegion io = new PlainIORegion(); // PlainIORegion, ObjectIORegion…
		
		ArrayList<Region> regions = io.lire(fileName);
		
		Collections.sort(regions);

		for (Region f : regions) { // on vérifie que regions1 = Regions 2
			System.out.println(f);
		}

		System.out.println("\n");

		Collections.sort(regions, new SortByPIBH());

		for (Region f : regions) {
			System.out.println(f);
		}

		System.out.println("\n");

		Collections.sort(regions, new SortByDensity());

		for (Region f : regions) {
			System.out.println(f);
		}

		//System.out.println("\n"+SortByPIBH.compare(regions.get(0),regions.get(1)));

	}
}

class SortByPIBH implements Comparator<Region> {
	public int compare(Region r1,Region r2){
		return ((r1.pib*1000000/r1.pop)-(r2.pib*1000000/r2.pop));
	}
}

class SortByDensity implements Comparator<Region> {
	public int compare(Region r1,Region r2){
		return ((r1.sup*1000000/r1.pop)-(r2.sup*1000000/r2.pop));
	}	
}