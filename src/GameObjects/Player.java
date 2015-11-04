package GameObjects;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import GameStates.MainGame;

public class Player extends GameObject{
	private int x;
	private int y;
	
	private int dx;
	private int dy;
	
	private int speed;
	
	private boolean vertical;
	
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	
	private MainGame m;
	
	public Player(MainGame m){
		x = 395;
		y = 395;
		
		this.m = m;
		
		speed = 6;
		
		dx = speed;
		dy = 0;
		
		up = false;
		down = false;
		left = false;
		right = true;
	}
	
	public void setUp(){
		dy = -speed; 
		dx = 0;
		
		if(y > 0 && !up){
			y -= 30;
			if(right){
				x -= 10;
			}
			
		}
		
		up = true;
		down = false;
		left = false;
		right = false;
	}
	public void setDown(){
		dy = speed; 
		dx = 0;
		
		if(!down && right){
			x -= 10;
		}
		
		up = false;
		down = true;
		left = false;
		right = false;
	}
	public void setLeft(){
		dx = -speed; 
		dy = 0;
		
		if(x > 0 && !left){
			x -= 30;
			if(down){
				y -= 10;
			}
			else if(up){
				y += 15;
			}
		}
		
		up = false;
		down = false;
		left = true;
		right = false;
	}
	public void setRight(){
		dx = speed; 
		dy = 0;
		
		if(!right && down){
			y -= 10;
		}
		
		up = false;
		down = false;
		left = false;
		right = true;
	}
	
	public void update(){		
		x += dx;
		y += dy;
		
		if(up){
			m.w.add(new Wall(x + 2, y + 30, 2));
		}
		else if(down){
			m.w.add(new Wall(x + 2, y - 6 , 2));
		}
		else if(left){
			m.w.add(new Wall(x + 30, y + 2, 1));
		}
		else{
			m.w.add(new Wall(x - 6, y + 2, 1));
		}
		
		if(x < 0){
			x = 0;
		}
		if(x > 770 && right){
			x = 770;
		}
		if(x > 790 && up){
			x = 790;
		}
		if(y < 0){
			y = 0;
		}
		if(y > 770){
			y = 770;
		}
	}
	
	public void draw(Graphics2D g){
		if(up){
			g.drawImage(new ImageIcon("images/redUp.png").getImage(), x, y, 10, 30, null);
		}
		else if(down){
			g.drawImage(new ImageIcon("images/redDown.png").getImage(), x, y, 10, 30, null);
		}
		else if(left){
			g.drawImage(new ImageIcon("images/redLeft.png").getImage(), x, y, 30, 10, null);
		}
		else{
			g.drawImage(new ImageIcon("images/redRight.png").getImage(), x, y, 30, 10, null);
		}
	}
}
