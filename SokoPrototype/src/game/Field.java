/**
 * @Project : KillerSokoban
 * @fileName Field.java
 * @date : 3/13/2018
 * @author : 
 */

package game;

import java.util.Map;
import java.util.TreeMap;
public abstract class Field {

    private Thing thing;
    private Map < Direction, Field > neighbors = new TreeMap < > ();
    private Friction friction = Friction.NORMAL;
    
    
    public abstract String MatrixElement();

    public Friction getFriction() {
		return friction;
	}

	public void setFriction(Friction friction) {
		this.friction = friction;
	}

	public void setNeighbor(Direction dir, Field field) {
        neighbors.put(dir, field);
    }

    public Field getNeighbor(Direction dir) {
        Field neighbor = neighbors.get(dir);
       
        return neighbor;
    }

    public static void ConnectHorizontal(Field western, Field eastern) {
        western.setNeighbor(Direction.RIGHT, eastern);
        eastern.setNeighbor(Direction.LEFT, western);
    }

    public static void ConnectVertical(Field northern, Field southern) {
        northern.setNeighbor(Direction.DOWN, southern);
        southern.setNeighbor(Direction.UP, northern);
    }

    
    public int pushHereBy(Player pusher, Thing pushed, Direction dir, int strength ) {  
        
    	int result = strength;
    	
    	// ha van ezen a mezo"n valami
        if (this.getThing() != null) { 
        	if (strength < friction.GetValue()) { // és már nincs ereje:
            	result = 0;
            }else {	// egyébként ha még maradt ereje:
            	result = this.getThing().slideBy(pusher, dir, strength - friction.GetValue());
            }
        
        // ha a mezőn nincs semmi   
        } else {	     	
        	result = strength;        	
        }       
        
        
        if (result > 0) { // ide pakoljuk phused thing et.
            pushed.setLastPusher(pusher);
            pushed.setNewField(this);
        }
        return result;
    }
    
    /*public boolean pushHereBy(Player pusher, Thing pushed, Direction dir, int strength ) {  
        
    	boolean result = true;    	
        
        if (strength < friction.GetValue()) {
        	return false;
        }

        if (this.getThing() != null) { // ha van ezen a mezo"n valami
            result = this.getThing().slideBy(pusher, dir, strength - friction.GetValue());
        }   

        if (result == true) { // ide pakoljuk phused thing et.
            pushed.setLastPusher(pusher);
            pushed.setNewField(this);
        }
        return result;
    }*/

    public void set(Box b) {
        if (thing != null)
            System.err.println("The thing is not null! (Field.Set(box))"); // TODO exception
        thing = b; //Bermuda triangle LOL		
    }

    public void remove(Box b) {
        thing = null;
    }
    
    public void setThingToNull() {
    	thing = null;
    }

    public void set(Player p) {        
        if (thing != null)
            System.err.println("Error: thing is not null! (Field.Set(player))"); // TODO exception
      
        thing = p; //Bermuda triangle LOL		
    }

    public void remove(Player p) {
        thing = null;
    }

    public Thing getThing() {
        return thing;
    }
}