package restaurantsOnline;
public class Clients {

	//ATRIBUTS
	private String Nom_client;
	private String Adreca;
	private int Telefon;
	private String Usuari;
	private int Contrasenya;
	private String[] Restriccions;
	private boolean Preferent;
	private int Identificador;
	private static int ID_Clients = 1;
	private llistaComanda comandes;
	private int nComandes;
	
	
	
	public Clients(String Nom_client, String Adreca, int Telefon, String Usuari, int Contrasenya, String[] Restriccions, Comanda[] Comandes) {
		this.Nom_client = Nom_client;
		this.Adreca = Adreca;
		this.Telefon = Telefon;
		this.Usuari = Usuari;
		this.Contrasenya = Contrasenya;
		for (int i=0; i<this.Restriccions.length; i++)
		{
			this.Restriccions[i] = Restriccions[i];
		}
		
		this.comandes = new llistaComanda(Comandes);
		this.nComandes = Comandes.length;
		
		this.Preferent = false;
		this.Identificador = ID_Clients++;
	}


	public String getNom_client() {
		return Nom_client;
	}


	public String getAdreca() {
		return Adreca;
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


	public llistaComanda getComandes() {
		return comandes;
	}


	public int getnComandes() {
		return nComandes;
	}


	public void setNom_client(String nom_client) {
		Nom_client = nom_client;
	}


	public void setAdreca(String Adreca) {
		Adreca = Adreca;
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


	public void setComandes(llistaComanda comandes) {
		this.comandes = comandes;
	}


	public void setnComandes(int nComandes) {
		this.nComandes = nComandes;
	}


	@Override
	public String toString() {
		return "Clients [Nom_client=" + Nom_client + ", Adreca=" + Adreca + ", Telefon=" + Telefon + ", Usuari="
				+ Usuari + ", Contrasenya=" + Contrasenya + ", Restriccions=" +
				// Acabar de fer el toString retornant la llista de restriccions
				 ", Preferent=" + Preferent + ", Identificador=" + Identificador + ", nComandes=" + nComandes + "]";
	}
	
	
}
