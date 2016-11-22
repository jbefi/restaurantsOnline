package restaurantsOnline;

import java.util.Scanner;
import java.util.Date;

public class Main {
	
	public LlistaProducte llistaProducte;
	public llistaComanda llistaComandes;
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
	        
	     String Product="beguda";
	     
	     // TODO Que demanes
	     
	     Product=teclat.nextLine();
	      
	      switch(Product){
	    	  case "beguda":
	    		  int volum;
	  	    	boolean tAlcohol;
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
	    	  case "plat":
	    		  boolean tRestr;
	  	    	String[] res = null;
	    	     System.out.print("\n\n\tIndica el nom del plat que vols afegir:\t");
	    	     nom=teclat.next();
 	         System.out.print("\n\n\tIndica el preu del plat que vols agefir :\t");
 	         preu=teclat.nextDouble();
	    	      System.out.print("\n\n\tIndica el descompte que te el plat :\t");
	    	      descompte=teclat.nextDouble();
	    	      System.out.print("\n\n\tIndica si el plat te retriccions  :\t");
	    	      
	    	      tRestr=teclat.nextBoolean();
	    	      if (tRestr){
	    	    	  System.out.print("\n\n\tIndica si el plat te retriccions  :\t");
	    	    	  
	    	    	  
	    	    	  //TODO DEmanar REstriccions
	    	    	  
	    	    	  p= new Plat(nom,preu,descompte, res);
	    	      }else
	    	      	p= new Plat(nom,preu,descompte);
	    	      
	    	     
	    	      
	    	      llistP.afegirProducte(p);
	      }
	    }

	    
	    public static void eliminarProducte(LlistaProducte llistP)
	    {
         int codi;
	        
	        System.out.print("\n\n\tIndica el codi del  prodcute  que vols eliminar:\t");
	        codi =Integer.parseInt(teclat.nextLine());
	        System.out.print("\n\n\tel producte s'ha eleminat amb exit\t");
	        llistP.eliminarProducte(codi);
	    }
	    
	    public static void carregarProducte(LlistaProducte llistP)
	    {
	    	int codi;
	    	
	    	 System.out.print("\n\n\tIndica el codi del  prodcute  que vols carregar:\t");
		     codi =Integer.parseInt(teclat.nextLine());
		        
		     llistP.informacio(codi);//encara falta el fitxer
	    }

	public static void afegirComanda() {

		int opcio; //creo les variable enteres que utilitzo per a les opcions que dono al client
		int quantitat;
		String nom; //variable utilitzada per al nom del producte
		boolean confirmar, plats, begudes;  //creo les variables booleanes que necessito per a fer el meu programa
		confirmar = false;
		plats = false;
		begudes = false;
		

		Comanda nova = new Comanda(null, null);
		
		System.out.println("** Crear comanda **") ;

		while(!confirmar) {

			int i;
			while(!plats) {

				System.out.println("Introdueix els plat que vols") ;

				nom=teclat.nextLine();

				System.out.println("Introdueix la quantitat") ;

				quantitat=teclat.nextInt();

				for (i=0;i<=quantitat; i++) {
					nova.afegirElement(nom);
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
					confirmar=true;
				}

			}

		}
	}


	    public static void consultarInformacio(LlistaProducte llistP)
	    {
	    	
	    	
	    	//TODO Demanar codi
	    	
	    	int i; 
			for (i=0; i<100; i++ ){
				System.out.println(llistP.toString());
			}
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
	        System.out.print("\n\n\tIndica si ele client te alguna restreccions:\t");
	        System.out.println("1.");
	        
	        // TODO ACABAR DEMANAR RESTRICCIONS
	        
	        
	        
	        Clients client=new Clients(nom,adreca,tel,usuari,contr,tRestr, new llistaComanda());
	        
	        
	        //TODO Afegir a la llista de Clients
	        
	    }

	    
	    
	    public static void consultarClient(LlistaClients llistCl)
	    {
	    	String nom;
	    	System.out.print("\n\n\tIndica nom del client que vols consultar:\t");
		        nom = teclat.nextLine();
		        llistCl.consultar_Client(nom);
	    }
	    
	    private static void eliminarComanda(llistaComanda llistCo)
	  
	    {
	    	int iden;
	  	    System.out.print("\n\n\tIndica el identificador  per eliminar la comanda :\t");
	        iden = Integer.parseInt(teclat.nextLine());
	        System.out.print("\n\n\tLa comanda s'ha eliminat amb exit\t");
	        llistCo.eliminarComanda(iden);
	    }
	    
	    private static void copiarComanda(LlistaClients llistCl)
		  
	    {
	    	String nom;
	    	int iden;
	    	System.out.print("\n\n\tIndica nom del client:\t");
		    nom = teclat.nextLine();
            System.out.print("\n\n\tIndica el identificador  del comanda que vols copiar :\t");
	        iden = Integer.parseInt(teclat.nextLine());
	    	
	        
	        // TODO Agefir a la llista de comandes del client
	        
		   //llistCl.Copiar_Comanda(nom,iden);
	    }
	    
	    
	    private static void ordenarComandes(llistaComanda llistCo)
		  
	    {
	        System.out.print("\n\n\t La llista de comanda ordenat\t");
	        llistCo.ordenarComandes();
	    }
	   
	    
	    public static void main(String[] args)
	    {
	    	
	    	
	    	//TODO Llegir fitxer Comandes - Catalin
	    	
	    	//TODO Llegit Fitxxer Productes - Enyu
	    	
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

	    	LlistaProducte llistP = new LlistaProducte(15);
	    	llistP.afegirProducte(b1);
	    	llistP.afegirProducte(b2);
	    	llistP.afegirProducte(p1);
	    	llistP.afegirProducte(p2);

	    	LlistaClients llistCl = new LlistaClients();
	    	llistaComanda llistCo = new llistaComanda();

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
	
