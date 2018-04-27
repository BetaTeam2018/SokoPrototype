/**
* @Project : KillerSokoban
* @fileName TrapDoor.java
* @date : 3/13/2018
* @author : 
*/

package game;
/**
 * csapóajtót reprezentál a játékban ami akkor nyílik ki, ha a hozzákötött Switchre ládát tolnak,
 * ha nyitva van Holeként viselkedik, ha zárva Floorként
 */
public class TrapDoor extends Floor {
	/**
	 * boolean ami megmonjda, hogy nyitva van-e a csapóajtó
	 */
	private boolean opened;
	/**
	 * alapértelmezett konstruktor amely zárt állapotban inicializálja a csapóajtót
	 */
	public TrapDoor() {
		opened = false;
	}
		/**
		 * Boxot állít a TrapDoorra
		 * @param b a Box referenciája
		 */
	public void set(Box b) {
		if(opened) {			// ha nyitva van megöli a Boxot
			b.die();
		}else {
			super.set(b);		// ha nincs nyitva csak ráhelyezi a TrapDoorra
		}
	}
	/**
	 * Playert állít a TrapDoorra 
	 */
	public void set(Player p) {
		
		if(opened) {								// Ha nyitva van megöli a  Playert 
			p.die();
		}else {
			super.set(p);							// Ha nincs nyitva csak ráhelyezi a TrapDoorra 
		}		
	}
	/**
	 * kinyitja a TrapDoort
	 */
	public void open() {		
		opened = true;
		if(this.getThing() != null)
			this.getThing().die();
	}
	/**
	 * bezárja a TrapDoort
	 */
	public void close() {		
		opened = false;		
	}
	/**
	 * visszaadja, hogy a TrapDoor nyitva van-e
	 * @return TrapDoor állapota
	 */
	public boolean getState() {
		return opened;
	}
	/**
	 * beállítja a TrapDoor állapotát
	 * @param opened az állapot amire akarjuk a TrapDoort állítani
	 */
	public void setState(boolean opened) {
		this.opened = opened;
	}
	/**
	 * Konzolra kiíráshoz ad vissza kiírandó karaktert
	 * @return kiírandó karakter
	 */
	@Override
	public String MatrixElement() {		
		return "t";
	}
}
