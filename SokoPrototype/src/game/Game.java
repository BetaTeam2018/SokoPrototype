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

public class Game {

	private boolean running;
	private Field[][] map;
	private List<Player> players;
	private Scanner sc = new Scanner(System.in);

	public void startGame() {
		running = true;
		
		// A menü parancsai
		
		this.gameMainLoop();
		
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

			testfile = "test_" + mainMenulistNum + ".txt";
			drawMap(testfile);

			System.out.println("-exit- kilép a tesztből");
			testExit = false;

			while (testExit == false) {
				String command = sc.nextLine();
				Matrix mat = new Matrix();

				Interpreter.readCommand(command, players, map);
				mat.Draw(System.out, map);

				if (command.equals("exit"))
					testExit = true;

			}
		}

	}

	

	/*public void commandreader() {
		int i = 1;
		while (i++ <= 3) {
			commandInterpreter(sc.nextLine());
		}

	}*/

	@Override
	protected void finalize() {
		sc.close();
	}

}
