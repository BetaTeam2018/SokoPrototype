/**
* @Project : KillerSokoban
* @fileName Switch.java
* @date : 3/13/2018
* @author : 
*/

package game;
/**
 * Kapcsoló reprezentációja a játékban amelyre Boxot lehet tolni és ennek hatására kinyitja
 * a hozzá kötött TrapDoort
 */
public class Switch extends Floor {
	
	/**
	 * A hozzákötött TrapDoor referenciája
	 */
	private TrapDoor td;	
	
	/**
	 * Konstruktor a TrapDoorral amit hozzákötünk
	 * @param td
	 */
	public Switch(TrapDoor td)
	{
		this.td=td;
	}
	/**
	 * Alapértelmezett konstruktor
	 */
	public Switch(){}
	/**
	 * Beállítja a hozzákötött TrapDoort
	 * @param td
	 */
	public void setTd(TrapDoor td) {
		this.td = td;
	}

	/**
	 * Visszaadja a hozzákötött TrapDoort
	 * @return TrapDoor
	 */
	public TrapDoor getTd()
	{
		return td;
	}

	@Override
	public void set(Box b) {
		super.set(b);
		td.open();
	}
	
	/**
	 * leveszi a Boxot és bezárja a hozzákötött TrapDoort
	 * @param b
	 */
	@Override
	public void remove(Box b) {
		super.remove(b);
		td.close();
	}
	/**
	 * kiiratáshoz szükséges
	 * @return String
	 */
	@Override
	public String MatrixElement() {		
		return "s";
	}
	
}
