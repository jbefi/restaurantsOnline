package restaurantsOnline;
import java.util.Date;
/**
 * Created by Kidu15 on 11/11/16.
 */
public class Comanda {


    //definicio de variables a la classe Comanda

    private LlistaProductes[] productes;
    private int codiProducte;   // me pasan el codigo del producto? o el nombre?
    private int quantitat;
    private float preuComanda;
    private Date hora;
    private float descuento;
    private boolean confirmarDescuento;
    public boolean confirmar;
    private String resumComanda;
    private static int identComanda=0;



    private int nElem;
    final int maxElementos = 100;

    public Comanda(String resumComanda, int quantitat, boolean confirmarDescuento, float descuento) {

        this.resumComanda=resumComanda;
        this.quantitat = quantitat;
        this.confirmarDescuento = confirmarDescuento;
        this.descuento = descuento;
        identComanda=identComanda+1;
    }


    public String ResumComanda() {



    }

    

    public void afegeixProducte() {

        if (nElem < maxElementos) {

           // productes[nElem] = new producte(nom, quantitat, tipus);
            nElem++;
        }

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

    public int getCodiProducte() {
        return codiProducte;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public float getPreuComanda() {
        return preuComanda;
    }

    public Date getHora() {
        return hora;
    }

    public float getDescuento() {
        return descuento;
    }

    public boolean isConfirmarDescuento() {
        return confirmarDescuento;
    }

    public boolean isConfirmar() {
        return confirmar;
    }

    public String getResumComanda() {
        return resumComanda;
    }

    public int getIdentComanda() {
        return identComanda;
    }
}


//