package game;

public class Game {
	
	private boolean running;
   
    public void startGame() {        
        running = true;     
    }

    public void endGame() {
        running = false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new Game().startGame();
		
		System.out.print("Hello World");
	}

}
