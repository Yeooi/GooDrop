package simpleobjects;

import java.awt.Color;
import java.awt.Graphics;

public class RedDrop extends Drop{

	Color color = Color.RED;
	
	public RedDrop(int xpos, int ypos, int xvel, int yvel, int size){
		
		super(xpos, ypos, xvel, yvel, size);
	}
	
	public void draw(Graphics g){ 
		
		g.setColor(color);
		g.fillOval(xpos, ypos, size, size);
	}
}
