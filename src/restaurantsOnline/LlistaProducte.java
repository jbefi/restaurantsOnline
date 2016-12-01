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
	 * @return la llista
	 */
	public Producte[] getLlista() {
		return llista;
	}

	/**
	 * M�tode per afegir un producte a la llista.
	 *
	 * @param p El producte a afegir.
	 */
	public void afegirProducte(Producte p) {
		if (nElem < llista.length) {
			llista[nElem] = p;
			nElem++;
		}
	}

	/**
	 * M�todes privat per retornar la posici� en la llista a partir del codi passat pel par�metre
	 *
	 * @param codi L'identificador �nic del producte.
	 * @return la posici� d'aquest element amb el seu codi corresponent. En cas contrari, es retornar� -1.
	 */
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
	 *  M�tode per eliminar un producte a partir del seu codi.
	 *
	 * @param codi L'identificador �nic del producte.
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
	 * M�tode per informar un producte a partir del seu codi.
	 *
	 * @param codi L'identificador �nic del producte.
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
				return (llista[pos].toString());
			}
		}
	}
	
	/**
	 * M�todes  per retornar la posici� en la llista a partir del nom passat pel par�metre.
	 *
	 * @param nom El nom del producte.
	 * @return la posici� d'aquest element amb el seu nom corresponent. En cas contrari, es retornar� -1.
	 */
	public int posicioProducte(String nom){
		if (nElem == 0) {
			return -1;
		} else {
			boolean trobat = false;
			int i = 0, posTrobat = 0;
			while (!trobat && (i < nElem)) {
				if (llista[i].getNom().equalsIgnoreCase(nom)) {
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
	 * M�tode toString() per retornar les informacions de l'objecte de la Classe instanciada.
	 */
	public String toString() {
		if (nElem == 0) {
			return "";
		} else {
			String frase = "";
			for (int i=0; i<nElem; i++) {
					frase+= llista[i].toString();
			}
			
			return frase;
		}
	}

}
