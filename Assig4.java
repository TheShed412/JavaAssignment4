import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Assig4
{
  private static final int HEIGHT = 300;
  private static final int WIDTH = 800;

  static ArrayList<Ballot> b = new ArrayList<Ballot>();

  public static void main(String[] args) throws IOException
  {
    String fileName = args[0];
    File file = new File(fileName);
    JFrame window = new JFrame();
    JButton login = new JButton("Login to Vote");
    JButton vote = new JButton("Cast Vote");
    vote.setEnabled(false);
    JPanel defaultButts = new JPanel();

    login.addActionListener(new VoteAction(b, vote));

    defaultButts.add(login);
    defaultButts.add(vote);
    getBallots(file);

    window.setSize(WIDTH, HEIGHT);
    window.setLayout(new GridLayout(1, b.size()+1));
    for(int i=0; i<b.size(); i++){
      window.add(b.get(i));
    }//for
    window.add(defaultButts);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  window.setVisible(true);
  }//main

  private static class VoteAction implements ActionListener
  {
    private ArrayList<Ballot> b;
    private JButton vote;

    public VoteAction(ArrayList<Ballot> b, JButton vote)
    {
      this.b = b;
      this.vote = vote;
    }//constructor

    public void actionPerformed(ActionEvent e)
    {
      for(int i=0; i<b.size(); i++){
        b.get(i).enableButtons();
      }//for

      vote.setEnabled(true);
      ((JButton)e.getSource()).setEnabled(false);
    }//actionPerfomred

    private String[] getPeople(String voterId)
    {
      int id = Integer.parseInt(voterId);

      File voters = new File("voters.txt");
      Scanner sc = new Scanner(voters);

    }//stuff
  }//vote action

  private static void getBallots(File file) throws IOException
  {
    int numBalls;
    int id;
    String cate;
    String[] opts;
    Scanner sc = new Scanner(file);

    numBalls = Integer.parseInt(sc.nextLine());

    for(int i=0; i<numBalls; i++){
      String line = sc.nextLine();
      String[] parse = line.split(":");

      id = Integer.parseInt(parse[0]);
      cate = parse[1];
      opts = parse[2].split(",");

      Ballot ball = new Ballot(id, cate, opts);
      b.add(ball);
    }//for
  }//getBallots

}//Assig4
