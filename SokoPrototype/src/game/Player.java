/**
* @Project : KillerSokoban
* @fileName Player.java
* @date : 3/13/2018
* @author : 
*/

package game;

public class Player extends Thing {
	
	private Game game;
	private long points;
	private long strength;
	

	
	public Player(Game g) {	
		this.game = g;
		points = 0;
	}
	
	public void step(Direction dir) {

		Field f = this.getCurrentField();
		Field f2 = f.getNeighbor(dir);		
		f2.pushHereBy(this, this, dir, strength);
	
	}
	
	@Override
	public boolean slideBy(Player pusher, Direction dir, long st) {

		boolean pushable = super.slideBy(pusher, dir, st);
		
		if(pushable == false) {
			this.die();
		}

		return true;
	}
	
	@Override
	public void die() {

		// this.getCurrentField().set((Player)null);
		super.die();
		game.endGame();

	}
	
	public void addPoints(long p) {
		points += p;
	}
	
	public void subtractPoints(long p) {
		points -= p;
	}
	
	@Override
	public void setNewField(Field newField) {
		
		this.getCurrentField().remove(this); 	// Töröljük az ide mutató referenciát a jelenlegi field-rol.
		this.setField(newField);				// Új field beállítása.
		newField.set(this);						// A játékos bekötéseaz új field-re.
		
	}
}
