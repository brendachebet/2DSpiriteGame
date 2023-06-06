package main;
  import java.awt.Dimension;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;

import entity.Player;

import tile.Tilemanager;
public class GamePanel extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//screen settings
final int originalTileSize=16;
final int scale=3;
public final int tileSize=originalTileSize*scale;
final int maxScreenCol=16;
final int maxScreenRow=12;//4*3 dimension
final int screenWidth=tileSize*maxScreenCol;
final int screenHeight=tileSize*maxScreenRow;//16*48*48, 12*48*48

int FPS=60;
//Tilemanager tileManager = new Tilemanager(this);

Thread gameThread;
KeyHandler keyH=new KeyHandler();


Player player=new Player(this,keyH);

public GamePanel() {
	this.setPreferredSize(new Dimension(screenWidth, screenHeight));
	this.setBackground(Color.pink);
	this.setDoubleBuffered(false);//
	this.addKeyListener(keyH);
	this.setFocusable(true);//GamePanel focuses on receiving input
	
}
public void startGameThread() {
gameThread = new Thread(this);	
gameThread.start();
}
@Override
public void run() {
	
	//while the gameThread continues to run...
	 double drawInterval= 1000000000/FPS; 
	double nextDrawTime= System.nanoTime() + drawInterval;//

	while(gameThread != null) {
		
		update();
		repaint();
		try {
			double remainingTime = nextDrawTime- System.nanoTime();
			
			remainingTime=remainingTime/1000000;
			if (remainingTime<0) {
				remainingTime=0;
			}
				Thread.sleep((long)remainingTime);
			nextDrawTime+= drawInterval;	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}

//create game loop	
	public void update() {
		player.update();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		 tileManager.draw(g2);//must come first before the player otherwise tile will appear first
		player.draw(g2);
		g2.dispose();//dispose of this graphics context and any system resources it is using
		
	}
	
}

//second//