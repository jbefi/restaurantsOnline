package restaurantsOnline;
import java.util.Date;
/**
 * Created by Kidu15 on 11/11/16.
 */
public class Comanda {


    //definicio de variables a la classe Comanda

    private LlistaProducte producte;
    //    private LlistaProducte producte = new LlistaProducte(100);
    private Date hora;
    private float descuento;
    private boolean confirmarDescuento;
    private static int identComanda=0;
    private String nom;

    public Comanda(LlistaProducte[] producte), Date hora){

        int i;
        for (i =0; i <=producte.length; i++) this.producte[i] = producte[i];
        this.confirmarDescuento = confirmarDescuento;
        this.descuento = descuento;
        identComanda=identComanda+1;
    }

    public static void afegirElement(String nom) {


        producte.afegirProducte(nom);


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



    public int getIdentComanda() {
        return identComanda;
    }
}


//