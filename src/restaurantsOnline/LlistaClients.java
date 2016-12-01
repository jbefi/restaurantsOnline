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
	
	
	public Comanda copiar_Comanda(String usuari, int pas, int identComanda)
	{
		
		int i = 0;
		int j;

		boolean trobat = false;
		boolean existeix1 = false, existeix2 = false;
		int posiciousuari = 0;
		
			for (i=0; ((i<llista.length)&&(!existeix1)&&(!existeix2)); i++){
			
				if(usuari.equals(llista[i].getUsuari())){
					existeix1=true; 
				}
				if(pas==(llista[i].getContrasenya())){
					existeix2=true; 
				}
			
				if (existeix1 && existeix2){
					posiciousuari=i; 
				}
			}
		if (existeix1 && existeix2){
			//j = consultar_Client(llista[posiciousuari].getIdentificador());
		
			LlistaComanda llista_comandes = this.llista[posiciousuari].getComandes();
		
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
		else return null;
	}
	
	public void afegirComandaClient (int id, Comanda comandaguardada)
	{
		int i = consultar_Client(id);
		llista[i].afegirComanda(comandaguardada);
	}
}

