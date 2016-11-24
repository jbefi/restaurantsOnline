
import java.io.*;
import java.util.*;

public class Main2 {

	public static LlistaProducte llegirFitxerProductes() throws IOException , FileNotFoundException {
		final String PLAT = "PLAT";
		final String BEGUDA = "BEGUDA";
		final String NO_ALERGIA = "NoRestriccions";
		final String SI_ALCOHOL = "SI";
		LlistaProducte llista = new LlistaProducte(20);
		Plat plat;
		Beguda beguda;
		int codi,i,volum;
		boolean teAlcohol;
		double preu, descompte;
		BufferedReader f = new BufferedReader(new FileReader("productes.txt"));
		String frase = "", nom;
		String paraula;
		frase = f.readLine();
		while (frase != null) {
			StringTokenizer st = new StringTokenizer(frase, ",");
			while (st.hasMoreTokens()) {
				codi = Integer.parseInt(st.nextToken());
				paraula = st.nextToken();
				if (paraula.equals(PLAT)){
					nom = st.nextToken();
					preu = Double.parseDouble(st.nextToken());
					descompte = Double.parseDouble(st.nextToken());
					paraula = st.nextToken();
					if (paraula.equals(NO_ALERGIA)){
						plat = new Plat(codi, nom, preu, descompte);
					} else {
						String[] alergies = new String[3];
						alergies[0] = paraula;
						i = 1;
						while (st.hasMoreTokens()){
							alergies[i] = st.nextToken();
							i++;
						}
						plat = new Plat(codi, nom, preu, descompte, alergies);
					}
					
					llista.afegirProducte(plat);
				} else if (paraula.equals(BEGUDA)){
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
	
	public static void escriureFitxerProductes(LlistaProducte productes)throws IOException{
		BufferedWriter f = new BufferedWriter(new FileWriter("productes_output.txt"));
		for (int i=0; i<productes.getnElem();i++){
			f.write(productes.getLlista()[i].getCodi()+",");
			if (productes.getLlista()[i] instanceof Plat){
				f.write("PLAT,");
				f.write(productes.getLlista()[i].getNom()+",");
				f.write(productes.getLlista()[i].getPreu()+",");
				f.write(productes.getLlista()[i].getDescompte()+",");
				if(((Plat)productes.getLlista()[i]).getTeRestriccio()){
					for (int j=0; j<((Plat)productes.getLlista()[i]).getRestriccions().length; j++){
						f.write(((Plat)productes.getLlista()[i]).getRestriccions()[j]);
						if (j != ((Plat)productes.getLlista()[i]).getRestriccions().length - 1)
							f.write(",");
					}
				} else {
					f.write("NoRestriccions");
				}
			} else if (productes.getLlista()[i] instanceof Beguda){
				f.write("BEGUDA,");
				f.write(productes.getLlista()[i].getNom()+",");
				f.write(productes.getLlista()[i].getPreu()+",");
				f.write(productes.getLlista()[i].getDescompte()+",");
				f.write(((Beguda)productes.getLlista()[i]).getVolum()+",");
				if (((Beguda)productes.getLlista()[i]).getTeAlcohol()){
					f.write("SI");
				} else {
					f.write("NO");
				}
			}
			f.newLine();
		}
		f.close();
	}

	public static void main(String[] args) {
		try {
			
			LlistaProducte llista = llegirFitxerProductes();
			System.out.println(llista);
			escriureFitxerProductes(llista);
			
		} catch(FileNotFoundException e) {
			System.out.println("L'arxiu d'entrada no existeix");
		}catch (IOException e) {
			System.out.println("Excepcions: " + e);
		}
		


	}
}
