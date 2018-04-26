package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import proto.Interpreter;
import proto.MapLoader;
import proto.Matrix;
import proto.Menu;
/**
 * 
 * A játékot irányító osztály ebben inicializálódik a minden a játékhoz szükséges adat
 *
 */
public class Game {
	/**
	 * az adott pálya mátrixa
	 */
	private Field[][] map;
	/**
	 * a pályán lévő játékosok listája
	 */
	private List<Player> players;
<<<<<<< HEAD
	/**
	 * Scanner objektum amelynek segítségével a bementről olvasunk
	 */
=======
>>>>>>> 036032eb9664c9b3852ecd25881b1d0dd51ed793
	private Scanner sc = new Scanner(System.in);

	/**
	 * elindítja a játékot
	 */
	public void startGame() {
<<<<<<< HEAD

		this.gameMainLoop();
=======
		running = true;
		
		// A menü parancsai
		
		this.gameMainLoop();
		
		System.out.println("player pontjai: " + players.get(0).getPoints());
		// System.out.println("player 2 pontjai: "+players.get(1).getPoints());
>>>>>>> 036032eb9664c9b3852ecd25881b1d0dd51ed793

	}

	/**
	 * pálya kirajzoló, paraméterként megkapja a pályát tartalmazó fájl nevét
	 * @param testFilename a pályát tartalmazó fájl neve
	 */
	public void drawMap(String testFilename) {	
		MapLoader ml = new MapLoader();
		InputStream is = null;
		try {
			is = new FileInputStream(new File("bin\\maps\\" + testFilename)); //fájl megnyitása
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ml.Load(is);								//pálya betöltése és a szükséges változók beállítása
		players = ml.getPlayers();
		map = ml.getFields();

		try {
			is.close();								//fájl bezárása
		} catch (IOException e) {
			e.printStackTrace();
		}

		Matrix mat = new Matrix();
		for (Player p : players)					//játékosoknak a pálya átadása
			p.setGame(this);

		mat.Draw(System.out, map);				//pálya kirajzolása

	}

	/**
	 * a játék befejezésekor végrehajtandó műveleteket végzi el
	 */
	public void endGame() {
		sc.close();
	}
/**
 * main függvény, ahonnan a program indul, elindít egy játékot
 * @param args
 */
	public static void main(String[] args) {	//játék indítása
		new Game().startGame();
	}

	/**
	 * 
	 */
	public void gameMainLoop() {

		String testfile = "";
		int mainMenulistNum = -1;								//szükséges változók
		boolean testExit = false;

		while (mainMenulistNum != 0) {
			Menu.printTestMenuList();
			mainMenulistNum = Menu.readListNumber();			//a szükséges teszt számának beolvasása

			testfile = "test_" + mainMenulistNum + ".txt";		//a fájl megnyitása majd az alaphelyzet kirajzolása
			drawMap(testfile);

			testExit = false;

			while (testExit == false) {
				String command = sc.nextLine();					//következő parancs beolvasása
				Matrix mat = new Matrix();

<<<<<<< HEAD
				commandInterpreter(command);					//parancs feldolgozása
				mat.Draw(System.out, map);						//aktuális állapot kiírása
=======
				Interpreter.readCommand(command, players, map);
				mat.Draw(System.out, map);
>>>>>>> 036032eb9664c9b3852ecd25881b1d0dd51ed793

				if (command.equals("exit"))						//kilépés ha szükséges
					testExit = true;

			}
		}
		endGame();

	}

<<<<<<< HEAD
	public void commandInterpreter(String command) { 					//parancs feldolgozó
		String[] commands = command.split(" ");						//parancs feldarabolása
		Player commander = new Player();

		switch (commands[0]) {
		case "step":												//step parancs
			if (commands[1].equals("p1")&& (players.size() >= 1)) {	//kiválasztjuk, hogy melyik Playerre vonatkozik
				commander = players.get(0);
			} else if (commands[1].equals("p2") && (players.size() >= 2)) {
				commander = players.get(1);
			} else {
				System.out.println("Nem érvényes a szintaxis, próbálja újra!");	//érvénytelen parancs esetén
				break;
			}

			if (commands[2].equals("RIGHT")) {						//kiválasztjuk, hogy melyik irányra vonatkozik
				commander.step(Direction.RIGHT);					//majd végrehajtjuk a parancsot
			} else if (commands[1].equals("LEFT")) {
				commander.step(Direction.LEFT);
			} else if (commands[1].equals("DOWN")) {
				commander.step(Direction.DOWN);
			} else if (commands[1].equals("UP")) {
				commander.step(Direction.UP);
			} else {
				System.out.println("Nem érvényes a szintaxis, próbálja újra!"); //érvénytelen parancs esetén
				break;
			}

			break;
		case "friction":										//friction parancs
			if (commands[1].equals("p1")) {						//Player kiválasztása
				commander = players.get(0);
			} else if (commands[1].equals("p2") && (players.size() == 2)) {
				commander = players.get(1);
			} else {
				System.out.println("Nem érvényes a szintaxis, próbálja újra!");	//érvénytelen parancs esetén
				break;
			}

			if (commands[2].equals("OIL")) {					//súrlódás kiválasztása, majd végrehajtás
				commander.changeFriction(Friction.OIL);
			} else if (commands[1].equals("NORMAL")) {
				commander.changeFriction(Friction.NORMAL);
			} else if (commands[1].equals("HONEY")) {
				commander.changeFriction(Friction.HONEY);
			} else {
				System.out.println("Nem érvényes a szintaxis, próbálja újra!");	//érvénytelen parancs esetén
				break;
			}

			break;
		}

	}
=======
	

	/*public void commandreader() {
		int i = 1;
		while (i++ <= 3) {
			commandInterpreter(sc.nextLine());
		}

	}*/
>>>>>>> 036032eb9664c9b3852ecd25881b1d0dd51ed793

	@Override
	protected void finalize() {
		sc.close();
	}

}
