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
	private List<Integer> trapdoorIdx = new LinkedList<Integer>();
	private List<Player> players = new LinkedList<Player>();
		
	public List<Player> getPlayers() {
		return players;
	}
		
	public Field[][] getFields() {
		Field[][] f = new Field[y][x];
		// x*y grid
		for(int i=0; i<y; ++i) {
			for(int j=0; j<x; ++j) {
				f[i][j] = fields.get(i*x+j);
			}
		}
		
		//TODO
		for(int i=0; i< y; i++) {
			for(int j =0; j< x-1; j++) {
				Field.ConnectHorizontal(f[i][j], f[i][j+1]);				
			}		
		}
		
		for(int i=0; i< y-1; i++) {
			for(int j =0; j< x; j++) {
				Field.ConnectVertical(f[i][j], f[i+1][j]);				
			}		
		}
				
		return f;
	}

	public void Load(InputStream is){
		sc = new Scanner(is);
		
		x = Integer.parseInt(sc.nextLine());
		y = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<x*y; ++i) {
			CreateField(sc.nextLine());
		}
		
		for(int i=0; i<switches.size(); ++i) {
			switches.get(i).setTd( (TrapDoor) fields.get(trapdoorIdx.get(i)));
		}
		
		while(sc.hasNext()) {
			CreateThing(sc.nextLine());
		}
	}
		
	private void CreateThing(String line) {
		String[] parts = line.split(" ");
		
		switch(parts[0]) {
			case "p":
				Player p = new Player();
				p.setField(fields.get(Integer.parseInt(parts[1])));
				p.setStrength(Integer.parseInt(parts[2]));
				p.getCurrentField().set(p);
				players.add(p);				
				break;
				
			case "b":
				Box b = new Box();
				b.setField(fields.get(Integer.parseInt(parts[1])));
				b.getCurrentField().set(b);
				break;
		}
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
				trapdoorIdx.add(Integer.parseInt(parts[3]));
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
