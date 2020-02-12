// Inesh Bose (2504266B)

package planning;
import java.util.Random;
import java.util.Set;

/**
 * Class Agent with field of type Thing.
 * 
 * @author 2504266B
 */
public class Agent {

	/** Thing held by Agent */
	private Thing thing;
	
	public Agent() {
		this.thing = null;
	}
	
	/**
	 * Agent attempts to pick up thing.
	 * 
	 * @param thing The thing to pick up
	 * @return if pick up was successful
	 */
	public boolean pickUp(Thing thing) {
		if(this.thing == null) {
			Random random = new Random();  
			if(random.nextBoolean()) {
				thing.setLocation(Location.HOLDING);
				this.thing = thing;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Agent attempts to put down thing.
	 * 
	 * @param place Location where to put.
	 * @return if put down was successful
	 */
	public boolean putDown(Location place) {
		if(this.thing == null) {
			return false;
		} else {
			if(place.equals(Location.HOLDING)) {
				return false;
			} else {
				Random random = new Random();
				if(random.nextBoolean()) {
					this.thing.setLocation(place);
					this.thing = null;
					return true;
				} else {
					return false;
				}
			}
		}
	}
	
	/**
	 * Agent places set of things on the Table.
	 * 
	 * @param things Set of things to place
	 */
	public void putOnTable(Set<Thing> things) {
		for(Thing i : things) {
			boolean notPut = true;
			while(notPut) {
				if(this.pickUp(i)) {
					if(this.putDown(Location.TABLE)) {
						notPut = false;
					}
				}
			}
		}
	}
	
}
