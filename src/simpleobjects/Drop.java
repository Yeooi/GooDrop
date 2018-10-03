package simpleobjects;

import java.awt.Color;
import java.awt.Graphics;

public class Drop {

	int xpos, ypos, xvel, yvel, size;
	
	public Drop(int x, int y, int vx, int vy, int sz){
		
		xpos = x;
		ypos = y;
		xvel = vx;
		yvel = vy;
		size = sz;
	}
	
	public void move(int width, int height){

		xpos = xpos + xvel;
		ypos = ypos + yvel;
		
		if (ypos > height) {
			
			ypos = 0;
			xpos = (int)(Math.random() * width);
		}
	}
	
	public void draw(Graphics g){
		
		g.setColor(Color.GRAY);
		g.fillOval(xpos, ypos, size, size);
	}
}
