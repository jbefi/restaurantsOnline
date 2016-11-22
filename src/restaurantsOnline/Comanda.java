
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
    private String nom;
    private static int nElem=0;
    private int posicion;


    public Comanda(LlistaProducte[] producte, Date hora){

        identComanda=identComanda+1;
    }


    public static void afegirElement(String nom) {  //completar con informacion En Yu

        int aux;
        aux =
        // producte[nElem].afegirProducte(nom);

                // copiar

        nElem++;

    }

    public int precioProducto (int posicion){

        int aux1;
        int aux;
        int aux2;
        aux=0;
        aux2 = producte.getLlista()[posicion].getPreu();
        aux1 = producte.getLlista()[posicion].getDescompte();

        aux= aux - (aux2*aux1);

        // precio

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


//