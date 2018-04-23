/**
* @Project : KillerSokoban
* @fileName StoreageArea.java
* @date : 3/13/2018
* @author : 
*/


package game;
public class StoreageArea extends Floor {
	
	long pointValue;
	Player pointTo;
	
	public StoreageArea()
	{
		super();
		pointValue=1;
		pointTo=null;
	}
	
	public void set(Box b) {
		super.set(b);
		//b.getLastPusher().addPoints(pointValue);
		pointTo=b.getLastPusher();
		pointTo.addPoints(pointValue);
	}
	
	public void remove(Box b) {
		super.remove(b);
		//b.getLastPusher().subtractPoints(pointValue);
		pointTo.subtractPoints(pointValue);
		pointTo=null;
	}
	
	@Override
	public String MatrixElement() {		
		return "a";
	}
}
