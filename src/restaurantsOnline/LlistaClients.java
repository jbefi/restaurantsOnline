
import java.util.Objects;


public class LlistaClients {
	
	//ATRIBUTS
	private int nClients;
	private Clients[] llista;
	
	
	public LlistaClients() {
		
		nClients = 0;
		llista = new Clients[100];
		
	}
	
	
	public int Consultar_Client(String Nom_client)
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
	
	
	public LlistaComanda Consultar_Comandes(String Nom_client)
	{
		int i;
		
		i = Consultar_Client(Nom_client);
		if (i != -1)
		{
			return (llista[i].getComandes());
		}
		else
		{
			return (null);
		}
	}
	
	
	public void Passa_Preferent (Clients Client)
	{
		
		if (Client.getnComandes() > 5)
		{
			Client.setPreferent(true);
		}
		
	}
	
	
	
	public boolean Conte_Restriccions (Clients Client, String Restriccions[])
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
	
	
	public Comandes Copiar_Comanda(String Nom_Client, int identComanda)
	{
		
		int i = 0;
		int j;
		j = Consultar_Client(Nom_Client);
		boolean trobat = false;
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
			
			return (Llista_comandes[i]);
		}
		else
		{
			return (null);
		}
	}
}
