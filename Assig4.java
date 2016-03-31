import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Assig4
{
  private static final int HEIGHT = 600;
  private static final int WIDTH = 800;
  
  public static void main(String[] args)
  {
    JFrame window = new JFrame();
    
    window.setSize(WIDTH, HEIGHT);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel msg = new JLabel("Monorail");
	  msg.setFont(new Font("TimesRoman", Font.ITALIC, 48));
	  msg.setForeground(Color.BLACK);
	  
	  window.add(msg);
	  window.setVisible(true);
  }//main
}//Assig4