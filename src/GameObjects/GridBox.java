package GameObjects;

import java.awt.Graphics2D;

public class GridBox {
	private GameObject g;
	
	private int x;
	private int y;
	
	public GridBox(int x, int y){
		g = null;
		
		this.x = x;
		this.y = y;
	}
	
	public void update(){
		if(g != null){
			g.update();
		}
	}
	
	public void draw(Graphics2D g){
		if(this.g != null){
			this.g.draw(g);
		}
	}
}
