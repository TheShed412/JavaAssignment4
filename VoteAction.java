import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VoteAction implements ActionListener
{
  /*Add the cast vote button to this so I have access to the
  person array list. Use the getSource to do the other things I have to do.*/
  private ArrayList<Ballot> b;
  private ArrayList<Person> people;
  private JButton vote;

  public VoteAction(ArrayList<Ballot> b, JButton vote)
  {
    this.b = b;
    this.vote = vote;
  }//constructor

  public void actionPerformed(ActionEvent e)
  {
    String id;
    boolean error = false;

    do{
        id = JOptionPane.showInputDialog("Enter Voter ID");
        if((id == null)){
          //System.out.println("Exit");
          System.exit(0);
        }//if for cancel button
        try{error = getPeople(id);}
        catch(IOException | NumberFormatException ex){
          System.out.println(ex);
          error = true;
        }//catch
    }while(error);

    for(int i=0; i<b.size(); i++){
      b.get(i).enableButtons();
    }//for
    vote.setEnabled(true);
    ((JButton)e.getSource()).setEnabled(false);
  }//actionPerfomred

  private boolean getPeople(String voterId) throws IOException
  {
    int id = Integer.parseInt(voterId);
    boolean match = false;
    int voter = 0;
    int counter = 0;;
    people = new ArrayList<Person>();

    File voters = new File("voters.txt");
    Scanner sc = new Scanner(voters);

    while(sc.hasNextLine()){
      int newId;
      String name;
      boolean voted;
      String[] split;
      String line = sc.nextLine();

      split = line.split(":");
      newId = Integer.parseInt(split[0]);
      name = split[1];
      voted = Boolean.parseBoolean(split[2]);

      Person p = new Person(newId, name, voted);
      people.add(p);

      if(newId == id){
        match = true;
        voter = counter;
      }//if
      counter++;
    }//while
    if(match){
      JOptionPane.showMessageDialog(null, "Welcome, "+people.get(voter).name+"!");
    }else{
      JOptionPane.showMessageDialog(null, "No such person exists.");
    }//if
    return !match;
  }//stuff

}//vote action
