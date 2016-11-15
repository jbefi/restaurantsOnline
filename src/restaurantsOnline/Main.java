package restaurantsOnline;

import java.util.Scanner;
public class Main {

	    static Scanner teclat = new Scanner(System.in);
	    
	    public static void mostraMenu()
	    {
	    	System.out.println("******RESTAURANTE ON LINE*******");
	        System.out.println("\n\nOpcions del menu:");
	        System.out.println("\n\t1. Afegir nous productes");
	        System.out.println("\n\t2.  Eliminar producte");    
	        System.out.println("\t3. Carregar els productes a partir d'un fitxer de dad es");
	        System.out.println("\t4. Consultar la informacio que es demana al registre ");
	        System.out.println("\t5. Crear un nou cliente "); 
	        System.out.println("\t6. Llistar  totes les comandes que ha fet un clint,ordenades de mes nova a mes antiga ");
	        System.out.println("\t7. Obrir una nova comanda per a un client ");
	        System.out.println("\t8. Sortir");
	        System.out.print("\n\t\t\tIndica opcio:\n");
	    }
	    public static void afegirProducte()
	    {
	      
	    }
	    public static void eliminarProducte()
	    {
	      
	    }
	    public static void carregarProducte()
	    {
	        
	    }

	    public static void consultarInformacio()
	    {
	    }

	    public static void crearClient()
	    {
	    }
	    

	    private static void llistarComandes()
	    {

	    }

	    private static void novaComanda()
	    
	    {
	    	
	    }

	 

	    public static void main(String[] args)
	    {
	        int opcio;
	    

	        mostraMenu();
	        opcio = Integer.parseInt(teclat.nextLine());
	        while(opcio != 6)
	        {
	         
	            switch(opcio)
	            {
	                case 1:
	                	afegirProducte();
	                    break;
	                case 2:
	                	eliminarProducte();
	                    break;
	                case 3:
	                	carregarProducte();
	                    break;
	                case 4:
	                	consultarInformacio();
	                    break;
	                case 5:
	                	crearClient();
	                    break;
	                case 6: 
	                	llistarComandes();
	                	break;
	                case 7:
	                	novaComanda();
	                    break;
	               

	            }
	            mostraMenu();
	            opcio = Integer.parseInt(teclat.nextLine());
	        }
	    }
	
}


	/*public static void main(String[] args) {
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
		// Apliquem el descompte a un producte
		llist.getLlista()[0].aplicarDescompte();
		System.out.println(llist.getLlista()[0]);
		
		

	}

}*/
