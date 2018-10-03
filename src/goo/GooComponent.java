package goo;

import java.util.ArrayList;

/**
 * Abstract representation of a component. Concrete components, which must
 * implement <code>public abstract void draw(Graphics g)</code>, are drawn to
 * the drawing frame. Components can fire events and are intended, therefore,
 * for user interaction.
 * 
 * @author timblackwell
 * 
 */
public abstract class GooComponent implements Drawable {

	private ArrayList<GooListener> listeners;

	private int x, y, width, height;

	/**
	 * Creates a zero-size <code>GooComponent</code> at the top left corner of
	 * the frame.
	 */
	public GooComponent() {

		this(0, 0, 0, 0);
	}

	/**
	 * Creates a GooComponent of user specified size and position
	 * 
	 * @param x
	 *            x coordinate of top left corner of component.
	 * @param y
	 *            y coordinate of top left corner of component.
	 * @param w
	 *            width of this component.
	 * @param h
	 *            height of this component.
	 */
	public GooComponent(int x, int y, int w, int h) {

		setListeners(new ArrayList<GooListener>());

		this.setX(x);
		this.setY(y);
		setWidth(w);
		setHeight(h);
	}

	/**
	 * Associates a listener with this component. All listeners must implement
	 * <code>GooListener> and are informed of user generated events.
	 * 
	 * @param gl reference to an interested object.
	 */
	public void addListener(GooListener gl) {

		getListeners().add(gl);
	}

	/**
	 * Checks if the point (a, b) is inside a rectangle.
	 * 
	 * @param x
	 *            x coordinate of rectangle.
	 * @param y
	 *            y coordinate of rectangle
	 * @param w
	 *            width of rectangle.
	 * @param h
	 *            height of rectangle.
	 * @param a
	 *            x coordinate of test point.
	 * @param b
	 *            y coordinate of test point.
	 * @return true if (a, b) is inside this rectangle.
	 */
	public boolean isInside(int x, int y, int w, int h, int a, int b) {

		return (a > x && a < x + w && b > y && b < y + h);
	}

	/**
	 * Concrete <code>GooComponents</code> must implement this method. The
	 * implementation will specify how the component reacts to user generated
	 * events.
	 * 
	 * @param e
	 *            Reference to a <GooEvent> object which represents this event.
	 */
	public abstract void fireActionPerformed(GooEvent e);

	private void setListeners(ArrayList<GooListener> listeners) {
		this.listeners = listeners;
	}

	/**
	 * Returns a list of all current listeners.
	 * 
	 * @return Return <code>java.util.ArrayList<GooListener></code> of
	 *         currently registered listeners.
	 */
	public ArrayList<GooListener> getListeners() {
		return listeners;
	}

	/**
	 * Sets the width of this component.
	 * 
	 * @param width
	 *            Width of this component.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the width of this component.
	 * 
	 * @return Width of this component.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the height of this component.
	 * 
	 * @param height
	 *            Height of this component.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the height of this component.
	 * 
	 * @return Height of this component.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the y coordinate of this component.
	 * 
	 * @param y
	 *            y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the y coordinate of this component
	 * 
	 * @return y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the x coordinate of this component.
	 * 
	 * @param x
	 *            x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the x coordinate of this component
	 * 
	 * @return x coordinate.
	 */
	public int getX() {
		return x;
	}
}
