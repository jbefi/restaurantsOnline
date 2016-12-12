package restaurantsOnline;
import java.util.Objects;


/**
 * Classe que implementa la llista de clients
 * 
 * @author Pablo
 *
 */
public class LlistaClients {
	
	//ATRIBUTS
	private int nClients;
	private Clients[] llista;
	
	
	/**
	 * Constructor de la classe LlistaClients
	 */
	public LlistaClients() {
		
		nClients = 0;
		llista = new Clients[100];
		
	}
	
	
	/**
	 * Getter del numero de clients a la llista de clients
	 *
	 * @return el numero de clients a la llista de clients
	 */
	public int getnClients() {
		return nClients;
	}


	/**
	 * Getter de la llista de clients
	 *
	 * @return llista de clients
	 */
	public Clients[] getLlista() {
		return llista;
	}


	/**
	 * Setter del numero de clients a la llista de clients
	 * 
	 * @param nClients
	 */
	public void setnClients(int nClients) {
		this.nClients = nClients;
	}



	/**
	 * Setter de la llista de clients
	 * 
	 * @param llista
	 */
	public void setLlista(Clients[] llista) {
		this.llista = llista;
	}



	/**
	 * Funcio que afegeix un nou client a la llista de clients
	 * 
	 * @param client
	 */
	public void creaClient(Clients client)
	{
		this.llista[nClients] = client;
		nClients++;
	}
	
	/**
	 * Funcio que troba el client a la llista a traves de la seva id
	 * 
	 * @param id
	 * @return -1 si error || posicio del client a la llista
	 */
	public int consultar_Client(int id)
	{
		int i = 0;
		boolean trobat = false;
		while ((!trobat) && (i<nClients))
		{
			trobat = llista[i].getIdentificador() == id;
			if (!trobat)
			{
				i++;
			}
		}
		
		if (trobat)
		{
			return (i);
		}
		else
		{
			i = -1;
			return (i);
		}
	}
	
	/**
	 * Funcio que troba el client a la llista a traves del seu usuari
	 * 
	 * @param usu
	 * @return -1 si error || posicio del client a la llista
	 */
	public int consultar_Client(String usu)
	{
		int i = 0;
		boolean trobat = false;
		while ((!trobat) && (i<nClients))
		{
			trobat = Objects.equals(llista[i].getUsuari(), usu);
			if (!trobat)
			{
				i++;
			}
		}
		
		if (trobat)
		{
			return (i);
		}
		else
		{
			i = -1;
			return (i);
		}
	}
	
	/**
	 * Funcio que retorna el toString del client
	 * 
	 * @param id
	 * @return toString del client || "no trobat"
	 */
	public String imprimirClient(int id)
	{
		int i = 0;
		boolean trobat = false;
		while ((!trobat) && (i<nClients))
		{
			trobat = Objects.equals(llista[i].getIdentificador(), id);
			if (!trobat)
			{
				i++;
			}
		}
		
		if (trobat)
		{
			return (llista[i].toString());
		}
		else
		{
			return ("No trobat");
		}
	}
	
	
	/**
	 * Funcio que consulta les comandes del client a traves de la seva id
	 * 
	 * @param id
	 * @return llista de comandes del usuari || null
	 */
	public LlistaComanda consultar_Comandes(int id)
	{
		int i;
		
		i = consultar_Client(id);
		if (i != -1)
		{
			return (llista[i].getComandes());
		}
		else
		{
			return (null);
		}
	}
	
	

	/**
	 * Funcio que passa a preferent un client si ha fet mes de 5 comandes
	 * 
	 * @param Client
	 * @return true || false
	 */
	public boolean passa_Preferent (Clients Client)
	{
		
		if (Client.getComandes().getnElem() > 5)
		{
			Client.setPreferent(true);
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
	/**
	 * Funcio que comprova si un client conte les restriccions de la llista que es pasada per parametre
	 * 
	 * @param Client
	 * @param Restriccions
	 * @return true || false
	 */
	public boolean conte_Restriccions (Clients Client, String Restriccions[])
	{
		int i = 0;
		int j = 0;
		boolean trobat = false;
		while ((!trobat) && (Restriccions[j]!=null))
		{
			while ((!trobat) && (i<Restriccions.length))
			{
				trobat = Objects.equals(Client.getRestriccions()[i], Restriccions[j]);
				i++;
			}
			j++;
		}
		
		if (trobat)
		{
			return (true);
		}
		else
		{
			return (false);
		}
		
		
	}
	
	

	/**
	 * Funcio que copia una comanda a traves del id del client i la id de la comanda
	 * 
	 * @param id
	 * @param identComanda
	 * @return 1 (s'ha fet) || 0 (no s'ha fet)
	 */
	public int copiar_Comanda(int id , int identComanda)
	{
		
		int i = 0;
		int j;

		j = consultar_Client(id);
		boolean trobat = false;
		
		LlistaComanda llista_comandes = this.llista[j].getComandes();
		
		while ((!trobat) && (i<llista_comandes.getnElem()))
		{
			if (llista_comandes.getLlista()[i].getIdentComanda() == identComanda)
			{
				trobat = true;
			}
			else
			{
				i++;
			}
		}
		
		if (trobat)
		{
			
			this.llista[j].getComandes().afegirComanda(this.llista[j].getComandes().getLlista()[llista_comandes.posicioComanda(identComanda)]);
			return (1);
		}
		else
		{
			return (0);
		}

	}

	
	/**
	 * Funcio que afegeix una comanda a un client a traves de la seva id
	 * 
	 * @param id
	 * @param comandaguardada
	 */
	public void afegirComandaClient (int id, Comanda comandaguardada)
	{
		int i = consultar_Client(id);
		llista[i].afegirComanda(comandaguardada);
	}
}
