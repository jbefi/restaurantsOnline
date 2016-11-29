package restaurantsOnline;

/**
 * Classe que implementa les caracter�stiques d'un Plat.
 * 
 * @author: Enyu Lin
 * @version: 1.0
 */
public class Plat extends Producte {
	// Atributs
	private boolean teRestriccio;
	private String[] restriccions;

	/**
	 * Constructor del plat sense restricci� aliment�ria. Sense l'atribut 'codi' en el par�metre (1a Fase).
	 *
	 * @param nom
	 *            El nom del plat.
	 * @param preu
	 *            El preu del plat sense el descompte.
	 * @param descompte
	 *            La rebaixa que apliquem al plat.
	 */
	public Plat(String nom, double preu, double descompte) {
		super(nom, preu, descompte);
		this.teRestriccio = false;
		this.restriccions = null;
	}

	/**
	 * Constructor del plat amb restricci� aliment�ria. Sense l'atribut 'codi' en el par�metre (1a Fase).
	 *
	 * @param nom
	 *            El nom del plat.
	 * @param preu
	 *            El preu del plat sense el descompte.
	 * @param descompte
	 *            La rebaixa que apliquem al plat.
	 * @param restriccions
	 *            Diferents tipus de restrccions aliment�ries.
	 */
	public Plat(String nom, double preu, double descompte, String[] restriccions) {
		super(nom, preu, descompte);
		this.teRestriccio = true;
		this.restriccions = new String[restriccions.length];
		for (int i = 0; i < restriccions.length; i++)
			this.restriccions[i] = restriccions[i];

	}

	/**
	 * Constructor del plat per la 2a Fase amb restriccions aliment�ries.
	 *
	 * @param codi
	 *            El codi del plat.
	 * @param nom
	 *            El nom del plat.
	 * @param preu
	 *            El preu del plat sense el descompte.
	 * @param descompte
	 *            La rebaixa que apliquem al plat.
	 * @param restriccions
	 *            Diferents tipus de restrccions aliment�ries.
	 */
	public Plat(int codi, String nom, double preu, double descompte, String[] restriccions) {
		super(codi, nom, preu, descompte);
		this.teRestriccio = true;
		int compt = 0, i = 0;
		while (i < restriccions.length) {
			if (restriccions[i] != null)
				compt++;
			i++;
		}
		this.restriccions = new String[compt];
		for (i = 0; i < compt; i++) {
			this.restriccions[i] = restriccions[i];
		}
		if (restriccions[0].equals("NoRestriccions"))
			teRestriccio = false;
		else
			teRestriccio = true;

	}

	/**
	 * Constructor del plat per la 2a Fase sense restriccions aliment�ries.
	 * 
	 * @param codi
	 *            El codi del plat.
	 * @param nom
	 *            El nom del plat.
	 * @param preu
	 *            El preu del plat sense el descompte.
	 * @param descompte
	 *            La rebaixa que apliquem al plat.
	 * 
	 */
	public Plat(int codi, String nom, double preu, double descompte) {
		super(codi, nom, preu, descompte);
		this.teRestriccio = false;
		this.restriccions = null;
	}

	/**
	 * Getter del teRestriccio.
	 *
	 * @return el valor de teRestriccio
	 */
	public boolean getTeRestriccio() {
		return teRestriccio;
	}

	/**
	 * Setter teRestriccio.
	 *
	 * @param teRestriccio
	 *            Boole� per indicar si t� restricci� o no.
	 */
	public void setTeRestriccio(boolean teRestriccio) {
		this.teRestriccio = teRestriccio;
	}

	/**
	 * Getter del restriccions.
	 *
	 * @return els diferents tipus de restrccions aliment�ries.
	 */
	public String[] getRestriccions() {
		return restriccions;
	}

	/**
	 * Setter del restriccions.
	 *
	 * @param restriccions
	 *            Diferents tipus de restrccions aliment�ries
	 */
	public void setRestriccions(String[] restriccions) {
		this.restriccions = restriccions;
	}

	/**
	 * M�tode toString() per retornar les informacions de l'objecte de la Classe instanciada.
	 */
	@Override
	public String toString() {
		String frase;
		frase = super.toString();
		if (teRestriccio) {
			frase += " Al�l�rgies:  ";
			for (int i = 0; i < this.restriccions.length; i++) {
				if (!restriccions[i].equals("")) {
					frase += restriccions[i] + "       ";	
				}
			}

		}
		frase += "\n";
		return frase;
	}

}
