/**
 * @Project : KillerSokoban
 * @fileName Field.java
 * @date : 3/13/2018
 * @author : 
 */

package game;

import java.util.Map;
import java.util.TreeMap;
/**
 * Pályaelemeket reprezentál, különböző pályaelemeknek ad ősosztályt
 *
 *
 */
public abstract class Field {

	/**
	 * a Fielden lévő Thing referenciája
	 */
    private Thing thing;
    /**
     * a szomszéd Fieldek referenciái
     */
    private Map < Direction, Field > neighbors = new TreeMap < > ();
    /**
     * a mező súrlódása
     */
    private Friction friction = Friction.NORMAL;
    
    /**
     * megvalósítandó konzolra kiíró fv a leszármazottaknak
     * @return visszaadja a kiíráshoz szükséges karaktert
     */
    public abstract String MatrixElement();

    /**
     * visszaadja a field súrlódását
     * @return	súrlódás
     */
    public Friction getFriction() {
		return friction;
	}

    /**
     * beállítja a Field súrlódását
     * @param friction beállítandó súrlódás
     */
	public void setFriction(Friction friction) {
		this.friction = friction;
	}

	/**
	 * beállítja a Field szomszédját egy adott irányban
	 * @param dir az adott irány
	 * @param field a szomszéd
	 */
	public void setNeighbor(Direction dir, Field field) {	
        neighbors.put(dir, field);
    }

	/**
	 * visszaadja a Field szomszédját az adott irányban
	 * @param dir az adott irány
	 * @return	a szomszéd Field referenciája
	 */
    public Field getNeighbor(Direction dir) {	
        Field neighbor = neighbors.get(dir);
       
        return neighbor;
    }

    /**
     * Beállítja az adott Field szomszédait horizontálisan
     * @param western baloldali szomszéd refernciája
     * @param eastern jobboldali szomszéd referenciája
     */
    public static void ConnectHorizontal(Field western, Field eastern) {
        western.setNeighbor(Direction.RIGHT, eastern);
        eastern.setNeighbor(Direction.LEFT, western);
    }

    /**
     * beállítja az adott Field szomszédait vertikálisan
     * @param northern fölötte lévő szomszéd
     * @param southern alatta lévő szomszéd
     */
    public static void ConnectVertical(Field northern, Field southern) {
        northern.setNeighbor(Direction.DOWN, southern);
        southern.setNeighbor(Direction.UP, northern);
    }

    /**
     * akkor hívódik meg ha valamit rá akarnak tolni, eldönti, hogy rátolható-e az adott dolog
     *  és ha igen elvégzi az eltolást
     * @param pusher a toló Player referenciája
     * @param pushed a tolt dolog referenciája
     * @param dir	a tolás iránya
     * @param strength	a Player maradék ereje mielőtt a Fielden lévő dolgot eltolná
     * @return	visszaadja a maradék Player maradék erejét
     */
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
        
        
        if (result > 0) { // ide rakjuk pushed thing et.
        	pushed.setLastPusher(pusher);
        	pushed.setNewField(this);
        }
        return result;
    }
    
/**
 * Box ráállítása a Fieldre
 * @param b a doboz amit rá kell állítani
 */
    public void set(Box b) {							
        if (thing != null)
            System.err.println("The thing is not null! (Field.Set(box))");
        thing = b;	
    }

    /**
     * Box levétele a Fieldről
     * @param b a Box amit le kell venni
     */
    public void remove(Box b) {							
        thing = null;
    }
    /**
     * Dolog levétele a Fieldről
     */
    public void setThingToNull() {						
    	thing = null;
    }

    /**
     * Player ráállítása a Fieldre
     * @param p a Player referenciája
     */
    public void set(Player p) {        					
        if (thing != null)
            System.err.println("Error: thing is not null! (Field.Set(player))");
      
        thing = p;	
    }

    /**
     * Player levétele a mezőről
     * @param p Player referenciája
     */
    public void remove(Player p) {	
        thing = null;
    }

    /**
     * visszaadja a Thinget ami a Fielden van
     * @return a Thing referenciája
     */
    public Thing getThing() {
        return thing;
    }
}