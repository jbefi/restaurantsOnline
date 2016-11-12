package restaurantsOnline;

public class Main {

	public static void main(String[] args) {
		Beguda b1 = new Beguda("cola",2,10,30,false);
		Beguda b2 = new Beguda("fanta",1.5,20,30,false);
		Plat p1 = new Plat("Amanida", 5, 20);
		String[] alergies = {"lactosa", "celiacs", "fruits secs"};
		Plat p2 = new Plat("Sopa", 10, 5, alergies);
		LlistaProducte llist = new LlistaProducte(10);
		
		llist.afegirProducte(b1);
		llist.afegirProducte(b2);
		llist.afegirProducte(p1);
		System.out.println(llist);
		llist.eliminarProducte(3);
		System.out.println("--------");
		System.out.println(llist);
		llist.afegirProducte(p2);
		System.out.println("-------->>>>>");
		System.out.println(llist);
		System.out.println(">>>>-------->>>>>");
		System.out.println(llist.informacio(4));

	}

}
