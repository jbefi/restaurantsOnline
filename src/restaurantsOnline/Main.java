package restaurantsOnline;


import java.io.*;
import java.util.*;

public class Main {

	public static LlistaProducte llistaProducte;
	public static LlistaComanda llistaComandes;
	public static LlistaClients llistaClients;

	static Scanner teclat = new Scanner(System.in);

	public static void mostraMenu() {
		System.out.println("******RESTAURANTE ON LINE*******");
		
		
		
		System.out.println("\n\nOpcions del menu:");
		System.out.println("\n\t1. Afegir nou producte");
		System.out.println("\t2. Eliminar producte");
		System.out.println("\t3. Consultar la informació d'un producte ");
		System.out.println("\t4. Crear un nou client ");
		System.out.println("\t5. Consultar un client ");
		System.out.println("\t6. Afegir una comanda ");
		System.out.println("\t7. Copiar  una comanda ");
		System.out.println("\t8. Llistar  totes les comandes d'un client ");
		System.out.println("\t9. Sortir");
		System.out.print("\n\t\t\tIndica opció:\n");
	}

	public static void afegirProducte(LlistaProducte llistP)

	{
		String nom;
		Double preu;
		Double descompte;
		Plat p;

		int opcio;

		
		System.out.print("\n\n\t Introdueixi '1' per la Beguda, '2' pel Plat:\t");
		opcio = teclat.nextInt();

		teclat.nextLine();

		switch (opcio) {
		case 1:
			int volum;
			boolean tAlcohol;
			System.out.print("\n\n\tIndiqui el nom:\t");
			nom = teclat.nextLine();
			System.out.print("\n\n\tIndiqui el preu:\t");
			preu = teclat.nextDouble();
			teclat.nextLine();
			System.out.print("\n\n\tIndiqui % del descompte:\t");
			descompte = teclat.nextDouble();
			teclat.nextLine();
			System.out.print("\n\n\tIndiqui el volum en ml: \t");
			volum = teclat.nextInt();
			teclat.nextLine();
			System.out.print("\n\n\tIndica si la beguda te alcol (si/no) :\t");
			if (teclat.nextLine().trim().equalsIgnoreCase("si"))
				tAlcohol = true;
			
			else 
				tAlcohol = false;
			Beguda b1 = new Beguda(nom, preu, descompte, volum, tAlcohol);
			llistP.afegirProducte(b1);
			break;
		case 2:
			String[] res = new String[3];
			System.out.print("\n\n\tIndiqui el nom:\t");

			nom = teclat.nextLine();
			System.out.print("\n\n\tIndiqui el preu :\t");
			preu = teclat.nextDouble();
			teclat.nextLine();

			System.out.print("\n\n\tIndiqui % del descompte :\t");
			descompte = teclat.nextDouble();
			teclat.nextLine();
			System.out.print("\n\n\tIndiqui si té restriccions alimentàries (si/no):\t");
			if (teclat.nextLine().trim().equalsIgnoreCase("si")) {
				System.out.print("\n\n\tIndica quina retriccions te aquet plat  :\n");// DEmanar REstriccions
				System.out.print("\t1.Celiacs  (si/no):\n");
				if (teclat.nextLine().trim().equalsIgnoreCase("si"))
					res[0] = "Celiacs";
				else {
					res[0] = "";
				}
				System.out.print("\t2.lactosa  (si/no):\n");
				if (teclat.nextLine().trim().equalsIgnoreCase("si"))
					res[1] = "Lactosa";
				else
					res[1] = "";
				System.out.print("\t3.fruit secs (si/no):\n");
				if (teclat.nextLine().trim().equalsIgnoreCase("si"))
					res[2] = "Fruits Secs";
				else
					res[2] = "";
				p = new Plat(nom, preu, descompte, res);
				llistP.afegirProducte(p);
			} else {
				p = new Plat(nom, preu, descompte);
				llistP.afegirProducte(p);
			}
			break;
		}

	}

	public static void eliminarProducte(LlistaProducte llistP) {
		int codi;

		System.out.print("\n\n\tIndiqui el codi del  producte a eliminar:\t");
		codi = Integer.parseInt(teclat.nextLine());
		llistP.eliminarProducte(codi);
		System.out.print("\n\n\tEl producte s'ha eliminat amb exit!\t");
	}

	public static void carregarProducte(LlistaProducte llistP) {
		// encara falta el fitxer
	}

	/**
	 * Metode al main que crea una comanda Created by Kidu15 on 11/11/16.
	 */
	public static void afegirComanda() {
		
		int i = 0; 
		int opcio; // creo les variable enteres que utilitzo per a les opcions que dono al client
		int quantitat = 0;
		String nom = null; // variable utilitzada per al nom del producte
		boolean confirmar, plats, begudes,existeix1, existeix2; // creo les variables booleanes que necessito per a fer el meu programa
		confirmar = false;
		plats = false;
		begudes = false;
		existeix1= false; 
		existeix2=false; 
		int pas; 
		int posiciousuari = 0; 
		String usuari=null;
		boolean preferent; 
		preferent=false; 
		
		Comanda nova = new Comanda(new LlistaProducte(50), 0, 0, 0);

		System.out.println("** Crear comanda **");
		
		System.out.println("Per a crear una comanda introdueix l'usuari i la clau de pas------>  ");
		
		System.out.println("Usuari:");
		usuari = teclat.nextLine(); 
		
		System.out.println("Clau de pas:");
		pas = teclat.nextInt(); 
		teclat.nextLine();
		
			while  ((i<llistaClients.getnClients())&&(!existeix1)&&(!existeix2)){
			
				if(usuari.equals(llistaClients.getLlista()[i].getUsuari())){
					existeix1=true; 
				}
				if(pas==(llistaClients.getLlista()[i].getContrasenya())){
					existeix2=true; 
				}
			
				if (existeix1 && existeix2){
					posiciousuari=i; 
					
				}
				i++; 
			}
			preferent = llistaClients.passa_Preferent(llistaClients.getLlista()[posiciousuari]);
			
			if (existeix1 && existeix2){
		
				while (!confirmar) { // bucle que confirma la comanda
				
					int aux=0;
					while (!plats) { // comencem amb els plats
						mostrarProducte(1); // Muestra todas las bebidas al usuario 
						// demanem a l'usuari els plats i la seva quantitat
						System.out.println("Introdueix el nom del plat: "); 
						nom=teclat.nextLine();
						System.out.println("Introdueix la quantitat");
						
						quantitat = teclat.nextInt();
						teclat.nextLine();
	
					
							aux = nova.afegirElement(nom, llistaProducte, quantitat, preferent); 
							
						
							if (aux == -1) {
								System.out.println("No hi ha l'element");
							
	
			
						System.out.println("Si vols mes plats, posa l'1, si no, el 2");
						opcio = teclat.nextInt();
						teclat.nextLine();
						if (opcio == 2) {
							plats = true;
						}
					}
					while (!begudes) {
						mostrarProducte(2); // Muestra todas las bebidas de la lista global 
						System.out.println("Introdueix les begudes que vols");
		
						nom = teclat.nextLine();
		
						System.out.println("Introdueix la quantitat");
		
						quantitat = teclat.nextInt();
						teclat.nextLine();
		
						
							nova.afegirElement(nom, llistaProducte, quantitat,preferent);
						
						System.out.println("Si vols mes begudes, posa l'1, si no, el 2");
						opcio = teclat.nextInt();
						teclat.nextLine();
						if (opcio == 2) {
							begudes = true;
						}
					}
		
					System.out.println("Per veure el resum de la comanda, posa l'1, per eliminar la comanda, el 2");
		
					opcio = teclat.nextInt();
					teclat.nextLine();
		
					if (opcio == 1) {
		
						Calendar horaComanda = new GregorianCalendar();
						int hora, minut;
		
						hora = horaComanda.get(Calendar.HOUR_OF_DAY);
						minut = horaComanda.get(Calendar.MINUTE);
						
						nova.setHora(hora);
						nova.setMinut(minut);
						
						nova.toString();
						System.out.println(nova);
						
		
						System.out.println("Si vols confirmar la comanda, posa l'1, si no, el 2 ");
		
						opcio = teclat.nextInt();
						teclat.nextLine();
						if (opcio == 1) {
							
							int id = llistaClients.getLlista()[posiciousuari].getIdentificador(); 
							llistaClients.afegirComandaClient(id, nova);
							
							confirmar = true;
		
						}
					}
					if (opcio==2){
						confirmar=true; 
					}
				
			
			else 
			{
				System.out.println("L'usuari no existeix");
			}
	
					}
			}
		}
	}

	public static void consultarInformacio(LlistaProducte llistP) {

		int codi;
		System.out.print("\n\n\tIndiqui el codi del producte:\t");
		codi = teclat.nextInt();
		teclat.nextLine();
		System.out.println("\n   ---------- INFORMACIÓ ---------");
		System.out.println(llistP.informacio(codi));

	}

	public static void crearClient() {
		String nom;
		String tel;
		int contr;
		String usuari;
		String adreca;
		String[] res = new String[3];

	
		System.out.print("\n\n\tIndica el nom del client:\t");
		nom = teclat.nextLine();
		System.out.print("\n\n\tIndica la adreca:\t");
		adreca = teclat.nextLine();
		System.out.print("\n\n\tIndica el numero de telefon :\t");
		tel = teclat.nextLine();
		System.out.print("\n\n\tIndica el nom d'usuari del client:\t");
		usuari = teclat.nextLine();
		System.out.print("\n\n\tIndica el mot de pas del client:\t");
		contr = teclat.nextInt();

		teclat.nextLine();
		System.out.print("\n\n\tIndica si el client te alguna restriccions: (si/no)\t"); // DEMANAR RESTRICCIONS
		if (teclat.nextLine().trim().equalsIgnoreCase("si")) {
			System.out.print("\n\n\tIndica quina retriccions te aquet client  :\n");
			System.out.print("\t1.Celiacs  (si/no):\n");
			if (teclat.nextLine().trim().equalsIgnoreCase("si"))
				res[0] = "Celiacs";
			else {
				res[0] = "";
			}
			System.out.print("\t2.lactosa  (si/no):\n");
			if (teclat.nextLine().trim().equalsIgnoreCase("si"))
				res[1] = "Lactosa";
			else
				res[1] = "";
			System.out.print("\t3.fruit secs (si/no):\n");
			if (teclat.nextLine().trim().equalsIgnoreCase("si"))
				res[2] = "Fruits Secs";
			else
				res[2] = "";
		}
		Clients client = new Clients(nom, adreca, tel, usuari, contr, res, new LlistaComanda());

		llistaClients.creaClient(client); // Afegir a la llista de Clients

	}

	public static void consultarClient()

	{
		int id;
		System.out.print("\n\n\tIndica id del client que vols consultar:\t");
		id = teclat.nextInt();
		teclat.nextLine();
		System.out.println(llistaClients.imprimirClient(id));
	}
	

	private static void copiarComanda()

	{
		int iden, id = 0;
		System.out.println("Usuari:");
		String usuari = teclat.nextLine(); 
		boolean exist1=false, exist2=false;
		int posusuari = 0;
		
		System.out.println("Mot de pas:");
		int pas = teclat.nextInt(); 
		teclat.nextLine();
		int i=0; 
		
		while  ((i<llistaClients.getnClients())&&(!exist1)&&(!exist2)){
			
			if(usuari.equals(llistaClients.getLlista()[i].getUsuari())){
				exist1=true; 
			}
			if(pas==(llistaClients.getLlista()[i].getContrasenya())){
				exist2=true; 
			}
		
			if (exist1 && exist2){
				posusuari=i; 
				
			}
			i++; 
		}
		
		id = llistaClients.getLlista()[posusuari].getIdentificador();
		
		System.out.println(llistaClients.consultar_Comandes(id));
		System.out.print("\n\n\tIndica el identificador  de la comanda que vols copiar :\t");
		iden = teclat.nextInt();
		teclat.nextLine();
		
		int j = llistaClients.copiar_Comanda (id, iden);
		if (j==1){
			System.out.print("\n\n\tLa comanda s'ha copiat amb exit \t");
		}
		else{
			System.out.print("\n\n\tNo s'ha trobat la comanda \t");
		}
		
		

	}

	private static void ordenarComandes()

	{
		int id = 0;
		System.out.println("Usuari:");
		String usuari = teclat.nextLine(); 
		boolean exist1=false, exist2=false;
		int posusuari = 0;
		
		System.out.println("Mot de pas:");
		int pas = teclat.nextInt(); 
		teclat.nextLine();
		for (int i=0; i<llistaClients.getnClients(); i++){
			
			if(usuari.equals(llistaClients.getLlista()[i].getUsuari())){
				exist1=true; 
			}
			if(pas==(llistaClients.getLlista()[i].getContrasenya())){
				exist2=true; 
			}
		
			if (exist1 && exist2){
				posusuari=i; 
				exist1 = false;
				exist2 = false;
			}
		}
		id = llistaClients.getLlista()[posusuari].getIdentificador();
		llistaClients.consultar_Comandes(id).ordenarComandes();
		System.out.print("\n\n\t La llista de comanda ordenat\t");
		System.out.println(llistaClients.consultar_Comandes(id));
	}
	
	// Mètode auxiliar per mostrar a la consola tots els plats o totes les begudes de la llista global de Productes.
	// El paràmetre tipus és 1 si mostra els plats, 2 les begudes
	public static void mostrarProducte(int tipus){
		System.out.println("************ Informació del Producte *****************");
		for (int i=0; i<llistaProducte.getnElem();i++){
			if (tipus==1 && llistaProducte.getLlista()[i] instanceof Plat )
				System.out.println(llistaProducte.getLlista()[i]);
			else if (tipus==2 && llistaProducte.getLlista()[i] instanceof Beguda )
				System.out.println(llistaProducte.getLlista()[i]);
		}
		System.out.println("******************************************************\n");
	}

	public static void main(String[] args) throws IOException {
		
		
		Producte[] llista = new Producte[4];
		Beguda b1 = new Beguda("sprite", 2, 10, 20, false);
		Beguda b2 = new Beguda("fanta", 2.5, 20, 30, false);

		Plat p1 = new Plat("Amanida", 5, 20);
		String[] Restriccions = { "celiacs", "lactosa", "fruits secs" };
		Plat p2 = new Plat("Sopa", 10, 5, Restriccions);

		llista[0] = b1;
		llista[1] = b2;
		llista[2] = p1;
		llista[3] = p2;

		llistaProducte = new LlistaProducte(12);
		llistaProducte.afegirProducte(b1);
		llistaProducte.afegirProducte(b2);
		llistaProducte.afegirProducte(p1);
		llistaProducte.afegirProducte(p2);

		String[] tRestr = { "celiacs", "lactosa", "fruits secs" };

		int hora = 0, min = 0;

		llistaClients = new LlistaClients();
		Clients Client1 = new Clients("Jose", " avenida Barcelona", "666999444", "jose32", 234, tRestr,
				new LlistaComanda());
		llistaClients.creaClient(Client1);
		Clients Client2 = new Clients("Alex", "avenida Jaume1", "666777444", "alex32", 123, tRestr,
				new LlistaComanda());
		llistaClients.creaClient(Client2);
		Clients Client3 = new Clients("Jordi", "avenida Ramon", "666888444", "jordi32", 543, tRestr,
				new LlistaComanda());
		llistaClients.creaClient(Client3);
		
	
		Comanda comanda1 = new Comanda(llistaProducte, hora, min,0);
		Comanda comanda2 = new Comanda(llistaProducte, hora, min,0);
		@SuppressWarnings("unused")
		Comanda comanda3 = new Comanda(llistaProducte, hora, min,0);

		llistaClients.afegirComandaClient(Client1.getIdentificador(), comanda1);
		llistaClients.afegirComandaClient(Client1.getIdentificador(), comanda2);

		int opcio = 0;
		while (opcio != 9) {
			mostraMenu();
			opcio = teclat.nextInt();
			teclat.nextLine();
			System.out.println(opcio);
			switch (opcio) {
			case 1:
				afegirProducte(llistaProducte);
				;
				break;
			case 2:
				eliminarProducte(llistaProducte);
				break;
			case 3:
				consultarInformacio(llistaProducte);
				break;
			case 4:
				crearClient();
				break;
			case 5:
				consultarClient();
				break;
			case 6:
				afegirComanda();
				break;
			case 7:
				copiarComanda();
				break;
			case 8:
				ordenarComandes();
				break;

			}
		}
	}

}