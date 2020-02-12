# Lab 5 (28/10/19)

## Task
Implement the following classes providing methods with suggestive names:

### Trainer class
Create a class in the **trainer** package called **Trainer** that has a name, a collection of Monsters and methods to manage the Monsters.<br />
The **Trainer** class should provide the following methods:
* `public Trainer (String name)`
* `public String getName()`
* `public boolean addMonster (Monster monster)`
* `public boolean removeMonster (Monster monster)`
* `public boolean hasMonster (Monster monster)`
* `public Map<String, Integer> countMonstersByType()`
* `public String toString()`

### Trade class
Create a class in the **trainer** package called **Trade** with the following methods:
* `public Trade(Trainer trainer1, Monster monster1, Trainer trainer2, Monster monster2) throws MonsterException`
* `public void doTrade()`
    
<br>

## Grade: 5/5