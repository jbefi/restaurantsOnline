package restaurantsOnline;

/**
 * Classe de la Comanda
 * Created by Kidu15 on 11/11/16.
 */
public class LlistaComanda {

    //definicio de variables
    private int nElem;
    private Comanda[] llista;
	private int identClient;
    private static final int maxElementos = 100;
    
    
    /**
     * Constructor de la LlistaComanda
     * @param comandes, que es una llista de la classe comanda
     */
    
    public LlistaComanda(){
    	llista = new Comanda[maxElementos];
    	nElem = 0; 
    }
    
    public LlistaComanda(Comanda[] comandes){
    	llista=comandes;
        nElem=comandes.length;
    }

    //mètodes

    /**
     * Metode que afegeix una comanda i que rep els seguents parametres
     * @param producte  , la llista de productes que conte la comanda
     * @param hora, la hora en que es fa la comanda 
     * @param minut, minut en que es fa la comanda
     */

    public void afegirComanda(LlistaProducte producte, int hora, int minut, double preuTotal) { 
       
    	if (nElem < maxElementos) {
        	
            llista[nElem] = new Comanda(producte, hora, minut, preuTotal); // en cada lloc de la llista poso una nova comanda amb els parametres que hi passo 
            nElem++;
            
        }

    }
  
    /**
     * Metode afegeix una comanda nova sense tots els parametres que demano abans
     * @param comanda  , una nova comanda
     */
    public void afegirComanda(Comanda nou) { 
        if (nElem < maxElementos) {
//        	
            llista[nElem] = nou; // en cada lloc de la llista poso una nova comanda amb els parametres que hi passo 
            nElem++;
            
        }

    }
    
    /**
     * Metode que elimina les comandes posant-li el identificador de comanda 
     * @param indentificador, numero de la comanda que es autogenerat a la classe comanda i que el treiem amb el getter getIdentComanda(); 
     */

	public void eliminarComanda(int identificador) {   //metode per eliminar la comanda

        int i=0, j;
        boolean be;
        be = false;

        while(i<nElem && !be){ //bucle while que m'ajuda a recorrer tota la llista per a eliminar 

            if(identificador==(llista[i].getIdentComanda())){    // si el identificador coincideix...
                for(j=i;j<-1;j++){

                    llista[j]=llista[j+1];  //cada comanda passa a ser la seguent, per tant, la primera ja no existira
                    be=true; // surto del bucle 
                }

            }
            i++;
        }
        nElem--;
    }
    
    public int posicioComanda(int idGeneral){
    	
    	boolean trobat=false; 
    	int i=0, pos=0; 
    	
    	while( (!trobat) && (i<nElem)){
    		
    		if (idGeneral== llista[i].getIdentComanda())
    		{
    			trobat=true; 
    			pos=i; 
    		}
    		i++; 
    	}
    	if ( !trobat){ 
    		pos=-1; 
    	}
    	return (pos); 
    	
    }
    //getters de la classe 
    
    public Comanda[] getLlista() {
		return llista;
	}

    
    public int getnElem ()
    {return nElem;}
    
    
    public int getIdentClient () { 
    	return identClient; 
    }
    
    
    public String toString(){
    	String aux = "";
    	for(int i=0;i<nElem;i++)
    		aux = aux + llista[i]+"\n";
    	return aux;
    }
    
    
}