/**
* @Project : KillerSokoban
* @fileName Player.java
* @date : 3/13/2018
* @author : 
*/

package game;

public class Player extends Thing {
	
	private Game game;
	private int points;
	private int strength;
	private int endurance = 4;
		
	public Player(Game g) {	
		this.game = g;
		points = 0;
	}
	
	public Player() {	
		points = 0;
		strength = 0;
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public long getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public long getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void step(Direction dir) {
		Field f = this.getCurrentField();
		Field f2 = f.getNeighbor(dir);		
		f2.pushHereBy(this, this, dir, strength);	
	}
	
	
	@Override
	public int slideBy(Player pusher, Direction dir, int st) {		
		int back = super.slideBy(pusher, dir, st);
		
		if(st-back > endurance) {
			this.die();
		}

		return back;
	}
	
	/*@Override
	public boolean slideBy(Player pusher, Direction dir, int st) {

		boolean pushable = super.slideBy(pusher, dir, st);
		
		if(pushable == false) {
			this.die();
		}

		return true;
	}*/
	
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
		
		this.getCurrentField().remove(this); 	// TĂ¶rĂ¶ljĂĽk az ide mutatĂł referenciĂˇt a jelenlegi field-rol.
		this.setField(newField);				// Ăšj field beĂˇllĂ­tĂˇsa.
		newField.set(this);						// A jĂˇtĂ©kos bekĂ¶tĂ©seaz Ăşj field-re.
		
	}

	@Override
	public String MatrixElement() {		
		return "☺";
	}
	public void changeFriction(Friction fr)
	{
		this.getCurrentField().setFriction(fr);
	}
}
