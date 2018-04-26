package game;
/**
 * Enumeráció a súrlódásoknak
 *
 *
 */
public enum Friction {
		OIL(1), 
		NORMAL(2), 
		HONEY(3);
	
	/**
	 * A Friction értéke Integer formában
	 */
		private final int value;
		/**
		 * beállítja az adott Integer érték alapján a value értéket
		 * @param value
		 */
		Friction(int value){
			this.value = value;
		}
		/**
		 * visszaadja a az adott Friction értéket Integer formában
		 * @return
		 */
		public int GetValue() {
			return value;
		}	
}
