package restaurantsOnline;
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
	
	public Clients(String Nom_client, String Adreca, String Telefon, String Usuari, int Contrasenya, int Identificador) {
		this.Nom_client = Nom_client;
		this.Adreca = Adreca;
		this.Telefon = Telefon;
		this.Usuari = Usuari;
		this.comandes = new LlistaComanda();
		this.Contrasenya = Contrasenya;
		this.Identificador = Identificador;
	}

	public String getNom_client() {
		return Nom_client;
	}


	public String getAdreca() {
		return Adreca;
	}


	public String getTelefon() {
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


	public LlistaComanda getComandes() {
		return comandes;
	}


	public int getnComandes() {
		return nComandes;
	}


	public void setNom_client(String nom_client) {
		Nom_client = nom_client;
	}


	public void setAdreca(String Adreca) {
		this.Adreca = Adreca;
	}


	public void setTelefon(String telefon) {
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


	public void setComandes(LlistaComanda comandes) {
		this.comandes = comandes;
	}


	public void setnComandes(int nComandes) {
		this.nComandes = nComandes;
	}

	@Override
	public String toString() {
		return "Clients [Nom_client=" + Nom_client + ", Adreca=" + Adreca + ", Telefon=" + Telefon + ", Usuari="
				+ Usuari + ", Contrasenya=" + Contrasenya + ", Restriccions=" +
				//TODO: Acabar de fer el toString retornant la llista de restriccions
				 ", Preferent=" + Preferent + ", Identificador=" + Identificador + ", nComandes=" + nComandes + "]";
	}
	
	
}
