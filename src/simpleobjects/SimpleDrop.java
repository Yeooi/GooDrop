package simpleobjects; // A

import java.awt.Color; // B
import java.awt.Graphics;

public class SimpleDrop {

	int xpos, ypos, xvel, yvel, size, red,green,blue; // C
	
	public SimpleDrop(int x, int y, int vx, int vy, int sz){ // D
		
		xpos = x;
		ypos = y;
		xvel = vx;
		yvel = vy;
		size = sz;
		red = 0;
		green = 0;
		blue = 0;
	}
	
	public void move(int width, int height){ // E

		xpos = xpos + xvel;
		ypos = ypos + yvel;

		if(xpos > width)
		{
			xpos = 0;
		}
		if(ypos > height)
		{
			ypos = 0;
		}

	}

	public boolean CheckCollision(SimpleDrop[] simpleDrops){
		
			for(int j=0;j<simpleDrops.length;j++)
			{
				if(this!=simpleDrops[j])
				{
					if ( Math.sqrt( ( simpleDrops[j].xpos-this.xpos ) 
					* ( simpleDrops[j].xpos-this.xpos )  
					+ ( simpleDrops[j].ypos-this.ypos ) 
					* ( simpleDrops[j].ypos-this.ypos ) ) 
					< ( this.size + simpleDrops[j].size ) ) 
					{
						return true;
					}
				}
			}
		return false;

	}
	
	public void draw(Graphics g){ // F
		
		g.setColor(new Color(red,green,blue));
		g.fillOval(xpos, ypos, size, size);
	}
}
