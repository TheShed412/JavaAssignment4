import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Person
{
  int id;
  String name;
  boolean vote;
  
  public Person(int id, String name, boolean voted)
  {
    this.id = id;
    this.name = name;
    this.vote = voted;
  }//Person
  
  public void voted()
  {
    vote = true;
  }//voted
}//Person