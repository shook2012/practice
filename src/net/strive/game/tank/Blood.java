package net.strive.game.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blood {
	int x,y,w,h;
	TankClient tc;
	private boolean live = true;
	int step = 0;
	private int[][] points = {{100,150},{150,220},{400,300},{500,220},{600,180}};
	
	public Blood() {
		x = points[0][0];
		y = points[0][1];
		w = h = 10;
	}

	public void draw(Graphics g) {
		if(!isLive())return;
		Color c = g.getColor();
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, w, h);
		g.setColor(c);
		move();
	}

	public void move(){
		step ++;
		if(step == points.length){step = 0;}
		x = points[step][0];
		y = points[step][1];
	}
	
	public Rectangle getRect(){
		return new Rectangle(x, y, w,h);
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
}
