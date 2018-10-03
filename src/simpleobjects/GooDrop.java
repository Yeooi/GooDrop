package simpleobjects;

import goo.Goo; // A
import java.awt.Graphics;

public class GooDrop extends Goo { // B

	SimpleDrop[] multiDrops;
	// SimpleDrop drop;

	public GooDrop(int width, int height, int numDrops) { // C

		super(width, height);

		multiDrops = new SimpleDrop[numDrops];
		for(int i = 0; i < numDrops ;i++)
		{
			int xpos = (int) (Math.random() * width) + 1;
			int ypos = 0;
			int xvel = (int) (Math.random() * 10) + 1;
			int yvel = (int) (Math.random() * 10) + 1;
			int size = (int) (Math.random() * 20) + 10;
			multiDrops[i] = new SimpleDrop(xpos, ypos, xvel, yvel, size);
		}
	}

	public void draw(Graphics g) { // D

		for(SimpleDrop drop : multiDrops)
		{
			if(drop.CheckCollision(multiDrops))
			{
				drop.red = (int) (Math.random() * 255);
				drop.green = (int) (Math.random() * 255);
				drop.blue = (int) (Math.random() * 255);
			}
			drop.move(getWidth(), getHeight());
			drop.draw(g);
		}
	}
}
