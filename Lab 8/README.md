# Lab 8 (18/11/19)

## Task
Write classes to allow a large group of Monsters to battle together. Each Monster will battle in its own, separate thread, and the process proceeds as follows:
* When a Monster **m1** is ready to battle, it checks the waiting area.
    * If another monster **m2** is already waiting, then **m1** will battle **m2**
    * If no other monster is waiting, **m1** will go to the waiting area and wait for another monster to be ready.
* When two Monsters **m1** and **m2** battle..
    * One of the monsters is randomly chosen to be the attack and the other will be the defender.
    * The attack randomly chooses one of its attacks and attacks the defender using the **Monster.attack()** method.

Implement two classes as follows:
### Battle
This class keeps track of the overall battle and contains a **main** method to run it. It should have three fields: a **java.util.concurrent.locks.Lock** object which is used to control access to the battle, a **java.util.concurrent.locks.Condition** object which is used to implement the waiting behaviour, and a **java.util.concurrent.atomic.AtomicReference<Monster>** object which is used to hold a Monster that is waiting to join a battle. The **main()** method should:
* Create a new **Battle** object and a list of **Monster** objects
* For each **Monster**, create a **Thread** object to run it in battle and **start()** the thread
* Wait for 10 seconds
* Interrupt all of the threads and wait for them all to terminate

### MonsterRunner
This class implements the **Runnable** interface and should have two instance fields - a **Monster** and a **Battle**. It should have an overriden **run()** method that does the following:
* While the associated **Monster** is not knocked out,
    * Get the battle lock
    * Check if **waitingMonster** is set to a non-null value
        * If the field is already set, start a battle and then set the field to zero
        * If the field is not set, set **waitingMonster** to the associated monster
    * After the battle is completed, the **run()** method should pause for 500ms
* If the thread is interrupted at any point, break the while loop

<br>

## Grade: 5/5