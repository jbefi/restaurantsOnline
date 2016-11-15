package restaurantsOnline;

/**
 * Created by Kidu15 on 11/11/16.
 */
public class LlistaComanda {

    //definicio de variables
    private int nElem;
    private Comanda[] llista;
    final int maxElementos = 100;



    public LlistaComanda(){

    }
    //mètodes

    public void afegirComanda(String resumComanda, int quantitat, boolean confirmarDescuento, float descuento) {  //metode per afegir la comanda


        if (nElem < maxElementos) {

            llista[nElem] = new Comanda(resumComanda, quantitat, confirmarDescuento, descuento);
            nElem++;
        }

        return;

    }

    public void eliminarComanda(int identificador) {   //metode per eliminar la comanda

        int i=0, j;
        boolean be=false;

        while(i<nElem && be==false){

            if(identificador==(llista[i].getIdentComanda())){
                for(j=i;j<-1;j++){

                    llista[j]=llista[j+1];
                    be=true;
                }

            }
            i++;
        }
        nElem--;
        return;
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