package restaurantsOnline;
/**
 * Classe que implementa un client
 * 
 * @author Pablo
 *
 */
public class Clients {

	//ATRIBUTS
	private String Nom_client;
	private String Adreca;
	private String Telefon;
	private String Usuari;
	private int Contrasenya;
	private String[] Restriccions;
	private boolean Preferent;
	private int Identificador;
	private static int ID_Clients = 1;
	private LlistaComanda comandes;
	private int nComandes;
	
	
	
	/**
	 * Constructor de la classe Clients per al main 1 que rep els seguents parametres:
	 * @param Nom_client
	 * @param Adreca
	 * @param Telefon
	 * @param Usuari
	 * @param Contrasenya
	 * @param Restriccions
	 * @param Comandes
	 */
	public Clients(String Nom_client, String Adreca, String Telefon, String Usuari, int Contrasenya, String[] Restriccions, LlistaComanda Comandes) {
		this.Nom_client = Nom_client;
		this.Adreca = Adreca;
		this.Telefon = Telefon;
		this.Usuari = Usuari;
		this.Contrasenya = Contrasenya;
		this.Restriccions = new String[Restriccions.length];
		for (int i=0; i<this.Restriccions.length; i++)
		{
			this.Restriccions[i] = Restriccions[i];
		}
		
		this.comandes = Comandes;
		this.nComandes = Comandes.getnElem();
		
		this.Preferent = false;
		this.Identificador = ID_Clients++;
	}
	
	/**
	 * Constructor de la classe clients per al main 2 que rep els seguents parametres:
	 * @param Nom_client
	 * @param Adreca
	 * @param Telefon
	 * @param Usuari
	 * @param Contrasenya
	 * @param Identificador
	 */
	public Clients(String Nom_client, String Adreca, String Telefon, String Usuari, int Contrasenya, int Identificador) {
		this.Nom_client = Nom_client;
		this.Adreca = Adreca;
		this.Telefon = Telefon;
		this.Usuari = Usuari;
		this.Restriccions = new String[3];
		this.comandes = new LlistaComanda();
		this.Contrasenya = Contrasenya;
		this.Identificador = Identificador;
	}
	
	/**
	 * Constructor de la classe clients per al main 3 que rep els seguents parametres:
	 * @param Nom_client
	 * @param Adreca
	 * @param Telefon
	 * @param Usuari
	 * @param Contrasenya
	 * @param Restriccions
	 */
	public Clients(String Nom_client, String Adreca, String Telefon, String Usuari, int Contrasenya, String[] Restriccions) {
		this.Nom_client = Nom_client;
		this.Adreca = Adreca;
		this.Telefon = Telefon;
		this.Usuari = Usuari;
		this.Contrasenya = Contrasenya;
		this.Restriccions = new String[Restriccions.length];
		for (int i=0; i<this.Restriccions.length; i++)
		{
			this.Restriccions[i] = Restriccions[i];
		}
		this.comandes = new LlistaComanda();
		this.Preferent = false;
		this.Identificador = ID_Clients++;
	}

	/**
	 * Getter del nom del client.
	 *
	 * @return el nom del client
	 */
	public String getNom_client() {
		return Nom_client;
	}


	/**
	 * Getter la adreca del client.
	 *
	 * @return la adreca del client
	 */
	public String getAdreca() {
		return Adreca;
	}


	/**
	 * Getter el telefon del client.
	 *
	 * @return el telefon del client
	 */
	public String getTelefon() {
		return Telefon;
	}


	/**
	 * Getter el usuari del client.
	 *
	 * @return el usuari del client
	 */
	public String getUsuari() {
		return Usuari;
	}


	/**
	 * Getter la contrasenya del client.
	 *
	 * @return la contrasenya del client
	 */
	public int getContrasenya() {
		return Contrasenya;
	}


	/**
	 * Getter les restriccions del client.
	 *
	 * @return les restriccions client
	 */
	public String[] getRestriccions() {
		return Restriccions;
	}


	/**
	 * Getter preferent del client.
	 *
	 * @return preferent del client
	 */
	public boolean getPreferent() {
		return Preferent;
	}


	/**
	 * Getter identificador del client.
	 *
	 * @return identificador del client
	 */
	public int getIdentificador() {
		return Identificador;
	}


	/**
	 * Getter ID general de la clase clients.
	 *
	 * @return ID general de la calse clients
	 */
	public static int getID_Clients() {
		return ID_Clients;
	}


	/**
	 * Getter llista de comandes del client.
	 *
	 * @return llista de comandes del client
	 */
	public LlistaComanda getComandes() {
		return comandes;
	}


	/**
	 * Getter numero de comandes del client.
	 *
	 * @return numero de comandes del client
	 */
	public int getnComandes() {
		return nComandes;
	}


	/**
	 * Setter del nom del client.
	 *
	 * @param nom_client
	 */
	public void setNom_client(String nom_client) {
		Nom_client = nom_client;
	}


	/**
	 * Setter de la adreca del client.
	 * 
	 * @param Adreca
	 */
	public void setAdreca(String Adreca) {
		this.Adreca = Adreca;
	}


	/**
	 * Setter del telefon del client.
	 * 
	 * @param telefon
	 */
	public void setTelefon(String telefon) {
		Telefon = telefon;
	}


	/**
	 * Setter del usuari del client.
	 * 
	 * @param usuari
	 */
	public void setUsuari(String usuari) {
		Usuari = usuari;
	}


	/**
	 * Setter de la contrasenya del client.
	 * 
	 * @param contrasenya
	 */
	public void setContrasenya(int contrasenya) {
		Contrasenya = contrasenya;
	}


	/**
	 * Setter de les restriccions del client.
	 * 
	 * @param restriccions
	 */
	public void setRestriccions(String[] restriccions) {
		Restriccions = restriccions;
	}


	/**
	 * Setter del preferent del client.
	 * 
	 * @param preferent
	 */
	public void setPreferent(boolean preferent) {
		Preferent = preferent;
	}


	/**
	 * Setter del identificador del client.
	 * 
	 * @param identificador
	 */
	public void setIdentificador(int identificador) {
		Identificador = identificador;
	}


	/**
	 * Setter del ID general dels clients.
	 * 
	 * @param iD_Clients
	 */
	public static void setID_Clients(int iD_Clients) {
		ID_Clients = iD_Clients;
	}


	/**
	 * Setter de les comandes del client.
	 * 
	 * @param comandes
	 */
	public void setComandes(LlistaComanda comandes) {
		this.comandes = comandes;
	}


	/**
	 * Setter del numero de comandes del client.
	 * 
	 * @param nComandes
	 */
	public void setnComandes(int nComandes) {
		this.nComandes = nComandes;
	}

	/**
	 * Funcio per afegir una comanda nova al client
	 * 
	 * @param nou
	 */
	public void afegirComanda(Comanda nou){
		comandes.afegirComanda(nou);
	}
	
	
	@Override
	public String toString() {
		String aux = "Clients [Nom_client=" + Nom_client + ", Adreca=" + Adreca + ", Telefon=" + Telefon + ", Usuari="
				+ Usuari + ", Contrasenya=" + Contrasenya + ", Restriccions = ";
		for (String i : Restriccions)
			aux += i+" ";
		aux+=", Preferent=" + Preferent + ", Identificador=" + Identificador + ", nComandes=" + nComandes + "]";
		return aux;
	}
	
	
}
