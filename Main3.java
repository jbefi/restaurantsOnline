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
		String[] opcionsMenu = { "Afegir nou producte", "Eliminar producte", "Informació d'un producte", "Crear client","consultar Client",
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
					new Fines_eliminarProducte("eleminar un producte", llistaProducte);
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
					// Nova comanda per client
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
		JLabel et2 = new JLabel("Indiqua el id del client que vols consultar (1-" + llistClient.getnClients() + "):");
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
		JLabel et2 = new JLabel("Indiqui el codi del producte que vols elimiar (1-" + llistProds.getnElem() + "):");
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
				textArea.append("s'ha eliminat el producte amb exit");
				llistProds.eliminarProducte(codi); // eliminar producte
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setSize(600, 400); 
		setVisible(true);
	}
}

// Classe Principal
public class Main3 {
	public static LlistaProducte llistaProducte;
	public static LlistaComanda llistaComandes;
	public static LlistaClients llistaClients;

	public static void main(String[] args) {
		Producte[] llista = new Producte[4];
		Beguda b1 = new Beguda("sprite", 2, 10, 20, false);
		Beguda b2 = new Beguda("fanta", 2.5, 20, 30, false);

		Plat p1 = new Plat("Amanida", 5, 20);
		String[] Restriccions = { "celiacs", "lactosa", "fruits secs" };
		Plat p2 = new Plat("Sopa", 10, 5, Restriccions);

		llista[0] = b1;
		llista[1] = b2;
		llista[2] = p1;
		llista[3] = p2;

		llistaProducte = new LlistaProducte(12);
		llistaProducte.afegirProducte(b1);
		llistaProducte.afegirProducte(b2);
		llistaProducte.afegirProducte(p1);
		llistaProducte.afegirProducte(p2);
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
