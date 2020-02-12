public abstract class Monster {

	/** The type */
	protected String type;
	/** Current hit points */
	protected int hitPoints;
	/** Data regarding Attacks */
	protected Attack[] attacks;

	public Monster(String type, int hitPoints, Attack[] attacks) {
		
		this.type = type;
		this.hitPoints = hitPoints;
		this.attacks = attacks;
		
	}

	
	/**
	 * Returns the current hit points of this Monster.
	 * 
	 * @return The current hit points
	 */
	public int getHitPoints() {
		
		return hitPoints;
		
	}

	
	/**
	 * Returns the type of this Monster.
	 * 
	 * @return The monster type
	 */
	public String getType() {
		
		return this.type;
		
	}

	
	/**
	 * Returns the list of attacks available to this Monster.
	 * 
	 * @return The list of attacks
	 */
	public Attack[] getAttacks() {
		
		return attacks;
		
	}


	/**
	 * Helper method to find the points for the given attack.
	 * 
	 * @param attack The attack to look for
	 * @return The corresponding points, or -1 if the attack is not found
	 */
	private int getAttackPoints(String attack) {
		
		// Look through the list and find the position of the attack
		int pos = -1;
		for (int i = 0; i < attacks.length; i++) {
			
			if (attacks[i].getName().equals(attack)) {
				
				pos = i;
				break;
				
			}
			
		}
		
		// If we found it, return the points; otherwise, return -1
		if (pos >= 0) {
			
			return attacks[pos].getPoints();
			
		} else {
			
			return -1;
			
		}
		
	}

	
	/**
	 * Attacks the given other monster, and returns a Boolean value indicating
	 * whether the attack was successful. An attack fails if otherMonster is
	 * equal to this monster, if either this Monster or otherMonster is
	 * knocked out, or if the given attack name is not valid. If the attack
	 * succeeds, the corresponding hit points are removed from otherMonster;
	 * if it fails, no changes are made to either Monster.
	 * 
	 * @param attack The attack to use
	 * @param otherMonster The Monster to attack
	 * @return True if the attack was successful, and false if not
	 */
	public void attack(String attack, Monster otherMonster) throws MonsterException{
		
		// A monster cannot attack itself
		if (otherMonster == this) {
			
			throw new MonsterException("The monster cannot attack yourself!");
		
		}

		// A monster cannot attack or be attacked if it is knocked out
		if (this.hitPoints <= 0 || otherMonster.getHitPoints() <= 0) {
			
			throw new MonsterException("The monster is knocked out!");
		
		}

		// Find the attack -- if it exists, use it, otherwise
		// damage the attacking monster
		int points = getAttackPoints(attack);
		if (points < 0) {
			
			throw new MonsterException("Attack does not exist!");
		
		} 
		
		else {
			
			if(otherMonster.dodge()) {
				
				this.removeHitPoints(10);
			
			} 
			
			else {
				
				otherMonster.removeHitPoints(points);
			
			}
		
		}
		
	}

	
	/**
	 * Removes the given hit points from the current monster. If the hit 
	 * points would go below zero, it is set to zero.
	 * 
	 * @param points The number of points to remove
	 */
	public void removeHitPoints(int points) {
		
		this.hitPoints -= points;
		if (hitPoints <= 0) {
			
			// Monster is knocked out
			hitPoints = 0;
			
		}
		
	}

	@Override
	/**
	 * Returns a nice String representation of this Monster.
	 */
	public String toString() {
		
		return "Monster [type=" + type + ", hitPoints=" + hitPoints + ", attacks=" + attacks.toString();
	
	}
	
	
	/**
	 * An abstract method of dodge()
	 */
	protected abstract boolean dodge();

}
