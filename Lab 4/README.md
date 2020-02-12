# Lab 4 (21/10/19)

## Task
Refactor the **Monster** class from Lab 3 into a set of classes that are able to represent every type of monster as its own class, instead of using the **type** field to distinguish them. The information that is common to all monsters will be retained in the **Monster** class, which will be made **abstract**, while other information that is relevant only to one of the monster types will be put into the appropriate subclass.

### Attack class
Create an **Attack** class to hold the details of an attack - the name (String) and the points (integer). It should have a constructor that sets those two fields, getter methods for both fields and an overriden `toString()` implementation.

### Subclasses and Fields
Create three concrete subclasses of **Monster**: FireMonster, WaterMonster and ElectricMonster, each of which will represent monster of that specific type only. The constructors of these classes should take only two parameters- **hitPoints** and **attacks**.

### MonsterException
Create an additional class **MonsterException**, which is a subclass of Exception. This class should consist only of a constructor which takes one parameter, a String, and calls the corresponding super-class constructor.

### dodge()
Add an abstract **dodge()** method to the parent **Monster** class that should return a boolean value and will be implemented in the subclasses to implement the modified **attack()** behaviour described below. The method should have a **protected** access modifier.<br />
The required behaviour for each subclass is as follows:
* **FireMonster**: this method should alternatively return **true** and **false**
* **WaterMonster**: this method should return **true** if the monster's hit points are at least 100, and **false** if they are less than 100
* **ElectricMonster**: this method should always return **false**

### attack()
Modify the **attack()** method of **Monster** in the following ways:
* The return type should be changed from **boolean** to **void**
* The signature should be modified to indicate that the method might throw a **MonsterException**
* Every case where the original method returns **false** should be modified to instead throw a **MonsterException** with an appropriate **String** message.

Also, assuming that no exception is thrown, the behaviour of **attack()** should be updated to use **dodge()** as follows:
* Call **dodge()** on the monster being attacked
* If result is **false**, the attack behaviour as before is implemented
* If result is **true**, no hit points are removed from the monster being attacked, but 10 from the monster attacking.
    
<br>

## Grade: 5/5