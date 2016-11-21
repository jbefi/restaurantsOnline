package restaurantsOnline;
import java.util.Date;
/**
 * Created by Kidu15 on 11/11/16.
 */
public class Comanda {


    //definicio de variables a la classe Comanda

    //private LlistaProducte producte;
     private LlistaProducte producte = new LlistaProducte(100);
    private Date hora;
    private float descuento;
    private boolean confirmarDescuento;
    private static int identComanda=0;
    private String nom;
    private static int nElem=0;



    public Comanda(LlistaProducte[] producte, Date hora){
        
        identComanda=identComanda+1;
    }

    public void afegirElement(String nom) {  //completar con informacion chino

        LlistaProducte.retPosLlista(nom);

       // producte[nElem].afegirProducte(nom);  //copiar
        nElem++;
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