package restaurantsOnline;
import java.util.Objects;


public class LlistaClients {
	
	//ATRIBUTS
	private int nClients;
	private Clients[] llista;
	
	
	public LlistaClients() {
		
		nClients = 0;
		llista = new Clients[100];
		
	}
	
	
	public int getnClients() {
		return nClients;
	}



	public Clients[] getLlista() {
		return llista;
	}



	public void setnClients(int nClients) {
		this.nClients = nClients;
	}



	public void setLlista(Clients[] llista) {
		this.llista = llista;
	}



	public void creaClient(Clients client)
	{
		this.llista[nClients] = client;
		nClients++;
	}
	
	public int consultar_Client(String Nom_client)
	{
		int i = 0;
		boolean trobat = false;
		while ((!trobat) && (i<nClients))
		{
			trobat = Objects.equals(llista[i].getNom_client(), Nom_client);
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
	
	
	public LlistaComanda consultar_Comandes(String Nom_client)
	{
		int i;
		
		i = consultar_Client(Nom_client);
		if (i != -1)
		{
			return (llista[i].getComandes());
		}
		else
		{
			return (null);
		}
	}
	
	
	public void passa_Preferent (Clients Client)
	{
		
		if (Client.getnComandes() > 5)
		{
			Client.setPreferent(true);
		}
		
	}
	
	
	
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
	
	
	public Comanda copiar_Comanda(String Nom_Client, int identComanda)
	{
		
		int i = 0;
		int j;
		j = consultar_Client(Nom_Client);
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
			return (llista_comandes.getLlista()[i]);
		}
		else
		{
			return (null);
		}
	}
}

