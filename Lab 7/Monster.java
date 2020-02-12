package monster;
import java.util.Arrays;
import java.util.Objects;


public abstract class Monster implements Comparable<Monster> {

	/** The type */
	protected String type;
	/** Current hit points */
	protected int hitPoints;
	/** List of attacks */
	protected Attack[] attacks;
	
	/**
	 * Creates a new Monster with the given properties.
	 * 
	 * @param type         The type to use
	 * @param hitPoints    The initial hit points
	 * @param attacks      The list of attacks
	 */
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
	private int getAttackPoints(String attackName) throws MonsterException {
		for (Attack attack : attacks) {
			if (attack.getName().equals(attackName)) {
				return attack.getPoints();
			}
		}
		throw new MonsterException("Invalid attack name: " + attackName);
	}

	/**
	 * Attacks the given other monster. An attack fails if otherMonster is
	 * equal to this monster, if either this Monster or otherMonster is
	 * knocked out, or if the given attack name is not valid. If the attack
	 * succeeds, the corresponding hit points are removed from otherMonster;
	 * if it fails, no changes are made to either Monster.
	 * 
	 * @param attack The attack to use
	 * @param otherMonster The Monster to attack
	 */
	public void attack(String attack, Monster otherMonster) throws MonsterException {
		// A monster cannot attack itself
		if (otherMonster == this) {
			throw new MonsterException("A monster cannot attack itself");
		}

		// A monster cannot attack or be attacked if it is knocked out
		if (this.hitPoints <= 0) {
			throw new MonsterException("Attacking monster is knocked out");
		}
		if (otherMonster.hitPoints <= 0) {
			throw new MonsterException("Attacked monster is knocked out");
		}

		// Check if the other monster has dodged
		if (!otherMonster.dodge()) {
			// Find the attack -- if it exists, use it and return true, otherwise
			// do nothing and return false
			otherMonster.removeHitPoints(getAttackPoints(attack));
		} else {
			this.removeHitPoints(10);
		}
	}
	
	/**
	 * An abstract method used when a monster might dodge in battle.
	 * @return Whether the monster dodges
	 */
	protected abstract boolean dodge();

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
		return type + " (" + hitPoints + "): " + Arrays.toString(attacks);
	}

	/**
	 * Compares and sorts two Monsters using Comparable interface according to:
	 * 1. Decreasing order of hit points
	 * 2. Alphabetical order based on type
	 * 
	 * @param otherMonster Monster to compare to
	 * @return Comparison of strings (ascending) / hitPoints (descending)
	 */
	public int compareTo(Monster otherMonster) {
		int result = Integer.compare(otherMonster.hitPoints, this.hitPoints);
		if (result == 0) {
			return this.type.compareTo(otherMonster.type);
		} else {
			return result;
		}
	}

	@Override
	/**
	 * Returns boolean value according to equality for particular object.
	 * 
	 * @param obj Object to equate to
	 * @return Boolean value according to equality
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monster other = (Monster) obj;
		if (!Arrays.equals(attacks, other.attacks))
			return false;
		if (hitPoints != other.hitPoints)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	@Override
	/**
	 * Returns hash code value for object.
	 * 
	 * @return Integral hash code for object
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(attacks);
		result = prime * result + hitPoints;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
}
