
package restaurantsOnline;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Finestra extends JFrame {

	private static final long serialVersionUID = 4552817780582259630L;

	// Constructor
	public Finestra(String titol, LlistaProducte llistaProducte, LlistaComanda llistaComandes,
			LlistaClients llistaClients) {
		super(titol);
		// Contenidor de la finestra principal, conté 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));
		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		JLabel etiqueta = new JLabel("BENVIGUT AL NOSTRE RESTAURANT!", SwingConstants.CENTER);
		panel1.add(etiqueta);
		contenidor.add(panel1, BorderLayout.PAGE_START);
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel etiqueta2 = new JLabel("Triï una opció del menú desplegable :");
		// Desplegable ('ComboBox') per mostrar totes les opcions del menú
		String[] opcionsMenu = { "Afegir nou producte", "Eliminar producte", "Informació d'un producte", "Crear client","Consultar Client",
				"Llistar comandes d'un client", "Nova comanda per client", "Copiar una comanda" };
		JComboBox<String> desplegable = new JComboBox<String>(opcionsMenu);
		desplegable.setForeground(Color.DARK_GRAY);
		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.WEST;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(etiqueta2, limit);
		limit.gridx = 0;
		limit.gridy = 1;
		panel2.add(desplegable, limit);
		contenidor.add(panel2, BorderLayout.CENTER);

		// Accions del desplegable
		desplegable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int opcio = desplegable.getSelectedIndex();
				switch (opcio) {
				case 0:
					// Afegir nou producte
					// new Fines_CrearProducte("Crear Producte");
					break;
				case 1:
					// Eliminar producte
					new Fines_eliminarProducte("Eliminar un producte", llistaProducte);
					System.out.println(1);
					break;
				case 2:
					// Informació d'un producte
					new Fines_InfoProducte("Informació d'un producte", llistaProducte);
					break;
				case 3:
					// Crear client
					System.out.println(3);
					break;
				case 4:
					new Fines_consultarClient("Informació d'un client", llistaClients);
					System.out.println(4);
					break;
				case 5:
					// Llistar comandes d'un client
					System.out.println(5);
					break;
				case 6:
					new afegirComanda("Nova Comanda ", llistaProducte, llistaComandes, llistaClients);
					System.out.println(6);
					break;
				case 7:
					// Copiar una comanda
					System.out.println(7);
					break;
				}
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE); // Per a poder tancar la finestra
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}

// Classe per crear la finestra que serveix per consultar tota la informació d'un producte de la llista.
class Fines_InfoProducte extends JFrame {

	private static final long serialVersionUID = 1L;

	// Constructor
	public Fines_InfoProducte(String titol, LlistaProducte llistProds) {
		super(titol);
		// Contenidor de la finestra principal, conté 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));
		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel etiqueta2 = new JLabel("Indiqui el codi del producte (1-" + llistProds.getnElem() + "):");
		JTextField campText = new JTextField(5);
		JButton boto = new JButton("Cerca");

		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.WEST;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(etiqueta2, limit);
		limit.gridx = 1;
		panel2.add(campText, limit);
		limit.gridx = 2;
		panel2.add(boto, limit);
		limit.gridx = 0;
		limit.gridy = 1;
		JTextArea textArea = new JTextArea();
		panel2.add(textArea, limit);

		contenidor.add(panel2, BorderLayout.CENTER);

		// Accions del botó
		boto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String valor = campText.getText(); // Agafo el codi del camp de text
				int codi = Integer.parseInt(valor);
				textArea.setText(""); // Esborro tot el contingut anterior de Text Area
				textArea.append(llistProds.informacio(codi)); // Mostro la informació
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
															// finestra principal
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}
class Fines_consultarClient extends JFrame {

	private static final long serialVersionUID = 1L;

	// Constructor
	public Fines_consultarClient(String titol, LlistaClients llistClient) {
	
		
		
		Container cont = getContentPane();
		cont.setLayout(new BorderLayout(10, 10));
		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		cont.add(panel1, BorderLayout.PAGE_START);
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel et2 = new JLabel("Indiqui el id del client que vol consultar (1-" + llistClient.getnClients() + "):");
		JTextField campText = new JTextField(5);
		JButton boto = new JButton("Cerca");
		
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.WEST;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(et2, limit);
		limit.gridx = 1;
		panel2.add(campText, limit);
		limit.gridx = 2;
		panel2.add(boto, limit);
		limit.gridx = 0;
		limit.gridy = 1;
		JTextArea textArea = new JTextArea();
		panel2.add(textArea, limit);

		cont.add(panel2, BorderLayout.CENTER);

		
		boto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String val = campText.getText(); // 
				int id= Integer.parseInt(val);
				textArea.setText(""); 
				textArea.append(llistClient.imprimirClient(id)); // consultar client
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setSize(1000, 500); 
		setVisible(true);
	}
}
class Fines_eliminarProducte extends JFrame {

	private static final long serialVersionUID = 1L;

	// Constructor
	public Fines_eliminarProducte(String titol, LlistaProducte llistProds) {
		super(titol);
		
		
		Container cont = getContentPane();
		cont.setLayout(new BorderLayout(10, 10));
		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		cont.add(panel1, BorderLayout.PAGE_START);
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel et2 = new JLabel("Indiqui el codi del producte que vol eliminar (1-" + llistProds.getnElem() + "):");
		JTextField campText = new JTextField(5);
		JButton boto = new JButton("Cerca");
		
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.WEST;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(et2, limit);
		limit.gridx = 1;
		panel2.add(campText, limit);
		limit.gridx = 2;
		panel2.add(boto, limit);
		limit.gridx = 0;
		limit.gridy = 1;
		JTextArea textArea = new JTextArea();
		panel2.add(textArea, limit);

		cont.add(panel2, BorderLayout.CENTER);

		
		boto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String valor = campText.getText(); // 
				int codi = Integer.parseInt(valor);
				textArea.setText(""); 
				textArea.append("S'ha eliminat el producte amb exit");
				llistProds.eliminarProducte(codi); // eliminar producte
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setSize(600, 400); 
		setVisible(true);
	}
}

// ********************** AFEGIR COMANDA *************************

//CLASSE PRINCIPAL 
	class afegirComanda extends JFrame {
		
		private static final long serialVersionUID = 1L;
		
		Comanda nova = new Comanda(new LlistaProducte(50), 0, 0, 0);
		
		 afegirComanda(String titol, LlistaProducte llistaProducte, LlistaComanda llistaComandes,
			LlistaClients llistaClients){
			 super(titol); 

			 	Container contenidor = getContentPane();
				contenidor.setLayout(new BorderLayout(10, 10));
				contenidor.setForeground(Color.BLACK); 
				// PANEL 1
				JPanel panel1 = new JPanel(new BorderLayout());
				JLabel etiqueta = new JLabel("*****Benvingut a la opcio de crear una nova comanda*****", SwingConstants.CENTER);
				etiqueta.setForeground(Color.DARK_GRAY);
				panel1.add(etiqueta);
				contenidor.add(panel1, BorderLayout.PAGE_START);
				// PANEL 2
				JPanel panel2 = new JPanel(new GridBagLayout());
				JLabel etiqueta2 = new JLabel("Triï una opció per a veure la nostra disponibilitat de productes i escollir-los :"); 
				//BOTONS DEL MENU PRINCIPAL DE BEGUDES Y PLATS
				JButton plats = new JButton("Plats"); 
				JButton begudes = new JButton("Begudes"); 
				// PART CONFIRMAR COMANDA 
				JLabel etiqueta3 = new JLabel ("Quan acabi d'escollir els productes, per confirmar la comanda ha d'apretar el boto de confirmar, si no, eliminar ** ");
				JButton confirmar = new JButton ("Confirmar"); 
				confirmar.setForeground(Color.GREEN);
				JButton eliminar = new JButton ("Eliminar/Tancar"); 
				eliminar.setForeground(Color.RED);
				// COLOR LLETRES BOTONS
				plats.setForeground(Color.BLUE);
				begudes.setForeground(Color.BLUE);
				// DEFINIM LIMITACIONS DEL PANEL 
				GridBagConstraints limit = new GridBagConstraints();
				// ANEM POSANT ELS DIFERENTS ELEMENTS 
				limit.anchor = GridBagConstraints.WEST;
				limit.insets = new Insets(10, 10, 10, 10);
				limit.gridx = 0;
				limit.gridy = 0;
				panel2.add(etiqueta2, limit);
				limit.gridx = 0;
				limit.gridy = 1;
				panel2.add(plats,limit); 
				limit.gridx = 1; 
				limit.gridy = 1; 
				panel2.add(begudes,limit); 
				limit.gridx = 0; 
				limit.gridy = 2; 
				panel2.add(etiqueta3,limit); 
				limit.gridx = 0; 
				limit.gridy = 3; 
				panel2.add(confirmar,limit);
				limit.gridx = 1;
				limit.gridy = 3; 
				panel2.add(eliminar,limit);
				
				contenidor.add(panel2, BorderLayout.CENTER);
				//FUNCIONS DELS DIFERENTS BOTONS 
				plats.addActionListener(new ActionListener() { //obro la finestra dels plats despres d'apretar el boto 
					public void actionPerformed(ActionEvent ae) {
						new Plats ("Menú dels plats", llistaProducte); 
					}
				});
				begudes.addActionListener(new ActionListener() { // obro la finestra de les begudes despres d'apretar el boto
					public void actionPerformed(ActionEvent ae) {
						new Begudes ("Menú de les begudes", llistaProducte); 
					}
				});
				confirmar.addActionListener(new ActionListener(){ 
					public void actionPerformed(ActionEvent ae){
						
						//llistaClients.afegirComandaClient(id, nova);
						
					}
				});
				eliminar.addActionListener(new ActionListener(){ 
					public void actionPerformed(ActionEvent ae){
						dispose(); 
					}
				
				});
				
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
																   // finestra principal
				setSize(1200, 600); // Mida de la finestra
				setVisible(true);					
					
		 }
	}
	// PLATS 
	class Plats extends JFrame{
		
		private static final long serialVersionUID = 1L;
		
		Plats (String titol, LlistaProducte llistaProducte) {
			
			Container contenidor = getContentPane();
			contenidor.setLayout(new BorderLayout(10, 10));
			contenidor.setBackground(Color.black);
			JPanel panel1 = new JPanel(new BorderLayout());
			JLabel etiqueta = new JLabel("Els plats del menu aniran apareixent un a un, selecciona ''posar al carro'' si vols el producte  ", SwingConstants.LEFT);
			panel1.add(etiqueta); // poso la etiqueta del titol etiqueta del titol 
			contenidor.add(panel1, BorderLayout.PAGE_START);
			// PART DE POSAR UN NOU PRODUCTE 
			JButton carro = new JButton("Posar al carro"); // boto de posar al carro
			carro.setForeground(Color.green);
			JButton seguent = new JButton ( "Següent"); 
			seguent.setForeground(Color.blue);
			// Panel 2
			JPanel panel2 = new JPanel(new GridBagLayout());
			panel1.setBackground(Color.black);

			// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
			GridBagConstraints limit = new GridBagConstraints();
			limit.anchor = GridBagConstraints.WEST;
			limit.insets = new Insets(5, 5, 5, 5);
			limit.gridx = 0;
			limit.gridy = 0;
			panel2.add(etiqueta, limit);  // etiqueta del titol 
			limit.gridx = 0; 
			limit.gridy = 1; 
			panel2.add(seguent,limit); 
			limit.gridx = 0; 
			limit.gridy = 2;  
			panel2.add(carro,limit); 
			limit.gridy = 3; 
			JTextArea textArea = new JTextArea();
			panel2.add(textArea, limit);
			contenidor.add(panel2, BorderLayout.CENTER);
			
			//accio del boto SEGUENT
			seguent.addActionListener(new ActionListener() {
				int i=0; 
				public void actionPerformed(ActionEvent ae) {
		
				textArea.setText(""); 
				textArea.append(llistaProducte.getLlista()[i].toString());
				if( i<= llistaProducte.getnElem()){
					i++;
				}
				}
			});
			
			//accio del boto CARRO
			carro.addActionListener(new ActionListener() {
				
				public void actionPerformed (ActionEvent ae) {
					
					
				
			}
			}); 
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra actual sense afectar la
			// finestra principal
			setSize(800, 800); // Mida de la finestra
			setVisible(true);		
		} 
		
	}
	//BEGUDES 
	class Begudes extends JFrame{
		
		private static final long serialVersionUID = 1L;
		
		Begudes (String titol, LlistaProducte llistaProducte) {
	
			
			Container contenidor = getContentPane();
			contenidor.setLayout(new BorderLayout(10, 10));
			contenidor.setBackground(Color.black);
			JPanel panel1 = new JPanel(new BorderLayout());
			JLabel etiqueta = new JLabel("Les begudes del menu aniran apareixent un a un, selecciona ''posar al carro'' si vols el producte  ", SwingConstants.LEFT);
			panel1.add(etiqueta); // poso la etiqueta del titol etiqueta del titol 
			contenidor.add(panel1, BorderLayout.PAGE_START);
			// PART DE POSAR UN NOU PRODUCTE 
			JButton carro = new JButton("Posar al carro"); // boto de posar al carro
			carro.setForeground(Color.green);
			JButton seguent = new JButton ( "Següent"); 
			seguent.setForeground(Color.blue);
			// Panel 2
			JPanel panel2 = new JPanel(new GridBagLayout());
			panel1.setBackground(Color.black);

			// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
			GridBagConstraints limit = new GridBagConstraints();
			limit.anchor = GridBagConstraints.WEST;
			limit.insets = new Insets(5, 5, 5, 5);
			limit.gridx = 0;
			limit.gridy = 0;
			panel2.add(etiqueta, limit);  // etiqueta del titol 
			limit.gridx = 0; 
			limit.gridy = 1; 
			panel2.add(seguent,limit); 
			limit.gridx = 0; 
			limit.gridy = 2;  
			panel2.add(carro,limit); 
			limit.gridy = 3; 
			JTextArea textArea = new JTextArea();
			panel2.add(textArea, limit);
			
			contenidor.add(panel2, BorderLayout.CENTER);
			
			//accio del boto SEGUENT
			seguent.addActionListener(new ActionListener() { // SEGUENT
				int i=0; 
				int num= 0; 
				public void actionPerformed(ActionEvent ae) {
					
					textArea.setText(""); 
					textArea.append(llistaProducte.getLlista()[i].toString()); // MOSTRA PRODUCTES 
					if( i< llistaProducte.getnElem()){
						num=i; 
						i++;
					}
					else {i=0;} 	
					
					
					carro.addActionListener(new ActionListener() { // CARRO 
						
						public void actionPerformed (ActionEvent ae) {
							
							textArea.setText("");
							textArea.append("Has d'introduir la quantitat");
							// nova finestra de posar quantitat
						}
					}); 
				}
			
			});
			//accio del boto CARRO
		
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra actual sense afectar la
			// finestra principal
			setSize(800, 800); // Mida de la finestra
			setVisible(true);		
		} 
		
	}

	
// Classe Principal
public class Main3 {
	public static LlistaProducte llistaProducte;
	public static LlistaComanda llistaComandes;
	public static LlistaClients llistaClients;
	
	
	public static void main(String[] args) {
		Producte[] llista = new Producte[6];
		Beguda b1 = new Beguda("sprite", 2, 10, 20, false);
		Beguda b2 = new Beguda("fanta", 2.5, 20, 30, false);
		Beguda b3 = new Beguda("fant3a", 2.5, 20, 30, false);
		Beguda b4 = new Beguda("fanta4", 2.5, 20, 30, false);

		Plat p1 = new Plat("Amanida", 5, 20);
		Plat p3 = new Plat("Amanidfsdf", 5, 20);
		String[] Restriccions = { "celiacs", "lactosa", "fruits secs" };
		Plat p2 = new Plat("Sopa", 10, 5, Restriccions);

		llista[0] = b1;
		llista[1] = b2;
		llista[2] = p1;
		llista[3] = p2;
		llista[4] = b3; 
		llista[5] = b4; 

		llistaProducte = new LlistaProducte(12);
		llistaProducte.afegirProducte(b1);
		llistaProducte.afegirProducte(b2);
		llistaProducte.afegirProducte(p1);
		llistaProducte.afegirProducte(p2);
		llistaProducte.afegirProducte(b3);
		llistaProducte.afegirProducte(b4);
		llistaProducte.afegirProducte(p3);
		llistaClients = new LlistaClients();
		String[] tRestr = { "celiacs", "lactosa", "fruits secs" };

		int hora = 0, min = 0;

		Clients Client1 = new Clients("Jose", " avenida Barcelona", "666999444", "jose32", 234, tRestr,
				new LlistaComanda());
		llistaClients.creaClient(Client1);
		Clients Client2 = new Clients("Alex", "avenida Jaume1", "666777444", "alex32", 123, tRestr,
				new LlistaComanda());
		llistaClients.creaClient(Client2);
		Clients Client3 = new Clients("Jordi", "avenida Ramon", "666888444", "jordi32", 543, tRestr,
				new LlistaComanda());
		llistaClients.creaClient(Client3);
		
	
		new Finestra("Restaurant Online", llistaProducte, llistaComandes, llistaClients);

	}
}
