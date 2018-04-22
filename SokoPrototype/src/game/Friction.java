package game;

public enum Friction {	
		OIL(1), 
		NORMAL(2), 
		HONEY(3);
	
		private final int value;
		
		Friction(int value){
			this.value = value;
		}
		
		public int GetValue() {
			return value;
		}	
}
