package hello;

import java.util.List;
import java.util.ArrayList;

public class Card {
  
  private int id;
  private String name;

  public Card (){}

  public Card(int id, String name) {
    this.name = name;
    this.id = id;
  }

  public String getname() {
     return this.name;
  }

  public int getId() {
    return this.id;
  }
  
  public void setname(String name) {
	this.name = name;
  }
}