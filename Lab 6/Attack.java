package monster;

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
		return "Attack [name=" + name + ", points=" + points + "]";
	}
	
	/**
	 * Returns a String that will help to write and load the file.
	 * 
	 * @return String according to format
	 */
	public String writeToFile() {
		return name + "&" + points + "~";
	}
	
}
