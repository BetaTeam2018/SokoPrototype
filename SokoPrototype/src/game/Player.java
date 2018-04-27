/**
* @Project : KillerSokoban
* @fileName Player.java
* @date : 3/13/2018
* @author : 
*/

package game;
/**
 * A játékos reprezentációja a játékban
 *
 */
public class Player extends Thing {
	/**
	 * A jelenlegi játék referenciája
	 */
	private Game game;
	/**
	 * a Player jelenlegi pontjai
	 */
	private int points;
	/**
	 * a Player ereje
	 */
	private int strength;
		/**
		 * Konstruktor amely a megadott játékkal hozza létre a Playert
		 * 0 erővel és ponttal
		 * @param g a játék referenciája
		 */
	public Player(Game g) {	
		this.game = g;
		points = 0;
		strength=0;
	}
	/**
	 * Alapértelmezett konstruktor, létrehoz egy Playert 0 erővel és ponttal
	 */
	public Player() {	
		points = 0;
		strength = 0;
	}
	
	/**
	 * visszaadja a jelenlegi játékot
	 * @return
	 */
	public Game getGame() {				
		return game;
	}

	/**
	 * beállítja a jelenlegi játékot
	 * @param game
	 */
	public void setGame(Game game) {	//beállítja a játékot
		this.game = game;
	}

	/**
	 * visszaadja a Player pontjait
	 * @return
	 */
	public long getPoints() {			//visszaadja a Player pontjait
		return points;
	}

	/**
	 * Beállítja a Player pontjait a paraméterlistában megadott szerint
	 * @param points a pontmennyiség amelyet be kell állítani
	 */
	public void setPoints(int points) {	//beállítja a Player pontjait
		this.points = points;
	}

	/**
	 * visszaadja a Player erejét
	 * @return
	 */
	public long getStrength() {			//visszaadja a Player erejét
		return strength;
	}

	/**
	 * beállítja a Player erejét
	 * @param strength a beállítandó erő
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}

	/**
	 * végrehajtja az interakciót ami akkor következik be, ha a Player lépni akar egy adott irányba
	 * @param dir a megadott irány
	 */
	public void step(Direction dir) {
		Field f = this.getCurrentField();
		Field f2 = f.getNeighbor(dir);		
		f2.pushHereBy(this, this, dir, strength);	
	}
	
	/**
	 * ha a Playert megpróbálják eltolni abban az esetben hívódik meg, meghívja annak a Fieldnek
	 * a pushHereBy() fvét ahova tolni akarják, szükség esetén megöli a Playert
	 * @param pusher a toló Player
	 * @param dir az irány amerre tolják a Playert
	 * @param st a toló Player maradék ereje
	 */
	@Override
	public int slideBy(Player pusher, Direction dir, int st) {	//akkor hívódik meg ha megpróbálják eltolni egy másik mezőre
		int back = super.slideBy(pusher, dir, st);
		
		if(st-back > 0) {
			this.die();
			return st;
		}

		return back;
	}
	
	/**
	 * a fv ami a Player halála estén végrehajtandó műveleteket hajtja végre
	 */
	@Override
	public void die() {

		super.die();
		game.endGame();

	}
	/**
	 * adott számú pontot ad a Playernek
	 * @param p a megadott számú pont
	 */
	public void addPoints(long p) {	
		points += p;
	}
	/**
	 * adott számú pontot vesz el a Playertől
	 * @param p a megadott számú pont
	 */
	public void subtractPoints(long p) {	//adott számú pontot vesz el a Playertől
		points -= p;
	}
	/**
	 * áthelyezi a Playert egy új Fieldre
	 * @param newField az új Field refernciája
	 */
	@Override
	public void setNewField(Field newField) {
		
		this.getCurrentField().remove(this); 	//Player levétele az előzőről
		this.setField(newField);				//Player áthelyezése az újra
		newField.set(this);						
		
	}

	/** a kiíráshoz szükséges karaktert adja vissza
	 * @return a kiíráshoz szükséges karakter
	 */
	@Override
	public String MatrixElement() {				//kiíráshoz szükséges
		return "☺";
	}
	public void changeFriction(Friction fr)		//A Field súrlódásának megváltoztatása amin a Player van
	{
		this.getCurrentField().setFriction(fr);
	}
}
