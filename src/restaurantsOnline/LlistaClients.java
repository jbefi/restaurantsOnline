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
	
	
	public String[] copiar_Comanda(String Nom_Client, int identComanda)
	{
		
		int i = 0;
		int j;
		j = consultar_Client(Nom_Client);
		boolean trobat = false;
		
		// Obtenir llista comandes del client
		// Buscar la comanda comparant codis (int)
		
		
		while ((!trobat) && (i<this.nClients))
		{
			
			trobat = Objects.equals(this.llista[i].getidentComanda(), identComanda);
			if (!trobat)
			{
				i++;
			}
		}
		
		if (trobat)
		{
			String[] comanda_aux = this.llista[i];
			return (comanda_aux);
		}
		else
		{
			return (null);
		}
	}
}
