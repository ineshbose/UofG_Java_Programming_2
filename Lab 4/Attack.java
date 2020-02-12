// Inesh Bose
// 2504266B


public class Attack {
	
	/** Name of the attack */
	private String attackName;
	/** Point for attack */
	private int attackPoints;
	
	public Attack(String attackName, int attackPoints) {
		
		this.attackName = attackName;
		this.attackPoints = attackPoints;
		
	}
	
	/** Getter Method to obtain attackName */
	public String getName() {
		
		return attackName;
		
	}
	
	/** Getter Method to obtain point for attack */
	public int getPoints() {
		
		return attackPoints;
		
	}
	
	/** Overriden toString() method for formatted representation */
	public String toString() {
		
		return attackName + " (Points " + attackPoints + ")";
		
	}
	
}
