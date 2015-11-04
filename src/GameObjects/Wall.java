package GameObjects;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Wall {
	private int x;
	private int y;
	private int type;
	
	public Wall(int x, int y, int t){
		this.x = x;
		this.y = y;
		
		this.type = t;
	}
	
	public int getX(){return x;}
	public int getY(){return y;}
	
	public void draw(Graphics2D g){
		switch(type){
			case 1: g.drawImage(new ImageIcon("images/redWallHorizantal.png").getImage(), x, y, 6, 6, null); break;
			case 2: g.drawImage(new ImageIcon("images/redWallVertical.png").getImage(), x, y, 6, 6, null); break;
		}
	}
}
 