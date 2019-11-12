package minoclone;

import apcs.Window;

public class Mino {
	int x;
	int y;
	
	public Mino() {
		x = 4;
		y = 0;
	}
	
	
	public void Draw() {
		Window.out.rectangle(30+x*20, 30+y*20, 20, 20);
	}
	
	public void Move(int cx,int cy) {
		x += cx;
		y += cy;
	}
}
