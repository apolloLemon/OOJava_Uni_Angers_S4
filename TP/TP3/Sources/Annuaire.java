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

	public int taille(){
		return Clients.size();
	}
}