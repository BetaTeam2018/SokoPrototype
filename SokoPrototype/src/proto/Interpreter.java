package proto;

import java.util.List;

import game.Direction;
import game.Field;
import game.Friction;
import game.Player;

public class Interpreter {
	
	public static void readCommand(String command, List<Player> players, Field[][] map) {
		String[] commands = command.split(" ");
		Player commander = new Player();

		switch (commands[0]) {
		case "step":
			if (commands[1].equals("p1")&& (players.size() >= 1)) {
				commander = players.get(0);
			} else if (commands[1].equals("p2") && (players.size() >= 2)) {
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
			if (commands[1].equals("p1")&& (players.size() >= 1)) {
				commander = players.get(0);
			} else if (commands[1].equals("p2") && (players.size() >= 2)) {
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
}
