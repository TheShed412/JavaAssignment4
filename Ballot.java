import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ballot extends JPanel
{
  int id;
  String cate;
  JPanel cPanel;
  ArrayList<JPanel> opts;
  ArrayList<Button> bl;

  public Ballot(int id, String cate, String[] opts)
  {
    this.id = id;
    this.cate = cate;
    this.opts = new ArrayList<JPanel>();
    bl = new ArrayList<Button>();
    for(int i=0; i<opts.length; i++){
      Button butt = new Button(opts[i]);
      JPanel pan = new JPanel();
      butt.addActionListener(new ButtonListener(bl));
      butt.setEnabled(false);
      bl.add(butt);
      pan.add(butt);
      this.opts.add(pan);
    }//for

    buildPanel();
  }//Ballot

  public void enableButtons()
  {
    for(int i=0; i<bl.size(); i++){
      bl.get(i).setEnabled(true);
    }//for

    for(int i=0; i<opts.size(); i++){
      opts.get(i).setVisible(true);
    }//for
  }//enableButtons

  public void disableButtons()
  {
    for(int i=0; i<bl.size(); i++){
      bl.get(i).setEnabled(false);
    }//for

    for(int i=0; i<opts.size(); i++){
      opts.get(i).setVisible(true);
    }//for
  }//enableButtons

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
