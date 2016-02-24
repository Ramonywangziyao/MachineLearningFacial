package mp3Facial;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoverImage implements KeyListener {
	
	static double mul = 120;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	
            if (e.getKeyCode() == KeyEvent.VK_UP) {
               	mul+=5;
               	
               	
                }
            else
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                   	mul-=5;
                   	if(mul<=0)
                   		mul=0;	
                   	
                    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
