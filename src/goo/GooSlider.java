package goo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Simple representation of a slider. The slider sends integer values between 0 and a maximum
 * value.
 * 
 * @author Tim Blackwell
 * 
 */
public class GooSlider extends GooComponent {

	private Color background = Color.WHITE;

	// margin between background and foreground
	private int margin;

	// foreground
	private Color foreground = new Color(200, 200, 200);
	private int foregroundX, foregroundY, foregroundWidth, foregroundHeight;

	// knob
	private int knobWidth, knobX;
	private Color knobColor = Color.BLACK;

	// value of slider between 0 and maxValue
	private int value, maxValue;

	// value 0 at position scaleOrigin
	private float scaleOrigin;

	// value maxValue at scaleOrigin + scaleMax
	private int scaleMax;

	// the x coordinate of the input event
	private int eventX;

	/**
	 * Creates a zero size slider.
	 */
	public GooSlider() {

		super();
	}

	/**
	 * Creates a slider of user specified size and position
	 * 
	 * @param x
	 *            x coordinate of top left corner of slider.
	 * @param y
	 *            y coordinate of top left corner of slider.
	 * @param w
	 *            width of this slider.
	 * @param h
	 *            height of this slider.
	 */
	public GooSlider(int x, int y, int w, int h) {

		super(x, y, w, h);

		// parameters
		margin = 2;
		knobWidth = 21;
		maxValue = 100;

		// foreground rectangle
		foregroundX = x + margin;
		foregroundY = y + margin;
		foregroundWidth = getWidth() - 2 * margin;
		foregroundHeight = getHeight() - 2 * margin;

		// set scale
		scaleOrigin = foregroundX + knobWidth / 2.0f;
		scaleMax = foregroundWidth - knobWidth - 1;

		// set initial value
		setValue(Math.round(maxValue / 2.0f));

	}

	/**
	 * Places the slider at a position corresponding to the supplied value.
	 * @param v Required value.
	 */
	public void setValue(int v) {

		if (0 <= v && v <= maxValue) {

			value = v;
			eventX = posX(v);
			knobX = Math.round(eventX - knobWidth / 2.0f);
		}
	}

	// returns a value when given a position
	private int value(int evX) {

		return Math.round(maxValue * 1.0f * (evX - scaleOrigin) / scaleMax);
	}

	// returns a position when given a value
	private int posX(int val) {

		return Math.round(scaleOrigin + 1.0f * val * scaleMax / maxValue);
	}

	/**
	 * Relays the <code>GooEvent></code> object to interested listeners.
	 */
	public void fireActionPerformed(GooEvent e) {

		int evX = e.getX();
		int evY = e.getY();

		int evValue = value(evX);
		if (evY >= foregroundY && evY <= foregroundY + foregroundHeight
				&& evValue >= 0 && evValue <= maxValue) {

			eventX = evX;
			knobX = Math.round(eventX - knobWidth / 2.0f);
			value = evValue;

			e.setValue(value);
			e.setSource(this);

			ArrayList<GooListener> listeners = getListeners();
			for (GooListener l : listeners) {

				l.gooActionPerformed(e);
			}
		}
	}

	/**
	 * Determines the appearance of this slider.
	 */
	public void draw(Graphics g) {

		Color currColor = g.getColor();

		g.setColor(background);
		g.fillRect(getX(), getY(), getWidth(), getHeight());

		g.setColor(foreground);
		g.fillRect(foregroundX, foregroundY, foregroundWidth, foregroundHeight);

		g.setColor(knobColor);
		g.fillRect(knobX, foregroundY, knobWidth, foregroundHeight);

		g.setColor(background);
		g.drawLine(eventX, foregroundY, eventX, foregroundY + foregroundHeight);

		g.setColor(currColor);
	}
}
