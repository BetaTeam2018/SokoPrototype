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
        
      
        String testFilename = this.gameMainLoop();
        //csak próba kód
       // System.out.println("Hello World...");
        MapLoader ml = new MapLoader();
        InputStream is = null;
		try {
			is = new FileInputStream(new File("src\\maps\\" + testFilename));
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
		//commandreader();
		/*players.get(0).step(Direction.RIGHT);
		mat.Draw(System.out, map);
		System.out.println("player pontjai: "+players.get(0).getPoints());
		
		players.get(0).step(Direction.RIGHT);
		mat.Draw(System.out, map);*/
		
		System.out.println("player pontjai: "+players.get(0).getPoints());
		//System.out.println("player 2 pontjai: "+players.get(1).getPoints());
                
    }

    public void endGame() {
        running = false;
    }

	public static void main(String[] args) {			
		new Game().startGame();	
	}
	
	
	public String gameMainLoop() {
		String testfile = "";
        int mainMenulistNum = -1;
        while (mainMenulistNum != 0) {
        	Menu.printTestMenuList();
        	mainMenulistNum = Menu.readListNumber();
            switch (mainMenulistNum) {
            case 0:							// Kilépés          	
                break;
            case 1:							// Teszt1  
            	// betöltése + interpreter
            	testfile = "test_1.txt";
            	break;
            case 2:							// Parancssor 
            	
                break;
            }
        }
        
        return testfile;
	}
	
	public void commandInterpreter(String command) {
		String[] commands = command.split(" ");
		Player commander = new Player();
		switch (commands[0]) {
		case "step": 
			if (commands[1].equals("p1")) {
				commander = players.get(0);
			} else if (commands[1].equals("p2")) {
				commander = players.get(1);			
			} else {
			System.out.println("Nem érvényes a szintaxis, próbálja újra!");
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
			}
		}
		}
	
	private Scanner sc;	
	public void commandreader() {
		int i = 1;
		while (i++ <= 3) {
			commandInterpreter(sc.nextLine());
		}
		
	}
	@Override
	protected void finalize(){
		sc.close();
	}
	


}
