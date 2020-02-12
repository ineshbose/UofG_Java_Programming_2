// Inesh Bose (2504266B)

package battle;
import battle.Battle;
import monster.Monster;

public class MonsterRunner implements Runnable{
	
	/** The monster */
	private Monster mons;
	/** The battle royale */
	private Battle battle;
	
	/**
	 * Creates a new MonsterRunner with the given properties.
	 * 
	 * @param mons         The monster in the battle
	 * @param battle    The battle royale field
	 */
	public MonsterRunner(Monster mons, Battle battle){
		
		this.mons = mons;
		this.battle = battle;
		
	}
	
	@Override
	public void run() {
		
		while(this.mons.getHitPoints() > 0) {
			
			System.out.println(Thread.currentThread().getId() + ": waiting for the lock");
			try {
				
				battle.lock.lockInterruptibly();
				
			} catch (InterruptedException e) {
				
				System.out.println(Thread.currentThread().getId() + ": interrupted in lock()");
				break;
				
			}
		
			System.out.println(Thread.currentThread().getId() + ": got the lock");
			if(battle.waitingMonster.compareAndSet(null, this.mons)) {
			
				try {
					
					battle.condition.await();
					
				} catch (InterruptedException e) {
					
					battle.lock.unlock();
					System.out.println(Thread.currentThread().getId() + ": interrupted in await()");
					break;
					
				}
			
			}
			
			else {
				
				Monster otherMonster = battle.waitingMonster.getAndSet(null);
				if(Utils.RAND.nextBoolean()) {
					
					Utils.doAttack(mons, otherMonster);
					System.out.println(mons.getName() + " attacked " + otherMonster.getName());
				
				}
				
				else {
					
					Utils.doAttack(otherMonster, mons);
					System.out.println(otherMonster.getName() + " attacked " + mons.getName());
				
				}
				
				battle.condition.signal();
				
			}
		
			battle.lock.unlock();
			try {
			
				Thread.sleep(500);
			
			} catch (InterruptedException e) {
			
				System.out.println(Thread.currentThread().getId() + ": interrupted in sleep()");
				break;
			
			}
		
		}
		
	}
	
}
