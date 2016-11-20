package restaurantsOnline;


/**
 * Classe que implementa una llista de productes.
 * 
 * @author: Enyu Lin
 * @version: 1.0
 */
public class LlistaProducte {
	
	// Atributs
	private int nElem;
	private Producte[] llista;

	/**
	 * Constructor.
	 *
	 * @param mida El tamany total de la llista.
	 */
	public LlistaProducte(int mida) {
		nElem = 0;
		llista = new Producte[mida];
	}

	/**
	 * Getter de l'atribut nElem.
	 *
	 * @return el valor de nElem
	 */
	public int getnElem() {
		return nElem;
	}
	
	/**
	 * Getter de l'atribut llista.
	 *
	 * @return el la llista de producte.
	 */
	public Producte[] getLlista() {
		return llista;
	}

	/**
	 * Mètode per afegir un producte a la llista.
	 *
	 * @param p El producte a afegir.
	 */
	public void afegirProducte(Producte p) {//anadir producte
		if (nElem < llista.length) {
			llista[nElem] = p;
			nElem++;
		}
	}

	/**
	 * Mètodes privat per retornar la posició en la llista a partir del codi passat pel paràmetre
	 *
	 * @param codi L'identificador únic del producte.
	 * @return la posició d'aquest element amb el seu codi corresponent.
	 */
	// 
	private int retPosLLista(int codi) {
		if (nElem == 0) {
			return -1;
		} else {
			boolean trobat = false;
			int i = 0, posTrobat = 0;
			while (!trobat && (i < nElem)) {
				if (llista[i].getCodi() == codi) {
					posTrobat = i;
					trobat = true;
				}
				i++;
			}
			if (trobat)
				return posTrobat;
			else
				return -1;
		}
	}

	/**
	 *  Mètode per eliminar un producte a partir del seu codi.
	 *
	 * @param codi L'identificador únic del producte.
	 */
	//
	public void eliminarProducte(int codi) {
		if (nElem != 0) {
			int pos = retPosLLista(codi);
			if (pos != -1) {
				for (int i = pos; i < (nElem - 1); i++) {
					llista[i] = llista[i + 1];
				}
				nElem--;
			}
		}
	}

	/**
	 * Mètode per informar un producte a partir del seu codi.
	 *
	 * @param codi L'identificador únic del producte.
	 * @return una cadena amb les seves informacions corresponents. 
	 */
	// 
	public String informacio(int codi) {
		if (nElem == 0) {
			return "";
		} else {
			int pos = retPosLLista(codi);
			if (pos == -1) {
				return "";
			} else {
				if (llista[pos] instanceof Plat)
					return ((Plat)llista[pos]).toString();
				else if (llista[pos] instanceof Beguda)
					return ((Beguda)llista[pos]).toString();
				else 
					return ""; // No entrarà mai aquí al 99,99%
			}
		}
	}
	
	
	
	/**
	 * Mètode toString() per retornar les informacions de l'objecte de la Classe instanciada.
	 */
	public String toString() {
		if (nElem == 0) {
			return "";
		} else {
			String frase = "";
			for (int i=0; i<nElem; i++) {
				if (llista[i] instanceof Plat)
					frase+= ((Plat)llista[i]).toString();
				else if (llista[i] instanceof Beguda)
					frase+=  ((Beguda)llista[i]).toString();
			}
			
			return frase;
		}
	}

}
