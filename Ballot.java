import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ballot extends JPanel
{
  int Id;
  String cate;
  JPanel cPanel;
  ArrayList<JPanel> opts;
  
  public Ballot(int Id, String cate, String[] opts)
  {
    this.Id = Id;
    this.cate = cate;
    this.opts = new ArrayList<JPanel>();
    for(int i=0; i<opts.length; i++){
      JButton butt = new JButton(opts[i]);
      JPanel pan = new JPanel();
      pan.add(butt);
      this.opts.add(pan);
    }//for
    
    buildPanel();
  }//Ballot
  
  private void buildPanel()
  {
    JLabel cate = new JLabel(this.cate);
    cPanel = new JPanel();
    cPanel.add(cate);
    this.setLayout(new GridLayout(opts.size()+1, 1));
    this.add(cPanel);
    for(int i=0; i<opts.size(); i++){
      this.add(opts.get(i));
      //System.out.println("Happening");
    }//for
    this.setVisible(true);
  }//buildPanel
}//ballot