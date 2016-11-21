package restaurantsOnline;



/**
 * Class que implementa un producte de tipus Beguda.
 * 
 * @author: Enyu Lin
 * @version: 1.0
 */
public class Beguda extends Producte {
	
	// Atributs
	private int volum;
	private boolean teAlcohol;

	/**
	 * Constructor per la 1a fase. Sense l'atribut 'codi' en el paràmetre.
	 *
	 * @param nom El nom de la beguda.
	 * @param preu El preu de la beguda sense el descompte.
	 * @param descompte La rebaixa que apliquem a la beguda.
	 * @param volum El volum de la beguda.
	 * @param teAlcohol Si conté alcohol o no.
	 */
	public Beguda(String nom, double preu, double descompte, int volum, boolean teAlcohol) {
		super(nom, preu, descompte);
		this.volum = volum;
		this.teAlcohol = teAlcohol;

	}
	
	/**
	 * Constructor per la 2a fase. Amb l'atribut 'codi' en el paràmetre.
	 *
	 * @param codi L'identificador del producte.
	 * @param nom El nom de la beguda.
	 * @param preu El preu de la beguda sense el descompte.
	 * @param descompte La rebaixa que apliquem a la beguda.
	 * @param volum El volum de la beguda.
	 * @param teAlcohol Si conté alcohol o no.
	 */
	public Beguda(int codi,String nom, double preu, double descompte, int volum, boolean teAlcohol) {
		super(codi,nom, preu, descompte);
		this.volum = volum;
		this.teAlcohol = teAlcohol;

	}

	/**
	 * Geter de volum.
	 *
	 * @return el valor del volum.
	 */
	public int getVolum() {
		return volum;
	}

	/**
	 * Setter de volum.
	 *
	 * @param volum El valor nou del volum.
	 */
	public void setVolum(int volum) {
		this.volum = volum;
	}

	/**
	 * Getter de teAlcohol.
	 *
	 * @return el valor de teAlcohol.
	 */
	public boolean getTeAlcohol() {
		return teAlcohol;
	}

	/**
	 * Setter de teAlcohol.
	 *
	 * @param teAlcohol El nou valor booleà de  teAlcohol
	 */
	public void setTeAlcohol(boolean teAlcohol) {
		this.teAlcohol = teAlcohol;
	}

	/**
	 * Mètode toString() per retornar les informacions de l'objecte de la Classe instanciada.
	 */
	@Override
	public String toString() {
		return super.toString() + " volum: " + volum + "ml\n És alcohòlica: " + teAlcohol + "\n";
	}

}
