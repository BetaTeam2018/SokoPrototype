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
	
	public void set(Box b) {						//ha rákerül egy Box pontot ad a Playernek aki rátolta
		super.set(b);
		pointTo=b.getLastPusher();
		pointTo.addPoints(pointValue);
	}
	
	public void remove(Box b) {						//ha lekerül róla a Box elveszi attól a Playertől a pontot aki rátolta
		super.remove(b);
		pointTo.subtractPoints(pointValue);
		pointTo=null;
	}
	
	@Override
	public String MatrixElement() {					//kiiratáshoz szükséges
		return "a";
	}
}
