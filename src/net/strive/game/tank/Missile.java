package net.strive.game.tank;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Missile extends TankHelper {
	private int x,y;
	Direction dir;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	public static final int X_SPEED = 10;
	public static final int Y_SPEED = 10;
	private boolean live = true;
	private boolean isGood;
	private TankClient tc;
	
	private static Image[] missileImgs = null;
	private static Map<Direction,Image> imgs = new HashMap<Direction,Image>();
	
	static{
		missileImgs = new Image[]{
				getImage("images/missileL.gif"),getImage("images/missileLU.gif"),
				getImage("images/missileU.gif"),getImage("images/missileRU.gif"),
				getImage("images/missileR.gif"),getImage("images/missileRD.gif"),
				getImage("images/missileD.gif"),getImage("images/missileLD.gif")};
		
		imgs.put(Direction.L, missileImgs[0]);
		imgs.put(Direction.LU, missileImgs[1]);
		imgs.put(Direction.U, missileImgs[2]);
		imgs.put(Direction.RU, missileImgs[3]);
		imgs.put(Direction.R, missileImgs[4]);
		imgs.put(Direction.RD, missileImgs[5]);
		imgs.put(Direction.D, missileImgs[6]);
		imgs.put(Direction.LD, missileImgs[7]);
	}
	
	public Missile(int x, int y, Direction dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public Missile(int x, int y, Direction dir, TankClient tc) {
		this(x, y, dir);
		this.tc = tc;
	}
	
	public Missile(int x, int y, Direction dir,boolean isGood, TankClient tc) {
		this(x, y, dir,tc);
		this.isGood = isGood;
	}



	public void draw(Graphics g) {
		switch (dir) {
			case L:
				g.drawImage(imgs.get(Direction.L), x, y, null);
				break;
			case LU:
				g.drawImage(imgs.get(Direction.LU), x, y, null);
				break;
			case U:
				g.drawImage(imgs.get(Direction.U), x, y, null);
				break;
			case RU:
				g.drawImage(imgs.get(Direction.RU), x, y, null);
				break;
			case R:
				g.drawImage(imgs.get(Direction.R), x, y, null);
				break;
			case RD:
				g.drawImage(imgs.get(Direction.RD), x, y, null);
				break;
			case D:
				g.drawImage(imgs.get(Direction.D), x, y, null);
				break;
			case LD:
				g.drawImage(imgs.get(Direction.LD), x, y, null);
				break;
			case STOP:
				break;
		}
		
		move();
	}

	private void move() {

		switch (dir) {
		case L:
			x -= X_SPEED;
			break;
		case LU:
			x -= X_SPEED;
			y -= Y_SPEED;
			break;
		case U:
			y -= Y_SPEED;
			break;
		case RU:
			x += X_SPEED;
			y -= Y_SPEED;
			break;
		case R:
			x += X_SPEED;
			break;
		case RD:
			x += X_SPEED;
			y += Y_SPEED;
			break;
		case D:
			y += Y_SPEED;
			break;
		case LD:
			x -= X_SPEED;
			y += Y_SPEED;
			break;
		case STOP:
			break;
		}
		
		if(x < 0 || y < 0 || x > TankClient.GAME_WIDTH || y > TankClient.GAME_HEIGHT)
		{
			live = false;
		}
	}

	public boolean hitTank(Tank t){
		if(live && this.getRect().intersects(t.getRect()) && t.isLive() && this.isGood != t.isGood()){
			if(t.isGood()){
				t.setLife(t.getLife()-20);
				if(t.getLife() <= 0){
					t.setLive(false);
				}
			}else{
				tc.score += 5;
				t.setLive(false);
			}
			this.live = false;
			Explode e = new Explode(x, y);
			tc.explodes.add(e);
			return true;
		}
		return false;
	}
	
	public boolean hitTanks(List<Tank> tanks){
		for (int i = 0; i < tanks.size(); i++) {
			if (hitTank(tanks.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hitWall(Wall wall){
		if(live && this.getRect().intersects(wall.getRect())){
			this.live = false;
			return true;
		}
		return false;
	}
	
	public Rectangle getRect(){
		return new Rectangle(x, y, WIDTH,HEIGHT);
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
}
