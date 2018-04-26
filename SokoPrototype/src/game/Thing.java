/**
* @Project : KillerSokoban
* @fileName Thing.java
* @date : 3/13/2018
* @author : 
*/

package game;

public abstract class Thing {
	
	private Player lastPusher;
	private Field currentField;
	
	
	public int slideBy(Player pusher, Direction dir, int strength) {		
		return this.getCurrentField().
				getNeighbor(dir).
				pushHereBy(pusher, this, dir, strength);
	}
	
	
	public abstract String MatrixElement();
	
	public abstract void setNewField(Field newField);
	
	public void setField(Field f) {
		currentField = f;
	}
	public void setLastPusher(Player p) {		
		lastPusher = p;	
	}
	
	public void die() {
		currentField.setThingToNull();
		currentField = null;
	}
	
	public Player getLastPusher() {
		return lastPusher;
	}
	
	public Field getCurrentField() {		
		return currentField;
	}
		
}
