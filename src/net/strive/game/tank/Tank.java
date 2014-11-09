package net.strive.game.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Tank extends TankHelper {
	
	private int x,y;
	private int oldX,oldY;
	
	private boolean live = true;
	private boolean isGood;
	private int life = 100;
	
	private boolean bL = false, bU = false, bR = false, bD = false;
	private Direction missDir = Direction.D;
	private static Random random = new Random();
	private BloodBar bar = new BloodBar();
	int step = random.nextInt(STEP_CHANGE)+STEP_VALUE;
	Direction dir = Direction.STOP;
	TankClient tc;
	
	public static final int X_SPEED = 15;
	public static final int Y_SPEED = 15;
	public static final int STEP_CHANGE = 15;
	public static final int STEP_VALUE = 5;
	
	private static Image[] tankImgs = null;
	private static Map<Direction,Image> imgs = new HashMap<Direction,Image>();
	
	static{
		tankImgs = new Image[]{
				getImage("images/tankL.gif"),getImage("images/tankLU.gif"),
				getImage("images/tankU.gif"),getImage("images/tankRU.gif"),
				getImage("images/tankR.gif"),getImage("images/tankRD.gif"),
				getImage("images/tankD.gif"),getImage("images/tankLD.gif")};
		
		imgs.put(Direction.L, tankImgs[0]);
		imgs.put(Direction.LU, tankImgs[1]);
		imgs.put(Direction.U, tankImgs[2]);
		imgs.put(Direction.RU, tankImgs[3]);
		imgs.put(Direction.R, tankImgs[4]);
		imgs.put(Direction.RD, tankImgs[5]);
		imgs.put(Direction.D, tankImgs[6]);
		imgs.put(Direction.LD, tankImgs[7]);
	}
	private static final int HEIGHT = 50;
	private static final int WIDTH = 50;
	
	public Tank() {
	}

	public Tank(int x, int y, boolean isGood) {
		this.x = x;
		this.y = y;
		this.isGood = isGood;
	}

	public Tank(int x, int y, boolean isGood, TankClient tc) {
		this(x, y, isGood);
		this.tc = tc;
	}
	
	public Tank(int x, int y, boolean isGood, TankClient tc,Direction dir) {
		this(x, y, isGood,tc);
		this.dir = dir;
	}

	public void draw(Graphics g) {
		if(!live)return;
		
		if (isGood) {
			g.setColor(Color.RED);
			bar.draw(g);
		}
		switch (missDir) {
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
	

	void move(){
		this.oldX = x;
		this.oldY = y;
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
		
		if(this.dir != Direction.STOP){
			this.missDir = dir;
		}
		
		if(x < 0 )x = 0;
		if(y < 30 )y = 30;
		if(x + Tank.WIDTH > TankClient.GAME_WIDTH)x = TankClient.GAME_WIDTH - Tank.WIDTH;
		if(y + Tank.HEIGHT > TankClient.GAME_HEIGHT)y = TankClient.GAME_HEIGHT - Tank.HEIGHT;
		
		if(!isGood){
			Direction[] dirs = Direction.values();
			if(step == 0){
				step = random.nextInt(STEP_CHANGE)+STEP_VALUE;
				int rn = random.nextInt(dirs.length);
				dir = dirs[rn];
			}
			step --;
			if(random.nextInt(40) > 38){
				this.fire(null);
			}
		}
		
	}
	
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
		}
		locateDirection();
	}
	
	

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_CONTROL:
			fire(null);
			break;
			case KeyEvent.VK_A:
			superFire();
			break;
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
			case KeyEvent.VK_F2:
				this.life = 100;
				this.live = true;
				break;
		}
		locateDirection();
	}
	
	void locateDirection(){
		if(bL && !bU && !bR && !bD)dir = Direction.L;
		else if(bL && bU && !bR && !bD)dir = Direction.LU;
		else if(!bL && bU && !bR && !bD)dir = Direction.U;
		else if(!bL && bU && bR && !bD)dir = Direction.RU;
		else if(!bL && !bU && bR && !bD)dir = Direction.R;
		else if(!bL && !bU && bR && bD)dir = Direction.RD;
		else if(!bL && !bU && !bR && bD)dir = Direction.D;
		else if(bL && !bU && !bR && bD)dir = Direction.LD;
		else if(!bL && !bU && !bR && !bD)dir = Direction.STOP;
	}
	
	public void fire(Direction dir){
		if(!live)return;
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		if(null == dir){
			tc.missiles.add(new Missile(x, y,missDir,isGood,this.tc));
		}else {
			tc.missiles.add(new Missile(x, y,dir,isGood,this.tc));
		}
	}
	
	public void superFire(){
		Direction[] dirs = Direction.values();
		for (int i = 0; i < dirs.length-1 ; i++) {
			fire(dirs[i]);
		}
	}
	
	public boolean collidesWithWall(Wall w){
		if(live && this.getRect().intersects(w.getRect())){
			this.stay();
			return true;
		}
		return false;
	}
	
	public boolean collidesWithTanks(List<Tank> tanks){
		for (int i = 0; i < tanks.size(); i++) {
			Tank t = tanks.get(i);
			if(this != t){
				if(this.live && this.getRect().intersects(t.getRect())){
					this.stay();
					t.stay();
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean eat(Blood b){
		if(live && b.isLive() && this.getRect().intersects(b.getRect())){
			this.life = 100;
			b.setLive(false);
			return true;
		}
		return false;
	}
	
	private void stay(){
		x = this.oldX;
		y = this.oldY;
	}
	
	public Rectangle getRect(){
		return new Rectangle(x, y, tankImgs[0].getWidth(null),tankImgs[0].getHeight(null));
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public boolean isGood() {
		return isGood;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	private class BloodBar{
		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.drawRect(x, y-10, WIDTH, 10);
			int w = WIDTH * life/100;
			g.fillRect(x, y-10, w, 10);
			g.setColor(c);
		}
	}
}
