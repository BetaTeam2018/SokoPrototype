package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import proto.MapLoader;
import proto.Matrix;

public class Game {
	
	private boolean running;		
	private Field[][] map;
	private List<Player> players;
   
    public void startGame() {        
        running = true;    
        
        //csak próba kód
        System.out.println("Hello World...");
        MapLoader ml = new MapLoader();
        InputStream is = null;
		try {
			is = new FileInputStream(new File("src\\maps\\test_3.txt"));
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
	
		players.get(0).step(Direction.RIGHT);
		mat.Draw(System.out, map);
		
		players.get(0).step(Direction.RIGHT);
		mat.Draw(System.out, map);
		
    }

    public void endGame() {
        running = false;
    }

	public static void main(String[] args) {			
		new Game().startGame();	
	}
	
	

}
