/**
* @Project : KillerSokoban
* @fileName Hole.java
* @date : 3/13/2018
* @author : 
*/

package game;

public class Hole extends Floor {	
	
	
	@Override
	public void set(Box b) {			//ha rákerül egy Box megöli (a fv akkor hívódik meg ha rákerül valami)
		if(b != null)
			b.die();
	}
	
	
	@Override
	public void set(Player p) {			//ha rákerül egy Player megöli (a fv akkor hívódik meg ha rákerül valami)
		if(p != null) 
			p.die();	
	}
	
	@Override
	public String MatrixElement() {		//kiíráshoz szükséges
		return "h";
	}
	
}
