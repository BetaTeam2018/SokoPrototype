package game;

import java.util.List;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class MapLoader {
	private Scanner sc;	
	private int x, y;
	private List<Field> fields = new LinkedList<Field>();
	private List<Switch> switches = new LinkedList<Switch>();
	private List<Integer> connectedTD = new LinkedList<Integer>();
	private List<Player> players = new LinkedList<Player>();
	
	
	public MapLoader(InputStream is) {
		sc = new Scanner(is);
	}
	
	public Field[][] Load(){
		x = Integer.parseInt(sc.nextLine());
		y = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<x*y; ++i) {
			CreateField(sc.nextLine());
		}
		
		for(int i=0; i<switches.size(); ++i) {
			switches.get(i).setTd( (TrapDoor) fields.get(connectedTD.get(i)));
		}
		
		//TODO
		return null;
		
	}
	
	
	private Thing CreateThing(String line) {
		String[] parts = line.split(" ");
		//TODO
		switch(parts[0]) {
			case "p":				
				break;
			case "b":
				break;
		}
		//TODO
		return null;
	}
	
	private void CreateField(String line) {
		Field f;
		String[] parts = line.split(" ");
		
		switch(parts[1]) {
			//floor
			case "f":
				f = new Floor();
				friction(f, parts[2]);
				break;
		
			//hole
			case "h":
				f = new Hole(); 				
				break;
			
			//storage area
			case "a":
				f = new StoreageArea();
				friction(f, parts[2]);
				break;
				
			//switch
			case "s":
				Switch s = new Switch();
				friction(s, parts[2]);
				switches.add(s);
				connectedTD.add(Integer.parseInt(parts[3]));
				f = s;
				break;
				
			//trapdoor
			case "t":
				f = new TrapDoor();
				friction(f, parts[2]);
				break;
			
			//wall
			case "w":
				f = new Wall();				
				break;
				
			default:
				f = null;
		}
		
		fields.add(f);
	}
	
	private void friction(Field f, String s) {
		switch (s) {
		case "O":
			f.setFriction(Friction.OIL);
			break;
		case "N":
			f.setFriction(Friction.NORMAL);
			break;
		case "H":
			f.setFriction(Friction.HONEY);
			break;
		}
	}
					
	@Override
	protected void finalize(){
		sc.close();
	}
	
	
	
}
