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
	
	
	public int copiar_Comanda(int id, int identComanda)
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
			this.llista[j].afegirComanda(this.llista[j].getComandes().getLlista()[llista_comandes.posicioComanda(identComanda)]);
			return (1);
		}
		else
		{
			return (0);
		}

	}
	
	public void afegirComandaClient (int id, Comanda comandaguardada)
	{
		int i = consultar_Client(id);
		llista[i].afegirComanda(comandaguardada);
	}
}

