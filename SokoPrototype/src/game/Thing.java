/**
* @Project : KillerSokoban
* @fileName Thing.java
* @date : 3/13/2018
* @author : 
*/

package game;
/**
 * Ősosztályt ad a különböző tárgyaknak amelyek a Fieldeken lehetnek
 *
 */
public abstract class Thing {
	/**
	 * a Player referenciája aki utóljára tolta a Thinget
	 */
	private Player lastPusher;
	/**
	 * a Field referenciája ahol a Thing tartózkodik
	 */
	private Field currentField;
	
	/**
	 * a Thing tolódása esetén hívódik meg, meghívja annak a Fieldnek a pushHereBy()
	 * fvét ahova tolni akarják
	 * @param pusher toló Player referenciája
	 * @param dir az irány amerre tolják
	 * @param strength a toló Player maradék ereje
	 * @return a maradék erő a tolás után
	 */
	public int slideBy(Player pusher, Direction dir, int strength) {		
		return this.getCurrentField().
				getNeighbor(dir).
				pushHereBy(pusher, this, dir, strength);
	}
	
	/**
	 * leszármazottaknak megvalósítandó fv amely a konzolra való kiíráshoz ad vissza
	 * egy kiírandó karaktert, ami majd az adott dolgot reprezentálja a konzolon
	 * @return
	 */
	public abstract String MatrixElement();
	
	/**
	 * leszármazottaknak megvalósítandó fv, amely egy új Fieldre helyezi őket
	 * @param newField az új Field referenciája
	 */
	public abstract void setNewField(Field newField);
	
	/**
	 * beállítja a Fieldet amin a dolog áll
	 * @param f a beállítandó Field referenciája
	 */
	public void setField(Field f) {
		currentField = f;
	}
	/**
	 * beállítja a Thinget utóljára eltoló Player referenciáját
	 * @param p a dolgot utóljára eltoló Player referenciája
	 */
	public void setLastPusher(Player p) {		
		lastPusher = p;	
	}
	/**
	 * függvény amely végrehajtja a szükséges műveleteket a Thing halála esetén
	 */
	public void die() {
		currentField.setThingToNull();
		currentField = null;
	}
	/**
	 * Visszaadja a Thinget utóljára eltoló Player referenciáját adja vissza
	 * @return a Thinget utoljára eltoló Player referenciája
	 */
	public Player getLastPusher() {
		return lastPusher;
	}
	/**
	 * Vissaadja a Fieldet amin a Thing éppen áll
	 * @return a Field referenciája
	 */
	public Field getCurrentField() {		
		return currentField;
	}
		
}
