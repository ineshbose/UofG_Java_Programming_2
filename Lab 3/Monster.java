import java.util.Arrays;

// Inesh Bose
// 2504266B


public class Monster {
	
	private String type;
	private int hitPoints;
	private String[] attacks;
	private int[] attackPoints;
	
	// Constructor
	
	public Monster(String type, int hitPoints, String[] attacks, int[] attackPoints) {
		
		this.type = type;
		this.hitPoints = hitPoints;
		this.attacks = attacks;
		this.attackPoints = attackPoints;
		
	}
	
	// Getter Methods
	
	public String getType() {
		
		return type;
		
	}
	
	public int getHitPoints() {
		
		return hitPoints;
		
	}
	
	public String[] getAttacks() {
		
		return attacks;
		
	}
	
	public int[] getAttackPoints() {
		
		return attackPoints;
		
	}
	
	// Print Data about Monster
	
	public String toString() {
		
		String attackList = Arrays.toString(attacks);
		String attackPtList = Arrays.toString(attackPoints);
		return "Monster " + type + " (HP " + hitPoints + ") has " + attackList + " worth " + attackPtList + " damage respectively.";
		
	}
	
	// Damage to Monster Method
	
	public void removeHitPoints (int pointsToRemove) {
		
		this.hitPoints-=pointsToRemove;
		if(hitPoints<0) {
			
			this.hitPoints = 0;
			
		}
		
	}
	
	// Attack Monster Method
	
	public boolean attack (String attack, Monster otherMonster) {
		
		boolean haveAttack = false; // To check if monster has the attack
		int damage = 0;				// To store hitPoints of attack corresponding to index
		
		// To check if Monster is the same
		
		if(otherMonster == this) {
			
			return false;
			
		}
		
		// To check if Monster is knocked out
		
		if(this.hitPoints == 0 || otherMonster.getHitPoints() == 0) {
			
			return false;
			
		}
		
		// To check if attack is available and take hitPoints
		
		for(int i=0;i<attacks.length;i++) {
			
			if(attacks[i].equals(attack)) {
				
				haveAttack = true;
				damage = this.attackPoints[i];
				break;
				
			}
			
		}
		
		// If attack is unavailable, return false
		
		if(haveAttack == false) {
			
			return haveAttack;
			
		}
		
		// If attack is available, remove hitPoints from otherMonster
		
		otherMonster.removeHitPoints(damage);
		return true;
		
	}
	
}
