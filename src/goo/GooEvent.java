package goo;

/**
 * Represents a user-generated event. Objects if this class encapsulate whether
 * the event is an ON or an OFF event, and an integer value that might be
 * associated with the event (for example the position of a slider). The event
 * also has a reference to its source.
 * 
 * @author Tim Blackwell
 * 
 */
public class GooEvent {

	private GooComponent source;

	private int x, y, value;

	final static int UNSPECIFIED = -1, ON = 1, OFF = 0;

	/**
	 * Creates a <code>GooEvent</code> associated with a given component.
	 * @param c reference to originating component.
	 * @param x x coordinate of original mouse click that generated this event.
	 * @param y y coordinate of mouse that generated this event.
	 * @param val an integer value that might be associated with this event
	 */
	public GooEvent(GooComponent c, int x, int y, int val) {

		source = c;
		this.x = x;
		this.y = y;
		value = val;
	}

	/**
	 * Returns a reference to the source of this event.
	 * @return a reference to the originating <code>GooComponent</code>.
	 */
	public GooComponent getSource() {
		return source;
	}

	/**
	 * This method can be used to manually set the originating source.
	 * @param c
	 */
	public void setSource(GooComponent c) {
		source = c;
	}

	/**
	 * Returns any integer value that might be associated with this event,
	 * @return integer event value.
	 */
	public int getValue() {
		return value;
	}
	/**
	 * Manually sets the value of this event.
	 * @param v the desired value.
	 */
	public void setValue(int v) {
		value = v;
	}

	/**
	 * Gets the x coordinate of the original mouse click.
	 * @return x coordinate of mouse click.
	 */
	public int getX() {
		return x;
	}

	/** 
	 * This method can be used to set a x coordinate of this event.
	 * @param i Desired x coordinate.
	 */
	public void setX(int i) {
		x = i;
	}

	/**
	 * Gets the y coordinate of the original mouse click.
	 * @return y coordinate of mouse click.
	 */
	public int getY() {
		return y;
	}

	/** 
	 * This method can be used to set a y coordinate of this event.
	 * @param i Desired y coordinate.
	 */
	public void setY(int i) {
		y = i;
	}
}
