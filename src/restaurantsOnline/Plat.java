package restaurantsOnline;


/**
 * Classe que implementa les característiques d'un Plat. 
 * 
 * @author: Enyu Lin
 * @version: 1.0
 */
public class Plat extends Producte {
	// Atributs
	private boolean teRestriccio;
	private String[] restriccions;

	/**
	 * Constructor del plat sense restricció alimentària. 
	 * Sense l'atribut 'codi' en el paràmetre (1a Fase).
	 *
	 * @param nom El nom del plat.
	 * @param preu El preu del plat sense el descompte.
	 * @param descompte La rebaixa que apliquem al plat.
	 */
	public Plat(String nom, double preu, double descompte) {
		super(nom, preu, descompte);
		this.teRestriccio = false;
		this.restriccions = null;
	}

	/**
	 * Constructor del plat amb restricció alimentària.
	 * Sense l'atribut 'codi' en el paràmetre (1a Fase).
	 *
	 * @param nom El nom del plat.
	 * @param preu El preu del plat sense el descompte.
	 * @param descompte La rebaixa que apliquem al plat.
	 * @param restriccions Diferents tipus de restrccions alimentàries.
	 */
	public Plat(String nom, double preu, double descompte, String[] restriccions) {
		super(nom, preu, descompte);
		this.teRestriccio = true;
		this.restriccions = new String[restriccions.length];
		for (int i = 0; i < restriccions.length; i++)
			this.restriccions[i] = restriccions[i];

	}
	
	/**
	 * Constructor del plat per la 2a Fase.
	 *
	 * @param nom El nom del plat.
	 * @param preu El preu del plat sense el descompte.
	 * @param descompte La rebaixa que apliquem al plat.
	 * @param restriccions Diferents tipus de restrccions alimentàries.
	 */
	public Plat(int codi,String nom, double preu, double descompte, String[] restriccions) {
		super(codi,nom, preu, descompte);
		this.teRestriccio = true;
		this.restriccions = new String[restriccions.length];
		for (int i = 0; i < restriccions.length; i++)
			this.restriccions[i] = restriccions[i];
		if (restriccions[0].equals("NoRestriccions"))
			teRestriccio = false;
		else 
			teRestriccio = true;
		

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
	 * Setter  teRestriccio.
	 *
	 * @param teRestriccio Booleà per indicar si té restricció o no.
	 */
	public void setTeRestriccio(boolean teRestriccio) {
		this.teRestriccio = teRestriccio;
	}

	/**
	 * Getter del restriccions.
	 *
	 * @return els diferents tipus de restrccions alimentàries.
	 */
	public String[] getRestriccions() {
		return restriccions;
	}

	/**
	 * Setter del restriccions.
	 *
	 * @param restriccions Diferents tipus de restrccions alimentàries
	 */
	public void setRestriccions(String[] restriccions) {
		this.restriccions = restriccions;
	}

	/**
	 * Mètode toString() per retornar les informacions de l'objecte de la Classe instanciada.
	 */
	@Override
	public String toString() {
		String frase;
		frase = super.toString();
		if (teRestriccio){
			frase += " Al·lèrgies:  ";
			for (int i=0; i<this.restriccions.length; i++){
				frase += restriccions[i];
				if (i != (this.restriccions.length -1))
					frase += ", ";
			}
			
		}
		frase += "\n";
		return  frase;
	}

}
