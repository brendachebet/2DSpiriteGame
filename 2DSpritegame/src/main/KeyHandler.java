package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
 public boolean upPressed, downPressed, leftPressed, rightPressed;

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code=e.getKeyCode();//returns a number the key pressed matches with
		if (code == KeyEvent.VK_W){
			upPressed = true;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed= true;
		}
if (code == KeyEvent.VK_S){
			downPressed = true;
		}
if (code == KeyEvent.VK_D){
	rightPressed= true;
}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code=e.getKeyCode();//returns a number the key pressed matches with
		if (code == KeyEvent.VK_W){
			upPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed= false;
		}
if (code == KeyEvent.VK_S){
			downPressed = false;
		}
if (code == KeyEvent.VK_D){
	rightPressed= false;
}
		
	}

	@Override
	public void keyTyped(KeyEvent args0) {
	// TODO Auto-generated method stub
		
	}
	//keyListener interface for receiving keyboard events(keystrokes)

}
//second//
