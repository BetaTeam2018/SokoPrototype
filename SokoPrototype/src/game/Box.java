/**
* @Project : KillerSokoban
* @fileName Box.java
* @date : 3/13/2018
* @author : 
*/

package game;

public class Box extends Thing {
	
	
	@Override
	public boolean slideBy(Player pusher, Direction dir, long strength) {
		return super.slideBy(pusher, dir, strength);
	}
	
	@Override
	public void setNewField(Field newField) {		
		
		this.getCurrentField().remove(this); 	// T�r�lj�k az ide mutat� referenci�t a jelenlegi field-rol.
		this.setField(newField);				// �j field be�ll�t�sa.
		newField.set(this);						// A box bek�t�seaz �j field-re.
												//ez melyik?
		
	}
	@Override
	public void die()
	{
		this.getCurrentField().set((Box)null);
		super.die();
	}

}
