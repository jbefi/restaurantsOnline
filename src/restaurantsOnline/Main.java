package restaurantsOnline;

import java.util.Date;
import java.io.*;
import java.util.*;

public class Main {
	
	public LlistaProducte llistaProducte;
	public LlistaComanda llistaComandes;
	public LlistaClients llistaClients;

	static Scanner teclat = new Scanner(System.in);
	 public static void mostraMenu()
	    {
	    	System.out.println("******RESTAURANTE ON LINE*******");
	        System.out.println("\n\nOpcions del menu:");
	        System.out.println("\n\t1. Afegir nous productes");
	        System.out.println("\n\t2. Eliminar producte");    
	        System.out.println("\t4. Consultar la informacio que es demana al registre ");
	        System.out.println("\t5. Crear un nou client "); 
	        System.out.println("\t6. Consultar un client "); 
	        System.out.println("\t7. afegir una comanda "); 
	        System.out.println("\t8. eleminar una comanda "); 
	        System.out.println("\t9. copiar  una comanda "); 
	        System.out.println("\t10. Llistar  totes les comandes que ha fet un client ordenades de mes nova a mes antiga ");
	        System.out.println("\t11. Sortir");
	        System.out.print("\n\t\t\tIndica opcio:\n");
	    }
	    
	   
	 public static void afegirProducte(LlistaProducte llistP)
	    
	    { 
	    	String nom;
	    	Double preu;
	    	Double descompte;
	    	Plat p;
	        
	     int opcio;
	     
	     // TODO Que demanes
	     System.out.print("\n\n\tSi vols agefir una  beguda posa el numero 1 si vols afegir un plat posa numero 2:\t");
	     opcio=teclat.nextInt();
	      
	      switch(opcio){
	    	  case 1:
	    		  int volum;
	  	    	  boolean tAlcohol;
	  	    	  System.out.print("\n\n\tSi vols agefir una  begida posa el numero 1:\t");
	    		  System.out.print("\n\n\tIndica el nom de biguda que vols agefir :\t");
	    		  nom=teclat.next();
	    	      System.out.print("\n\n\tIndica el preu de biguda que vols agefir :\t");
	    	      preu=teclat.nextDouble();
	    	      System.out.print("\n\n\tIndica el descompte de biguda que vols agefir :\t");
	    	      descompte=teclat.nextDouble();
	    	      System.out.print("\n\n\tIndica el volum del producte :\t");
	    	      volum=teclat.nextInt();
	    	      System.out.print("\n\n\tIndica si la beguda te alcol  :\t");
	    	      tAlcohol=teclat.nextBoolean();
	    	      Beguda b1= new Beguda(nom,preu,descompte,volum,tAlcohol);
	    	      llistP.afegirProducte(b1);
	    	      break;
	    	  case 2:
	    		  boolean tRestr;
	  	    	  String[] res = null;
	  	    	  System.out.print("\n\n\tSi vols agefir una  begida posa el numero 2:\t");
	    	      System.out.print("\n\n\tIndica el nom del plat que vols afegir:\t");
	    	      nom=teclat.next();
 	              System.out.print("\n\n\tIndica el preu del plat que vols agefir :\t");
 	              preu=teclat.nextDouble();
	    	      System.out.print("\n\n\tIndica el descompte que te el plat :\t");
	    	      descompte=teclat.nextDouble();
	    	      System.out.print("\n\n\tIndica si el plat te retriccions  :\t");
	    	      
	    	      tRestr=teclat.nextBoolean();
	    	      if (tRestr){
	    	    	  System.out.print("\n\n\tIndica quina retriccions te aquet plat  :\t");// DEmanar REstriccions  
	    	    	  System.out.print("1.Celias  :\t");
	    	    	  res[0]=teclat.next();
	    	    	  System.out.print("2.lactosa  :\t");
	    	    	  res[1]=teclat.next();
	    	    	  System.out.print("3.fruit secs :\t");
	    	    	  res[2]=teclat.next();
	    	    	  
	   
	    	      }else
	    	        p=null;
	    	      	p= new Plat(nom,preu,descompte);
	    	        llistP.afegirProducte(p);
	    	        
	    	        break;
	      }
	   
	    }

	    
	    public static void eliminarProducte(LlistaProducte llistP)
	    {
         int codi;
	        
	        System.out.print("\n\n\tIndica el codi del  prodcute  que vols eliminar:\t");
	        codi =Integer.parseInt(teclat.nextLine());
	        System.out.print("\n\n\tEl producte s'ha eleminat amb exit\t");
	        llistP.eliminarProducte(codi);
	    }
	    
	    public static void carregarProducte(LlistaProducte llistP)
	    {
	    	//encara falta el fitxer
	    }
	    /**
	     * Metode al main que crea una comanda 
	     * Created by Kidu15 on 11/11/16.
	     */
	public static void afegirComanda() {

		int opcio; //creo les variable enteres que utilitzo per a les opcions que dono al client
		int quantitat = 0;
		String nom = null; //variable utilitzada per al nom del producte
		boolean confirmar, plats, begudes;  //creo les variables booleanes que necessito per a fer el meu programa
		confirmar = false;
		plats = false;
		begudes = false;
		

		Comanda nova = new Comanda(null, 0, 0); 
		
		System.out.println("** Crear comanda **") ; 

		while(!confirmar) { // bucle que confirma la comanda 

			int i;
			int aux; 
			while(!plats) { // comencem amb els plats 
												
																			// demanem a l'usuari els plats i la seva quantitat 
				System.out.println("Introdueix els plat que vols") ;
					
				nom=teclat.nextLine();
				
				System.out.println("Introdueix la quantitat") ;

				quantitat=teclat.nextInt();		

					
				for (i=0;i<=quantitat; i++) {
					aux=nova.afegirElement(nom);
					if(aux==-1){
						System.out.println("No hi ha l'element"); 
					}
					
				}

				System.out.println("Si vols mes plats, posa l'1, si no, el 2");
				opcio=teclat.nextInt();
				if (opcio==2){
					plats=true;
				}
			}
			while (!begudes) {

				System.out.println("Introdueix les begudes que vols") ;

				nom=teclat.nextLine();

				System.out.println("Introdueix la quantitat") ;

				quantitat=teclat.nextInt();

				for (i=0;i<=quantitat; i++) {
					nova.afegirElement(nom);
				}
				System.out.println("Si vols mes begudes, posa l'1, si no, el 2");
				opcio=teclat.nextInt();
				if (opcio==2){
					begudes=true;
				}
			}
			
			System.out.println("Per veure el resum de la comanda, posa l'1, per més productes posa el 2") ;

			opcio=teclat.nextInt();

			if (opcio==1){

				// resum comanda

				System.out.println("Si vols confirmar la comanda, posa l'1, si vols més productes el 2 ");

				opcio=teclat.nextInt();
				if (opcio==1){
				
					Calendar horaComanda = new GregorianCalendar();
					int hora, minuto; 
					
					hora =horaComanda.get(Calendar.HOUR_OF_DAY);
					minuto = horaComanda.get(Calendar.MINUTE);
					
					
					//TODO hay que añadir la comanda dentro de la lista de comandas del cliente actual
					confirmar=true;
		
				}
			}

		}
	}

	    public static void consultarInformacio(LlistaProducte llistP)
	    {
	    	
	    	int codi;
	    	 System.out.print("\n\n\tIndica el codi del  prodcute  que vols consultar:\t");
		     codi =teclat.nextInt();
		     llistP.informacio(codi);
			} 

	    public static void crearClient(LlistaClients llistCl)
	    {
	    	String nom;
	    	String tel;
	    	int contr;
	    	String usuari;
	    	String adreca;
	    	String[] tRestr = null;
	    	
	    	
	        System.out.print("\n\n\tIndica el nom del client:\t");
	        nom=teclat.nextLine();
	        System.out.print("\n\n\tIndica la adreca:\t");
	        adreca=teclat.next();
	        System.out.print("\n\n\tIndica el numero de telelfono :\t");
	        tel=teclat.next();
	        System.out.print("\n\n\tIndica el nom del usuari client:\t");
	        usuari=teclat.next();
	        System.out.print("\n\n\tIndica la contrasi�a del client:\t");
	        contr=teclat.nextInt();
	        System.out.print("\n\n\tIndica si el client te alguna restriccions:\t");  // DEMANAR RESTRICCIONS
	      
	    	  System.out.print("1.Celias  :\t");
	    	  tRestr[0]=teclat.next();
	    	  System.out.print("2.lactosa  :\t");
	    	  tRestr[1]=teclat.next();
	    	  System.out.print("3.fruit secs :\t");
	    	  tRestr[2]=teclat.next();
	      
	          Clients client=new Clients(nom,adreca,tel,usuari,contr,tRestr, new LlistaComanda());
	        
	          llistCl.creaClient(client);  //Afegir a la llista de Clients              
	        
	    }

	    
	    public static void consultarClient(LlistaClients llistCl)
	    {
	    	String nom;
	    	System.out.print("\n\n\tIndica nom del client que vols consultar:\t");
		        nom = teclat.nextLine();
		        llistCl.consultar_Client(nom);
	    }
	    
	    public static void teDescompte()
	    {
	  
        }
	     		
	    
	    private static void eliminarComanda(LlistaComanda llistCo)
	  
	    {
	    	int iden;
	  	    System.out.print("\n\n\tIndica el identificador  per eliminar la comanda :\t");
	        iden = teclat.nextInt();
	        System.out.print("\n\n\tLa comanda s'ha eliminat amb exit\t");
	        llistCo.eliminarComanda(iden);
	    }
	    
	    
	    private static void copiarComanda(LlistaClients llistCl)
		  
	    {
	    	String nom;
	    	int iden;
	    	System.out.print("\n\n\tIndica nom del client:\t");
		    nom = teclat.nextLine();
            System.out.print("\n\n\tIndica el identificador  de la comanda que vols copiar :\t");
	        iden = teclat.nextInt();
	        System.out.print("\n\n\tLa comanda s'ha copiat amb exit \t");
		    llistCl.copiar_Comanda(nom,iden);                      // Agefir a la llista de comandes del client
	    }
	    
	    
	    private static void ordenarComandes(LlistaComanda llistCo)
		  
	    {
	        System.out.print("\n\n\t La llista de comanda ordenat\t");
	        llistCo.ordenarComandes();
	    }
	   
	    
	    public static void main(String[] args) throws IOException {
	    
	    	
	    	
	    	//TODO Llegir fitxer Comandes - Catalin 
<<<<<<< HEAD
	    	
	    	/*try{
	    		
		    	
		    	Scanner f=new Scanner(new File("Comandes.txt")); 
		    	int identificador=0;
		    	String plat; 
		    	String beguda; 
		    	int hora=0, minut=0; 
		    	
		    	
	    	}                          */
	    
	    	//TODO Llegit Fitxxer Productes - Enyu
=======

	    	//TODO Llegit Fitxer Productes - Enyu
>>>>>>> origin/master
	    	
	    	//TODO Llegir fitxer Clients - Pablo
	    	
	    	
	    	//TODO 1 Excepcio cada un Catalin, Enyu, Pablo
	    	
	    	
	    	// Carregar de fitxer
	    	//    carregarProducte(llistP); break;
	    	
	    	//AFEGIR COSES

	    	Producte[] llista=new Producte[4];
	    	Beguda b1 = new Beguda("sprite",2,10,20,false);
	    	Beguda b2 = new Beguda("fanta",2.5,20,30,false);

	    	Plat p1 = new Plat("Amanida", 5, 20);
	    	String[] Restriccions = {"celiacs","lactosa","fruits secs"};
	    	Plat p2 = new Plat("Sopa", 10, 5, Restriccions);

	    	llista[0] = b1;
	    	llista[1] = b2;
	    	llista[2] = p1;
	    	llista[3] = p2;

	    	LlistaProducte llistP = new LlistaProducte(12);
	    	llistP.afegirProducte(b1);
	    	llistP.afegirProducte(b2);
	    	llistP.afegirProducte(p1);
	    	llistP.afegirProducte(p2);

	    	
	    	
	    	Clients[] llistaCl=new Clients[3];
	    	String[] tRestr = {"celiacs","lactosa","fruits secs"};
	    
	    	Date data=new Date(11,11,2016);
	    	
	    	Clients Client1=new Clients("Jose"," avenida Barcelona","666999444","jose32",234,tRestr,new LlistaComanda());
	    	Clients Client2=new Clients("Alex","avenida Jaume1","666777444","alex32",123,tRestr,new LlistaComanda());
	    	Clients Client3=new Clients("Jordi","avenida Ramon","666888444","jordi32",543,tRestr,new LlistaComanda());
	    	LlistaClients llistCl = new LlistaClients();
	    	
	    	Comanda comanda1=new Comanda(llistP,data);
	    	LlistaComanda llistCo = new LlistaComanda();

	    	int opcio=0;
	    	while(opcio != 11)
	    	{  		
	    	mostraMenu();
	    	opcio = Integer.parseInt(teclat.nextLine());
	    	System.out.println(opcio);
	    		switch(opcio)
	    		{
	    		case 1:
	    			System.out.println("HOLA");afegirProducte(llistP);;break;
	    		case 2:
	    			eliminarProducte(llistP);break;
	    		case 4:
	    			consultarInformacio(llistP); break;
	    		case 5:
	    			crearClient(llistCl);break;
	    		case 6:
	    			consultarClient(llistCl);break;
	    		case 7: 
	    			afegirComanda();break;
	    		case 8:
	    			eliminarComanda(llistCo); break;
	    		case 9:
	    			copiarComanda(llistCl); break;
	    		case 10:
	    			ordenarComandes(llistCo);break;

	    		}	          
	    	}
	    }

}
	
