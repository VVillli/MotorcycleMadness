package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class MenuButton {
	private String text;
	private Color c;
	
	private int x;
	private int y;
	
	private boolean idle;
	private boolean selected;
	
	private int xDraw;
	
	private GameStateManager gsm;
	
	public MenuButton(int x, int y, String t, Color c, GameStateManager g, boolean b){
		this.text = t;
		this.c = c;
		
		this.x = x;
		this.y = y;
		
		this.gsm = g;
		
		idle = b;
		
		if(b){
			xDraw = x - 385;
		}
		else{
			xDraw = x;
		}
	}
	
	public void setIdle(boolean b){idle = b;}
	public void selected(){selected = true;}
	
	public void update(){
		if(idle){
			if(xDraw > x - 385){
				xDraw -= 40;
			}
			else{
				xDraw = x - 385;
			}
		}
		else if(selected){
			xDraw += 40;
			if(xDraw >= x + 400){
				xDraw = x + 400;
			}
		}
		else{
			if(xDraw < x){
				xDraw += 40;
			}
			else{
				xDraw = x;
			}
		}
	}
	
	public void draw(Graphics2D g){
		g.setColor(c);
		g.fillRect(xDraw, y, 800, 120);
		
		Font myFont = new Font("Century Gothic", Font.BOLD, 68);
		g.setColor(new Color(40,40,40));
		g.setFont(myFont);
		int width = g.getFontMetrics().stringWidth(text);
		g.drawString(text, xDraw + 800 - 15 - width, y + 86);
	}
}
