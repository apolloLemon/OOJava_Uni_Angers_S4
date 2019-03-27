import java.util.*;
import java.io.*;

class RUN {
	public static void main (String[] args){

		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez un path: ");		
		String in = sc.nextLine();

		File f = new File(in);
		boolean xist = f.exists();
		System.out.println(xist);
		boolean isdir = f.isDirectory();
		if(isdir){
			for (String e : f.list())  {
				System.out.println(e);
			}
		} else {
			System.out.println(f.length()+" "+f.getAbsolutePath());
		}
	}
}