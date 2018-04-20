/**
* @Project : KillerSokoban
* @fileName Hole.java
* @date : 3/13/2018
* @author : 
*/

package game;

public class Hole extends Floor {	
	
	/**
	 * @param 
	 * @date 3/13/2018
 	 * @author 
	 */
	@Override
	public void set(Box b) {
		if(b != null)
			b.die();
	}
	
	
	/**
	 * @param 
	 * @date 3/13/2018
 	 * @author 
	 */
	@Override
	public void set(Player p) {
		if(p != null) 
			p.die();	
	}
	
}
