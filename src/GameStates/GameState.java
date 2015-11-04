package GameStates;

import java.awt.Graphics2D;

public abstract class GameState {
	public abstract void update();
	public abstract void draw(Graphics2D g);
	
	public abstract void keyPressed(int k);
}
