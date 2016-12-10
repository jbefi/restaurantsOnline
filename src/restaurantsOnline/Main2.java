package restaurantsOnline;

import java.io.*;
import java.util.*;

public class Main2 {

	static LlistaClients llista;
	static LlistaProducte llistacomanda;
	static LlistaComanda llistaclients;

	// Mètode estàtica per llegir els productes a partir del fitxer, on el seu nom es passa pel paràmetre.
	public static LlistaProducte llegirFitxerProductes(String nomFitxer) throws IOException, FileNotFoundException {
		// Constants per comparar amb les informacions del fitxer
		final String PLAT = "PLAT";
		final String BEGUDA = "BEGUDA";
		final String NO_ALERGIA = "NoRestriccions";
		final String SI_ALCOHOL = "SI";
		LlistaProducte llista = new LlistaProducte(100); // variable LlistaProducte per retornada en la funció
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
			StringTokenizer st = new StringTokenizer(frase, ","); // Llegirem cada línia del fitxer (cada línia = un
																	// producte)
			while (st.hasMoreTokens()) {
				// Separem cada producte per les propietats corresponents
				codi = Integer.parseInt(st.nextToken());
				paraula = st.nextToken();
				if (paraula.equals(PLAT)) {
					// Si el producte és de subtipus Plat
					nom = st.nextToken();
					preu = Double.parseDouble(st.nextToken());
					descompte = Double.parseDouble(st.nextToken());
					paraula = st.nextToken();
					if (paraula.equals(NO_ALERGIA)) {
						// El plat no té restriccions al·lèrgics
						plat = new Plat(codi, nom, preu, descompte);
					} else {
						// El plat sí conté alguna al·lèrgia alimentària
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
					// El producte és de subtipus Plat
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

	// Mètode per escriure la llista de productes (passat per paràmetre) al fitxer resultant, on el seu nom també és
	// passat perl paràmetre.
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

	public static void escriureFitxerClients(LlistaClients clients) throws IOException {
		BufferedWriter f = new BufferedWriter(new FileWriter("clients_output.txt"));
		for (int i = 0; i < clients.getnClients(); i++) {

			f.write(clients.getLlista()[i].getIdentificador() + ",");
			f.write(clients.getLlista()[i].getNom_client() + ",");
			f.write(clients.getLlista()[i].getAdreca() + ",");
			f.write(clients.getLlista()[i].getTelefon() + ",");
			f.write(clients.getLlista()[i].getUsuari() + ",");
			f.write(clients.getLlista()[i].getContrasenya() + ",");

			f.newLine();
		}
		f.close();
	}

	public static LlistaComanda llegirFitxerComandes() throws IOException , FileNotFoundException {
	
		LlistaComanda llistaguardada = new LlistaComanda(); 
		Comanda comandaguardada = new Comanda(null,0,0,0); // creo les variables que necessito per a poder llegir tot el que tinc al fitxer
		int identClient, identComanda, hora, minut, quantitat = 0;
		String beguda, plat; 
		BufferedReader f = new BufferedReader(new FileReader("Comandes.txt")); // el fitxer que miro es el comandes.txt
		String paraula = "";
		paraula = f.readLine(); //paraula : cada nova cosa que llegeixo 
		
		while (paraula != null) {   // mentres la paraula seguent existeixi 
			
			StringTokenizer next = new StringTokenizer(paraula, ",");  // primer agafo 
			identClient = Integer.parseInt(next.nextToken());  
			identComanda = Integer.parseInt(next.nextToken()); 
			comandaguardada.setIdentComanda(identComanda); 
			
			while ( )
			if ((paraula = next.nextToken()) == "."){
				while ((paraula = next.nextToken())!= ","){
					plat = next.nextToken(); 
					quantitat =Integer.parseInt(next.nextToken());
					comandaguardada.afegirElement(plat,llistacomanda, quantitat, false); 
				}
				while ((paraula = next.nextToken())!= ","){
					
					beguda = next.nextToken(); 
					comandaguardada.afegirElement(beguda, llistacomanda, quantitat, false);
						
				}
			}
			hora = Integer.parseInt(next.nextToken()); 
			comandaguardada.setHora(hora);
			minut = Integer.parseInt(next.nextToken()); 
			comandaguardada.setMinut(minut);
			int id = llista.consultar_Client(identClient);
			llista.afegirComandaClient(id, comandaguardada);
		
		}
		f.close();
		return llistaguardada;
		
	}

	public static void main(String[] args) {
		try {
			LlistaProducte llistaProductes = llegirFitxerProductes("productes.txt");
			System.out.println(llistaProductes);
			escriureFitxerProductes("productes_output.txt", llistaProductes);

		} catch (FileNotFoundException e) {
			System.out.println("L'arxiu d'entrada no existeix");
		} catch (IOException e) {
			System.out.println("Excepcions: " + e);
		}

		try {

			LlistaClients llista = llegirFitxerClients();
			System.out.println(llista);
			escriureFitxerClients(llista);

		} catch (FileNotFoundException e) {
			System.out.println("L'arxiu d'entrada no existeix");
		} catch (IOException e) {
			System.out.println("Excepcions: " + e);
		}

	}
}
