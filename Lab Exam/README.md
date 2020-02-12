# Lab Exam (02/12/19)

## Task 1: Location (2 marks)
Create an enumerated type **Location** with the following values:
`TABLE, FLOOR, HOLDING`

## Task 2: Thing (6 marks)
Create a class **Thing** that should have the following properties:
* `name (String)`
* `location (Location)`
* Constructor: `public Thing(String name, Location location)`
* Complete set of **get** methods and a **set** method only for the location
* Appropriate implementations of `equals()`, `hashCode()` and `toString()`

## Task 3: Agent (6 marks)
Create a class **Agent** representing an agent. This class should have a single field of type **Thing**, representing the object which the agent is holding, which should be initially set to **null**. In addition, **Agent** must provide the following two methods:
* `public boolean pickUp(Thing thing)`
    * If the agent is already holding something, return **false**
    * Otherwise, choose a random **Boolean** value to determine whether the pick-up succeeds
        * If the random value is true, set the location of the **Thing** to `HOLDING`, update the `holding` field and return **true**
        * If the random value is false, do nothing and return **false**
* `public boolean putDown(Location place)`
    * If the agent is not holding anything, return **false**
    * If **place** is `HOLDING`, return **false**
    * Otherwise, choose a random **Boolean** value to determine whether the put-down succeeds
        * If the random value is true, set the location of the thing to **place**, update the `holding` field and return **true**
        * If the random value is false, do nothing and return **false**

## Task 4: planning (5 marks)
Add an additional method to the **Agent** class with the following signature:
<pre>
    public void putOnTable(Set<Thing> things)
</pre>
This method should process the given set of things to ensure that they are all located on the table at the end, using the `pickUp()` and `putDown()` methods as appropriate.

## Grade
### Task 1: 2/2
### Task 2: 6/6
### Task 3: 5/6
* **Feedback:** You could have used different variable names for the "thing" the agent is currently holding and the "thing" to pickup...
### Task 4: 2/5
* **Feedback:** Some missing criteria:- remove anything that the agent is already holding in its hand - ignore all objects that are already on the table - Repeatedly picking up/putting down objects until it is successful is not clearly defined...
### Style: 0.5/1
* **Feedback:** The main methods does not have any comments.