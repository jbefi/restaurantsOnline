
package fase3_IG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import restaurantsOnline.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase per crear la finestra principal on cont� un desplegable de totes les opcions del men�
 * 
 * @author Enyu Lin
 */
class Finestra extends JFrame {

	private static final long serialVersionUID = 4552817780582259630L;

	/**
	 * Constructor
	 * 
	 * @param titol
	 *            el t�tol de la finestra
	 * @param llistaProducte
	 *            la llista on cont� tots els productes.
	 * @param llistaComandes
	 *            la llista de totes les comandes.
	 * @param llistaClients
	 *            la llista de tots els clients.
	 */
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
		String[] opcionsMenu = { "Afegir nou producte", "Eliminar producte", "Informació d'un producte",
				"Crear client", "Consultar Client", "Llistar comandes d'un client", "Nova comanda per client",
				"Copiar una comanda" };
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
					new Fines_AfegirProducte("Afegir un nou producte", llistaProducte);
					break;
				case 1:
					// Eliminar producte
					new Fines_eliminarProducte("Eliminar un producte", llistaProducte);
					break;
				case 2:
					// Informació d'un producte
					new Fines_InfoProducte("Informació d'un producte", llistaProducte);
					break;
				case 3:
					// Crear client
					new Fines_CreaClient("Crear client", llistaClients);
					break;
				case 4:
					new Fines_consultarClient("Informació d'un client", llistaClients);
					break;
				case 5:
					new Fines_LlistarComandes("Llistar comandes d'un client", llistaClients);
					break;
				case 6:
					new Contrasenya("Autentifica't al sistema", llistaClients, llistaProducte, llistaComandes);
					break;
				case 7:
					new ContrasenyaComanda(titol, llistaClients, llistaProducte, llistaComandes);
					break;
				}
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE); // Per a poder tancar la finestra
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}

/**
 * Classe per crear la finestra que serveix per afegir un nou producte
 * 
 * @author Enyu Lin
 */
class Fines_AfegirProducte extends JFrame {

	private static final long serialVersionUID = 1L;
	private boolean esPlat, apteCeliacs, apteLactosa, apteFruitsSecs, teAlcohol;

	/**
	 * Constructor
	 * 
	 * @param titol
	 *            el t�tol de la finestra.
	 * @param llistProds
	 *            la llista de tots els productes.
	 */
	public Fines_AfegirProducte(String titol, LlistaProducte llistProds) {
		super(titol);

		// Contenidor de la finestra principal, cont� 2 panels horitzontals
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
		// RadioButtons per triar si �s un plat o una beguda
		JRadioButton opcioPlat = new JRadioButton("Plat");
		JRadioButton opcioBeguda = new JRadioButton("Beguda");
		ButtonGroup seleccio = new ButtonGroup(); // Selecci� de grup: per a qu� nom�s pugui triar un dels dos
		seleccio.add(opcioPlat);
		seleccio.add(opcioBeguda);
		JLabel etiqueta5 = new JLabel("Al�l�rigies:");
		// ChckBox per elegir els 3 tipus de restriccions aliment�ries
		JCheckBox celiacs = new JCheckBox("Celiacs");
		JCheckBox lactosa = new JCheckBox("Lactosa");
		JCheckBox fruitsSecs = new JCheckBox("Fru�ts secs");
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

		// Acci� del radioButton de la tria entre plat i beguda
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

		// Acci� del radioButton de TeAlcohol
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

		// Accions del bot�
		boto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// Accions del checkbox de les al�l�rgies
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
					// El producte nou �s un plat
					Plat platNou;
					if (apteCeliacs || apteLactosa || apteFruitsSecs) {
						// En el cas que hagi seleccionat un o m�s al�l�rgia,
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
						// aqu� el plat nou no cont� cap al�l�rgia
						platNou = new Plat(nom, preu, descompte);
					}
					llistProds.afegirProducte(platNou);
				} else {
					// El producte nou �s una beguda
					int volum = Integer.parseInt(campText6.getText());
					Beguda begudaNou = new Beguda(nom, preu, descompte, volum, teAlcohol);
					llistProds.afegirProducte(begudaNou);
				}
				dispose(); // Per tancar la finestra actual al pulsar el bot� d'afegir
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
		// finestra principal
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}

/**
 * Classe per crear la finestra que serveix per consultar tota la informació d'un producte de la llista.
 * 
 * @author Enyu Lin
 *
 */
class Fines_InfoProducte extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param titol
	 * @param llistProds
	 */
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


// ****** ELIMINAR PRODUCTE DE LA LLISTA *******
/**
 * Classe per crear la finestra que serveix per eliminar un producte de la llista.
 * 
 * @author Catalin-Mihai Salvan
 *
 */
class Fines_eliminarProducte extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param titol
	 * @param llistProds
	 */
	public Fines_eliminarProducte(String titol, LlistaProducte llistaProducte) {
		super(titol);

		Container cont = getContentPane();
		cont.setLayout(new BorderLayout(10, 10));
		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		cont.add(panel1, BorderLayout.PAGE_START);
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel et2 = new JLabel("Introdueixi el codi del producte de la finestra que vol eliminar ");
		JButton veure = new JButton("Veure llista"); 
		JTextField campText = new JTextField(5);
		JButton boto = new JButton("Eliminar");
		boto.setForeground(Color.red);
		veure.setForeground(Color.blue);

		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.WEST;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(et2, limit);
		limit.gridy = 1;
		panel2.add(campText, limit);
		limit.gridy = 2;
		panel2.add(boto, limit);
		limit.gridx = 1;
		limit.gridy = 4; 
		panel2.add(veure,limit);
		
		cont.add(panel2, BorderLayout.CENTER);
		
		boto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String valor = campText.getText(); //
				int codi = Integer.parseInt(valor);
				llistaProducte.eliminarProducte(codi); // eliminar producte
				dispose(); 
			}
		});
		
		veure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new Fines_MostrarProductes(llistaProducte);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 400);
		setVisible(true);
	}
}

// ********************** AFEGIR COMANDA *************************

/**
 * Classe que serveix per crear la finestra per obrir una nova comanda.
 * 
 * @author Catalin-Mihai Salvan
 *
 */
class afegirComanda extends JFrame {

	private static final long serialVersionUID = 1L;
	boolean quantitat = false;
	String producte, auxt;
	int num, aux;
	Comanda nova = new Comanda(new LlistaProducte(50), 0, 0, 0); // creo una nova comanda buida

	/**
	 * Constructor
	 * 
	 * @param titol
	 * @param llistaProducte
	 * @param llistaComandes
	 * @param llistaClients
	 * @param preferent
	 * @param id
	 */
	afegirComanda(String titol, LlistaProducte llistaProducte, LlistaComanda llistaComandes,
			LlistaClients llistaClients, boolean preferent, int id) {
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
		JLabel etiqueta2 = new JLabel("Si apreta el boto de ´veure´, se li mostrara una llista de productes:");
		// PART VEURE PRODUCTES
		JButton veure = new JButton("Veure");
		JTextArea textArea = new JTextArea();

		// PART CREAR COMANDA
		//
		JLabel etiqueta3 = new JLabel("Esculli un producte de la llista (nom)");
		JTextField campText1 = new JTextField(10);
		JButton continuar = new JButton("Continuar");
		continuar.setForeground(Color.blue);
		JLabel etiqueta4 = new JLabel("Quantitat del producte? ");
		JTextField campText2 = new JTextField(10);
		JButton posar = new JButton("Posar al carro");
		posar.setForeground(Color.green);
		JButton fer = new JButton("Fer Comanda");
		fer.setForeground(Color.green);
		JTextArea textArea1 = new JTextArea();
		JButton confComanda = new JButton("Confirmar Comanda");
		confComanda.setForeground(Color.green);

		// DEFINIM LIMITACIONS DEL PANEL
		GridBagConstraints limit = new GridBagConstraints();
		// ANEM POSANT ELS DIFERENTS ELEMENTS
		limit.anchor = GridBagConstraints.WEST;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(etiqueta2, limit);
		limit.gridx = 1;
		limit.gridy = 0;
		panel2.add(veure, limit);
		limit.gridx = 1;
		limit.gridy = 1;
		panel2.add(textArea, limit);
		etiqueta2.setVisible(true);
		veure.setVisible(true);
		textArea.setVisible(false);
		limit.gridx = 0;
		panel2.add(etiqueta3, limit);
		limit.gridy = 2;
		panel2.add(campText1, limit);
		limit.gridy = 3;
		panel2.add(continuar, limit);
		etiqueta3.setVisible(false);
		campText1.setVisible(false);
		continuar.setVisible(false);
		limit.gridy = 4;
		panel2.add(etiqueta4, limit);
		limit.gridy = 5;
		panel2.add(campText2, limit);
		limit.gridy = 6;
		panel2.add(posar, limit);
		etiqueta4.setVisible(false);
		campText2.setVisible(false);
		posar.setVisible(false);
		limit.gridx = 1;
		limit.gridy = 8;
		panel2.add(fer, limit);
		fer.setVisible(false);
		limit.gridx = 0;
		limit.gridy = 1;
		panel2.add(confComanda, limit);
		limit.gridx = 0;
		limit.gridy = 4;
		panel2.add(textArea1, limit);
		confComanda.setVisible(false);
		textArea1.setVisible(false);

		contenidor.add(panel2, BorderLayout.CENTER);
		// FUNCIONS DELS DIFERENTS BOTONS

		veure.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				new Fines_MostrarProductes(llistaProducte);
				etiqueta3.setVisible(true);
				campText1.setVisible(true);
				continuar.setVisible(true);
				fer.setVisible(true);
			}
		});
		continuar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				producte = campText1.getText();
				quantitat = true;
				if (quantitat) {
					etiqueta4.setVisible(true);
					campText2.setVisible(true);
					posar.setVisible(true);
				}
			}
		});
		posar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				auxt = campText2.getText();
				aux = Integer.parseInt(auxt);
				aux = nova.afegirElement(producte, llistaProducte, aux, preferent); // afegim un nou element a la
																					// comanda

				if (aux == -1) {
					System.out.println("No hi ha l'element"); // si l'element no existeix, informo al client
				}
				auxt = "";
				aux = 0;
				etiqueta4.setVisible(false);
				campText2.setVisible(false);
				posar.setVisible(false);
			}
		});

		fer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				textArea.setVisible(false);
				etiqueta3.setVisible(false);
				campText1.setVisible(false);
				continuar.setVisible(false);
				confComanda.setVisible(true);

				Calendar horaComanda = new GregorianCalendar(); // crido aixo per tenir l'hora actual i poder afergir-la
																// a la comanda
				int hora, minut;

				hora = horaComanda.get(Calendar.HOUR_OF_DAY);
				minut = horaComanda.get(Calendar.MINUTE);

				nova.setHora(hora);
				nova.setMinut(minut);

				new Fines_MostrarComanda(nova);
			}
		});
		confComanda.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				llistaClients.afegirComandaClient(id, nova);
				System.out.println(nova);
				dispose();

			}
		});

		System.out.println(nova);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
															// finestra principal
		setSize(650, 500); // Mida de la finestra
		setVisible(true);

	}
}

/**
 * Classe per crear la finestra que mostra la comanda per a poder confirmar-la.
 * 
 * @author Catalin-Mihai Salvan
 *
 */
class Fines_MostrarComanda extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param nova
	 */
	public Fines_MostrarComanda(Comanda nova) {
		// Contenidor de la fiestra principal, cont� 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));

		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("Els productes de la teva comanda son aquests:", SwingConstants.CENTER);
		panel1.add(etiqueta, SwingConstants.CENTER);
		JButton boto = new JButton("Finalitzar");
		contenidor.add(boto, BorderLayout.PAGE_END);

		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());

		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.CENTER;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 1;
		JTextArea textArea = new JTextArea();
		panel2.add(textArea, limit);
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		contenidor.add(panel2, BorderLayout.CENTER);

		// LLAMAR AL TO STRING DE LAS COMANDAS Y IMPRIMIRLO
		textArea.append(nova.toString()); // Mostro la informacio
		contenidor.add(scroll);

		// Accions del bot�
		boto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
															// finestra principal
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}

/**
 * Classe per crear la finestra que mostra els productes
 * 
 * @author Catalin-Mihai Salvan
 *
 */
class Fines_MostrarProductes extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param llistaproducte
	 */
	public Fines_MostrarProductes(LlistaProducte llistaproducte) {
		// Contenidor de la fiestra principal, cont� 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));

		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("Els productes son els seguents", SwingConstants.CENTER);
		panel1.add(etiqueta, SwingConstants.CENTER);
		JButton boto = new JButton("Finalitzar");
		contenidor.add(boto, BorderLayout.PAGE_END);

		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());

		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.CENTER;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 1;
		JTextArea textArea = new JTextArea();
		panel2.add(textArea, limit);
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		contenidor.add(panel2, BorderLayout.CENTER);

		// LLAMAR AL TO STRING DE LAS COMANDAS Y IMPRIMIRLO
		textArea.append(llistaproducte.toString()); // Mostro la informacio
		contenidor.add(scroll);

		// Accions del bot�
		boto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
															// finestra principal
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}

/**
 * Classe que crea una finestra per l'autentificaci� del client.
 * 
 * @author Catalin-Mihai Salvan
 *
 */
class Contrasenya extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param titol
	 * @param llistaClients
	 * @param llistaProducte
	 * @param llistaComanda
	 */
	Contrasenya(String titol, LlistaClients llistaClients, LlistaProducte llistaProducte, LlistaComanda llistaComanda) {

		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));

		// panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("Autentifica't", SwingConstants.CENTER);
		panel1.add(etiqueta, SwingConstants.CENTER);

		// panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());

		JLabel etiqueta1 = new JLabel("Usuari:");
		JLabel etiqueta2 = new JLabel("Contrasenya (numeros):");

		JTextField campText = new JTextField(10);
		JTextField campText2 = new JTextField(10);

		JButton entrar = new JButton("Entrar");
		entrar.setForeground(Color.blue);
		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.WEST;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(etiqueta1, limit);
		limit.gridx = 1;
		panel2.add(campText, limit);
		limit.gridx = 0;
		limit.gridy = 1;
		panel2.add(etiqueta2, limit);
		limit.gridx = 1;
		panel2.add(campText2, limit);
		limit.gridx = 0;
		limit.gridy = 2;
		panel2.add(entrar, limit);

		contenidor.add(panel2, BorderLayout.CENTER);
		// accio del boto ENTRAR
		entrar.addActionListener(new ActionListener() { // ENTRAR

			public void actionPerformed(ActionEvent ae) {
				boolean existeix1, existeix2, preferent;
				existeix1 = false;
				existeix2 = false;
				preferent = false;
				int i = 0;
				int j = 0;
				int id = 0;
				String usuari = campText.getText();
				String aux = campText2.getText();
				int contrasenya = Integer.parseInt(aux);

				while ((i < llistaClients.getnClients()) && ((!existeix1) && (!existeix2))) {

					if (usuari.equals(llistaClients.getLlista()[i].getUsuari())) {
						existeix1 = true;
					}
					if (contrasenya == (llistaClients.getLlista()[i].getContrasenya())) {
						existeix2 = true;
					}
					j = i;
					i++;
				}

				if (existeix1 && existeix2) {
					preferent = llistaClients.passa_Preferent(llistaClients.getLlista()[j]);

					id = llistaClients.getLlista()[j].getIdentificador();
					new afegirComanda("Afegir Comanda", llistaProducte, llistaComanda, llistaClients, preferent, id);
				}

				else {

					new noCorrecte();

				}

			}

		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra actual sense afectar la
		// finestra principal
		setSize(400, 400); // Mida de la finestra
		setVisible(true);

	}
}
/**
 * Classe per crear la finestra per informar que l'autentificaci� del client �s incorrecte.
 * @author Catalin-Mihai Salvan
 *
 */
class noCorrecte extends JFrame {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 */
	public noCorrecte() {
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));

		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("Autentifica't", SwingConstants.CENTER);
		panel1.add(etiqueta, SwingConstants.CENTER);
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel etiqueta2 = new JLabel("L'USUARI NO ES CORRECTE!");

		JButton eliminar = new JButton("Tancar");
		eliminar.setForeground(Color.RED);

		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.WEST;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(etiqueta2, limit);
		limit.gridy = 1;
		panel2.add(eliminar, limit);
		contenidor.add(panel2, BorderLayout.WEST);

		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}

		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra actual sense afectar la
		// finestra principal
		setSize(200, 200); // Mida de la finestra
		setVisible(true);

	}
}

////// COPIAR COMANDA ///////
/**
 * Classe per crear la finestra per demanar l'autentificaci� del client
 * @author Catalin-Mihai Salvan
 *
 */
class ContrasenyaComanda extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * Constructor
	 * @param titol
	 * @param llistaClients
	 * @param llistaProducte
	 * @param llistaComanda
	 */
	ContrasenyaComanda(String titol, LlistaClients llistaClients, LlistaProducte llistaProducte,
			LlistaComanda llistaComanda) {

		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));

		// panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("Autentifica't", SwingConstants.CENTER);
		panel1.add(etiqueta, SwingConstants.CENTER);

		// panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());

		JLabel etiqueta1 = new JLabel("Usuari:");
		JLabel etiqueta2 = new JLabel("Contrasenya (numeros):");

		JTextField campText = new JTextField(10);
		JTextField campText2 = new JTextField(10);

		JButton entrar = new JButton("Entrar");
		entrar.setForeground(Color.blue);
		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.WEST;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(etiqueta1, limit);
		limit.gridx = 1;
		panel2.add(campText, limit);
		limit.gridx = 0;
		limit.gridy = 1;
		panel2.add(etiqueta2, limit);
		limit.gridx = 1;
		panel2.add(campText2, limit);
		limit.gridx = 0;
		limit.gridy = 2;
		panel2.add(entrar, limit);

		contenidor.add(panel2, BorderLayout.CENTER);
		// accio del boto ENTRAR
		entrar.addActionListener(new ActionListener() { // ENTRAR

			public void actionPerformed(ActionEvent ae) {
				boolean existeix1, existeix2;
				existeix1 = false;
				existeix2 = false;

				int i = 0;
				int j = 0;
				int id = 0;
				String usuari = campText.getText();
				String aux = campText2.getText();
				int contrasenya = Integer.parseInt(aux);

				while ((i < llistaClients.getnClients()) && ((!existeix1) && (!existeix2))) {

					if (usuari.equals(llistaClients.getLlista()[i].getUsuari())) {
						existeix1 = true;
					}
					if (contrasenya == (llistaClients.getLlista()[i].getContrasenya())) {
						existeix2 = true;
					}
					j = i;
					i++;
				}

				if (existeix1 && existeix2) {

					id = llistaClients.getLlista()[j].getIdentificador();
					new CopiarComanda(llistaClients, llistaComanda, llistaProducte, id);
				}

				else {

					new noCorrecte();

				}

			}

		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra actual sense afectar la
		// finestra principal
		setSize(400, 400); // Mida de la finestra
		setVisible(true);

	}
}

/**
 * Classe per crear la finestra per copiar una comanda existent
 * @author Catalin-Mihai Salvan
 *
 */
class CopiarComanda extends JFrame {
	private static final long serialVersionUID = 1L;
	int aux = 0;
	String auxt = "";
	
	/**
	 * Constructor
	 * @param llistaClients
	 * @param llistaComanda
	 * @param llistaProducte
	 * @param id
	 */
	public CopiarComanda(LlistaClients llistaClients, LlistaComanda llistaComanda, LlistaProducte llistaProducte,
			int id) {
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));

		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("** Copiar comanda ** ", SwingConstants.CENTER);

		// PANEL 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel etiqueta2 = new JLabel("Si apreta el boto de ´veure´, se li mostrara la seva llista de comandes:");
		JLabel etiqueta3 = new JLabel("Introdueixi el identificador de la comanda que vol copiar");
		// PART Copiar comanda
		JButton veure = new JButton("Veure");
		veure.setForeground(Color.blue);
		JButton copiar = new JButton("Copiar");
		copiar.setForeground(Color.green);
		JTextField campText = new JTextField(3);

		// DEFINIM LIMITACIONS DEL PANEL
		GridBagConstraints limit = new GridBagConstraints();
		// ANEM POSANT ELS DIFERENTS ELEMENTS
		limit.anchor = GridBagConstraints.WEST;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(etiqueta, limit);
		limit.gridx = 0;
		limit.gridy = 1;
		panel2.add(etiqueta2, limit);
		limit.gridx = 1;
		panel2.add(veure, limit);
		limit.gridx = 0;
		limit.gridy = 2;
		panel2.add(etiqueta3, limit);
		limit.gridx = 0;
		limit.gridy = 3;
		panel2.add(campText, limit);
		limit.gridx = 1;
		panel2.add(copiar, limit);
		campText.setVisible(false);
		copiar.setVisible(false);
		etiqueta3.setVisible(false);

		contenidor.add(panel2, BorderLayout.CENTER);
		// FUNCIONS DELS DIFERENTS BOTONS

		veure.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				new Fines_MostrarComandes(llistaClients.consultar_Comandes(id));
				campText.setVisible(true);
				copiar.setVisible(true);
				etiqueta3.setVisible(true);

			}
		});
		copiar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				auxt = campText.getText();
				aux = Integer.parseInt(auxt);
				llistaClients.copiar_Comanda(id, aux);
				dispose();
			}

		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra actual sense afectar la
		// finestra principal
		setSize(600, 300); // Mida de la finestra
		setVisible(true);

	}

}


//////////////////////////////////CONSULTAR CLIENT//////////////////////////////////////////////////////
/**
 * Classe per crear la finestra per consultar la informaci� d'un client.
 * 
 * @author Pablo Paradinas Prieto
 *
 */
class Fines_consultarClient extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param titol
	 * @param llistClient
	 */
	public Fines_consultarClient(String titol, LlistaClients llistacl) {

		//Contenidor de la fiestra principal, cont� 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));

		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("CONSULTAR CLIENT", SwingConstants.CENTER);
		panel1.add(etiqueta, SwingConstants.CENTER);

		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel etiqueta1 = new JLabel("Usuari:");
		JLabel etiqueta2 = new JLabel("Contrasenya: (numeros)");
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

		// Accions del bot�
		boto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				String usu = campText1.getText(); // Agafo el nom
				String contrasenya = campText2.getText(); // Agafo la contrasenya del camp de text
				int pass = Integer.parseInt(contrasenya); // Agafo la contrasenya
				// LLAMAR A UNA FUNCION QUE NOS DIGA LA POSICION DE LA LISTA DEL CLIENTE

				int i = 0;
				i = llistacl.consultar_Client(usu);
				if ((i == -1) || (llistacl.getLlista()[i].getContrasenya()) != pass) {
					new Fines_Incorrecte();

				} else {
					dispose();
					new Fines_MuestraCliente(llistacl.getLlista()[i]);
				}
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
		// finestra principal
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}


/**
 * Classe que mostra el client consultat
 * @author Pablo Paradinas Prieto
 *
 */
class Fines_MuestraCliente extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param titol
	 * @param llistacl
	 */
	public Fines_MuestraCliente(Clients client) {

		// Contenidor de la finestra principal, cont� 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));

		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("CLIENT", SwingConstants.CENTER);
		panel1.add(etiqueta, SwingConstants.CENTER);
		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel etiqueta2 = new JLabel("Nom:");
		JLabel etiqueta3 = new JLabel("Adreca:");
		JLabel etiqueta4 = new JLabel("Telefon:");
		JLabel etiqueta5 = new JLabel("Usuari:");
		JLabel etiqueta6 = new JLabel("Contrasenya:");
		JLabel etiqueta7 = new JLabel("Restriccions:");
		
		JLabel nom = new JLabel(client.getNom_client());
		JLabel adreca = new JLabel(client.getAdreca());
		JLabel telefon = new JLabel(client.getTelefon());
		JLabel usuari = new JLabel(client.getUsuari());
		String contra = Integer.toString(client.getContrasenya());
		JLabel contrasenya = new JLabel(contra);
		String[] restr = client.getRestriccions();
		JLabel restriccions = new JLabel(restr[0]+ "," +restr[1]+ "," +restr[1]);
		
		
		JButton boto = new JButton("Finalitzar");

		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.WEST;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 0;
		panel2.add(etiqueta2, limit);
		limit.gridx = 1;
		panel2.add(nom, limit);
		limit.gridx = 0;
		limit.gridy = 1;
		panel2.add(etiqueta3, limit);
		limit.gridx = 1;
		panel2.add(adreca, limit);
		limit.gridx = 0;
		limit.gridy = 2;
		panel2.add(etiqueta4, limit);
		limit.gridx = 1;
		panel2.add(telefon, limit);
		limit.gridx = 0;
		limit.gridy = 3;
		panel2.add(etiqueta5, limit);
		limit.gridx = 1;
		panel2.add(usuari, limit);
		limit.gridx = 0;
		limit.gridy = 4;
		panel2.add(etiqueta6, limit);
		limit.gridx = 1;
		panel2.add(contrasenya, limit);
		limit.gridx = 0;
		limit.gridy = 5;
		panel2.add(etiqueta7, limit);
		limit.gridx = 1;
		panel2.add(restriccions, limit);
		limit.gridx = 0;
		limit.gridy = 6;
		panel2.add(boto, limit);

		contenidor.add(panel2, BorderLayout.WEST);

		// Accions del bot�
		boto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				dispose();

			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
		// finestra principal
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}


////////////////////////////////// CREAR CLIENT//////////////////////////////////////////////////////

/**
 * Classe per crear la finestra que serveix per crear un nou client
 * @author Pablo Paradinas Prieto
 *
 */
class Fines_CreaClient extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param titolya 
	 * @param llistacl
	 */
	public Fines_CreaClient(String titol, LlistaClients llistacl) {
		super(titol);
		// Contenidor de la finestra principal, cont� 2 panels horitzontals
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
		JLabel etiqueta6 = new JLabel("Contrasenya: (numeros)");
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

				if (e.getStateChange() == ItemEvent.SELECTED) {// si se ha seleccionado

					new Fines_Restriccions(restriccions, llistacl);
				}
				;
			}
		});

		// Accions del bot�
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

/**
 * Classe per crear la finestra per determinar les restriccions del nou client.
 * @author Pablo Paradinas Prieto
 *
 */
class Fines_Restriccions extends JFrame {

	private static final long serialVersionUID = 1L;

	// Constructor
	public Fines_Restriccions(String[] restriccions, LlistaClients llistacl) {
		// Contenidor de la finestra principal, cont� 2 panels horitzontals
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

		// Accions del bot�
		boto.addActionListener(new ActionListener() {

			int i = 0;

			public void actionPerformed(ActionEvent ae) {

				i = 0;
				restriccions[0] = null;
				restriccions[1] = null;
				restriccions[2] = null;

				if (Click2.isSelected()) {
					restriccions[i] = "Celiacs";
					i++;
				}
				if (Click3.isSelected()) {
					restriccions[i] = "Lactosa";
					i++;
				}
				if (Click4.isSelected()) {
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

/**
 *  Classe per crear la finestra  per registrar un client.
 * @author Pablo Paradinas Prieto
 *
 */
class Fines_Registrat extends JFrame {

	private static final long serialVersionUID = 1L;

	// Constructor
	public Fines_Registrat(Clients client) {
		// Contenidor de la fiestra principal, cont� 2 panels horitzontals
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

		// Accions del bot�
		boto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});

		textArea.append("L'usuari: " + client.getUsuari() + " s'ha registrat amb exit"); // Mostro la informaci�

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
															// finestra principal
		setSize(250, 200); // Mida de la finestra
		setVisible(true);
	}
}

//////////////////////////////////////// CONSULTAR COMANDES////////////////////////////////////////////////
/**
 * Classe per crear la finestra per consultar les comandes del client.
 * @author Catalin-Mihai Salvan
 *
 */
class Fines_LlistarComandes extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 *  Constructor
	 * @param titol
	 * @param llistacl
	 */
	public Fines_LlistarComandes(String titol, LlistaClients llistacl) {
		// Contenidor de la fiestra principal, cont� 2 panels horitzontals
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
		JLabel etiqueta2 = new JLabel("Contrasenya: (numeros)");
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

		// Accions del bot�
		boto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				String usu = campText1.getText(); // Agafo el nom
				String contrasenya = campText2.getText(); // Agafo la contrasenya del camp de text
				int pass = Integer.parseInt(contrasenya); // Agafo la contrasenya
				// LLAMAR A UNA FUNCION QUE NOS DIGA LA POSICION DE LA LISTA DEL CLIENTE

				int i = 0;
				i = llistacl.consultar_Client(usu);
				if ((i == -1) || (llistacl.getLlista()[i].getContrasenya()) != pass) {
					new Fines_Incorrecte();

				} else {
					dispose();
					new Fines_MostrarComandes(llistacl.getLlista()[i].getComandes());
				}
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
		// finestra principal
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}

/**
 * Classe per crear finestra que mostra les comandes del client.
 * @author  Catalin-Mihai Salvan
 *
 */
class Fines_MostrarComandes extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param llistacom
	 */
	public Fines_MostrarComandes(LlistaComanda llistacom) {
		// Contenidor de la fiestra principal, cont� 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));

		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("LES COMANDES SON LES SEGUENTS", SwingConstants.CENTER);
		panel1.add(etiqueta, SwingConstants.CENTER);
		JButton boto = new JButton("FINALITZAR");
		contenidor.add(boto, BorderLayout.PAGE_END);

		// Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());

		// Afegin un objecte de GridBagConstraints per definir les limitacions dels components en el panel
		GridBagConstraints limit = new GridBagConstraints();
		limit.anchor = GridBagConstraints.CENTER;
		limit.insets = new Insets(10, 10, 10, 10);
		limit.gridx = 0;
		limit.gridy = 1;
		JTextArea textArea = new JTextArea();
		panel2.add(textArea, limit);
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		contenidor.add(panel2, BorderLayout.CENTER);

		// LLAMAR AL TO STRING DE LAS COMANDAS Y IMPRIMIRLO
		textArea.append(llistacom.toString()); // Mostro la informacio
		contenidor.add(scroll);

		// Accions del bot�
		boto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
															// finestra principal
		setSize(500, 400); // Mida de la finestra
		setVisible(true);
	}
}

/**
 * Classe per crear la finestra on s'informa que el registre del client �s incorrecte.
 * @author  Catalin-Mihai Salvan
 *
 */
class Fines_Incorrecte extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 *  Constructor
	 */
	public Fines_Incorrecte() {
		// Contenidor de la fiestra principal, cont� 2 panels horitzontals
		Container contenidor = getContentPane();
		contenidor.setLayout(new BorderLayout(10, 10));

		// Panel 1
		JPanel panel1 = new JPanel(new BorderLayout());
		contenidor.add(panel1, BorderLayout.PAGE_START);
		JLabel etiqueta = new JLabel("INCORRECTE", SwingConstants.CENTER);
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

		// Accions del bot�
		boto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});

		textArea.append("L'usuari o contrasenya son incorrectes"); // Mostro la informacio

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Per a poder tancar la finestra atual sense afectar la
															// finestra principal
		setSize(250, 200); // Mida de la finestra
		setVisible(true);
	}
}

/**
 * Classe principal que inicilitza la primera finestra, on cont� un desplegable per mostrar totes opcions del men�.
 * @author Enyu Lin
 */
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
		LlistaProducte productesClient1 = new LlistaProducte(50);
		productesClient1.afegirProducte(p1);
		productesClient1.afegirProducte(b1);
		// aquesta llista l'afegirem a la comanda del client 1
		Comanda comanda1 = new Comanda(productesClient1, hora, min, 0);
		llistaClients.creaClient(Client1);
		llistaClients.afegirComandaClient(Client1.getIdentificador(), comanda1);
		llistaClients.afegirComandaClient(Client1.getIdentificador(), comanda1);
		llistaClients.afegirComandaClient(Client1.getIdentificador(), comanda1);
		llistaClients.afegirComandaClient(Client1.getIdentificador(), comanda1);
		llistaClients.afegirComandaClient(Client1.getIdentificador(), comanda1);
		llistaClients.afegirComandaClient(Client1.getIdentificador(), comanda1);
		Clients Client2 = new Clients("Alex", "avenida Jaume1", "666777444", "alex32", 123, tRestr,
				new LlistaComanda());
		llistaClients.creaClient(Client2);
		Clients Client3 = new Clients("Jordi", "avenida Ramon", "666888444", "jordi32", 543, tRestr,
				new LlistaComanda());
		llistaClients.creaClient(Client3);

		new Finestra("Restaurant Online", llistaProducte, llistaComandes, llistaClients);

	}
}
