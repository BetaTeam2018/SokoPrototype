package proto;

import java.io.PrintStream;



import game.*;
/**
 * a pálya mátrixos alakban való kirajzolásáért felelős osztály
 *
 */
public class Matrix {
	/**
	 * kirajzolja a paraméterként kapott 2D-s tömböt mátrixos alakban a Megadott Streamre
	 * @param p a megadott Stream
	 * @param map a pálya 2D-s tömb alakban
	 */
	public void Draw(PrintStream p, Field[][] map) {
		
		for(int i=0; i<map.length; ++i) {
			for(int j=0; j<map[i].length; ++j) {
				if(map[i][j].getThing() == null) {
					p.print(map[i][j].MatrixElement()); //ha nincs rajta semmi a Fieldet írjuk ki
				}else {
					p.print(map[i][j].getThing().MatrixElement()); //ha van a Thinget
				}
			}
			p.println();
			
		}		
	}	
}
