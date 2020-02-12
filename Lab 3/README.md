# Lab 3 (14/10/19)

## Task
Implement a class `Monster` representing a (simplified) monster in a monster-battling game. A monster includes a **type**, a number of **hit points**, a list of **attacks**, and a list of **attack points**.

### Fields and Constructor
The relevant properties should be included in the **Monster** class by defining the following `private` fields:
* `type (String)`
* `hitPoints (int)`
* `attacks (String[])`
* `attackPoints (int[])`
There should be a single public constructor method that takes four parameters to initialise the fou fields. The constructor signature should be:
<pre>
    public Monster(String type, int hitPoints, 
            String[] attacks, int[] attackPoints)
</pre>

### Methods
Define getter methods for all of the **Monster** fields:
* `public String getType()`
* `public int getHitPoints()`
* `public String[] getAttacks()`
* `public int[] getAttackPoints()`

Also override the inherited `toString()` method to return a String including the values of the object fields. Also define the following two methods which are used when monsters battle each other:
* `public void removeHitPoints(int pointsToRemove)`
    * Removes the indicated number of hit points from the current monster. If the hit point value becomes negative, then it should be set to zero.
* `public boolean attack (String attack, Monster otherMonster)`
    * This method is called when the current monster attacks the other monster with the given attack.

<br>

## Grade: 5/5