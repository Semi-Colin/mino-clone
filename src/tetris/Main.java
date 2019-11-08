package tetris;

import apcs.Window;

public class Main {
	
	static int[][] matrix = new int[10][20];

	public static void main(String[] args) {
		int width = 800;
		int height = 800;
		int gravity = 10;
		int frame = 0;
		
		
		Mino bob = new Mino();
		
		Window.size(width, height);
		Window.setFrameRate(60);
		
		while(true) {
			Window.frame();
			frame++;
			for(int x=0;x<11;x++) {
				Window.out.line(20+x*20,20,20+x*20,420);
				
			}
			for(int y=0;y<21;y++) {
				Window.out.line(20,20+y*20,220,20+y*20);
			}
			
			if(frame>=gravity || Window.key.pressed("down")) {
				frame = 0;
				if(bob.y < 19 && matrix[bob.x][bob.y+1] == 0) {
					bob.Move(0, 1);
				} else{
					Lock(bob.x,bob.y);
					Window.sleep(250);
					bob.x=4;
					bob.y=0;
				}
			}
			
			if(Window.key.pressed("right") && bob.x < 9 && matrix[bob.x+1][bob.y] == 0) {
				bob.Move(1, 0);
			}
			if(Window.key.pressed("left") && bob.x > 0 && matrix[bob.x-1][bob.y] == 0) {
				bob.Move(-1, 0);
		}
			
			if(Window.key.pressed("space")) {
				Harddrop(bob.x,bob.y);
				Window.sleep(250);
				bob.x=4;
				bob.y=0;
			}
			
			
			bob.Draw();
			DisplayMatrix();
			
		}

	}
	
	public static void Lock(int x, int y) {
		matrix[x][y] = 1;
	}
	
	public static void DisplayMatrix() {
		for(int x=0;x<10;x++) {
			for(int y=0;y<20;y++) {
				if(matrix[x][y] == 1) {
					Window.out.rectangle(30+x*20, 30+y*20, 20, 20);
				}
			}
		}
	}
	
	public static void Harddrop(int x, int y) {
		for(int dist=0;dist<19;dist++) {
			if(matrix[x][y+dist] == 1 || y+dist == 19) {
				if(y+dist == 19 && matrix[x][y+dist] == 0) {
					Lock(x,19);
				} else {
					System.out.println("ah");
					Lock(x,y+dist-1);
				}
				break;
			}
		}
	}

}