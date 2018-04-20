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
	 * Azt az interakciót kezeli amikor egy játékos a csapóajtóra kerül. 
	 */
	public void set(Player p) {
		
		if(opened) {								// Ha a csapóajtó nyitott, akkor a játékos meghal. 
			p.die();
		}else {
			super.set(p);							// Ha nincs nyitva, akkor helyezze rá a mezõre. 
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
}
