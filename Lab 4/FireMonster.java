public class FireMonster extends Monster {
	
	/** To keep track of occurances */
	int time=1;
	
	/** Constructor taking only two parameters */
	public FireMonster(int hitPoints, Attack[] attacks) {
		
		super("Fire", hitPoints, attacks);
	
	}
	
	/** Definition of dodge() method */
	protected boolean dodge() {
		
		/** Odd numbers (including one i.e. the first time) would return true */
		if(time%2!=0) {
			
			time++;
			return true;
		
		}
		
		/** Even numbers return false */
		else {
			
			time++;
			return false;
		
		}
	
	}
	
}
