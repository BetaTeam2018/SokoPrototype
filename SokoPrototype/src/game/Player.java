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
		
	public Player(Game g) {	
		this.game = g;
		points = 0;
	}
	
	public Player() {	
		points = 0;
		strength = 0;
	}
	
	public Game getGame() {				//visszaadja az adott játékot
		return game;
	}

	public void setGame(Game game) {	//beállítja a játékot
		this.game = game;
	}

	public long getPoints() {			//visszaadja a Player pontjait
		return points;
	}

	public void setPoints(int points) {	//beállítja a Player pontjait
		this.points = points;
	}

	public long getStrength() {			//visszaadja a Player erejét
		return strength;
	}

	public void setStrength(int strength) {	//beállítja a Player erejét
		this.strength = strength;
	}

	public void step(Direction dir) {		//a megadott irányba lépés
		Field f = this.getCurrentField();
		Field f2 = f.getNeighbor(dir);		
		f2.pushHereBy(this, this, dir, strength);	
	}
	
	
	@Override
	public int slideBy(Player pusher, Direction dir, int st) {	//akkor hívódik meg ha megpróbálják eltolni egy másik mezőre
		int back = super.slideBy(pusher, dir, st);
		
		if(st-back > 0) {
			this.die();
			return st;
		}

		return back;
	}
	
	
	@Override
	public void die() {			//megöli a Playert

		// this.getCurrentField().set((Player)null);
		super.die();
		game.endGame();

	}
	
	public void addPoints(long p) {	//adott számú pontot ad a Playernek
		points += p;
	}
	
	public void subtractPoints(long p) {	//adott számú pontot vesz el a Playertől
		points -= p;
	}
	
	@Override
	public void setNewField(Field newField) {	//Player áthelyezése egy új Fieldre
		
		this.getCurrentField().remove(this); 	//Player levétele az előzőről
		this.setField(newField);				//Player áthelyezése az újra
		newField.set(this);						
		
	}

	@Override
	public String MatrixElement() {				//kiíráshoz szükséges
		return "☺";
	}
	public void changeFriction(Friction fr)		//A Field súrlódásának megváltoztatása amin a Player van
	{
		this.getCurrentField().setFriction(fr);
	}
}
