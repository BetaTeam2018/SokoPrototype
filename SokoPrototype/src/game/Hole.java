/**
* @Project : KillerSokoban
* @fileName Hole.java
* @date : 3/13/2018
* @author : 
*/

package game;

public class Hole extends Floor {	
	
	
	/**
	 * Box ráállítása a Hole-ra, megöli a Boxot
	 * @param b Box referenciája
	 */
	@Override
	public void set(Box b) {			
		if(b != null)
			b.die();
	}
	
	/**
	 * //Player ráállítása a Hole-ra, megöli a Playert
	 * @param p Player referenciája
	 */
	@Override
	public void set(Player p) {			
		if(p != null) 
			p.die();	
	}
	/**
	 * konzolra kiíráshoz szükséges karaktert adja vissza
	 * @return a kiírandó karakter
	 */
	@Override
	public String MatrixElement() {		//kiíráshoz szükséges
		return "h";
	}
	
}
