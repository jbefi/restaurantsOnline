package restaurantsOnline;

/**
 * Created by Kidu15 on 11/11/16.
 */

public class Comanda {


    //definicio de variables a la classe Comanda

    private LlistaProducte producte;
    private int hora;
    private int minut; 
    private static int idGeneral=0;
    private int identComanda;
    private double preuTotal=0; 

    
    



	/**
     * Constructor de la classe comanda que rep els seguents parametres 
     * @param producte -> una llista de llista producte que conte tots els productes de la comanda 
     * @param hora -> l'hora en que es fa la comanda 
     */

    public Comanda(LlistaProducte producte, int hora, int minut, double preuTotal){
    	this.producte=producte; 
    	identComanda=idGeneral;
    	idGeneral++;
        
        this.hora=hora;
        this.minut=minut; 
        this.preuTotal=preuTotal;
        Producte[] auxLlista = producte.getLlista();
        for( int i = 0; i<producte.getnElem(); i++){
        	this.preuTotal+=auxLlista[i].getPreu();
        }
    }


	/**
     * Metode que afegeix elements a la llista de la comanda buscant el producte dins la llista
     * de productes
     * També calcula el seu preu.
     * @param nom, un string que es el nom del producte que es vol buscar 
     * @param producte, una llista de llistaproducte 
     * @param quantitat, la quantitat del producte que es vol afegir
     */
    public int afegirElement(String nom, LlistaProducte producte, int quantitat, boolean preferent) {  

        int aux;
        double preuProducte = 0;
        double descuento; 
        identComanda=idGeneral;
        idGeneral++;
       
        aux = producte.posicioProducte(nom); // busco la posicio del producte dins de la llista sencera de productes per a poder copiarlo
        
        descuento = producte.getLlista()[aux].getDescompte(); // busquem el descompte del producte 
        
      
        if  (aux>=0){
        		
                this.producte.afegirProducte(producte.getLlista()[aux]);  // afegeixo el producte de la posicio ''aux'' de dins de la LlistaProducte a la llista producte que he creat 
                this.producte.getLlista()[this.producte.getnElem()-1].setQuantitat(quantitat); // faig un set de l'atribut quantitat de producte del producte que acabo d'afegir a la nova llista
                this.producte.getLlista()[this.producte.getnElem()-1].calcularPreuTotal(); // calculo el preu total del producte i més tard, augmento el preu total de la comanda 
                if (preferent){
                	this.producte.getLlista()[this.producte.getnElem()-1].aplicarDescompte(); // si el client es preferent, aplico el descompte (per aixo passo per paràmetre si el client es preferent) 
                }
        }
        this.preuTotal+= this.producte.getLlista()[this.producte.getnElem()-1].getPreuTotal();
        return aux;
    }

	//getters de la classe
    public int getHora() {
        return hora;
    }
    public int getMinut() {
        return minut;
        
    }

    public LlistaProducte getProducte() {
		return producte;
	}


	public void setProducte(LlistaProducte producte) {
		this.producte = producte;
	}


	public int getIdentComanda() {
        return identComanda;
    }
    
    public void setHora(int hora) {
  		this.hora = hora;
  	}

  	public void setMinut(int minut) {
  		this.minut = minut;
  	}
  	public void setpreuTotal(double preuTotal) {
  		this.preuTotal=preuTotal;
  	}

	public void setIdentComanda(int identComanda) {
		this.identComanda = identComanda;
	}
	
 

	public String toString() {
		return "El resum de la teva comanda es el següent:\n  "
				+ ""
				+ "*************************************"
				+ ""
				+ producte.toString() +
				 " \nLa hora de la comanda es :\t" + hora + ":" + minut + "\nL'identificador de comanda es el seguent:\n" + identComanda + "\n \n El preu total de la comanda es: "+ preuTotal+" euros\n";
	}


}
