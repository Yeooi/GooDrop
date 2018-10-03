package simpleobjects;

import goo.Goo;

import java.awt.Graphics;

public class GooDrop2 extends Goo { 

	Drop drop; 

	public GooDrop2(int width, int height) { 

		super(width, height);

		int xpos = width / 2;
		int ypos = 0;
		int xvel = 0;
		int yvel = 1;
		int size = 10;

		drop = new RedDrop(xpos, ypos, xvel, yvel, size); 
	}

	public void draw(Graphics g) { 

		drop.move(getWidth(), getHeight());
		drop.draw(g);
	}
}
