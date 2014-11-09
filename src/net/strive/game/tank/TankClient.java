package net.strive.game.tank;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TankClient extends Frame {
	
	int x = 50;
	int y = 50;
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	
	Tank myTank =new Tank(50, 50,true,this);
	
	List<Missile> missiles = new ArrayList<Missile>();
	List<Explode> explodes =new ArrayList<Explode>();
	List<Tank> tanks =new ArrayList<Tank>();
	
	public int score = 0;
	
	private List<Scope> scopes = new ArrayList<Scope>(){{
									add(new Scope(0,10,"新兵蛋子"));
									add(new Scope(10,25,"初级士官"));
									add(new Scope(25,50,"中级士官"));
									add(new Scope(50,90,"高级士官"));
									add(new Scope(90,150,"少尉"));
									add(new Scope(150,220,"中尉"));
									add(new Scope(220,300,"上尉"));
									add(new Scope(300,400,"少校"));
									add(new Scope(400,550,"中校"));
									add(new Scope(550,750,"上校"));
									add(new Scope(750,1000,"大校"));
									add(new Scope(1000,1300,"少将"));
									add(new Scope(1300,1800,"中将"));
									add(new Scope(1800,2500,"上将"));
									add(new Scope(2500,5000000,"你超神了！"));
								}};
	
	
	Wall w1 = new Wall(100, 300, this,0);
	Wall w2 = new Wall(300, 200, this,1);
	Blood b = new Blood();
	Image visulScreenImage = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TankClient t = new TankClient();
		t.lauchFrame();
	}
	
	public void lauchFrame(){
		this.setTitle("坦克大战_Design By Strive");
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(TankHelper.class.getClassLoader().getResource("images/tankLogo.png")));
		this.setResizable(false);
		this.addKeyListener(new KeyMonitor());
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		createEnemy(10);
		this.setVisible(true);
		new Thread(new PaintThead()).start();
	}

	private void createEnemy(int nums) {
		for (int i = 0; i < nums; i++) {
			tanks.add(new Tank(750-55*(i+1),550, false,this,Direction.U));
		}
	}

	@Override
	public void paint(Graphics g) {
		myTank.draw(g);
		myTank.eat(b);
		if(tanks.size() <= 0){
			createEnemy(5);
		}
		
		Iterator<Missile> iterator = missiles.iterator();
		while (iterator.hasNext()) {
			Missile missile = (Missile) iterator.next();
			if(missile.isLive()){
				missile.hitTanks(tanks);
				missile.hitTank(myTank);
				missile.hitWall(w1);
				missile.hitWall(w2);
				missile.draw(g);
			}else{
				iterator.remove();
			}
		}
		
		for (int i = 0; i < explodes.size(); i++) {
			Explode e = explodes.get(i);
			if(e.isLive()){
				e.draw(g);
			}else{
				explodes.remove(i);
			}
		}
		
		
		for (int i = 0; i < tanks.size(); i++) {
			Tank t = tanks.get(i);
			if(t.isLive()){
				t.draw(g);
				t.collidesWithWall(w1);
				t.collidesWithWall(w2);
				t.collidesWithTanks(tanks);
			}else{
				tanks.remove(i);
			}
		}
		
		w1.draw(g);
		w2.draw(g);
		b.draw(g);
		
		
		g.drawString("我方生命值:"+myTank.getLife(), 700, 60);
		for(Scope scope : scopes)
		{
			if(score >= scope.getMin() && score < scope.getMax()){
				g.drawString("等级:"+scope.getName(), 700, 80);
			}
		}
//		g.drawString("当前爆炸数:"+explodes.size(), 700, 80);
		g.drawString("敌方坦克数:"+tanks.size(), 700, 100);
		g.drawString("屏幕子弹数:"+missiles.size(), 700, 120);
	}
	

	@Override
	public void update(Graphics g) {
		if (visulScreenImage == null) {
			visulScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);//Toolkit.getDefaultToolkit().getImage(TankHelper.class.getClassLoader().getResource("images/bg.png"));//g.drawImage(Toolkit.getDefaultToolkit().getImage(TankHelper.class.getClassLoader().getResource("images/bg.png")), GAME_WIDTH, GAME_HEIGHT, null);//this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gVisulScreen = visulScreenImage.getGraphics();
		/*Color c = gVisulScreen.getColor();
		gVisulScreen.setColor(Color.LIGHT_GRAY);
		gVisulScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gVisulScreen.setColor(c);*/
		gVisulScreen.drawImage(Toolkit.getDefaultToolkit().getImage(TankHelper.class.getClassLoader().getResource("images/bg.png")), 0, 0, null);
		paint(gVisulScreen);
		g.drawImage(visulScreenImage, 0, 0, null);
		
	}
	
	private class PaintThead implements Runnable{

		@Override
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			myTank.keyReleased(e);
		}
	}
	
}
