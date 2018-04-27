/**
* @Project : KillerSokoban
* @fileName StoreageArea.java
* @date : 3/13/2018
* @author : 
*/


package game;
/**
 * célhelyet reprezentál a játékban amelyekre ládákat kell tolni, hogy a Playerek pontot
 * kapjanak
 *
 */
public class StoreageArea extends Floor {
	/**
	 * az a pontmennyiség amelyet a Playernek ad a StorageArea
	 */
	long pointValue;
	/**
	 * a Player referenciája akinek a pontot adja a StorageArea
	 */
	Player pointTo;
	/**
	 * Alapértelmezett konstruktor, pointValue=1
	 */
	public StoreageArea()
	{
		super();
		pointValue=1;
		pointTo=null;
	}
	/**
	 * ráállít egy Boxot a StorageAreara és pointValue mennyiségű pontot ad a Playernek aki tolta
	 * a Boxot
	 */
	public void set(Box b) {						//ha rákerül egy Box pontot ad a Playernek aki rátolta
		super.set(b);
		pointTo=b.getLastPusher();
		pointTo.addPoints(pointValue);
	}
	/**
	 * leveszi a Boxot a StorageAreara és pointValue mennyiségű pontot von le a Playertől
	 * aki ezelőtt rátolta a Boxot
	 */
	public void remove(Box b) {						//ha lekerül róla a Box elveszi attól a Playertől a pontot aki rátolta
		super.remove(b);
		pointTo.subtractPoints(pointValue);
		pointTo=null;
	}
	/**
	 * a kiíráshoz szükséges karaktert adja vissza
	 * @return a kiírandó karakter
	 */
	@Override
	public String MatrixElement() {					//kiiratáshoz szükséges
		return "a";
	}
}
