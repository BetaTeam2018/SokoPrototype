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
	/**
	 * Scanner objektum amelynek segítségével a bementről olvasunk
	 */
	private Scanner sc = new Scanner(System.in);

	/**
	 * elindítja a játékot
	 */
	public void startGame() {
		
		this.gameMainLoop();
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

				Interpreter.readCommand(command, players, map);	//parancs feldolgozása
				mat.Draw(System.out, map);						//aktuális állapot kiírása


				if (command.equals("exit"))						//kilépés ha szükséges
					testExit = true;

			}
		}
		endGame();

	}



	@Override
	protected void finalize() {
		sc.close();
	}

}
