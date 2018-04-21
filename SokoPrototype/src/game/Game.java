package game;

public class Game {
	
	private boolean running;
	private Field[][] map;
   
    public void startGame() {        
        running = true;    
        System.out.print("Hello World...");
    }

    public void endGame() {
        running = false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new Game().startGame();		
		
	}

}
