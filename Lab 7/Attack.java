// Inesh Bose (2504266B)

package monster;

import java.util.Objects;

public class Attack {
	
	/** The name of Attack */
	private String name;
	/** The points of Attack */
	private int points;
	
	/**
	 * Creates a new Attack with the given properties.
	 * 
	 * @param name         The name of the Attack
	 * @param points	   The points of the Attack
	 */
	public Attack(String name, int points) {
		this.name = name;
		this.points = points;
	}

	/**
	 * Returns the name of the Attack.
	 * 
	 * @return The name of attack
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the points of the Attack.
	 * 
	 * @return The points of attack
	 */
	public int getPoints() {
		return points;
	}

	@Override
	/**
	 * Returns a nice String representation of this Monster.
	 */
	public String toString() {
		return name + " (" + points + ")";
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
		Attack other = (Attack) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (points != other.points)
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + points;
		return result;
	}
	
}
