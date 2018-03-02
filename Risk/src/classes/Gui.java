package classes;

 import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/****************************************************************************
 * A class to hold all the logic for rendering the game as well as player-
 * Input. I hope to combine Main and Gui
 ***************************************************************************/
public class Gui extends JFrame{
	private static final long serialVersionUID = 1L;

	//Window Size
	public static int width = 512;
	public static int height = 512;
	private String title = "Risk!";
	private Canvas canvas;
	private Mouse mouse;
	private boolean running = false;
	//Image Stuff for Canvas Rendering
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	private Main main;
	
	private JButton attack;
	private JButton endTurn;
	private JButton addUnits;
	
	private JPanel jpanel;
	
	/****************************************************************************
	 * The constructor for Gui, it sets up the window and the space for 
	 * everything that goes inside it, currently, that's 4 countries and a 
	 * pop-up menu for the game once a country has been selected. 
	 ***************************************************************************/
	public Gui() {
		//Create Window (JFrame)
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);
		
		//instantiating buttons
		attack = new JButton("Attack");
		attack.addActionListener(new ButtonListener());
		addUnits = new JButton("Add Units");
		addUnits.addActionListener(new ButtonListener());
		endTurn = new JButton("End Turn");
		endTurn.addActionListener(new ButtonListener());
		
		//Put Stuff in the Window
		jpanel = new JPanel();
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		add(jpanel);
		jpanel.add(canvas);
		jpanel.add(attack);
		jpanel.add(addUnits);
		jpanel.add(endTurn);
		pack();
		setVisible(true);
		
		//Add Mouse
		mouse = new Mouse();
		canvas.addMouseListener(mouse);
		canvas.addMouseMotionListener(mouse);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	System.out.println("Close!");
		    	stop();
		    }
		});
		
		//Create Main Instance
		main = new Main(width, height);
		
	}
	
	/****************************************************************************
	 * This puts the game as the front window no your computer, sets running 
	 * to true, and calls run()
	 ***************************************************************************/
	public void start() {
		running = true;
		//Sets Game as Primary Window
		requestFocus();
		//Launch Game Loop;
		run();
	}
	
	/****************************************************************************
	 * This is called when the window is closed.
	 ***************************************************************************/
	public void stop() {
		running  = false;
		System.exit(0);
	}
	
	/****************************************************************************
	 * this is where the decision from the user begins.
	 ***************************************************************************/
	public void update() {
		if(Mouse.getB() == 4)
			System.exit(0);
		if (main.getSelected() == null) {
			selectCountry();
		}
		else {
			System.out.println(main.getSelected().getName());
		}
		//this is for release 2
		/*
		else if (!main.isShowMenu()) {
			main.setChoice(showMenu());
		}
		else {
			//FIXME need to have two possible menus
			if (main.getChoice() == 1) {
				Country defender = showNeighbors(main.getSelected());
				main.Attack(defender);
			}
			else if (main.getChoice() == 2) {
				main.addUnits();
			}
		}*/
	}
	
	/****************************************************************************
	 * pops up a menu to let the user attack or addUnits
	 * if they already have selected attack, then it pops up a menu of neighbors
	 * THIS IS FOR RELEASE 2
	 ***************************************************************************/
	private int showMenu() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	/****************************************************************************
	 * The logic get an array of neighbors to the Gui
	 * @param Country c: the country that we want neighbors from
	 ***************************************************************************/
	private Country showNeighbors(Country c) {
		int place = -1;
		Country def;
		for (int i = 0; i < main.getWorld().length; i++) {
			if (main.getWorld()[i] == c) {
				place = i;
			}
		}
		Country[] neighbors = main.getWorld()[place].getNeighbors();
		//FIXME somehow ask which neighbor they want here
		def = new Country("hi", 5, "hi");
		return def;
	}

	/****************************************************************************
	 * The logic to select a country and set it to Main.selected using 
	 * man.setSelected
	 ***************************************************************************/
	public void selectCountry() {
		if(Mouse.getB() == 1 && Mouse.getX() < 256 && Mouse.getY() < 256) {
			main.setSelected(main.green);
		}
		else if(Mouse.getB() == 1 && Mouse.getX() < 512 && Mouse.getY() < 256) {
			main.setSelected(main.magenta);
		}
		else if(Mouse.getB() == 1 && Mouse.getX() < 256 && Mouse.getY() < 512) {
			main.setSelected(main.purple);
		}
		else if(Mouse.getB() == 1 && Mouse.getX() < 512 && Mouse.getY() < 512) {
			main.setSelected(main.yellow);
		}
	}

	/****************************************************************************
	 * This renders all the countries to the board
	 ***************************************************************************/
	public void renderPixels(int[] pixels) {
		main.getScreen().renderCountries(main.getWorld());
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = main.getScreen().getPixels()[i];
		}
	}
	
	/****************************************************************************
	 * The logic to select a country and set it to Main.selected using 
	 * man.setSelected
	 ***************************************************************************/
	public void render() {
		//If no BufferStrategy exists, make it a 3 length buffer
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		//Clear the screen to all black
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
		//Set pixelsFIXME
		renderPixels(pixels);
		
		//Draw Graphics
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image,  0,  0,  canvas.getWidth(), canvas.getHeight(), null);
		//g.drawString(main.getTurn().getName(), 1, 1);
		
		//Dispose Graphics
		g.dispose();
		//Show BufferedImage
		bs.show();
	}
	
	//Main Program Loop
	public void run() {
		while(running) {
			update();
			render();
		}
	}
	
	public static void main(String[] args) {
		Gui gui = new Gui();
		gui.start();
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == attack) {
				if (main.getSelected() != null) {
					System.out.println("my name is "+ main.getSelected().getName());
					if (main.getSelected().getName() == "green"){
						System.out.println(Integer.toString(main.getSelected().getNumUnits()));
						System.out.println(Integer.toString(main.purple.getNumUnits()));
						main.getBoard().attack(main.green, main.purple, main.getBoard().getAtt(), main.getBoard().getDef());
						System.out.println(Integer.toString(main.getSelected().getNumUnits()));
						System.out.println(Integer.toString(main.purple.getNumUnits()));
					}
					else if (main.getSelected().getName() == "magenta"){
						System.out.println(Integer.toString(main.getSelected().getNumUnits()));
						System.out.println(Integer.toString(main.yellow.getNumUnits()));
						main.getBoard().attack(main.magenta, main.yellow, main.getBoard().getAtt(), main.getBoard().getDef());
						System.out.println(Integer.toString(main.getSelected().getNumUnits()));
						System.out.println(Integer.toString(main.yellow.getNumUnits()));
					}
					else if (main.getSelected().getName() == "purple"){
						System.out.println(Integer.toString(main.getSelected().getNumUnits()));
						System.out.println(Integer.toString(main.green.getNumUnits()));
						main.getBoard().attack(main.purple, main.green, main.getBoard().getAtt(), main.getBoard().getDef());
						System.out.println(Integer.toString(main.getSelected().getNumUnits()));
						System.out.println(Integer.toString(main.green.getNumUnits()));
					}
					else if (main.getSelected().getName() == "yellow"){
						System.out.println(Integer.toString(main.getSelected().getNumUnits()));
						System.out.println(Integer.toString(main.magenta.getNumUnits()));
						main.getBoard().attack(main.yellow, main.magenta, main.getBoard().getAtt(), main.getBoard().getDef());
						System.out.println(Integer.toString(main.getSelected().getNumUnits()));
						System.out.println(Integer.toString(main.magenta.getNumUnits()));
					}
				main.setSelected(null);
				}
			}
			if (e.getSource() == addUnits) {
				if (main.getSelected() != null) {
					System.out.println(Integer.toString(main.getSelected().getNumUnits()));
					main.addUnits();
					System.out.println(Integer.toString(main.getSelected().getNumUnits()));
					main.setSelected(null);
				}
			}
			if (e.getSource() == endTurn) {
				if (main.getSelected() != null) {
					main.setSelected(null);
				}
				System.out.println(main.getTurn().getName());
				main.switchTurn();
				System.out.println(main.getTurn().getName());
				main.setSelected(null);
			}
		}
	}
			
}
