package goo;

/**
 * All listeners must implement this interface.
 * @author Tim Blackwell
 *
 */
public interface GooListener {

    public abstract void gooActionPerformed(GooEvent e);
}
