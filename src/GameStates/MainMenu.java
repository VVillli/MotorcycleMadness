package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class MainMenu extends GameState{
	private GameStateManager gsm;
	
	private MenuButton[] m;
	
	private int selected;
	private boolean transition;
	
	private int count;
	
	public MainMenu(GameStateManager g){
		this.gsm = g;
		
		MenuButton play = new MenuButton(-400, 360, "PLAY", new Color(72,255,94), gsm, false);
		MenuButton help = new MenuButton(-400, 480, "HELP", new Color(255,238,61), gsm, true);
		MenuButton quit = new MenuButton(-400, 600, "QUIT", new Color(255,72,72), gsm, true);
		
		m = new MenuButton[]{play,help, quit};
		
		count = 0;
		
		selected = 0;
	}
	
	public void update(){
		for(int i = 0; i < 3; i++){
			if(i != selected){
				m[i].setIdle(true);
			}
			else{
				m[i].setIdle(false);
			}
		}
		
		
		m[0].update();
		m[1].update();
		m[2].update();
		
		if(transition){
			count++;
			if(count >= 10){
				gsm.setCurrent(1);
			}
		}
	}

	public void draw(Graphics2D g) {
		Font myFont = new Font("Century Gothic", Font.BOLD, 81);
		g.setFont(myFont);
		g.setColor(Color.WHITE);
		g.drawString("MOTORCYCLE", 140, 160);
		g.drawString("MADNESS", 220, 250);
		
		m[0].draw(g);
		m[1].draw(g);
		m[2].draw(g);
	}

	public void keyPressed(int k) {
		if(k == KeyEvent.VK_DOWN){
			if(selected < 2){
				selected++;
			}
		}
		if(k == KeyEvent.VK_UP){
			if(selected > 0){
				selected--;
			}
		}
		if(k == KeyEvent.VK_ENTER){
			if(selected == 0){
				m[0].selected();
				transition = true;
				gsm.setTransition(true);
			}
			if(selected == 2){
				System.exit(0);
			}
		}
	}
}
