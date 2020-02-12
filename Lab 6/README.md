# Lab 6 (04/11/19)

## Task
Update the **Monster** and **Trainer** classes as described below:

### Sorting Monsters
Using the **Comparable** interface, implement a comparison method for **Monster** objects that sorts as follows
* Monsters should be sorted in **decreasing** order of hit points.
* If two monsters have same hit points, sort in **alphabetical** order based on type.

### Saving and loading Trainer
Implement methods that should allow **Trainer** objects to be saved to a file on the local file system and loaded from a previously saved file. The method signatures are as follows:
* `public void saveToFile (String filename) throws IOException`
* `public static Trainer loadFromFile (String filename) throws IOException`

The **Serializable** interface should **not** be used for this lab.

<br>

## Grade: 5/5