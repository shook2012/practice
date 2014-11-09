package net.strive.game.tank;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Wall extends TankHelper {
	int x,y,w,h;
	TankClient tc;
	
	private int bgIndex;
	
	private static Image[] imgs = {getImage("images/w1.png"),getImage("images/w2.png")};
	public Wall(int x, int y, int w, int h, TankClient tc,int bgIndex) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.tc = tc;
		this.bgIndex = bgIndex;
	}
	public Wall(int x, int y, TankClient tc,int bgIndex) {
		this.x = x;
		this.y = y;
		this.tc = tc;
		this.bgIndex = bgIndex;
	}
	
	public void draw(Graphics g) {
		g.drawImage(imgs[bgIndex], x, y, null);
	}
	
	public Rectangle getRect(){
		return new Rectangle(x, y, imgs[bgIndex].getWidth(null),imgs[bgIndex].getHeight(null));
	}
	
}
