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
    String[] str = {"S", "S", "S"};
    
    JFrame window = new JFrame();
    Ballot ball = new Ballot(1234, "Stuff", str);
    
    window.setSize(WIDTH, HEIGHT);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.add(ball);
	  window.setVisible(true);
  }//main
}//Assig4