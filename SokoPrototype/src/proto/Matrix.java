package proto;

import java.io.PrintStream;

//import java.io.OutputStream;


import game.*;
public class Matrix {
	
	public void Draw(PrintStream p, Field[][] map) {
		
		for(int i=0; i<map.length; ++i) {
			for(int j=0; j<map[i].length; ++j) {
				if(map[i][j].getThing() == null) {
					p.print(map[i][j].MatrixElement());
				}else {
					p.print(map[i][j].getThing().MatrixElement());
				}
			}
			p.println();
		}	
		
	}	
}
