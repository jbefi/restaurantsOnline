﻿package restaurantsOnline;

import java.io.*;
import java.util.*;

public class Main {

	public static LlistaProducte llistaProducte;
	public static LlistaComanda llistaComandes;
	public static LlistaClients llistaClients;

	public static Scanner teclat = new Scanner(System.in);

	public static void mostraMenu() {
		System.out.println("\n ******RESTAURANTE ON LINE*******");

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

	// Mètode per eliminar un producte de la llista passat per paràmetre a partir del codi introduït per l'usuari.
	public static void eliminarProducte(LlistaProducte llistP) {
		int codi;
		mostrarProducte(1);
		mostrarProducte(2);
		System.out.print("\n\n\tIndiqui el codi del  producte a eliminar:\t");
		codi = Integer.parseInt(teclat.nextLine());
		llistP.eliminarProducte(codi);
		System.out.print("\n\n\tEl producte s'ha eliminat amb exit!\t");
	}

	/**
	 * Metode al main que crea una comanda Created by Kidu15 on 11/11/16.
	 */
	public static void afegirComanda() {

		// creo les variables booleanes que necessito per a fer el meu programa
		String nom = null;
		String usuari = null;

		int i = 0, opcio, quantitat = 0, pas, posiciousuari = 0;

		boolean confirmar, plats, begudes, existeix1, existeix2, preferent;
		confirmar = false;
		plats = false;
		begudes = false;
		existeix1 = false;
		existeix2 = false;
		preferent = false;

		Comanda nova = new Comanda(new LlistaProducte(50), 0, 0, 0);

		System.out.println("** Crear comanda **");

		System.out.println("Per a crear una comanda introdueix l'usuari i la clau de pas------>  ");

		System.out.println("Usuari:");
		usuari = teclat.nextLine();

		System.out.println("Clau de pas:");
		pas = teclat.nextInt();
		teclat.nextLine();

		while ((i < llistaClients.getnClients()) && (!existeix1) && (!existeix2)) {

			if (usuari.equals(llistaClients.getLlista()[i].getUsuari())) {
				existeix1 = true;
			}
			if (pas == (llistaClients.getLlista()[i].getContrasenya())) {
				existeix2 = true;
			}

			if (existeix1 && existeix2) {
				posiciousuari = i;

			}
			i++;
		}
		preferent = llistaClients.passa_Preferent(llistaClients.getLlista()[posiciousuari]);

		if (existeix1 && existeix2) {

			while (!confirmar) { // bucle que confirma la comanda

				int aux = 0;
				while (!plats) { // comencem amb els plats
					mostrarProducte(1); // Muestra todas las bebidas al usuario
					// demanem a l'usuari els plats i la seva quantitat
					System.out.println("Introdueix el nom del plat: ");
					nom = teclat.nextLine();
					System.out.println("Introdueix la quantitat");

					quantitat = teclat.nextInt();
					teclat.nextLine();

					aux = nova.afegirElement(nom, llistaProducte, quantitat, preferent);

					if (aux == -1) {
						System.out.println("No hi ha l'element");
					}

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

					nova.afegirElement(nom, llistaProducte, quantitat, preferent);

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
				if (opcio == 2) {
					confirmar = true;
				}
			}
		} else {
			System.out.println("L'usuari no existeix");
		}
	}

	public static void consultarInformacio(LlistaProducte llistP) {

		int codi;
		System.out.print("\n\n\tIndiqui el codi del producte (1-" + llistP.getnElem() + "): \t");
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
		System.out.print("\n\n\tIndica el Contrasenya:  del client:\t");
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
		System.out.print("\n\n\tIndica id del client que vols consultar (1-" + llistaClients.getnClients() + "): \t");
		id = teclat.nextInt();
		teclat.nextLine();
		System.out.println(llistaClients.imprimirClient(id));
	}

	private static void copiarComanda()

	{
		int iden, id = 0;
		System.out.println("Usuari:");
		String usuari = teclat.nextLine();
		boolean exist1 = false, exist2 = false;
		int posusuari = 0;

		System.out.println("Contrasenya:");
		int pas = teclat.nextInt();
		teclat.nextLine();
		int i = 0;

		while ((i < llistaClients.getnClients()) && (!exist1) && (!exist2)) {

			if (usuari.equals(llistaClients.getLlista()[i].getUsuari())) {
				exist1 = true;
			}
			if (pas == (llistaClients.getLlista()[i].getContrasenya())) {
				exist2 = true;
			}

			if (exist1 && exist2) {
				posusuari = i;

			}
			i++;
		}

		if (exist1 && exist2) {
			id = llistaClients.getLlista()[posusuari].getIdentificador();

			System.out.println(llistaClients.consultar_Comandes(id));
			System.out.print("\n\n\tIndica el identificador  de la comanda que vols copiar :\t");
			iden = teclat.nextInt();
			teclat.nextLine();

			int j = llistaClients.copiar_Comanda(id, iden);
			if (j == 1) {
				System.out.print("\n\n\tLa comanda s'ha copiat amb exit \t");
			} else {
				System.out.print("\n\n\tNo s'ha trobat la comanda \t");
			}
		} else {
			System.out.println("No existeix aquest usuari amb aquesta contrasenya!\n ");
		}

	}

	private static void comandes()

	{
		int id = 0;
		System.out.println("Usuari:");
		String usuari = teclat.nextLine();
		boolean exist1 = false, exist2 = false;
		int posusuari = 0;

		System.out.println("Contrasenya:");
		int pas = teclat.nextInt();
		teclat.nextLine();
		for (int i = 0; i < llistaClients.getnClients(); i++) {

			if (usuari.equals(llistaClients.getLlista()[i].getUsuari())) {
				exist1 = true;
			}
			if (pas == (llistaClients.getLlista()[i].getContrasenya())) {
				exist2 = true;
			}

			if (exist1 && exist2) {
				posusuari = i;
				exist1 = false;
				exist2 = false;
			}
		}
		if (exist1 && exist2) {
			id = llistaClients.getLlista()[posusuari].getIdentificador();
			System.out.print("\n\n\t La llista de comandes ordenada : \t");
			System.out.println(llistaClients.consultar_Comandes(id));
		} else {
			System.out.println("No existeix aquest usuari amb aquesta contrasenya!\n ");
		}
	}

	// Mètode auxiliar per mostrar a la consola tots els plats o totes les begudes de la llista global de Productes.
	// El paràmetre tipus és 1 si mostra els plats, 2 les begudes
	public static void mostrarProducte(int tipus) {
		System.out.println("************ Informació del Producte *****************");
		for (int i = 0; i < llistaProducte.getnElem(); i++) {
			if (tipus == 1 && llistaProducte.getLlista()[i] instanceof Plat)
				System.out.println(llistaProducte.getLlista()[i]);
			else if (tipus == 2 && llistaProducte.getLlista()[i] instanceof Beguda)
				System.out.println(llistaProducte.getLlista()[i]);
		}
		System.out.println("******************************************************\n");
	}

	public static void main(String[] args) throws IOException {
		// Primer de tot, inicialitzem una quants productes directament
		Beguda sprite = new Beguda("Sprite", 1.5, 10, 330, false);
		Beguda cola = new Beguda("Coca-Cola", 1.6, 5, 330, false);
		Beguda aigua = new Beguda("Aigua", 1.5, 10, 500, false);
		Beguda cervesa = new Beguda("Cervesa", 1.7, 5.5, 330, true);
		Beguda viNegre = new Beguda("Vi negre", 5.95, 5, 750, true);
		Plat amanida = new Plat("Amanida", 5, 10);
		String[] alergSopa = { "Fruits Secs", "", "" };
		Plat sopa = new Plat("Sopa", 6, 5, alergSopa);
		String[] alergMacarrons = { "Celiacs", "Lactosa", "Fruits Secs" };
		Plat macarrons = new Plat("Macarrons", 8.5, 3, alergMacarrons);
		Plat arros = new Plat("Arros", 7, 2);
		Plat gambes = new Plat("Gambes", 12, 1);
		// Assumint que la llista global de productes no poden tenir més de 100
		llistaProducte = new LlistaProducte(100);
		// Afegirem tots els productes anteriors a la llista global
		llistaProducte.afegirProducte(sprite);
		llistaProducte.afegirProducte(cola);
		llistaProducte.afegirProducte(aigua);
		llistaProducte.afegirProducte(cervesa);
		llistaProducte.afegirProducte(viNegre);
		llistaProducte.afegirProducte(amanida);
		llistaProducte.afegirProducte(sopa);
		llistaProducte.afegirProducte(macarrons);
		llistaProducte.afegirProducte(arros);
		llistaProducte.afegirProducte(gambes);

		int hora = 0, min = 0;
		// Creem uns quants clients
		llistaClients = new LlistaClients();
		String[] restrClient1 = { "Celiacs", "Lactosa", "Fruits secs" }; // Al·lèrgies per client 1
		Clients Client1 = new Clients("Jose", " avenida Barcelona", "666999444", "jose32", 234, restrClient1,
				new LlistaComanda());
		llistaClients.creaClient(Client1);
		String[] restrClient2 = { "", "", "Fruits secs" }; // Al·lèrgies per client 2
		Clients Client2 = new Clients("Alex", "avenida Jaume1", "666777444", "alex32", 123, restrClient2,
				new LlistaComanda());
		llistaClients.creaClient(Client2);
		String[] restrClient3 = { "", "", "" }; // El client 3 no té cap al·lèrgia
		Clients Client3 = new Clients("Jordi", "avenida Ramon", "666888444", "jordi32", 543, restrClient3,
				new LlistaComanda());
		llistaClients.creaClient(Client3);
		// Creem una llista de productes seleccionats pel client 1,
		LlistaProducte productesClient1 = new LlistaProducte(50);
		productesClient1.afegirProducte(cola);
		productesClient1.afegirProducte(sopa);
		productesClient1.afegirProducte(arros);
		// aquesta llista l'afegirem a la comanda del client 1
		Comanda comanda1 = new Comanda(productesClient1, hora, min, 0);
		// Ara creem una llista de productes seleccionats pel client 2,
		LlistaProducte productesClient2 = new LlistaProducte(50);
		productesClient2.afegirProducte(cervesa);
		productesClient2.afegirProducte(amanida);
		productesClient2.afegirProducte(macarrons);
		productesClient2.afegirProducte(gambes);
		// aquesta llista l'afegirem a la comanda del client 2
		Comanda comanda2 = new Comanda(productesClient2, hora, min, 0);
		// Finalment creem una llista de productes seleccionats pel client 3,
		LlistaProducte productesClient3 = new LlistaProducte(50);
		productesClient3.afegirProducte(viNegre);
		productesClient3.afegirProducte(sprite);
		productesClient3.afegirProducte(amanida);
		productesClient3.afegirProducte(arros);
		productesClient3.afegirProducte(gambes);
		// aquesta llista l'afegirem a la comanda del client 3
		Comanda comanda3 = new Comanda(productesClient3, hora, min, 0);
		// Afegim les comandes anteriors corresponents de vada client a la llista global dels clients
		llistaClients.afegirComandaClient(Client1.getIdentificador(), comanda1);
		llistaClients.afegirComandaClient(Client2.getIdentificador(), comanda2);
		llistaClients.afegirComandaClient(Client3.getIdentificador(), comanda3);

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
				comandes();
				break;
			default:
				if (opcio != 9)
					System.out.println("Opció trïada incorrecte!");
				break;

			}
		}
	}

}