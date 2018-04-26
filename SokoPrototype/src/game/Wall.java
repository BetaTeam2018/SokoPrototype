
/**
* @Project : KillerSokoban
* @file Name : Wall.java
* @date : 3/13/2018
* @author : 
*/

package game;
/**
 * falak reprezentációja a játékban
 */
public class Wall extends Field {
	
	/**
     * akkor hívódik meg ha valamit rá akarnak tolni, eldönti, hogy rátolható-e az adott dolog,
     * mindig 0-t ad vissza, azaz sosem tudnak rátolni semmit
     * @param pusher a toló Player referenciája
     * @param pushed a tolt dolog referenciája
     * @param dir	a tolás iránya
     * @param strength	a Player maradék ereje mielőtt a Fielden lévő dolgot eltolná
     * @return	visszaadja a maradék Player maradék erejét (0)
     */
	@Override
	public int pushHereBy(Player pusher, Thing pushed, Direction dir, int strength) {		
		return 0;
	}

	/**
	 * kiíráshoz szökséges karaktert adja vissza
	 * @return kiíráshoz szükséges karakter
	 */
	@Override
	public String MatrixElement() {		
		return "w";
	}
}
