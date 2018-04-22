
/**
* @Project : KillerSokoban
* @file Name : Wall.java
* @date : 3/13/2018
* @author : 
*/

package game;

public class Wall extends Field {
	
	@Override
	public int pushHereBy(Player pusher, Thing pushed, Direction dir, int strength) {		
		return 0;
	}

	@Override
	public String MatrixElement() {		
		return "w";
	}
}
