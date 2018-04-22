/**
* @Project : KillerSokoban
* @fileName StoreageArea.java
* @date : 3/13/2018
* @author : 
*/


package game;
public class StoreageArea extends Floor {
	
	long pointValue;
	
	public StoreageArea()
	{
		super();
		//pointValue=0;
	}
	
	public void set(Box b) {
		super.set(b);
		b.getLastPusher().addPoints(pointValue);
	}
	
	public void remove(Box b) {
		super.remove(b);
		b.getLastPusher().addPoints(pointValue);		
	}
	
	@Override
	public String MatrixElement() {		
		return "a";
	}
}
