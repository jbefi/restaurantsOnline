package restaurantsOnline;
public class Clients {

	//ATRIBUTS
	private String Nom_client;
	private String Adreça;
	private int Telefon;
	private String Usuari;
	private int Contrasenya;
	private String[] Restriccions;
	private boolean Preferent;
	private int Identificador;
	private static int ID_Clients = 1;
	private LlistaComanda[] Comandes;
	private int nComandes;
	
	
	
	public Clients(String Nom_client, String Adreça, int Telefon, String Usuari, int Contrasenya, String[] Restriccions, LlistaComanda[] Comandes) {
		this.Nom_client = Nom_client;
		this.Adreça = Adreça;
		this.Telefon = Telefon;
		this.Usuari = Usuari;
		this.Contrasenya = Contrasenya;
		for (int i=0; i<this.Restriccions.length; i++)
		{
			this.Restriccions[i] = Restriccions[i];
		}
		
		for (int i=0; i<this.Comandes.length; i++)
		{
			this.Comandes[i] = Comandes[i];
		}
		this.nComandes = 0;
		
		this.Preferent = false;
		this.Identificador = ID_Clients++;
	}


	public String getNom_client() {
		return Nom_client;
	}


	public String getAdreça() {
		return Adreça;
	}


	public int getTelefon() {
		return Telefon;
	}


	public String getUsuari() {
		return Usuari;
	}


	public int getContrasenya() {
		return Contrasenya;
	}


	public String[] getRestriccions() {
		return Restriccions;
	}


	public boolean getPreferent() {
		return Preferent;
	}


	public int getIdentificador() {
		return Identificador;
	}


	public static int getID_Clients() {
		return ID_Clients;
	}


	public LlistaComanda[] getComandes() {
		return Comandes;
	}


	public int getnComandes() {
		return nComandes;
	}


	public void setNom_client(String nom_client) {
		Nom_client = nom_client;
	}


	public void setAdreça(String adreça) {
		Adreça = adreça;
	}


	public void setTelefon(int telefon) {
		Telefon = telefon;
	}


	public void setUsuari(String usuari) {
		Usuari = usuari;
	}


	public void setContrasenya(int contrasenya) {
		Contrasenya = contrasenya;
	}


	public void setRestriccions(String[] restriccions) {
		Restriccions = restriccions;
	}


	public void setPreferent(boolean preferent) {
		Preferent = preferent;
	}


	public void setIdentificador(int identificador) {
		Identificador = identificador;
	}


	public static void setID_Clients(int iD_Clients) {
		ID_Clients = iD_Clients;
	}


	public void setComandes(LlistaComanda[] comandes) {
		Comandes = comandes;
	}


	public void setnComandes(int nComandes) {
		this.nComandes = nComandes;
	}
	
	
	
	
	
	
}
