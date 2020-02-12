package monster;
import java.util.Arrays;

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

		int pointsToRemove = getAttackPoints(attack);
		// Check if the other monster has dodged
		if (!otherMonster.dodge()) {
			// Find the attack -- if it exists, use it and return true, otherwise
			// do nothing and return false
			otherMonster.removeHitPoints(pointsToRemove);
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
		return "Monster [type=" + type + ", hitPoints=" + hitPoints + ", attacks=" + Arrays.toString(attacks);
	}
	
	/**
	 * Compares and sorts two Monsters using Comparable interface according to:
	 * 1. Decreasing order of hit points
	 * 2. Alphabetical order based on type
	 * 
	 * @param otherMonster Monster to compare to
	 * @return Comparison of strings (ascending) / hitPoints (descending)
	 */
	public int compareTo (Monster otherMonster) {
		if(this.getHitPoints() == otherMonster.getHitPoints()) {
			return this.getType().compareTo(otherMonster.getType());
		}
		else {
			return -Integer.compare(this.getHitPoints(), otherMonster.getHitPoints());
		}
	}
	
	/**
	 * Returns a String that will help to write and load the file.
	 * 
	 * @return String according to format
	 */
	public String writeToFile() {
		String attackInfo = "";
		for(Attack attack : attacks) {
			attackInfo+=attack.writeToFile();
		}
		return type + "*" + hitPoints + "*" + attackInfo + "%";
	}
	
}
