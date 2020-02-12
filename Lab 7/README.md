# Lab 7 (11/11/19)

## Task
Update the **Monster** class so that it overrides `equals()` and `hashCode()` properly and write the callback methods in the **TrainerFrame** and **AddMonsterDialog** classes to implement appropriate behaviour.

### Behaviour to Implement
* **Add**: when one of these buttons is clicked, create a new instance of the provided **AddMonsterDialog** class and call its **setVisible()** method.
* **Delete**: when one of these buttons is clicked, check whether a monster is selected in the relevant list. If none, then do nothing, else remove the monster frm the displayed list and the Trainer's list.
* **Trade**: when this button is clicked, create a new **Trade** object, execute the trade and update the two displayed lists.

<br>

## Grade: 5/5