package planning;

/**
 * Class Thing with fields 'name' and 'location'.
 */
public class Thing {

	/** Name of Thing */
	private String name;
	/** Location of Thing */
	private Location location;
	
	/**
	 * Creates a new Thing with the given properties.
	 * 
	 * @param name 		Name of Thing
	 * @param location 	Location of Thing
	 */
	public Thing(String name, Location location) {
		this.name = name;
		this.location = location;
	}

	/**
	 * Returns name of thing.
	 * 
	 * @return name of thing.
	 */
	public String getName() {	
		return name;
	}

	/**
	 * Returns location of thing.
	 * 
	 * @return location of thing.
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets location of thing.
	 * 
	 * @param location New location of thing.
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thing other = (Thing) obj;
		if (location != other.location)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Thing [name=" + name + ", location=" + location + "]";
	}
	
}
