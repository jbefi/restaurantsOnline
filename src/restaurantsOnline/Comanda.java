package restaurantsOnline;

/**
 * Created by Kidu15 on 11/11/16.
 */

public class Comanda {


    //definicio de variables a la classe Comanda

    private LlistaProducte producte;
    private int hora;
    private int minut; 
    private float descuento;
    private boolean confirmarDescuento;
    private int identComanda=0;

    /**
     * Constructor de la classe comanda que rep els seguents parametres 
     * @param producte -> una llista de llista producte que conte tots els productes de la comanda 
     * @param hora -> l'hora en que es fa la comanda 
     */

    public Comanda(LlistaProducte producte, int hora, int minut){
        identComanda=identComanda+1;
        this.hora=hora;
        this.minut=minut; 
    }


	/**
     * Metode que afegeix elements a la llista de la comanda buscant el producte dins la llista
     * de productes 
     * @param nom, un string que es el nom del producte que es vol buscar 
     */
    public int afegirElement(String nom) {  

        int aux;
        aux = producte.posicioProducte(nom); // busco la posicio del producte dins de la llista per a poder copiarlo

        if  (aux>=0){
                this.producte.afegirProducte(producte.getLlista()[aux]);  // afegeixo el producte de la posicio ''aux'' de dins de la LlistaProducte a la llista producte que he creat 
        }
        return aux;
    }
    
    //getters de la classe
    public int getHora() {
        return hora;
    }
    public int getMinut() {
        return minut;
    }

    public float getDescuento() {
        return descuento;
    }

    public boolean isConfirmarDescuento() {
        return confirmarDescuento;
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

	public void setIdentComanda(int identComanda) {
		this.identComanda = identComanda;
	}


}
