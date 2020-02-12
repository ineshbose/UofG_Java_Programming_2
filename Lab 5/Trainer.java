package trainer;
import monster.Monster;
import java.util.*;

public class Trainer {

	/** The name of the Trainer */
	private String trainerName;
	/** The Trainer's collection of Monsters */
	private Set<Monster> trainerMonsters = new HashSet<>();
	
	public Trainer(String trainerName) {
		
		this.trainerName = trainerName;
		
	}
	
	
	/**
	 * Returns the name of this Trainer.
	 * 
	 * @return The name
	 */
	public String getName() {
		
		return trainerName;
		
	}
	
	
	/**
	 * Adds Monster to this Trainer's collection.
	 * 
	 * @param monster The monster to add to the collection
	 * @return If monster has been successfully added
	 */
	public boolean addMonster(Monster monster) {
		
		return trainerMonsters.add(monster);
		
	}
	
	
	/**
	 * Removes Monster from this Trainer's collection.
	 * 
	 * @param monster The monster to remove from the collection
	 * @return If monster has been successfully removed
	 */
	public boolean removeMonster(Monster monster) {
		
		return trainerMonsters.remove(monster);
		
	}
	
	
	/**
	 * Checks if Monster is in the Trainer's collection.
	 * 
	 * @param monster The monster to check in the collection
	 * @return If monster is in the Trainer's collection
	 */
	public boolean hasMonster(Monster monster) {
		
		return trainerMonsters.contains(monster);
		
	}
	
	
	/**
	 * Counts the number of Monsters of each type that a Trainer has.
	 * 
	 * @return The values for each type as a HashMap.
	 */
	public Map<String, Integer> countMonstersByType(){
		
		Map<String, Integer> count = new HashMap<>();
		for(Monster monster : trainerMonsters) {
			
			Integer value = count.get(monster.getType());
			if(value == null) {
				
				value = 0;
				
			}
			
			count.put(monster.getType(), value+1);
			
		}
		
		return count;
		
	}
	
	
	/**
	 * Returns a nice String representation of this Trainer.
	 */
	public String toString() {
		
		return this.trainerName + " has " + this.trainerMonsters.toString();
		
	}
	
}
