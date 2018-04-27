package proto;

import java.util.List;

import game.Direction;
import game.Field;
import game.Friction;
import game.Player;
/**
 * parancsfeldolgozó osztály, ez értelmezi a bementről érkező parancsokat, majd végrehajtja őket
 *
 */
public class Interpreter {
	/**
	 *  a bemenetről érkező parancsot értelmezi és hajtja végre
	 * @param command a parancs String formában
	 * @param players a játékban lévő Playerek listája
	 * @param map a játék térképe
	 */
	public static void readCommand(String command, List<Player> players, Field[][] map) {
		String[] commands = command.split(" ");		//parancs feldarabolása
		Player commander = new Player();

		switch (commands[0]) {
		case "step":									//step parancs
			if (commands[1].equals("p1")&& (players.size() >= 1)) {	// player kiválasztása
				commander = players.get(0);
			} else if (commands[1].equals("p2") && (players.size() >= 2)) {
				commander = players.get(1);
			} else {
				System.out.println("Nem érvényes a szintaxis, próbálja újra!");
				break;
			}

			if (commands[2].equals("RIGHT")) {			//irány kiválasztása majd végrehajtás
				commander.step(Direction.RIGHT);
			} else if (commands[2].equals("LEFT")) {
				commander.step(Direction.LEFT);
			} else if (commands[2].equals("DOWN")) {
				commander.step(Direction.DOWN);
			} else if (commands[2].equals("UP")) {
				commander.step(Direction.UP);
			} else {
				System.out.println("Nem érvényes a szintaxis, próbálja újra!");
				break;
			}

			break;
		case "friction":											//friction parancs
			if (commands[1].equals("p1")&& (players.size() >= 1)) {	//player kiválasztása
				commander = players.get(0);
			} else if (commands[1].equals("p2") && (players.size() >= 2)) {
				commander = players.get(1);
			} else {
				System.out.println("Nem érvényes a szintaxis, próbálja újra!");
				break;
			}
			
			if (commands[2].equals("OIL")) {						//friction értékének kiválasztása majd végrehajtás
				commander.changeFriction(Friction.OIL);
			} else if (commands[2].equals("NORMAL")) {
				commander.changeFriction(Friction.NORMAL);
			} else if (commands[2].equals("HONEY")) {
				commander.changeFriction(Friction.HONEY);
			} else {
				System.out.println("Nem érvényes a szintaxis, próbálja újra!");
				break;
			}

			break;
		}

	}
}
