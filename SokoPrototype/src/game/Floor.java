/**
* @Project : KillerSokoban
* @fileName Floor.java
* @date : 3/13/2018
* @author : 
*/

package game;
public class Floor extends Field {
	
	/**
     * akkor hívódik meg ha valamit rá akarnak tolni, eldönti, hogy rátolható-e az adott dolog
     *  és ha igen elvégzi az eltolást, meghívja a Field ősosztály ugyanilyen nevű fvét
     * @param pusher a toló Player referenciája
     * @param pushed a tolt dolog referenciája
     * @param dir	a tolás iránya
     * @param strength	a Player maradék ereje mielőtt a Fielden lévő dolgot eltolná
     * @return	visszaadja a maradék Player maradék erejét
     */
	@Override
	public int pushHereBy(Player pusher, Thing pushed, Direction dir, int strength) {
		return super.pushHereBy(pusher, pushed, dir, strength);
	}

	/**
	 * a konzolra kiíráshoz ad egy kiírandó karaktert
	 * @return a kiírandó karakter
	 */
	@Override
	public String MatrixElement() {	
		return ".";
	}
	
	
	
	
}
