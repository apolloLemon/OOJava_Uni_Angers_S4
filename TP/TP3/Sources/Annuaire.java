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
		Annuaire.remove(Annuaire.indexOf(num2Client(num)));
	}

	public int taille(){
		return Clients.size();
	}
}