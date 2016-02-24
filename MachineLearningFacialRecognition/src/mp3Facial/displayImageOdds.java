package mp3Facial;


import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import mp3Facial.MoverImage;

public class displayImageOdds {
	public static void main(String [] args) throws IOException, InterruptedException
	{
		JFrame f = new JFrame();
	
		f.setTitle("MP3Face");
		MainRun mr = new MainRun();
		
		
		f.add(mr.ev);
		f.addKeyListener(new MoverImage());
		f.setSize(300,370);
		f.setBackground(Color.WHITE);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
