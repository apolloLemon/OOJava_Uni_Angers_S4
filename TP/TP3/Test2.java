class TestTwo {
	public static void main (String[] args){
		Client c1 = new Client("Bob");
		Client c2 = new Client("Bob");

		Annuaire a = new Annuaire();
		a.ajouterClient(c1);
		System.out.println(a.contient(c2));
	}
}