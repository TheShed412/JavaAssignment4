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
  
  static ArrayList<Ballot> b = new ArrayList<Ballot>();
  
  public static void main(String[] args)
  {
    String[] str = {"Sasdf", "Sasdf", "Sasdf", "asdf", "asdf"};
    
    JFrame window = new JFrame();
    Ballot ball = new Ballot(1234, "Stuff", str);
    Ballot ball2 = new Ballot(1234, "Stuf", str);
    Ballot ball3 = new Ballot(1234, "Stu", str);
    Ballot ball4 = new Ballot(1234, "St", str);
    
    b.add(ball);
    b.add(ball2);
    b.add(ball3);
    b.add(ball4);
    
    window.setSize(WIDTH, HEIGHT);
    window.setLayout(new GridLayout(1, b.size()+2));
    for(int i=0; i<b.size(); i++){
      window.add(b.get(i));
    }//for
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  window.setVisible(true);
  }//main
}//Assig4