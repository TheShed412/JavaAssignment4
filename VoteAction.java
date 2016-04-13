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
  private static ArrayList<Person> people;
  private JButton vote;
  private JButton login;

  public VoteAction(ArrayList<Ballot> b, JButton vote, JButton login)
  {
    this.b = b;
    this.vote = vote;
    this.login = login;
  }//constructor

  public void actionPerformed(ActionEvent e)
  {
        String id;
        boolean error = false;
        if(((JButton)e.getSource()).getText() == "Login to Vote"){
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
      }// if for login

      if(((JButton)e.getSource()).getText() == "Cast Vote"){
        ArrayList<Button> butt =null;
        int op = JOptionPane.showConfirmDialog(null, "Are you sure these are your votes?",
                                               null, JOptionPane.YES_NO_OPTION);
        if(op == JOptionPane.YES_OPTION){
        for(int i=0;i<b.size();i++){
          int idNum = (b.get(i)).id;
          butt = (b.get(i)).bl;
          try{safeSave(idNum, butt);}
          catch (Exception ex){}
        }//for
        try{saveVoters();
            JOptionPane.showMessageDialog(null,"Thank you for voting!");
            String[] a = {};}
        catch (Exception ex){System.out.println(e);}

        for(int i=0; i<b.size(); i++){
          b.get(i).disableButtons();
        }//for
        login.setEnabled(true);
        ((JButton)e.getSource()).setEnabled(false);
      }else{
        JOptionPane.getRootFrame().dispose();
      }//if else
    }//
  }//actionPerfomred

  private void safeSave(int id, ArrayList<Button> butt) throws IOException
  {
      File temp = new File("temp.txt");
      File check = new File(id+".txt");

      if(check.exists()){
        Scanner sc = new Scanner(check);
        PrintWriter pw = new PrintWriter(temp);
        int[] numVotes = new int[butt.size()];
        int j = 0;
        while(sc.hasNextLine()){
          String line = sc.nextLine();
          String[] stuff = line.split(":");
           numVotes[j] = Integer.parseInt(stuff[1]);
           j++;
        }//while
        for(int i=0; i<butt.size(); i++){
          butt.get(i).votes += numVotes[i];
          pw.println(butt.get(i).name+":"+butt.get(i).votes);
        }//for
        pw.close();
        sc.close();
        check.delete();
        temp.renameTo(new File(id+".txt"));
      }//if

      else{
        PrintWriter pw = new PrintWriter(temp);
        for(int i=0; i<butt.size(); i++){
          pw.println(butt.get(i).name+":"+butt.get(i).votes);
        }//for
        pw.close();
        check.delete();
        temp.renameTo(check);
      }//else

  }//safeSave

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
    if(match && (people.get(voter).vote == false)){
      JOptionPane.showMessageDialog(null, "Welcome, "+people.get(voter).name+"!");
      people.get(voter).voted();
    }
    else if(match && (people.get(voter).vote == true)){
      JOptionPane.showMessageDialog(null, people.get(voter).name+" has already voted.");
      match = false;
    }//else if
    else{
      JOptionPane.showMessageDialog(null, "There is no one with that number.");
    }//if
    sc.close();
    return !match;
  }//stuff

  private void saveVoters() throws IOException
  {
    File voters = new File("voters.txt");
      File vTemp = new File("vtemp.txt");
      PrintWriter pw = new PrintWriter(vTemp);
      for(int i=0; i<people.size();i++){
        pw.println(people.get(i).id+":"+people.get(i).name+":"+people.get(i).vote);
      }//for
      pw.close();
      voters.delete();
      vTemp.renameTo(voters);
  }//saveVoters
}//vote action
