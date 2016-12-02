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
	protected int quantitat;
	protected double preuTotal;
	private static int numProducte = 0; // Atribut estàtica per implementar el codi de cada producte.

	/**
	 * Constructor per la Fase. Sense 'codi' en el paràmetre.
	 *
	 * @param nom
	 *            El nom del producte.
	 * @param preu
	 *            El preu del producte sense el descompte.
	 * @param descompte
	 *            La rebaixa que apliquem al producte.
	 */
	public Producte(String nom, double preu, double descompte) {
		this.nom = nom;
		this.preu = preu;
		this.descompte = descompte;
		numProducte++;
		this.codi = numProducte;
		this.quantitat = 1;
		this.preuTotal = preu;
	}

	/**
	 * Constructor per 2a Fase. Amb el paràmetre 'codi's.
	 *
	 * @param codi
	 *            L'identificador del producte.
	 * @param nom
	 *            El nom del producte.
	 * @param preu
	 *            El preu del producte sense el descompte.
	 * @param descompte
	 *            La rebaixa que apliquem al producte.
	 */
	public Producte(int codi, String nom, double preu, double descompte) {
		this.nom = nom;
		this.preu = preu;
		this.descompte = descompte;
		this.codi = codi;
		this.quantitat = 1;
		this.preuTotal = preu;
	}

	/**
	 * Getter de nom.
	 *
	 * @return el valor del nom.
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Getter de preu Total.
	 *
	 * @return el valor de preu Total.
	 */
	public double getPreuTotal() {
		return preuTotal;
	}
	
	/**
	 * Setter de preu total (preu*quantitat).
	 *
	 * @param nom
	 *            El nou valor de preu total.
	 */
	public void setPreuTotal(double preuTotal) {
		this.preuTotal = preuTotal;
	}

	/**
	 * Setter de nom.
	 *
	 * @param nom
	 *            El nou valor de nom.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter de codi.
	 *
	 * @return el valor de codi.
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
	 * @param preu
	 *            El nou valor del preu.
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
	 * @return el valor de descompte
	 */
	public double getDescompte() {
		return descompte;
	}

	/**
	 * Setter de descompte.
	 *
	 * @param descompte
	 *            El nou valor del descompte.
	 */
	public void setDescompte(float descompte) {
		this.descompte = descompte;
	}

	/**
	 * Getter de numProducte.
	 *
	 * @return el valor de numProducte.
	 */
	public static int getNumProducte() {
		return numProducte;
	}

	/**
	 * Getter de Quantitat.
	 *
	 * @return el valor de quantitat.
	 */
	public int getQuantitat() {
		return quantitat;
	}

	/**
	 * Setter de Quantitat.
	 *
	 * @param quantitat
	 *            El nou valor del quantitat.
	 */
	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}

	/**
	 * Mètode per modificar el preu segons el percentage del descompte.
	 * 
	 */
	public void aplicarDescompte() {
		preuTotal *= (1 - descompte / 100) ;
	}
	
	/**
	 * Mètode per calcular el preu total de cada producte.
	 * 
	 */
	public void calcularPreuTotal() {
		preuTotal = (preu * quantitat);
	}

	/**
	 * Mètode toString() per retornar les informacions de l'objecte de la Classe instanciada.
	 */
	public String toString() {
		return ("\n " + codi + ": " + nom + " ............................ " + preu + "€\n Descompte: " + descompte
				+ "%\n Quantitat: " + quantitat + "\n Preu total:  " + preuTotal + "€\n");
	}

}
