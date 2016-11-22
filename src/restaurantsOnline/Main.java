package restaurantsOnline;

import java.util.Scanner;

public class Main {

	static Scanner teclat = new Scanner(System.in);
	 public static void mostraMenu()
	    {
	    	System.out.println("******RESTAURANTE ON LINE*******");
	        System.out.println("\n\nOpcions del menu:");
	        System.out.println("\n\t1. Afegir nous productes");
	        System.out.println("\n\t2. Eliminar producte");    
	        System.out.println("\t3. Carregar els productes a partir d'un fitxer de dades");
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
	    
	   
	    public static void afegirProducte(LlistaProducte llistP)//anadir producte
	    
	    { 
	    	String nom;
	    	Double preu;
	    	float descompte;
	    	int volum;
	    	boolean tAlcohol;
	    	boolean tRestr;
	    	String[] res;
	    	
	    	
	        Beguda aux= new Beguda(nom,preu,descompte,volum,false);
	        Plat aux1= new Plat(nom,preu,descompte);//arreglar
	        
	     String Product="beguda";
	     Product=teclat.nextLine();
	     
	      
	      switch(Product){
	    	  case "beguda":
	    		  System.out.print("\n\n\tIndica el nom de biguda que vols agefir :\t");
	    		  aux.setNom(nom);
	    	      System.out.print("\n\n\tIndica el preu de biguda que vols agefir :\t");
	    	      aux.setPreu(preu);//necesito un setter para atributo preu
	    	      System.out.print("\n\n\tIndica el descompte de biguda que vols agefir :\t");
	    	      aux.setDescompte(descompte);
	    	      System.out.print("\n\n\tIndica el volum del producte :\t");
	    	      aux.setVolum(volum);
	    	      System.out.print("\n\n\tIndica si la beguda te alcol  :\t");
	    	      aux.setTeAlcohol(tAlcohol);
	    	      llistP.afegirProducte(aux);
	    		  break;
	    	  case "plat":
	    	     System.out.print("\n\n\tIndica el nom del plat que vols afegir:\t");
    	        aux1.setNom(nom);
    	         System.out.print("\n\n\tIndica el preu del plat que vols agefir :\t");
	    	      aux1.getPreu();
	    	      System.out.print("\n\n\tIndica el descompte que te el plat :\t");
	    	      aux1.setDescompte(descompte);
	    	      System.out.print("\n\n\tIndica si el plat te retriccions  :\t");
	    	      aux1.setTeRestriccio(tRestr);
	    	    
	      }
	      
	    
	 
                 llistP.afegirProducte(aux);
                 llistP.afegirProducte(aux1);
      
	       
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


public class Main {

	public static void main(String[] args) {

		Beguda b1 = new Beguda("cola",2,10,30,false);
		Beguda b2 = new Beguda("fanta",1.5,20,30,false);
		Plat p1 = new Plat("Amanida", 5, 20);
		String[] alergies = {"lactosa", "celiacs", "fruits secs"};
		Plat p2 = new Plat("Sopa", 10, 5, alergies);
		LlistaProducte llist = new LlistaProducte(10);
		
		llist.afegirProducte(b1);
		llist.afegirProducte(b2);
		llist.afegirProducte(p1);
		System.out.println(llist);
		llist.eliminarProducte(3);
		System.out.println("--------");
		System.out.println(llist);
		llist.afegirProducte(p2);
		System.out.println("-------->>>>>");
		System.out.println(llist);
		System.out.println(">>>>-------->>>>>");
		System.out.println(llist.informacio(4));
		// Apliquem el descompte a un producte
		llist.getLlista()[0].aplicarDescompte();
		System.out.println(llist.getLlista()[0]);

		Scanner teclat=new Scanner(System.in);
		int opcio; //creo les variable enteres que utilitzo per a les opcions que dono al client
		int quantitat;
		String nom; //variable utilitzada per al nom del producte
		boolean confirmar, plats, begudes;  //creo les variables booleanes que necessito per a fer el meu programa
		confirmar = false;
		plats = false;
		begudes = false;



		System.out.println("** Crear comanda **") ;

		while(!confirmar) {


			int i;
			while(!plats) {

				System.out.println("Introdueix els plat que vols") ;

				nom=teclat.nextLine();

				System.out.println("Introdueix la quantitat") ;

				quantitat=teclat.nextInt();

				for (i=0;i<=quantitat; i++) {

					Comanda.afegirElement(nom);

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

					Comanda.afegirElement(nom);

				}
				System.out.println("Si vols mes begudes, posa l'1, si no, el 2");
				opcio=teclat.nextInt();
				if (opcio==2){
					begudes=true;
				}
			}

			System.out.println("Per veure el resum de la comanda, posa l'1, per mÃ©s productes posa el 2") ;

			opcio=teclat.nextInt();

			if (opcio==1){


				LlistaComanda.afegirComanda(producte);

				// resum comanda

				System.out.println("Si vols confirmar la comanda, posa l'1, si vols mÃ©s productes el 2 ");

				opcio=teclat.nextInt();
				if (opcio==1){
					confirmar=true;
				}

			}

		}




	}


	    public static void consultarInformacio(LlistaProducte llistP)
	    {
	    	int i; 
			for (i=0; i<100; i++ ){
				
				System.out.println(llistP.toString());
			}
	    }
	    

	    public static void crearClient(LlistaClients llistCl)
	    {
	    	String nom;
	    	int tel;
	    	int contr;
	    	String usuari;
	    	String adreça;
	    	String[] tRestr;
	    	
	    	Clients aux2=new Clients(nom,adreça,tel,usuari,contr,tRestr);//arreglar
	        System.out.print("\n\n\tIndica el nom del client:\t");
	        aux2.getNom_client();
	        System.out.print("\n\n\tIndica la adreça:\t");
	        aux2.setAreça(adreça);//necesito sitter de adreca
	        System.out.print("\n\n\tIndica el numero de telelfono :\t");
	        aux2.setTelefon(tel);
	        System.out.print("\n\n\tIndica el nom del usuari client:\t");
	        aux2.setUsuari(usuari);
	        System.out.print("\n\n\tIndica la contrasiña del client:\t");
	        aux2.setContrasenya(contr);
	        System.out.print("\n\n\tIndica si ele client te alguna restreccions:\t");
	        aux2.setRestriccions(tRestr);
	        llistCl.crearClient();//necesito el metodo de crear client en la llista client
	    }
	    
	    
	    public static void consultarClient(LlistaClients llistCl)
	    {
	    	String nom;
	    	System.out.print("\n\n\tIndica nom del client que vols consultar:\t");
		        nom = teclat.nextLine();
		        llistCl.Consultar_Client(nom);
	    }
	    
	    private static void afegirComanda(LlistaComanda llistCo)
	    {
	    	String nom;
	    	String resumComanda;
	    	int quantitat;
	    	boolean confiDescuento;
	    	float descuento;
	    	
	    	//Comanda aux2=new Comanda(resumComanda,quantitat,true,descuento); //arreglar
	    	System.out.print("\n\n\tIndica nom del client :\t");
	    	nom=teclat.nextLine();
	    	if (llistCl.Conte_Restriccions (nom))
	    		System.out.print("\n\n\tAvis:te Restriccions");
	    	else
	    			System.out.print("\n\n\tIndica nom del producte que vols agefir :\t");
	    	        
	    	        System.out.print("\n\n\tIndica la quantitat del producte que vol afegir a la comanda :\t");
	    	        
	    	//llistCo.afegirComanda(aux2);
	    	

	    }
	    
	    private static void eliminarComanda(LlistaComanda llistCo)
	  
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
	    	
		   //llistCl.Copiar_Comanda(nom,iden);
	    }
	    
	    
	    private static void ordenarComandes(LlistaComanda llistCo)
		  
	    {
	        System.out.print("\n\n\t La llista de comanda ordenat\t");
	        llistCo.ordenarComandes();
	    }
	   
	    
	    public static void main(String[] args)
	    {
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
	    	
             
             //Clients cl1=new Clients("jose","Barcelona",666333222,"jose77",123,"sal");
	    	LlistaClients llistCl = new LlistaClients();
	    	//llistCl.crearClient(cl1);
	    	Comanda coma1=new Comanda("pescado",2,false,3.5f);
	    	LlistaComanda llistCo = new LlistaComanda();
	    	//llistCo.afegirComanda(coma1);
	    	
	    	
	        int opcio;
	    

	        mostraMenu();
	        opcio = Integer.parseInt(teclat.nextLine());
	        while(opcio != 11)
	        {
	         
	            switch(opcio)
	            {
	                case 1:
	                	afegirProducte(llistP);break;
	                case 2:
	                	eliminarProducte(llistP);break;
	                case 3:
	                	carregarProducte(llistP); break;
	                case 4:
	                	consultarInformacio(llistP); break;
	                case 5:
	                	crearClient(llistCl);break;
	                case 6:
	                	consultarClient(llistCl);break;
	                case 7: 
	                	afegirComanda(llistCo);break;
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


	
