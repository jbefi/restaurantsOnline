package restaurantsOnline;

import java.util.Date;
/**
 * Created by Kidu15 on 11/11/16.
 */
public class Comanda {


    //definicio de variables a la classe Comanda

    private LlistaProducte producte;
    //private LlistaProducte producte = new LlistaProducte(100);
    private Date hora;
    private float descuento;
    private boolean confirmarDescuento;
    private static int identComanda=0;


    public Comanda(LlistaProducte producte, Date hora){
        identComanda=identComanda+1;
        this.hora=hora;
    }


    public int afegirElement(String nom) {  //completar con informacion En Yu

        int aux;
        aux = producte.posicioProducte(nom);

        if  (aux>=0){
                this.producte.afegirProducte(producte.getLlista()[aux]);
        }
        return aux;
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
