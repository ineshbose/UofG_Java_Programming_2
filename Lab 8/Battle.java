// Inesh Bose (2504266B)

package battle;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.ArrayList;
import java.util.List;

import monster.Monster;

public class Battle{
	
	/** The Thread Lock */
	public Lock lock = new ReentrantLock();
	/** The Thread Condition */
	public Condition condition = lock.newCondition();
	/** The Atomic Reference of Thread */
	public AtomicReference<Monster> waitingMonster = new AtomicReference<>(null);
	
	public static void main (String[] args) throws InterruptedException{
		
		Battle battle = new Battle();
		List<Monster> monsters = Utils.generateMonsters(4);
		List<Thread> threads = new ArrayList<>();
		
		for(Monster m : monsters) {
			
			threads.add(new Thread(new MonsterRunner(m, battle)));
			
		}
		
		for (Thread t : threads) {
			
			t.start();
			
		}
		
		Thread.sleep(10000);
		
		for (Thread t : threads) {
			
			t.interrupt();
			
		}
		
		for (Thread t : threads) {
			
			t.join();
			
		}
		
	}
	
}
