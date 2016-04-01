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
    ArrayList<Button> bl = new ArrayList<Button>();
    for(int i=0; i<opts.length; i++){
      Button butt = new Button(opts[i]);
      JPanel pan = new JPanel();
      butt.addActionListener(new ButtonListener(bl))
      //butt.setEnabled(false);
      bl.add(butt);
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
  
  private class ButtonListener implements ActionListener
  {
    ArrayList<Button> al = new ArrayList<Button>();
    
    public ButtonListener(ArrayList<Button> bl)
    {
      al = bl;
    }//constructor
    
    public void actionPerformed(ActionEvent e)
    {
      for(int i=0; i<al.size(); i++){
        if(e.getSource() == al.get(i)){
          al.get(i).select();
        }else{
          al.get(i).unselect();
        }//if else
      }//for
    }//actionPerformed
    
  }//ButtonListener
  
}//ballot