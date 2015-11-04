package GameStates;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import GameObjects.Player;
import GameObjects.Wall;

public class MainGame extends GameState{
	
	private Player p;
	
	private GameStateManager gsm;
	
	private boolean transition;
	private int count;
	
	public ArrayList<Wall> w;
	
	public MainGame(GameStateManager gsm){
		p = new Player(this);
		w = new ArrayList<Wall>();
		this.gsm = gsm;
	}
	
	public void update(){
		p.update();
		
		/*for(int i = 0; i < w.size(); i++){
			if(w.size() > 1){
				for(int j = i + 1; j < w.size(); j++){
					if(w.get(i).getX() == w.get(j).getX()){
						if(w.get(i).getY() == w.get(j).getY()){
							w.remove(i);
							i--;
						}
					}
				}
			}
		}*/
		
		if(transition){
			count++;
			if(count >= 10){
				gsm.setCurrent(0);
			}
		}
	}
	
	public void draw(Graphics2D g){
		for(int i = 0; i < w.size(); i++){
			w.get(i).draw(g);
		}
		
		p.draw(g);
	}
	
	public void keyPressed(int k){
		if(k == KeyEvent.VK_UP){
			p.setUp();
		}
		if(k == KeyEvent.VK_DOWN){
			p.setDown();
		}
		if(k == KeyEvent.VK_LEFT){
			p.setLeft();
		}
		if(k == KeyEvent.VK_RIGHT){
			p.setRight();
		}
		if(k == KeyEvent.VK_ESCAPE){
			gsm.setTransition(true);
			transition = true;
		}
	}
}
