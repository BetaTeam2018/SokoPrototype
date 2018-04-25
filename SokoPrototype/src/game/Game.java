package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import proto.MapLoader;
import proto.Matrix;
import proto.Menu;

public class Game {

	private boolean running;
	private Field[][] map;
	private List<Player> players;

   
    public void startGame() {        
        running = true;    
        
        // List Test-cases: Listázza ki a teszt-eseteket 
        // Elindul a Game-Loop, aminek az alap állapota, mindig a tesztek kilistázása. 
        // A kilistázás mindig akkor történik, hogy egy tesztből kilép a felhasználó. 
        
        this.gameMainLoop();
        //csak próba kód
       // System.out.println("Hello World...");
       
		//commandreader();
		/*players.get(0).step(Direction.RIGHT);


	public void startGame() {
		running = true;

		this.gameMainLoop();
		// csak próba kód
		// System.out.println("Hello World...");

		// commandreader();
		/*
		 * players.get(0).step(Direction.RIGHT); mat.Draw(System.out, map);
		 * 
		 * players.get(0).step(Direction.RIGHT); mat.Draw(System.out, map);
		 */

		System.out.println("player pontjai: " + players.get(0).getPoints());
		// System.out.println("player 2 pontjai: "+players.get(1).getPoints());

	}

	public void drawMap(String testFilename) {
		MapLoader ml = new MapLoader();
		InputStream is = null;
		try {
			is = new FileInputStream(new File("bin\\maps\\" + testFilename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ml.Load(is);
		players = ml.getPlayers();
		map = ml.getFields();

		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Matrix mat = new Matrix();
		for (Player p : players)
			p.setGame(this);


		mat.Draw(System.out, map);


		System.out.println("player pontjai: "+players.get(0).getPoints());
		//System.out.println("player 2 pontjai: "+players.get(1).getPoints());
              
    }
    
 

   

	public void endGame() {
		running = false;
	}

	public static void main(String[] args) {
		new Game().startGame();
	}

	public void gameMainLoop() {

		String testfile = "";

		int mainMenulistNum = -1;
		boolean testExit = false;

		while (mainMenulistNum != 0) {
			Menu.printTestMenuList();
			mainMenulistNum = Menu.readListNumber();
			switch (mainMenulistNum) {
			case 0: // Kilépés
				break;
			case 1: // Teszt1
				// betöltése + interpreter
				testfile = "test_1.txt";
				drawMap(testfile);

				System.out.println("-exit- kilép a tesztből");
				testExit = false;

				while (testExit == false) {
					String command = sc.nextLine();
					Matrix mat = new Matrix();

					commandInterpreter(command);
					mat.Draw(System.out, map);

					if (command.equals("exit"))
						testExit = true;
				}
				break;
			case 2: // Parancssor

				break;
			}
		}


	}

	public void commandInterpreter(String command) {
		String[] commands = command.split(" ");
		Player commander = new Player();
		
		switch (commands[0])
		{
			case "step": 
				if (commands[1].equals("p1")) {
					commander = players.get(0);
				} else if (commands[1].equals("p2")&&(players.size()==2)) {
					commander = players.get(1);			
				} else {
				System.out.println("Nem érvényes a szintaxis, próbálja újra!");
				break;
			 	}
				
				if (commands[2].equals("RIGHT")) {
					commander.step(Direction.RIGHT);
				} else if (commands[1].equals("LEFT")) {
					commander.step(Direction.LEFT);			
				} else if (commands[1].equals("DOWN")) {
					commander.step(Direction.DOWN);
				} else if (commands[1].equals("UP")) {
					commander.step(Direction.UP);
				} else {
					System.out.println("Nem érvényes a szintaxis, próbálja újra!");
					break;
				}
				
				break;
			case "friction":
				if (commands[1].equals("p1")) {
					commander = players.get(0);
				} else if (commands[1].equals("p2")&&(players.size()==2)) {
					commander = players.get(1);			
				} else {
				System.out.println("Nem érvényes a szintaxis, próbálja újra!");
				break;
			 	}
				
				if (commands[2].equals("OIL")) {
					commander.changeFriction(Friction.OIL);
				} else if (commands[1].equals("NORMAL")) {
					commander.changeFriction(Friction.NORMAL);		
				} else if (commands[1].equals("HONEY")) {
					commander.changeFriction(Friction.HONEY);
				} else {
					System.out.println("Nem érvényes a szintaxis, próbálja újra!");
					break;
				}
				
				break;
		}
		
		
		}

	private Scanner sc = new Scanner(System.in);

	public void commandreader() {
		int i = 1;
		while (i++ <= 3) {
			commandInterpreter(sc.nextLine());
		}

	}

	@Override
	protected void finalize() {
		sc.close();
	}

}
