// Inesh Bose (2504266B)

package trainer;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import monster.Attack;
import monster.ElectricMonster;
import monster.FireMonster;
import monster.Monster;
import monster.WaterMonster;

public class Trainer {

	/** The name of Trainer */
	private String name;
	/** The collection of Monsters */
	private Set<Monster> monsters;
	
	/**
	 * Creates a new Trainer with the given properties.
	 * 
	 * @param name         The name of the Trainer
	 */
	public Trainer(String name) {
		this.name = name;
		this.monsters = new HashSet<>();
	}
	
	/**
	 * Counts the number of Monsters for each type.
	 * 
	 * @return A map for type and number
	 */
	public Map<String, Integer> countMonstersByType() {
		Map<String, Integer> monsterMap = new HashMap<>();
		for (Monster m : monsters) {
			if (monsterMap.get(m.getType()) == null) {
				monsterMap.put(m.getType(), 1);
			} else {
				monsterMap.put(m.getType(), monsterMap.get(m.getType()) + 1);
			}
		}
		return monsterMap;
	}
	
	/**
	 * Checks if Trainer has a monster
	 * 
	 * @param monster Monster to check
	 * @return If trainer has monster
	 */
	public boolean hasMonster(Monster monster) {
		return monsters.contains(monster);
	}

	/**
	 * Returns the name of the Trainer.
	 * 
	 * @return The name of Trainer
	 */
	public String getName() {
		return name;
	}

	/**
	 * Removes monster from Trainer's collection
	 * 
	 * @param monster Monster to remove
	 * @return If monster has been successfully removed
	 */
	public boolean removeMonster(Monster monster) {
		return monsters.remove(monster);
	}
	
	/**
	 * Adds monster to Trainer's collection
	 * 
	 * @param monster Monster to add
	 * @return If monster has been successfully added
	 */
	public boolean addMonster(Monster monster) {
		return monsters.add(monster);
	}
	
	/**
	 * Returns a nice String representation of this Monster.
	 */
	public String toString() {
		return name + ": " + monsters;
	}
	
	/**
	 * Returns the collection of Monsters
	 * 
	 * @return Collection of monsters
	 */
	public Collection<Monster> getMonsters() {
		return monsters;
	}
	
	/**
	 * Saves the data of the Trainer
	 * 
	 * @param filename The path/filename where data is stored
	 */
	public void saveToFile(String filename) throws IOException {
		// Open the file
		PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get(filename)));

		writer.println(this.name);

		// Write the monsters one line at a time
		for (Monster monster : monsters) {
			writer.print(monster.getType());
			writer.print("^");
			writer.print(monster.getHitPoints());
			for (Attack attack : monster.getAttacks()) {
				writer.print("^");
				writer.print(attack.getName());
				writer.print("^");
				writer.print(attack.getPoints());
			}
			writer.println();
		}

		// We are done!
		writer.close();
	}
	
	/**
	 * Loads the data of the Trainer
	 * 
	 * @param filename The path/filename where data is stored
	 */
	public static Trainer loadFromFile(String filename) throws IOException {
		// Load the whole file into a List<String> in memory
		Path p = Paths.get(filename);
		List<String> lines = Files.readAllLines(p);

		// First line is name
		String name = lines.remove(0);
		Trainer trainer = new Trainer(name);

		// Process the rest of the lines into Monster objects
		for (String line : lines) {
			// Split the line
			String[] fields = line.split("\\^");
			Attack[] attacks = new Attack[(fields.length - 2)/2];
			for (int i = 2; i < fields.length; i+=2) {
				attacks[(i-2)/2] = new Attack(fields[i], Integer.parseInt(fields[i+1]));
			}
			// Use the fields to create a new Monster and add it
			Monster monster = createMonster(fields[0], Integer.parseInt(fields[1]),
					attacks);
			if (monster != null) {
				trainer.addMonster(monster);
			}
		}

		// Return the newly created Trainer
		return trainer;
	}

	/**
	 * Creates a monster with the values.
	 * 
	 * @param type Type of Monster
	 * @param hitPoints HP of Monster
	 * @param attacks Attacks of Monster
	 */
	public static Monster createMonster(String type, int hitPoints, Attack[] attacks) {
		switch (type) {
		case "Fire":
			return new FireMonster(hitPoints, attacks);
			
		case "Water":
			return new WaterMonster(hitPoints, attacks);
			
		case "Electric":
			return new ElectricMonster(hitPoints, attacks);
		}
		System.err.println("Invalid type: " + type);
		return null;
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
		Trainer other = (Trainer) obj;
		if (monsters == null) {
			if (other.monsters != null)
				return false;
		} else if (!monsters.equals(other.monsters))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		result = prime * result + ((monsters == null) ? 0 : monsters.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
}
