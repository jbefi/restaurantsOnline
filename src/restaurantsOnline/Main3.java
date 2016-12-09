
package restaurantsOnline;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import RestuarantsOnline.Beguda;
import RestuarantsOnline.LlistaProducte;
import RestuarantsOnline.Plat;

import java.util.Objects;


class Finestra extends JFrame {

	private static final long serialVersionUID = 4552817780582259630L;

	// Constructor
	public Finestra(String titol, LlistaProducte llistaProducte, LlistaComanda llistaComandes,
			LlistaClients llistaClients) {
		super(titol);
		// Contenidor de la finestra principal, contÃ© 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));
		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		JLabel etiqueta = new JLabel("BENVIGUT AL NOSTRE RESTAURANT!", SwingConstants.CENTER);
		panel1.add(etiqueta);
		contenidor.add(panel1, BorderLayout.PAGE_START);
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel etiqueta2 = new JLabel("TriÃ¯ una opciÃ³ del menÃº desplegable :");
		// Desplegable ('ComboBox') per mostrar totes les opcions del menÃº
		String[] opcionsMenu = { "Afegir nou producte", "Eliminar producte", "InformaciÃ³ d'un producte", "Crear client","Consultar Client",
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
					new Fines_AfegirProducte("Afegir un nou producte",llistaProducte);
					break;
				case 1:
					// Eliminar producte
					new Fines_eliminarProducte("Eliminar un producte", llistaProducte);
					break;
				case 2:
					// InformaciÃ³ d'un producte
					new Fines_InfoProducte("InformaciÃ³ d'un producte", llistaProducte);
					break;
				case 3:
					// Crear client
					new Fines_CreaClient("Crear client", llistaClients);
					break;
				case 4:
					new Fines_consultarClient("InformaciÃ³ d'un client", llistaClients);
					break;
				case 5:
					new Fines_LlistarComandes("Llistar comandes d'un client", llistaClients);
					break;
				case 6:
					new afegirComanda("Nova Comanda ", llistaProducte, llistaComandes, llistaClients);
					break;
				case 7:
					// Copiar una comanda
					break;
				}
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE); // Per a poder tancar la finestra
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}

//Classe per crear la finestra que serveix per afegir un nou producte
class Fines_AfegirProducte extends JFrame {

	private static final long serialVersionUID = 1L;
	private boolean esPlat, apteCeliacs, apteLactosa, apteFruitsSecs, teAlcohol;

	// Constructor
	public Fines_AfegirProducte(String titol, LlistaProducte llistProds) {
		super(titol);

		// Contenidor de la finestra principal, conté 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));

		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel etiqueta2 = new JLabel("Nom:");
		JLabel etiqueta3 = new JLabel("Preu:");
		JLabel etiqueta4 = new JLabel("Descompte(%):");
		// RadioButtons per triar si és un plat o una beguda
		JRadioButton opcioPlat = new JRadioButton("Plat");
		JRadioButton opcioBeguda = new JRadioButton("Beguda");
		ButtonGroup seleccio = new ButtonGroup(); // Selecció de grup: per a què només pugui triar un dels dos
		seleccio.add(opcioPlat);
		seleccio.add(opcioBeguda);
		JLabel etiqueta5 = new JLabel("Al·lèrigies:");
		// ChckBox per elegir els 3 tipus de restriccions alimentàries
		JCheckBox celiacs = new JCheckBox("Celiacs");
		JCheckBox lactosa = new JCheckBox("Lactosa");
		JCheckBox fruitsSecs = new JCheckBox("Fruïts secs");
		JLabel etiqueta6 = new JLabel("Volum:");
		JTextField campText2 = new JTextField(10);
		JTextField campText3 = new JTextField(10);
		JTextField campText4 = new JTextField(10);
		JTextField campText6 = new JTextField(10);
		JRadioButton opcioTeAlcohol = new JRadioButton("Te Alcohol");
		JButton boto = new JButton("Afegir");

		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.WEST;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(etiqueta2, limit);
		limit.gridx = 1;
		panel2.add(campText2, limit);
		limit.gridx = 0;
		limit.gridy = 1;
		panel2.add(etiqueta3, limit);
		limit.gridx = 1;
		panel2.add(campText3, limit);
		limit.gridx = 0;
		limit.gridy = 2;
		panel2.add(etiqueta4, limit);
		limit.gridx = 1;
		panel2.add(campText4, limit);
		limit.gridx = 0;
		limit.gridy = 3;
		panel2.add(opcioPlat, limit);
		limit.gridx = 1;
		panel2.add(opcioBeguda, limit);
		limit.gridx = 0;
		limit.gridy = 4;
		panel2.add(etiqueta5, limit);
		etiqueta5.setVisible(false);
		limit.gridx = 0;
		limit.gridy = 5;
		panel2.add(celiacs, limit);
		limit.gridx = 1;
		panel2.add(lactosa, limit);
		limit.gridx = 2;
		panel2.add(fruitsSecs, limit);
		celiacs.setVisible(false);
		lactosa.setVisible(false);
		fruitsSecs.setVisible(false);
		limit.gridx = 0;
		limit.gridy = 6;
		panel2.add(etiqueta6, limit);
		limit.gridx = 1;
		panel2.add(campText6, limit);
		limit.gridx = 0;
		limit.gridy = 7;
		panel2.add(opcioTeAlcohol, limit);
		campText6.setVisible(false);
		etiqueta6.setVisible(false);
		opcioTeAlcohol.setVisible(false);
		limit.gridx = 0;
		limit.gridy = 8;
		panel2.add(boto, limit);
		boto.setVisible(false);
		contenidor.add(panel2, BorderLayout.WEST);

		// Acció del radioButton de la tria entre plat i beguda
		opcioPlat.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				int state = event.getStateChange();
				if (state == ItemEvent.SELECTED) {
					// Si l'usuari vol afegir un plat,
					esPlat = true;
					boto.setVisible(true);
					// mostro els components per triar les propietats del plat,
					etiqueta5.setVisible(true);
					celiacs.setVisible(true);
					lactosa.setVisible(true);
					fruitsSecs.setVisible(true);
					// i amago els componets per triar les propietats de les begudes.
					campText6.setVisible(false);
					etiqueta6.setVisible(false);
					opcioTeAlcohol.setVisible(false);
				} else if (state == ItemEvent.DESELECTED) {
					esPlat = false;
					boto.setVisible(true);
					etiqueta5.setVisible(false);
					celiacs.setVisible(false);
					lactosa.setVisible(false);
					fruitsSecs.setVisible(false);
					campText6.setVisible(true);
					etiqueta6.setVisible(true);
					opcioTeAlcohol.setVisible(true);
				}
			}
		});
		opcioBeguda.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				int state = event.getStateChange();
				if (state == ItemEvent.DESELECTED) {
					esPlat = true;
					boto.setVisible(true);
					etiqueta5.setVisible(true);
					celiacs.setVisible(true);
					lactosa.setVisible(true);
					fruitsSecs.setVisible(true);
					campText6.setVisible(false);
					etiqueta6.setVisible(false);
					opcioTeAlcohol.setVisible(false);
				} else if (state == ItemEvent.SELECTED) {
					esPlat = false;
					boto.setVisible(true);
					etiqueta5.setVisible(false);
					celiacs.setVisible(false);
					lactosa.setVisible(false);
					fruitsSecs.setVisible(false);
					campText6.setVisible(true);
					etiqueta6.setVisible(true);
					opcioTeAlcohol.setVisible(true);
				}
			}
		});

		// Acció del radioButton de TeAlcohol
		opcioTeAlcohol.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				int state = event.getStateChange();
				if (state == ItemEvent.SELECTED) {
					teAlcohol = true;
				} else if (state == ItemEvent.DESELECTED) {
					teAlcohol = false;
				}
			}
		});

		// Accions del botó
		boto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// Accions del checkbox de les al·lèrgies
				if (celiacs.isSelected()) {
					apteCeliacs = true;
				} else {
					apteCeliacs = false;
				}
				if (lactosa.isSelected()) {
					apteLactosa = true;
				} else {
					apteLactosa = false;
				}
				if (fruitsSecs.isSelected()) {
					apteFruitsSecs = true;
				} else {
					apteFruitsSecs = false;
				}
				String nom = campText2.getText();
				double preu = Double.parseDouble(campText3.getText());
				double descompte = Double.parseDouble(campText4.getText());
				if (esPlat) {
					// El producte nou és un plat
					Plat platNou;
					if (apteCeliacs || apteLactosa || apteFruitsSecs) {
						// En el cas que hagi seleccionat un o més al·lèrgia,
						String[] alergies = new String[3];
						int i = 0;
						if (apteCeliacs)
							alergies[i++] = "Celiacs";
						if (apteLactosa)
							alergies[i++] = "Lactosa";
						if (apteFruitsSecs)
							alergies[i++] = "Fruits secs";
						for (int j = i; j < 3; j++)
							alergies[j] = "";
						platNou = new Plat(nom, preu, descompte, alergies);

					} else {
						// aquí el plat nou no conté cap al·lèrgia
						platNou = new Plat(nom, preu, descompte);
					}
					llistProds.afegirProducte(platNou);
				} else {
					// El producte nou és una beguda
					int volum = Integer.parseInt(campText6.getText());
					Beguda begudaNou = new Beguda(nom, preu, descompte, volum, teAlcohol);
					llistProds.afegirProducte(begudaNou);
				}
				dispose(); // Per tancar la finestra actual al pulsar el botó d'afegir
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
		// finestra principal
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}

// Classe per crear la finestra que serveix per consultar tota la informaciÃ³ d'un producte de la llista.
class Fines_InfoProducte extends JFrame {

	private static final long serialVersionUID = 1L;

	// Constructor
	public Fines_InfoProducte(String titol, LlistaProducte llistProds) {
		super(titol);
		// Contenidor de la finestra principal, contÃ© 2 panels horitzontals
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

		// Accions del botÃ³
		boto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String valor = campText.getText(); // Agafo el codi del camp de text
				int codi = Integer.parseInt(valor);
				textArea.setText(""); // Esborro tot el contingut anterior de Text Area
				textArea.append(llistProds.informacio(codi)); // Mostro la informaciÃ³
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
				JLabel etiqueta2 = new JLabel("TriÃ¯ una opciÃ³ per a veure la nostra disponibilitat de productes i escollir-los :"); 
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
						new Plats ("MenÃº dels plats", llistaProducte); 
					}
				});
				begudes.addActionListener(new ActionListener() { // obro la finestra de les begudes despres d'apretar el boto
					public void actionPerformed(ActionEvent ae) {
						new Begudes ("MenÃº de les begudes", llistaProducte); 
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
			JButton seguent = new JButton ( "SegÃ¼ent"); 
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
			JButton seguent = new JButton ( "SegÃ¼ent"); 
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

	

//////////////////////////////////CREAR CLIENT//////////////////////////////////////////////////////

//Classe per crear la finestra que serveix per crear un nou client
class Fines_CreaClient extends JFrame {

	private static final long serialVersionUID = 1L;

	// Constructor
	public Fines_CreaClient(String titol, LlistaClients llistacl) {
		super(titol);
		// Contenidor de la finestra principal, conté 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));
		
		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("CREANT NOU CLIENT", SwingConstants.CENTER);
		panel1.add(etiqueta, SwingConstants.CENTER);
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel etiqueta2 = new JLabel("Nom:");
		JLabel etiqueta3 = new JLabel("Adreca:");
		JLabel etiqueta4 = new JLabel("Telefon:");
		JLabel etiqueta5 = new JLabel("Usuari:");
		JLabel etiqueta6 = new JLabel("Contrasenya:");
		JLabel etiqueta7 = new JLabel("Restriccions");
		JTextField campText2 = new JTextField(10);
		JTextField campText3 = new JTextField(10);
		JTextField campText4 = new JTextField(10);
		JTextField campText5 = new JTextField(10);
		JTextField campText6 = new JTextField(10);
		JButton boto = new JButton("Crear");
		
		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.WEST;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(etiqueta2, limit);
		limit.gridx = 1;
		panel2.add(campText2, limit);
		limit.gridx = 0;
		limit.gridy = 1;
		panel2.add(etiqueta3, limit);
		limit.gridx = 1;
		panel2.add(campText3, limit);
		limit.gridx = 0;
		limit.gridy = 2;
		panel2.add(etiqueta4, limit);
		limit.gridx = 1;
		panel2.add(campText4, limit);
		limit.gridx = 0;
		limit.gridy = 3;
		panel2.add(etiqueta5, limit);
		limit.gridx = 1;
		panel2.add(campText5, limit);
		limit.gridx = 0;
		limit.gridy = 4;
		panel2.add(etiqueta6, limit);
		limit.gridx = 1;
		panel2.add(campText6, limit);
		limit.gridx = 0;
		limit.gridy = 5;
		panel2.add(etiqueta7, limit);
		limit.gridx = 1;
		JCheckBox Click = new JCheckBox();
		panel2.add(Click, limit);
		limit.gridx = 1;
		limit.gridy = 6;
		panel2.add(boto, limit);
		limit.gridx = 3;
		limit.gridy = 2;
		JTextArea textArea = new JTextArea();
		panel2.add(textArea, limit);
		
		contenidor.add(panel2, BorderLayout.WEST);
		
		String[] restriccions = new String[3];

		Click.addItemListener(new ItemListener() {
			@Override
				public void itemStateChanged(ItemEvent e) {
				
					if(e.getStateChange() == ItemEvent.SELECTED) {//si se ha seleccionado
				
							new Fines_Restriccions(restriccions, llistacl);
					};
				}
		});

		// Accions del botó
		boto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
	
				String nom = campText2.getText(); // Agafo el nom
				String adreca = campText3.getText(); // Agafo la adreca
				String telefon = campText4.getText(); // Agafo el telefon
				String usuari = campText5.getText(); // Agafo el usuari
				String aux = campText6.getText(); // Agafo la contrasenya
				int contrasenya = Integer.parseInt(aux);
				Clients client = new Clients(nom, adreca, telefon, usuari, contrasenya, restriccions);
				llistacl.creaClient(client); // Afegir a la llista de Clients
				dispose();
				new Fines_Registrat(client);
	
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
									// finestra principal
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}

//Classe per determinar les restriccions del nou client
class Fines_Restriccions extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Constructor
	public Fines_Restriccions(String[] restriccions, LlistaClients llistacl) {
		// Contenidor de la finestra principal, conté 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));
		
		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("RESTRICCIONS", SwingConstants.CENTER);
		panel1.add(etiqueta, SwingConstants.CENTER);
		
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel etiqueta2 = new JLabel("Celiacs");
		JLabel etiqueta3 = new JLabel("Lactosa");
		JLabel etiqueta4 = new JLabel("Fruit secs");
		JCheckBox Click2 = new JCheckBox();
		JCheckBox Click3 = new JCheckBox();
		JCheckBox Click4 = new JCheckBox();
		
		JButton boto = new JButton("Aceptar");
		
		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.CENTER;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(etiqueta2, limit);
		limit.gridx = 1;
		panel2.add(Click2, limit);
		limit.gridx = 0;
		limit.gridy = 1;
		panel2.add(etiqueta3, limit);
		limit.gridx = 1;
		panel2.add(Click3, limit);
		limit.gridx = 0;
		limit.gridy = 2;
		panel2.add(etiqueta4, limit);
		limit.gridx = 1;
		panel2.add(Click4, limit);
		limit.gridx = 1;
		limit.gridy = 6;
		panel2.add(boto, limit);
		limit.gridx = 4;
		limit.gridy = 2;
		JTextArea textArea = new JTextArea();
		panel2.add(textArea, limit);
		limit.gridx = 4;
		limit.gridy = 5;
		JTextArea textArea1 = new JTextArea();
		panel2.add(textArea1, limit);
		limit.gridx = 4;
		limit.gridy = 6;
		JTextArea textArea2 = new JTextArea();
		panel2.add(textArea2, limit);
		limit.gridx = 4;
		limit.gridy = 7;
		JTextArea textArea3 = new JTextArea();
		panel2.add(textArea3, limit);
		
		contenidor.add(panel2, BorderLayout.CENTER);
		
		// Accions del botó
		boto.addActionListener(new ActionListener() {
			
			int i = 0;

			public void actionPerformed(ActionEvent ae) {
			
				i = 0;
				restriccions[0] = null;
				restriccions[1] = null;
				restriccions[2] = null;
				
				if (Click2.isSelected())
				{
				restriccions[i] = "Celiacs";
				i++;
				}
				if (Click3.isSelected())
				{
				restriccions[i] = "Lactosa";
				i++;
				}
				if (Click4.isSelected())
				{
				restriccions[i] = "Fruits secs";
				i++;
				}
	
				dispose();
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
									// finestra principal
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}

//Classe client resgistrat
class Fines_Registrat extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Constructor
	public Fines_Registrat(Clients client) {
		// Contenidor de la fiestra principal, conté 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));
		
		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("USUARI CREAT", SwingConstants.CENTER);
		panel1.add(etiqueta, SwingConstants.CENTER);
		
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JButton boto = new JButton("Aceptar");
		
		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.CENTER;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		JTextArea textArea = new JTextArea();
		panel2.add(textArea, limit);
		limit.gridx = 0;
		limit.gridy = 3;
		panel2.add(boto, limit);
		
		contenidor.add(panel2, BorderLayout.CENTER);
		
		// Accions del botó
		boto.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});
		
		textArea.append("L'usuari: "+client.getUsuari()+ " s'ha registrat amb exit"); // Mostro la informació
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// Per a poder tancar la finestra atual sense afectar la
															// finestra principal
		setSize(250, 200); // Mida de la finestra
		setVisible(true);
	}
}

////////////////////////////////////////CONSULTAR COMANDES////////////////////////////////////////////////
//Classe per consultar les comandes del client
class Fines_LlistarComandes extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Constructor
	public Fines_LlistarComandes(String titol, LlistaClients llistacl) {
		// Contenidor de la fiestra principal, conté 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));
		
		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("CONSULTAR COMANDES", SwingConstants.CENTER);
		panel1.add(etiqueta, SwingConstants.CENTER);
		
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel etiqueta1 = new JLabel("Usuari:");
		JLabel etiqueta2 = new JLabel("Contrasenya:");
		JTextField campText1 = new JTextField(10);
		JTextField campText2 = new JTextField(10);
		JButton boto = new JButton("CONSULTAR");
		
		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.CENTER;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(etiqueta1, limit);
		limit.gridx = 1;
		panel2.add(campText1, limit);
		limit.gridx = 0;
		limit.gridy = 1;
		panel2.add(etiqueta2, limit);
		limit.gridx = 1;
		panel2.add(campText2, limit);
		limit.gridx = 3;
		panel2.add(boto, limit);
		limit.gridx = 3;
		limit.gridy = 2;
		JTextArea textArea = new JTextArea();
		panel2.add(textArea, limit);
		
		contenidor.add(panel2, BorderLayout.CENTER);
		
		// Accions del botó
		boto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
			
				String usu = campText1.getText(); // Agafo el nom
				String pass = campText2.getText(); // Agafo la adreca
				//LLAMAR A UNA FUNCION QUE NOS DIGA LA POSICION DE LA LISTA DEL CLIENTE
				
				
				int i = 0;
				i = llistacl.consultar_Client(usu);
				if (Objects.equals(llistacl.getLlista()[i].getContrasenya(), pass))
				{
				dispose();
				new Fines_MostrarComandes(llistacl.getLlista()[i].getComandes());	
				}
				else{
				textArea.append("L'usuari o contrasenya son incorrectes"); // Mostro la informació
				}
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
									// finestra principal
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}

//Classe que mostra les comandes del client
class Fines_MostrarComandes extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Constructor
	public Fines_MostrarComandes(LlistaComanda llistacom) {
		// Contenidor de la fiestra principal, conté 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));
		
		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("CONSULTAR COMANDES", SwingConstants.CENTER);
		panel1.add(etiqueta, SwingConstants.CENTER);
		
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel etiqueta1 = new JLabel("Usuari:");
		JLabel etiqueta2 = new JLabel("Contrasenya:");
		JTextField campText1 = new JTextField(10);
		JTextField campText2 = new JTextField(10);
		JButton boto = new JButton("FINALITZAR");
		
		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.CENTER;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(etiqueta1, limit);
		limit.gridx = 1;
		panel2.add(campText1, limit);
		limit.gridx = 0;
		limit.gridy = 1;
		panel2.add(etiqueta2, limit);
		limit.gridx = 1;
		panel2.add(campText2, limit);
		limit.gridx = 3;
		panel2.add(boto, limit);
		limit.gridx = 3;
		limit.gridy = 2;
		JTextArea textArea = new JTextArea();
		panel2.add(textArea, limit);
		
		
		contenidor.add(panel2, BorderLayout.CENTER);
		
		//LLAMAR AL TO STRING DE LAS COMANDAS Y IMPRIMIRLO
		textArea.append(llistacom.toString()); // Mostro la informació
		
		// Accions del botó
		boto.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent ae) {
			
				dispose();
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// Per a poder tancar la finestra atual sense afectar la
															// finestra principal
		setSize(500, 400); // Mida de la finestra
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
