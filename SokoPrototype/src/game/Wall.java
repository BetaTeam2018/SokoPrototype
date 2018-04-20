
/**
* @Project : KillerSokoban
* @file Name : Wall.java
* @date : 3/13/2018
* @author : 
*/

package game;

public class Wall extends Field {
	
	@Override
	public boolean pushHereBy(Player pusher, Thing pushed, Direction dir, long strength) {		
		return false;
	}
}
