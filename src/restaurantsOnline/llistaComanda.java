package restaurantsOnline;

import java.util.Date;
/**
 * Classe de la Comanda
 * Created by Kidu15 on 11/11/16.
 */
public class llistaComanda {

    //definicio de variables
    private int nElem;
    private Comanda[] llista;
    private static final int maxElementos = 100;


    /**
     * Constructor de la LlistaComanda
     */
    public llistaComanda(){
        nElem=0;
    }
    
    public llistaComanda(Comanda[] comandes){
    	llista=comandes;
        nElem=comandes.length;
    }
    
    public int getnElem (){return nElem;}
    
    //mètodes


    /**
     * Constructor de la LlistaComanda
     * @param producte  , quantitat del producte a afegir a la llista
     */

    public void afegirComanda(LlistaProducte[] producte, Date hora) {  //metode per afegir la comanda
        if (nElem < maxElementos) {

            llista[nElem] = new Comanda(producte, hora);
            nElem++;
        }

    }

    
    
    public Comanda[] getLlista() {
		return llista;
	}

	public void eliminarComanda(int identificador) {   //metode per eliminar la comanda

        int i=0, j;
        boolean be;
        be = false;

        while(i<nElem && !be){

            if(identificador==(llista[i].getIdentComanda())){
                for(j=i;j<-1;j++){

                    llista[j]=llista[j+1];
                    be=true;
                }

            }
            i++;
        }
        nElem--;
    }

    public void ordenarComandes() {     // metode per ordenar comandes

        int i=0;
        int j;
        while (i<nElem) {

            for(j=i;j<-1;j++){

                llista[j]=llista[j+1];

            }
            i++;
        }
    }

}