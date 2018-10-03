package goo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Implementation of a simple toggle button.
 * 
 * @author Tim Blackwell
 * 
 */
public class GooButton extends GooComponent {

	private boolean isOn = false;
	private Color onColor = new Color(255, 255, 255);
	private Color offColor = new Color(200, 200, 200);
	private Color buttonBackground = Color.white;
	private int margin, pressX, pressY, pressWidth, pressHeight;

	/**
	 * Creates a a zero size button
	 */
	public GooButton() {

		super();
	}

	/**
	 * Creates a button with the specified size and position
	 * 
	 * @param x
	 *            x coordinate of top left corner of button.
	 * @param y
	 *            y coordinate of top left corner of button.
	 * @param w
	 *            width of this button.
	 * @param h
	 *            height of this button.
	 */
	public GooButton(int x, int y, int w, int h) {

		super(x, y, w, h);
		margin = 2;
		pressX = x + margin;
		pressY = y + margin;
		pressWidth = getWidth() - 2 * margin;
		pressHeight = getHeight() - 2 * margin;
	}

	/**
	 * Relays the <code>GooEvent></code> object to interested listeners.
	 */
	public void fireActionPerformed(GooEvent e) {

		if (isInside(pressX, pressY, pressWidth, pressHeight - 2 * margin, e
				.getX(), e.getY())) {

			isOn = !isOn;

			e.setSource(this);
			e.setValue(isOn ? GooEvent.ON : GooEvent.OFF);

			ArrayList<GooListener> listeners = getListeners();
			for (GooListener l : listeners) {

				l.gooActionPerformed(e);
			}
		}
	}

	/**
	 * Determines the appearance of this button.
	 */
	public void draw(Graphics g) {

		Color currColor = g.getColor();

		g.setColor(buttonBackground);
		g.fillRect(getX(), getY(), getWidth(), getHeight());

		g.setColor(isOn ? onColor : offColor);
		g.fillRect(pressX, pressY, pressWidth, pressHeight);
		g.setColor(currColor);
	}
}
