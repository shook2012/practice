package net.strive.game.tank;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public abstract class TankHelper {
	
	public static Toolkit tk = Toolkit.getDefaultToolkit();
	
	public abstract void draw(Graphics g);
	
	public static Image getImage(String fileName){
		return tk.getImage(TankHelper.class.getClassLoader().getResource(fileName));
	}
}
