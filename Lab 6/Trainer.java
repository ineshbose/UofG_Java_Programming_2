package trainer;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import monster.*;

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
	public void saveToFile(String filename) throws IOException{
		String monsterInfo = "";
		for (Monster m : monsters) {
			monsterInfo+=m.writeToFile();
		}
		Path p = Paths.get(filename);
		PrintWriter p1 = new PrintWriter(Files.newBufferedWriter(p));
		p1.println(name + "#" + monsterInfo);
		p1.close();
	}
	
	/**
	 * Loads the data of the Trainer
	 * 
	 * @param filename The path/filename where data is stored
	 */
	public static Trainer loadFromFile(String filename) throws IOException{
		List<String> lines = Files.readAllLines(Paths.get(filename));
		String line = lines.get(0);
		String[] fields = line.split("\\#");
		Trainer baseTrainer = new Trainer(fields[0]);
		String monsterInfo = fields[1];
		String[] eachMonster = monsterInfo.split("\\%");
		/* A trainer has multiple monsters */
		for(int i=0;i<eachMonster.length;i++) {
			String[] monsterStat = eachMonster[i].split("\\*");
			String monsterType = monsterStat[0];
			int monsterHP = Integer.parseInt(monsterStat[1]);
			String[] attackInfo = monsterStat[2].split("\\~");
			Attack[] attackList = new Attack[attackInfo.length];
			/* A monster has multiple attacks */
			for(int j=0;j<attackInfo.length;j++) {
				String[] attackStat = attackInfo[j].split("\\&");
				String attackName = attackStat[0];
				int attackPt = Integer.parseInt(attackStat[1]);
				attackList[j] = new Attack(attackName, attackPt);
			}
			if(monsterType.equals("Fire")) {
				baseTrainer.addMonster(new FireMonster(monsterHP, attackList));
			}
			else if(monsterType.equals("Water")) {
				baseTrainer.addMonster(new WaterMonster(monsterHP, attackList));
			}
			else if(monsterType.equals("Electric")) {
				baseTrainer.addMonster(new ElectricMonster(monsterHP, attackList));
			}
		}
		return baseTrainer;
	}
	
}
