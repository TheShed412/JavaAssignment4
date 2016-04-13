import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Button extends JButton
{
  int votes = 0;
  boolean selected = false;
  String name;

  public Button(String name)
  {
    this.setText(name);
    this.name = name;
  }//constructor

  public void addVote()
  {
    votes++;
  }//addVote

  public int getVote()
  {
    return votes;
  }//getVote

  public void select()
  {
    selected = true;
    this.setForeground(Color.RED);
    votes = 1;
  }//select

  public void unselect()
  {
    selected = false;
    this.setForeground(Color.BLACK);
    votes = 0;
  }//unselect

}//Button
