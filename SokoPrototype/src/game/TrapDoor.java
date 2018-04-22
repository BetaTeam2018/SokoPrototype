/**
* @Project : KillerSokoban
* @fileName TrapDoor.java
* @date : 3/13/2018
* @author : 
*/

package game;

public class TrapDoor extends Floor {
	
	private boolean opened;
	
	public TrapDoor() {
		opened = false;
	}
	
	public void set(Box b) {
		if(opened) {
			b.die();
		}else {
			super.set(b);
		}
	}
	/**
	 * Azt az interakci�t kezeli amikor egy j�t�kos a csap�ajt�ra ker�l. 
	 */
	public void set(Player p) {
		
		if(opened) {								// Ha a csap�ajt� nyitott, akkor a j�t�kos meghal. 
			p.die();
		}else {
			super.set(p);							// Ha nincs nyitva, akkor helyezze r� a mez�re. 
		}		
	}
	
	public void open() {		
		opened = true;		
	}
	
	public void close() {		
		opened = false;		
	}
	
	public boolean getState() {
		return opened;
	}
	
	public void setState(boolean opened) {
		this.opened = opened;
	}
	
	@Override
	public String MatrixElement() {		
		return "t";
	}
}
