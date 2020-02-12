// Inesh Bose
// 2504266B


public class WaterMonster extends Monster {
	
	/** Constructor taking only two parameters */
	public WaterMonster(int hitPoints, Attack[] attacks) {
		
		super("Water", hitPoints, attacks);
	
	}
	
	/** Definition of dodge() method */
	protected boolean dodge() {
		
		if(hitPoints>=100) {
			
			return true;
		
		}
		
		else {
			
			return false;
		
		}
	
	}
	
}