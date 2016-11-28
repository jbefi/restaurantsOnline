package restaurantsOnline;


/**
 * The Class Producte.
 * 
 * @author: Enyu Lin
 * @version: 1.0
 */
public abstract class Producte {
	// Atributs
	protected String nom;
	protected int codi;
	protected double preu;
	protected double descompte;
	protected static int numProducte; // Atribut estàtica per implementar el codi de cada producte.

	/**
	 * Constructor per la Fase. Sense 'codi' en el paràmetre.
	 *
	 * @param nom El nom del producte.
	 * @param preu El preu del producte sense el descompte.
	 * @param descompte La rebaixa que apliquem al producte.
	 */
	public Producte(String nom, double preu, double descompte) {
		this.nom = nom;
		this.preu = preu;
		this.descompte = descompte;
		numProducte++;
		this.codi = numProducte;
	}
	
	/**
	 * Constructor per 2a Fase. Amb el paràmetre 'codi's.
	 *
	 * @param codi L'identificador del producte.
	 * @param nom El nom del producte.
	 * @param preu El preu del producte sense el descompte.
	 * @param descompte La rebaixa que apliquem al producte.
	 */
	public Producte(int codi,String nom, double preu, double descompte) {
		this.nom = nom;
		this.preu = preu;
		this.descompte = descompte;
		this.codi = codi;
	}

	/**
	 * Getter thdee nom.
	 *
	 * @return el valor del nom.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter de nom.
	 *
	 * @param nom El nou valor de  nom.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter de codi.
	 *
	 * @return el valor de  codi.
	 */
	public int getCodi() {
		return codi;
	}

	/**
	 * Getter de preu.
	 *
	 * @return el valor de preu.
	 */
	public double getPreu() {
		return preu;
	}
	
	/**
	 * Setter de preu.
	 *
	 * @param preu El nou valor del preu.
	 */
	public void setPreu(double preu) {
		this.preu = preu;
	}
	

	/**
	 * Setter de descompte.
	 *
	 * @return descompte El nou valor de decompte.
	 */
	public void setDescompte(double descompte) {
		this.descompte = descompte;
	}

	/**
	 * Getter de descompte.
	 *
	 * @return el valor de  descompte
	 */
	public double getDescompte() {
		return descompte;
	}

	/**
	 * Setter de descompte.
	 *
	 * @param descompte El nou valor del descompte.
	 */
	public void setDescompte(float descompte) {
		this.descompte = descompte;
	}

	/**
	 * Geter de numProducte.
	 *
	 * @return el valor de  numProducte.
	 */
	public static int getNumProducte() {
		return numProducte;
	}
	
	/**
	 * Mètode per modificar el preu segons el percentage del descompte.
	 * 
	 */
	public void aplicarDescompte(){
		preu = preu * (1 - descompte / 100);
	}

	/**
	 * Mètode toString() per retornar les informacions de l'objecte de la Classe instanciada.
	 */
	public String toString() {
		return ("\n " + codi + ": " + nom + " ............................ " + preu + "€\n Descompte: " + descompte + "% \n");
	}

}
