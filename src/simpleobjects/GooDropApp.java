package simpleobjects;

public class GooDropApp {
	
	public static void main(String[] args) {
		
		int width = 800;
		int height = 500;
		GooDrop gd = new GooDrop(width, height,20);
		gd.smooth();
		gd.go();
	}
}
