package fase2;

import java.io.*;
import java.util.*;

import restaurantsOnline.*;

public class Main2 {

	static LlistaClients llista;
	static LlistaProducte llistacomanda;
	public static LlistaProducte llistaProducte; // llista global de tots els productes.
	public static LlistaComanda llistaComandes; // llista de totes les comandes.
	public static LlistaClients llistaClients; // llista de tots els clients.

	/**
	 * Mètode estàtica per llegir els productes a partir del fitxer, on el seu nom es passa pel paràmetre.
	 * @author Enyu Lin
	 * @param nomFitxer
	 *            el nom del fitxer
	 * @return la llista de tots els productes del fitxer.
	 * @throws IOException
	 *             les excepcions d'E/S de les dades.
	 * @throws FileNotFoundException
	 *             l'excepció de què no trobi el fitxer.
	 */
	public static LlistaProducte llegirFitxerProductes(String nomFitxer) throws IOException, FileNotFoundException {
		// Constants per comparar amb les informacions del fitxer
		final String PLAT = "PLAT";
		final String BEGUDA = "BEGUDA";
		final String NO_ALERGIA = "NoRestriccions";
		final String SI_ALCOHOL = "SI";
		LlistaProducte llista = new LlistaProducte(100); // variable LlistaProducte per retornada en la funciï¿½
		Plat plat;
		Beguda beguda;
		int codi, i, volum;
		boolean teAlcohol;
		double preu, descompte;
		BufferedReader f = new BufferedReader(new FileReader(nomFitxer));
		String frase = "", nom;
		String paraula;
		frase = f.readLine();
		while (frase != null) {
			// Mentre no arribi al final del fitxer
			StringTokenizer st = new StringTokenizer(frase, ","); // Llegirem cada lï¿½nia del fitxer (cada lï¿½nia = un
																	// producte)
			while (st.hasMoreTokens()) {
				// Separem cada producte per les propietats corresponents
				codi = Integer.parseInt(st.nextToken());
				paraula = st.nextToken();
				if (paraula.equals(PLAT)) {
					// Si el producte ï¿½s de subtipus Plat
					nom = st.nextToken();
					preu = Double.parseDouble(st.nextToken());
					descompte = Double.parseDouble(st.nextToken());
					paraula = st.nextToken();
					if (paraula.equals(NO_ALERGIA)) {
						// El plat no tï¿½ restriccions alï¿½lï¿½rgics
						plat = new Plat(codi, nom, preu, descompte);
					} else {
						// El plat sï¿½ contï¿½ alguna alï¿½lï¿½rgia alimentï¿½ria
						String[] alergies = new String[3];
						alergies[0] = paraula;
						i = 1;
						while (st.hasMoreTokens()) {
							alergies[i] = st.nextToken();
							i++;
						}
						plat = new Plat(codi, nom, preu, descompte, alergies);
					}
					llista.afegirProducte(plat);
				} else if (paraula.equals(BEGUDA)) {
					// El producte ï¿½s de subtipus Plat
					nom = st.nextToken();
					preu = Double.parseDouble(st.nextToken());
					descompte = Double.parseDouble(st.nextToken());
					volum = Integer.parseInt(st.nextToken());
					paraula = st.nextToken();
					if (paraula.equals(SI_ALCOHOL))
						teAlcohol = true;
					else
						teAlcohol = false;
					beguda = new Beguda(codi, nom, preu, descompte, volum, teAlcohol);
					llista.afegirProducte(beguda);
				}
			}
			frase = f.readLine();
		}
		f.close();
		return llista;
	}

	/**
	 * Mètode estàtica per per escriure la llista de productes (passat per paràmetre) al fitxer resultant, on el seu nom
	 * també és passat perl paràmetre.
	 *
	 * @param nomFitxer
	 *            el nom del fitxer
	 * @param productes
	 *            la llista de tots els productes per ser escrits al fitxer.
	 * @throws IOException
	 *             les excepcions d'E/S de les dades.
	 */
	public static void escriureFitxerProductes(String nomFitxer, LlistaProducte productes) throws IOException {
		BufferedWriter f = new BufferedWriter(new FileWriter(nomFitxer));
		for (int i = 0; i < productes.getnElem(); i++) {
			f.write(productes.getLlista()[i].getCodi() + ",");
			if (productes.getLlista()[i] instanceof Plat) {
				f.write("PLAT,");
				f.write(productes.getLlista()[i].getNom() + ",");
				f.write(productes.getLlista()[i].getPreu() + ",");
				f.write(productes.getLlista()[i].getDescompte() + ",");
				if (((Plat) productes.getLlista()[i]).getTeRestriccio()) {
					for (int j = 0; j < ((Plat) productes.getLlista()[i]).getRestriccions().length; j++) {
						f.write(((Plat) productes.getLlista()[i]).getRestriccions()[j]);
						if (j != ((Plat) productes.getLlista()[i]).getRestriccions().length - 1)
							f.write(",");
					}
				} else {
					f.write("NoRestriccions");
				}
			} else if (productes.getLlista()[i] instanceof Beguda) {
				f.write("BEGUDA,");
				f.write(productes.getLlista()[i].getNom() + ",");
				f.write(productes.getLlista()[i].getPreu() + ",");
				f.write(productes.getLlista()[i].getDescompte() + ",");
				f.write(((Beguda) productes.getLlista()[i]).getVolum() + ",");
				if (((Beguda) productes.getLlista()[i]).getTeAlcohol()) {
					f.write("SI");
				} else {
					f.write("NO");
				}
			}
			f.newLine();
		}
		f.close();
	}

	/**
	 * Mètode estàtica per llegir els clients a partir del fitxer, on el seu nom es passa pel paràmetre.
	 *
	 * @param nomFitxer
	 *            el nom del fitxer
	 * @return la llista de tots els clients del fitxer.
	 * @throws IOException
	 *             les excepcions d'E/S de les dades.
	 * @throws FileNotFoundException
	 *             l'excepció de què no trobi el fitxer.
	 */
	public static LlistaClients llegirFitxerClients() throws IOException, FileNotFoundException {

		llista = new LlistaClients();
		Clients client;
		String nom_client, adreca, usuari, telefon;
		int contrasenya, identificador;
		BufferedReader f = new BufferedReader(new FileReader("clients.txt"));
		String frase = "";
		frase = f.readLine();
		while (frase != null) {
			StringTokenizer st = new StringTokenizer(frase, ",");
			while (st.hasMoreTokens()) {

				identificador = Integer.parseInt(st.nextToken());
				nom_client = st.nextToken();
				adreca = st.nextToken();
				telefon = st.nextToken();
				usuari = st.nextToken();
				contrasenya = Integer.parseInt(st.nextToken());

				client = new Clients(nom_client, adreca, telefon, usuari, contrasenya, identificador);
				llista.creaClient(client);

			}
			frase = f.readLine();
		}

		f.close();
		return llista;

	}

	/**
	 * Mètode estàtica per per escriure la llista de clients (passat per paràmetre) al fitxer resultant, on el seu nom
	 * també és passat perl paràmetre.
	 *
	 * @param clients
	 *            la llista de tots els clients
	 * @return la llista de tots els productes del fitxer.
	 * @throws IOException
	 *             les excepcions d'E/S de les dades.
	 */
	public static void escriureFitxerClients(LlistaClients clients) throws IOException {
		BufferedWriter f = new BufferedWriter(new FileWriter("clients_output.txt"));
		for (int i = 0; i < clients.getnClients(); i++) {

			f.write(clients.getLlista()[i].getIdentificador() + ",");
			f.write(clients.getLlista()[i].getNom_client() + ",");
			f.write(clients.getLlista()[i].getAdreca() + ",");
			f.write(clients.getLlista()[i].getTelefon() + ",");
			f.write(clients.getLlista()[i].getUsuari() + ",");
			f.write(clients.getLlista()[i].getContrasenya() + "");

			f.newLine();
		}
		f.close();
	}

	/**
	 * 
	 * Mètode estàtica per llegir les comandes a partir del fitxer, on el seu nom es passa pel paràmetre.
	 *
	 * @param nomFitxer
	 *            el nom del fitxer
	 * @return la llista de totes les comandes del fitxer.
	 * @throws IOException
	 *             les excepcions d'E/S de les dades.
	 * @throws FileNotFoundException
	 *             l'excepció de què no trobi el fitxer.
	 */
	public static LlistaComanda llegirFitxerComandes() throws IOException, FileNotFoundException {

		LlistaComanda llistaguardada = new LlistaComanda();
		Comanda comandaguardada = new Comanda(new LlistaProducte(50), 0, 0, 0); // creo una nova comanda buida
		int identClient, identComanda, hora, minut, quantitat = 0;
		String plat;
		BufferedReader f = new BufferedReader(new FileReader("Comandes.txt")); // el fitxer que miro es el comandes.txt
		String paraula = "";
		paraula = f.readLine(); // paraula : cada nova cosa que llegeixo

		while (paraula != null) {
			StringTokenizer st = new StringTokenizer(paraula, ","); // com a separador poso la coma
			while (st.hasMoreTokens()) {

				identClient = Integer.parseInt(st.nextToken()); // agafo primer la id del client
				identComanda = Integer.parseInt(st.nextToken()); // despres la id de la comanda
				comandaguardada.setIdentComanda(identComanda);
				paraula = st.nextToken();

				while (!paraula.equals("ya")) {
					plat = paraula;
					quantitat = Integer.parseInt(st.nextToken());
					comandaguardada.afegirElement(plat, llistaProducte, quantitat, false);
					paraula = st.nextToken();
				}

				hora = Integer.parseInt(st.nextToken());
				comandaguardada.setHora(hora);
				minut = Integer.parseInt(st.nextToken());
				comandaguardada.setMinut(minut);
				int id = llista.consultar_Client(identClient);
				id = llista.getLlista()[id].getIdentificador();
				llista.afegirComandaClient(id, comandaguardada);
			}
			paraula = f.readLine();
		}
		f.close();
		return llistaguardada;

	}

	/**
	 * Mètode estàtica per mostra les opcions del menú per la consola.
	 */
	public static void mostraMenu() {
		System.out.println("\n ******RESTAURANTE ON LINE*******");
		System.out.println("\nOpcions del menu:");
		System.out.println("\t1. Carregar els productes del fitxer");
		System.out.println("\t2. Carregar les comandes del fitxer");
		System.out.println("\t3. Carregar els clients del fitxer");
		System.out.println("\t4. Afegir un nou producte");
		System.out.println("\t5. Eliminar producte");
		System.out.println("\t6. Consultar la informaciï¿½ d'un producte ");
		System.out.println("\t7. Crear un nou client ");
		System.out.println("\t8. Consultar un client ");
		System.out.println("\t9. Afegir una comanda ");
		System.out.println("\t10. Copiar  una comanda ");
		System.out.println("\t11. Llistar  totes les comandes d'un client ");
		System.out.println("\t12. Escriure els productes al fitxer");
		System.out.println("\t13. Escriure les comandes al fitxer");
		System.out.println("\t14. Escriure els clients al fitxer");
		System.out.println("\t15. Sortir");
		System.out.print("\n\t\t\tIndica opciï¿½:\n");
	}

	//////////////////////////////////// MATEIXA PART QUE 'Main.java' /////////////////////////////////

	public static Scanner teclat = new Scanner(System.in);

	/**
	 * Mètode estàtica per afegir un nou producte. Es demana a l'usuari per introduir totes les informacions
	 * relacionades amb les propietats que té el plat o la beguda.
	 *
	 * @param llistP
	 *            la llista de producte in ha d'afegir un nou proucte.
	 */
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

	/**
	 * Mètode estàtica per eliminar un producte de la llista passat per paràmetre a partir del codi introduït per
	 * l'usuari.
	 *
	 * @param llistP
	 *            la llista de producte on conté el producte a eliminar.
	 * 
	 */
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
	 * Mètode estàtica per obrir una nova comanda que s'afegirà a la llista de comanda d'un client en concret. Primer
	 * cal l'autentificació del client, després s'ha de triar entre els producte i la seva quantitat. Després mostrem el
	 * resum de la comanda nova i l'usuari tria si accepta aquesta comanda o no.
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

		Comanda nova = new Comanda(new LlistaProducte(50), 0, 0, 0); // creo una nova comanda buida

		System.out.println("** Crear comanda **");

		System.out.println("Per a crear una comanda introdueix l'usuari i la clau de pas------>  ");

		System.out.println("Usuari:");
		usuari = teclat.nextLine();

		System.out.println("Clau de pas:");
		pas = teclat.nextInt();
		teclat.nextLine();

		while ((i < llistaClients.getnClients()) && (!existeix1) && (!existeix2)) { // part que comprova l'usuari i la
																					// contrasenya

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
		preferent = llistaClients.passa_Preferent(llistaClients.getLlista()[posiciousuari]); // ara que se quina es la
																								// pos de la llista del
																								// client
																								// miro si es prferent
																								// per a poder usar-ho
																								// despres

		if (existeix1 && existeix2) { // si l'usuari existeix

			while (!confirmar) { // bucle que confirma la comanda

				int aux = 0;
				while (!plats) { // comencem amb els plats
					mostrarProducte(1); // Mostra tots els plats
					// demanem a l'usuari els plats i la seva quantitat
					System.out.println("Introdueix el nom del plat: ");
					nom = teclat.nextLine();
					System.out.println("Introdueix la quantitat");

					quantitat = teclat.nextInt();
					teclat.nextLine();

					aux = nova.afegirElement(nom, llistaProducte, quantitat, preferent); // afegim un nou element a la
																							// comanda

					if (aux == -1) {
						System.out.println("No hi ha l'element"); // si l'element no existeix, informo al client
					}

					System.out.println("Si vols mes plats, posa l'1, si no, el 2"); // confirmo el que vol el client
					opcio = teclat.nextInt();
					teclat.nextLine();
					if (opcio == 2) {
						plats = true;
					}
				}
				while (!begudes) { // te la mateixa estructura que els plats
					mostrarProducte(2); // mostra totes les begudes
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

				System.out.println("Per veure el resum de la comanda, posa l'1, per eliminar la comanda, el 2"); // poso
																													// el
																													// resum
																													// de
																													// la
																													// comanda

				opcio = teclat.nextInt();
				teclat.nextLine();

				if (opcio == 1) {

					Calendar horaComanda = new GregorianCalendar(); // crido aixo per tenir l'hora actual i poder
																	// afergir-la a la comanda
					int hora, minut;

					hora = horaComanda.get(Calendar.HOUR_OF_DAY);
					minut = horaComanda.get(Calendar.MINUTE);

					nova.setHora(hora);
					nova.setMinut(minut);

					nova.toString();
					System.out.println(nova);

					System.out.println("Si vols confirmar la comanda, posa l'1, si no, el 2 "); // pregunto al client si
																								// vol confirmar la
																								// comanda

					opcio = teclat.nextInt();
					teclat.nextLine();
					if (opcio == 1) {

						int id = llistaClients.getLlista()[posiciousuari].getIdentificador(); // busco l'identificador
																								// de l'usuari actual i
																								// li poso la comanda a
																								// la seva llista de
																								// comandes
						llistaClients.afegirComandaClient(id, nova);

						confirmar = true;

					}
				}
				if (opcio == 2) {
					confirmar = true;
				}
			}
		} else { // si l'usuari no existeix informo al client
			System.out.println("L'usuari no existeix");
		}
	}

	/**
	 * Mètode estàtica per consultar tota la informació d'un producte de la llista global de producte.
	 *
	 * @param llistP
	 *            the llist P
	 */
	public static void consultarInformacio(LlistaProducte llistP) {

		int codi;
		System.out.print("\n\n\tIndiqui el codi del producte (1-" + llistP.getnElem() + "): \t");
		codi = teclat.nextInt();
		teclat.nextLine();
		System.out.println("\n   ---------- INFORMACIÓ ---------");
		System.out.println(llistP.informacio(codi));

	}

	/**
	 * Mètode estàtica per crear un nou client. Es demana a l'usuari introduir tots els camps relacionats amb els
	 * atributs del client.
	 */
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
		System.out.print("\n\n\tIndica la contrasenya del client (numeros):\t");
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

	/**
	 * Mètode estàtica per consultar el client en la llista global dels clients. Es demana l'autentificació del client a
	 * consultar. Si és correcte, es mostra totes les informacions relacionades amb ell. Si no, es mostra un missatge de
	 * què el client no es troba en la llista.
	 */
	public static void consultarClient()

	{
		int id;
		String usuari;
		int i = 0;
		System.out.println("Indica el Usuari del Client:");
		usuari = teclat.nextLine();
		System.out.println("Indica la contrasenya:");
		int contra = teclat.nextInt();
		teclat.nextLine();

		i = llistaClients.consultar_Client(usuari);
		if ((i == -1) || (llistaClients.getLlista()[i].getContrasenya()) != contra) {
			System.out.println("L'usuari o la contrasenya son incorrectes");

		} else {
			id = llistaClients.getLlista()[i].getIdentificador();
			System.out.println(llistaClients.imprimirClient(id));
		}
	}

	/**
	 * Mètode estàtica per copiar una comanda existent i ferr-ne de nova amb els matexios productes. Es demana
	 * l'autentificació del client.
	 */
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

	/**
	 * Mètode per mostrar totes comandes d'un client. Es demana l'autentificació del client.
	 */
	private static void comandes()

	{
		int id;
		String usuari;
		int i = 0;
		System.out.println("Indica el Usuari del Client:");
		usuari = teclat.nextLine();
		System.out.println("Indica la contrasenya:");
		int contra = teclat.nextInt();
		teclat.nextLine();

		i = llistaClients.consultar_Client(usuari);
		if ((i == -1) || (llistaClients.getLlista()[i].getContrasenya()) != contra) {
			System.out.println("L'usuari o la contrasenya son incorrectes");

		} else {
			id = llistaClients.getLlista()[i].getIdentificador();
			System.out.print("\n\n\t La llista de comandes ordenada : \t");
			System.out.println(llistaClients.consultar_Comandes(id));
		}
	}

	/**
	 * Mètode estàtica auxiliar per mostrar a la consola tots els plats o totes les begudes de la llista global de
	 * Productes.
	 *
	 * @param tipus
	 *            si és 1 és el plat i 2 , beguda.
	 * 
	 */
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

	/////////////////////////////////// Fi MATEIXA PART QUE 'Main.java' ///////////////////////////////

	/**
	 * Mètode principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		boolean carregarProductes, carregarComandes, carregarClients;
		int opcio = 0;
		// Variables booleanes per controlar que l'usuari no vagi a les opcions de les accions i consultes si no ha
		// carregat les dades del fitxer.
		carregarProductes = false;
		carregarClients = false;
		carregarComandes = false;
		while (opcio != 15) {
			mostraMenu();
			opcio = teclat.nextInt();
			teclat.nextLine();
			System.out.println(opcio);
			switch (opcio) {
			case 1:
				try {
					llistaProducte = llegirFitxerProductes("productes.txt");
					carregarProductes = true;

				} catch (FileNotFoundException e) {
					System.out.println("L'arxiu d'entrada no existeix");
					carregarProductes = false;
				} catch (IOException e) {
					System.out.println("Error en : " + e);
					carregarProductes = false;
				}
				break;
			case 2:
				try {
					llistaComandes = llegirFitxerComandes();
					System.out.println(llistaComandes);
					carregarComandes = true;
				} catch (FileNotFoundException e) {
					System.out.println("L'arxiu d'entrada no existeix");
					carregarComandes = false;
				} catch (IOException e) {
					System.out.println("Error en : " + e);
					carregarComandes = false;
				}

				break;
			case 3:
				try {
					llistaClients = llegirFitxerClients();
					carregarClients = true;
				} catch (FileNotFoundException e) {
					System.out.println("L'arxiu d'entrada no existeix");
					carregarClients = false;
				} catch (IOException e) {
					System.out.println("Error en : " + e);
					carregarClients = false;
				}
				break;
			case 4:
				if (carregarProductes)
					afegirProducte(llistaProducte);
				else
					System.out.println("No estï¿½ carregada els productes del fitxer!");
				break;
			case 5:
				if (carregarProductes)
					eliminarProducte(llistaProducte);
				else
					System.out.println("No estï¿½ carregada els productes del fitxer!");
				break;
			case 6:
				if (carregarProductes)
					consultarInformacio(llistaProducte);
				else
					System.out.println("No estï¿½ carregada els productes del fitxer!");
				break;
			case 7:
				if (carregarClients)
					crearClient();
				else
					System.out.println("No estï¿½ carregada els clients del fitxer!");
				break;
			case 8:
				if (carregarClients)
					consultarClient();
				else
					System.out.println("No estï¿½ carregada els clients del fitxer!");
				break;
			case 9:
				if (carregarClients && carregarComandes)
					afegirComanda();
				else {
					System.out.println("No estï¿½ carregada les dades!");
				}
				break;
			case 10:
				if (carregarClients && carregarComandes)
					copiarComanda();
				else
					System.out.println("No estï¿½ carregada les dades!");
				break;
			case 11:
				if (carregarClients && carregarComandes)
					comandes();
				else
					System.out.println("No estï¿½ carregada les dades!");
				break;
			case 12:
				if (carregarProductes) {
					try {
						escriureFitxerProductes("productes_output.txt", llistaProducte);

					} catch (IOException e) {
						System.out.println("Error en : " + e);
					}
				} else {
					System.out.println("No hi ha informacions del productes per escriure al fitxer!");
				}
				break;
			case 13:
				if (carregarComandes) {
					// TODO: Catalin
					// try {
					//
					//
					// } catch (IOException e) {
					// System.out.println("Error en : " + e);
					// }
				} else {
					System.out.println("No hi ha informacions dels productes per escriure al fitxer!");
				}
				break;
			case 14:
				if (carregarClients) {
					try {
						escriureFitxerClients(llistaClients);
					} catch (IOException e) {
						System.out.println("Error en : " + e);
					}
				} else {
					System.out.println("No hi ha informacions dels clients per escriure al fitxer!");
				}
				break;
			default:
				if (opcio != 15)
					System.out.println("Opciï¿½ trï¿½ada incorrecte!");
				break;

			}
		}

	}
}
