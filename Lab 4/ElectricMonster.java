// Inesh Bose
// 2504266B


public class ElectricMonster extends Monster {
	
	/** Constructor taking only two parameters */
	public ElectricMonster(int hitPoints, Attack[] attacks) {
		
		super("Electric", hitPoints, attacks);
	
	}
	
	/** Definition of dodge() method and would always return false */
	protected boolean dodge() {
		
		return false;
		
	}
	
}