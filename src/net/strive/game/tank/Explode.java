package net.strive.game.tank;

import java.awt.Graphics;
import java.awt.Image;

public class Explode extends TankHelper {
	
	private int x,y;
	private boolean live = true;
	private boolean init  = false;
	
	int step = 0;
	
	private static Image[] images = {
									getImage("images/0.gif"),getImage("images/1.gif"),
									getImage("images/2.gif"),getImage("images/3.gif"),
									getImage("images/4.gif"),getImage("images/5.gif"),
									getImage("images/6.gif"),getImage("images/7.gif"),
									getImage("images/8.gif"),getImage("images/9.gif"),
									getImage("images/10.gif")};
	
	
	public Explode(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		if(!init){
			for (int i = 0; i < images.length; i++) {
				g.drawImage(images[i], x, y, null);
			}
			init = true;
		}
		
		if(!live)return;
		if(step == images.length){
			live = false;
			step = 0;
			return;
		}
		g.drawImage(images[step],x,y,null);
		step ++;
	}
	
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
}
