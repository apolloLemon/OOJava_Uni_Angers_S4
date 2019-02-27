import java.util.*;

public class Annuaire {
	private ArrayList<Client> Clients;

	public Annuaire(){
		Clients = new ArrayList<Client>();
	}

	public void ajouterClient(String nom){
		Clients.add(new Client(nom));
	}

	public void ToutLister(){
		for (Client c : Clients) {
			System.out.println(c);
		}
	}

	private Client num2Client(int num){
		for (Client c : Clients)
			if(c.getNum()==num)
				return c;
		return null;
	}

	public void Trouver(int num){
		System.out.println(num2Client(num));
	}

	public void Retirer(int num){
		Clients.remove(Clients.indexOf(num2Client(num)));
	}

	public int taille(){
		return Clients.size();
	}

	public void Crediter(int num, double credit){
		Client c = num2Client(num);
		c.setSld(c.getSld()+credit);
	}

	public double allthemoney(){
		double out=0;
		for(Client c : Clients)
			out += c.getSld();
		return out;
	}

	public Boolean contient(Client c){
		return Clients.contains(c);
	}

	
}