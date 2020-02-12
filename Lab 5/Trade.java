package trainer;
import monster.Monster;
import monster.MonsterException;

public class Trade {
	
	/** The Trainers that will trade */
	private Trainer trainer1,trainer2;
	/** The Monsters that will be traded */
	private Monster monster1,monster2;
	
	public Trade(Trainer trainer1, Monster monster1, Trainer trainer2, Monster monster2) throws MonsterException{
		
		/** Checks if both trainers have their respective monsters else throws an exception */
		if(trainer1.hasMonster(monster1) && trainer2.hasMonster(monster2)) {
			
			this.trainer1 = trainer1;
			this.trainer2 = trainer2;
			this.monster1 = monster1;
			this.monster2 = monster2;
			
		}
		
		else {
			
			throw new MonsterException("Monster does not belong to trainer.");
			
		}
	
	}
	
	
	/**
	 * Trades the monsters between the trainers.
	 */
	public void doTrade() {
		
		trainer1.removeMonster(monster1);
		trainer1.addMonster(monster2);
		trainer2.removeMonster(monster2);
		trainer2.addMonster(monster1);
		
	}

}
