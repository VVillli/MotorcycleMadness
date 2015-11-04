package GameStates;

import java.awt.Color;
import java.awt.Graphics2D;

public class GameStateManager {
	
	private GameState[] states;
	private int current;
	private boolean transition;
	private int opacity;
	private int count;
	
	public GameStateManager(){		
		states = new GameState[]{new MainMenu(this), new MainGame(this)};
		current = 0;
		transition = false;
		opacity = 0;
		count = 0;
	}
	
	public void setCurrent(int x){
		current = x;
		switch(current){
			case 0:
				states[current] = new MainMenu(this);
				break;
			case 1:
				states[current] = new MainGame(this);
				break;
		}
	}
	
	public void setTransition(boolean b){
		transition = b;
	}
	
	public void update(){
		states[current].update();
		
		if(transition){
			if(count <= 10){
				opacity += 25;
				if(opacity >= 250){
					opacity = 255;
				}
			}
			else{
				opacity -= 25;
				if(opacity <= 5){
					opacity = 0;
					transition = false;
					count = 0;
				}
			}
			count++;
		}
	}
	
	public void draw(Graphics2D g){
		states[current].draw(g);
		
		g.setColor(new Color(255,255,255,opacity));
		g.fillRect(0, 0, 800, 800);
	}
	
	public void keyPressed(int k){
		states[current].keyPressed(k);
	}
}
